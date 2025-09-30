package com.spring.springGroupS.vo;

import lombok.Data;

@Data
public class FileVO {
	private int fileIdx;
	private String category;
	private String fileName;
	private String uploaderMid;
	private String fileTitle;
	private long fileSize;
	private String uploadDate;
	private String hostIp;
}
