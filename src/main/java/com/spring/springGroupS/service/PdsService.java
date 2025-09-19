package com.spring.springGroupS.service;

import java.util.List;

import com.spring.springGroupS.vo.PdsVO;

public interface PdsService {

	List<PdsVO> getPdsList(int startIndexNo, int pageSize, String part);

	int getTotRecCnt(String part);

}
