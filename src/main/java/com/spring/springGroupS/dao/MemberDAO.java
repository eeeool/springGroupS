package com.spring.springGroupS.dao;

import java.util.List;

import com.spring.springGroupS.vo.MemberVO;

public interface MemberDAO {
	MemberVO getMemberIdCheck(String mid);

	MemberVO getMemberNickNameCheck(String nickName);

	List<MemberVO> getAddressList();
}
