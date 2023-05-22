package com.example.projectInnerUtil;

import com.example.dto.ArticleDto;
import com.example.dto.ArticleDtoForWriteArticle;
import com.example.repository.ArticleRepositoryMemoryImpl;
import com.example.vo.Article;

public class VoDtoConvertUtil {
	
	public Article convertDtoToVo(ArticleDto articleData) {
		
		Article article = new Article(++ArticleRepositoryMemoryImpl.lastArticleId, TimeUtil.getNowString(), TimeUtil.getNowString(), 
				articleData.getBoardGroup(), articleData.getBoardId(), articleData.getMemberId(), articleData.getTitle(), articleData.getBody());
		
		return article;
	}
	
	public Article convertArticleDtoForWriteArticle(ArticleDtoForWriteArticle articleData) {
		
		Article article = new Article(0, "", "", 
				articleData.getBoardGroup(), articleData.getBoardId(), articleData.getMemberId(), articleData.getTitle(), articleData.getBody());
		
		return article;
	}
	
	public ArticleDto convertVoToDto(Article article) {
		//TODO ArticleDTO memberNickname 가져와서 조립
		ArticleDto articleData = new ArticleDto(article.getId(), article.getRegDate(), article.getUpdateDate(),
				article.getBoardGroup(), article.getBoardId(), article.getMemberId(), article.getTitle(), article.getBody(), "");
		
		return articleData;
	}

}
