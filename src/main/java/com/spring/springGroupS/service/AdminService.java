package com.spring.springGroupS.service;

public interface AdminService {

	int totUserCnt(int level);

	int setMemberLevelChange(int idx, int level);

	int memberLevelSelectChange(String idxSelectArray, int levelSelect);

	
}
