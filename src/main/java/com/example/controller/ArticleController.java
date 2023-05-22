package com.example.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.example.dto.ArticleDto;
import com.example.dto.ArticleDtoForWriteArticle;

public interface ArticleController {
	
	/**
	 * 일반 게시판 글쓰기 뷰 jsp로 연결하는 메서드
	 * 반환값: String(jsp 경로)
	 */
	public String viewWriteArticleWindow(HttpServletRequest request, Model model);
	
	/**
	 * 일반 게시판 글 데이터 저장 메서드
	 * 매개변수: ArticleDto 타입 게시물 데이터, Model 타입 스프링프레임워크 모델
	 * 반환값: String(게시물 뷰 jsp 경로: showArticle 메서드 호출 -> 저장된 글 id와 모델을 매개변수로 넘김)
	 */
	public String writeArticle(ArticleDtoForWriteArticle articleData, Model model);

	/**
	 * 글 목록 가져오는 메서드
	 * 매개변수: Integer 게시판 아이디(디폴트 값 0), Integer 게시판 페이지 값
	 * 반환값: List<ArticleDto>
	 */
	public List<ArticleDto> showArticleList(Integer boardId, Integer page);
	
	/**
	 * 특정 게시물을 보여주는 메서드
	 * 매개변수: int 게시물 아이디, Integer 게시판 페이지 값, Model 스프링프레임워크 모델
	 */
	public String showArticle(int id, Model model);
	
	/**
	 * 일반 게시판 게시물을 수정하는 뷰 jsp로 연결하는 메서드
	 * 매개변수: int 게시물 아이디, Model 스프링프레임워크 모델
	 * 반환값: String(jsp 경로)
	 */
	public String viewModifyArticleWindow(int id, Model model);
	
	/**
	 * 일반 게시판 게시물을 내용을 수정하도록 저장하는 메서드
	 * 매개변수: int 게시물 아이디, ArticleDto 타입 수정할 게시물 데이터
	 * 반환값: String(리다이렉트 url)
	 */
	public String modifyArticle(Integer id, ArticleDto articleData);
	
	/**
	 * 일반 게시판 게시물을 삭제하는 메서드
	 * 매개변수: int 게시물 아이디
	 * 반환값: 없음
	 */
	public void deleteArticle(int id);
}
