package com.spring.springGroupS.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.spring.springGroupS.common.Pagination;
import com.spring.springGroupS.service.AdminService;
import com.spring.springGroupS.service.MemberService;
import com.spring.springGroupS.vo.ComplaintVO;
import com.spring.springGroupS.vo.MemberVO;
import com.spring.springGroupS.vo.PageVO;

@Controller
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
	AdminService adminService;
	
	@Autowired
	MemberService memberService;
	
	@Autowired
	Pagination pagination;
	
	@GetMapping("/adminMain")
	public String adminMainGet() {
		return "admin/adminMain";
	}
	
	@GetMapping("/adminLeft")
	public String adminListGet() {
		return "admin/adminLeft";
	}
	
	@GetMapping("/adminContent")
	public String adminContentGet() {
		return "admin/adminContent";
	}
	
	@GetMapping("/member/adMemberList")
	public String adMemberListGet(Model model,
			@RequestParam(name="pag", defaultValue = "1", required = false) int pag,
			@RequestParam(name="pageSize", defaultValue = "10", required = false) int pageSize,
			@RequestParam(name="level", defaultValue = "99", required = false) int level
		) {
		// 페이징 처리
		int blockSize = 3;

		int totUserCnt = adminService.totUserCnt(level);
		int totPage = (totUserCnt % pageSize == 0) ? totUserCnt / pageSize : (totUserCnt / pageSize) + 1;
		
		if(totPage == 0) totPage = 1;
		
		int startIdxNo = (pag - 1) * pageSize;
		int curBlock = (pag - 1) / blockSize;
		int lastBlock = (totPage - 1) / blockSize;
		
		if (lastBlock < 0) lastBlock = 0;
		
		List<MemberVO> vos = memberService.getMemberList(startIdxNo, pageSize, level);
		
		// 페이징 변수 넘겨주기
		model.addAttribute("vos", vos);
		model.addAttribute("pag", pag);
		model.addAttribute("pageSize", pageSize);
		model.addAttribute("totPage", totPage);
		model.addAttribute("blockSize", blockSize);
		model.addAttribute("curBlock", curBlock);
		model.addAttribute("lastBlock", lastBlock);
		model.addAttribute("level", level);
		
		return "admin/member/adMemberList";
	}
	
	// 회원등급 변경처리
//	@ResponseBody
//	@PostMapping("/member/memberLevelChange")
//	public String memberLevelChange(int idx, int level) {
//		return adminService.setMemberLevelChange(idx, level) + "";
//	}
	
	@ResponseBody
	@PostMapping("/member/memberLevelChange")
	public int memberLevelChange(int idx, int level) {
		return adminService.setMemberLevelChange(idx, level);
	}
	
	//선택한 회원들 등급변경 처리
	@ResponseBody
	@PostMapping("/member/memberLevelSelectChange")
	public int memberLevelSelectChange(String idxSelectArray, int levelSelect) {
		return adminService.memberLevelSelectChange(idxSelectArray, levelSelect);
	}
	
	// 신고 리스트 보기
	@GetMapping("/complaint/complaintList")
	public String complaintListGet(Model model, PageVO pageVO) {
		pageVO.setSection("complaint");
		pageVO = pagination.pagination(pageVO);
		List<ComplaintVO> vos = adminService.getComplaintList(pageVO.getStartIndexNo(), pageVO.getPageSize());
		model.addAttribute("vos", vos);
		
		return "admin/complaint/complaintList";
	}
	
	// 신고 상세내역 보기
	@GetMapping("/complaint/complaintContent")
	public String complaintContentGet(Model model, int partIdx) {
		ComplaintVO vo = adminService.getComplaintSearch(partIdx);
		model.addAttribute("vo", vo);
		
		return "admin/complaint/complaintContent";
	}
	
	// 신고내역 자료 '취소(S)/감추기(H)/삭제(D)'
	@ResponseBody
	@PostMapping("/complaint/complaintProcess")
	public int complaintProcessPost(ComplaintVO vo) {
		int res = 0;
		
		if (vo.getComplaintSw().equals("D")) {
			res = adminService.setComplaintDelete(vo.getPartIdx(), vo.getPart());
			vo.setComplaintSw("처리완료(D)");
		}
		else {
			if (vo.getComplaintSw().equals("H")) {
				res = adminService.setComplaintProcess(vo.getPartIdx(), "HI");
				vo.setComplaintSw("처리중(H)");
			}
			else {
				res = adminService.setComplaintProcess(vo.getPartIdx(), "NO");
				vo.setComplaintSw("처리중(S)");
			}
		}
		
		if (res != 0) adminService.setComplaintProcessOk(vo.getIdx(), vo.getComplaintSw());
		
		return res;
	}
}
