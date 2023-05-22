package com.example.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.vo.Article;

@Mapper
public interface ArticleRepository {

	int writeArticle(Article aritcle);
	
	Article getArticle(int id);

	List<Article> getFreeboardsArticleList(Integer page);

	void modifyArticle(Integer id, Article article);
}
