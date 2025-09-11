package com.spring.springGroupS.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.spring.springGroupS.vo.MemberVO;

public interface MemberDAO {
	MemberVO getMemberIdCheck(@Param("mid") String mid);

	MemberVO getMemberNickNameCheck(@Param("nickName") String nickName);

	List<MemberVO> getAddressList();

	int setMemberJoin(@Param("vo") MemberVO vo);

	void setLastDateUpdate(@Param("mid") String mid);

	int setMemberPwdChange(@Param("mid") String mid, @Param("pwd") String pwd);
}
