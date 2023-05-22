package com.example.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Member {
	
	private int id;
	private String regDate;
	private String updateDate;
	private String email;
	private String loginPw;
	private int authLevel;
	private String nickname;	
	private boolean delStatus;
	private String delDate;
}
