package com.spring.springGroupS.service;

import com.spring.springGroupS.vo.MemberVO;

public interface MemberService {
	MemberVO getMemberIdCheck(String mid);

	MemberVO getMemberNickNameCheck(String nickName);

	int setMemberJoin(MemberVO vo);

	void setLastDateUpdate(String mid);

	int setMemberPwdChange(String mid, String pwd);
}
