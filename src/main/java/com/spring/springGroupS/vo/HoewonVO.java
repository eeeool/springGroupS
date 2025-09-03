package com.spring.springGroupS.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Data
public class HoewonVO {
	private String mid;
	private String pwd;
	private String name;
	private String gender;
	private int age;
	
	private String nickName;
	private String strGender;
}
