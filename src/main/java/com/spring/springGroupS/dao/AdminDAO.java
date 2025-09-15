package com.spring.springGroupS.dao;

import org.apache.ibatis.annotations.Param;

public interface AdminDAO {
	int totUserCnt(int level);

	int setMemberLevelChange(@Param("idx") int idx, @Param("level") int level);
}
