package com.spring.springGroupS.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.spring.springGroupS.service.MemberService;
import com.spring.springGroupS.vo.MemberVO;

@Controller
@RequestMapping("/member")
public class MemberController {
	
	@Autowired
	MemberService memberService;
	
	// 濡�洹몄�� ��
	@GetMapping("/memberLogin")
	public String memberLoginGet() {
		return "member/memberLogin";
	}
	
  // 濡�洹몄�� 泥�由ы��湲�
	@PostMapping("/memberLogin")
	public String memberLoginPost(HttpSession session,
			@RequestParam(name="mid", defaultValue = "hkd1234", required = false) String mid,
			@RequestParam(name="pwd", defaultValue = "1234", required = false) String pwd,
			@RequestParam(name="idSave", defaultValue = "on", required = false) String idSave
		) {
		//  濡�洹몄�� �몄�泥�由�(�ㅽ��留� ����由ы�곗�� BCryptPasswordEncoder媛�泥대�� �댁�⑺�� ���명������ ���� 鍮�諛�踰��� 鍮�援���湲�)
		//MemberVO vo = memberService.getMemberIdCheck(mid);
		
		//if() {
			// 濡�洹몄�� �몄���猷��� 泥�由ы�� 遺�遺�(1.�몄��, 2.荑���, 3.湲고�� �ㅼ��媛�....)
			// 1.�몄��泥�由�
			
			
			// 2.荑��� ����/����
			
			
			// 3. 湲고��泥�由�(DB�� 泥�由ы�댁�쇳��寃���(諛⑸Ц移댁�댄��, �ъ�명��,... ��)
			// 3-1. 湲고��泥�由� : �ㅻ�� 泥ル갑臾몄�대㈃ todayCnt = 0
			
			
			// 3-2. 湲고��泥�由� : 諛⑸Ц移댁�댄�몃� 10�ъ�명�� 利���(��, 1�� 50�ъ�명�멸�吏�留� ����泥�由�)
			
			
			// 諛⑸Ц移댁�댄��
			
			
			return "redirect:/message/memberLoginOk?mid="+mid;
		//}
		//else {
			//return "redirect:/message/memberLoginNo";
		//}
	}
	
	// 濡�洹몄���� 泥�由�
	@GetMapping("/memberLogout")
	public String memberLogoutGet(HttpSession session) {
		String mid = (String) session.getAttribute("sMid");
		session.invalidate();
		
		return "redirect:/message/memberLogout?mid="+mid;
	}
	
	// ���� 媛����� 蹂댁�ъ＜湲�
	@GetMapping("/memberJoin")
	public String memberJoinGet() {
		return "member/memberJoin";
	}
	
	@PostMapping("/idCheck")
	@ResponseBody
	public String MemberIdCheckPost(@RequestParam("mid") String mid) {	
		MemberVO vo = memberService.getMemberIdCheck(mid);
		
		return vo == null ? "0" : "1";
	}
	
	@PostMapping("/nickNameCheck")
	@ResponseBody
	public String NumberNickNameCheckPost(@RequestParam("nickName") String nickName) {
		MemberVO vo = memberService.getMemberNickNameCheck(nickName);
		
		return vo == null ? "0" : "1";
	}
}
