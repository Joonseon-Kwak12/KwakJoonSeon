package com.example.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.example.dto.ArticleDto;
import com.example.dto.ArticleDtoForWriteArticle;

public interface GatheringController extends ArticleController{

	@Override
	String viewWriteArticleWindow(HttpServletRequest request, Model model);

	@Override
	String writeArticle(ArticleDtoForWriteArticle articleData, Model model);

	@Override
	List<ArticleDto> showArticleList(Integer boardId, Integer page);

	@Override
	String showArticle(int id, Model model);

	@Override
	String viewModifyArticleWindow(int id, Model model);

	@Override
	String modifyArticle(Integer id, ArticleDto articleData);

	@Override
	void deleteArticle(int id);
	
}
