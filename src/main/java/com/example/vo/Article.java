package com.example.vo;

import com.example.enums.BoardGroup;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Article {
	
	private int id;
	private String regDate;
	private String updateDate;
	private BoardGroup boardGroup;
	private int boardId;
	private int memberId;
	private String title;
	private String body;	
}
