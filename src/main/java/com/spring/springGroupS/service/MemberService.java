package com.spring.springGroupS.service;

import java.util.List;

import com.spring.springGroupS.vo.MemberVO;

public interface MemberService {
	MemberVO getMemberIdCheck(String mid);

	MemberVO getMemberNickNameCheck(String nickName);

	int setMemberJoin(MemberVO vo);

	void setLastDateUpdate(String mid);

	int setMemberPwdChange(String mid, String pwd);

	List<MemberVO> getmemberIdSearch(String email);

	int setMemberUpdateOk(MemberVO vo);

	int setUserDelete(String mid);

	List<MemberVO> getMemberList(int startIndexNo, int pageSize, int level);
}
