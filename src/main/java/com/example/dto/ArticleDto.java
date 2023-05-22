package com.example.dto;

import com.example.enums.BoardGroup;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ArticleDto {
	
	private int id;
	private String regDate;
	private String updateDate;
	private BoardGroup boardGroup;
	private int boardId;
	private int memberId;
	private String title;
	private String body;	
	//
	private String memberNickname;
	
	public ArticleDto(BoardGroup boardGroup, int boardId, int memberId, String title, String body) {
		this.boardGroup = boardGroup;
		this.boardId = boardId;
		this.memberId = memberId;
		this.title = title;
		this.body = body;
	}

}
