package com.example.dto;

import com.example.enums.BoardGroup;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ArticleDtoForWriteArticle {
	
	private BoardGroup boardGroup;
	private int boardId;
	private int memberId;
	private String title;
	private String body;

}
