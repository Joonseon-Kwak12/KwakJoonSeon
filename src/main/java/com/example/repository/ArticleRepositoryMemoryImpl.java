package com.example.repository;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import com.example.enums.BoardGroup;
import com.example.projectInnerUtil.TimeUtil;
import com.example.vo.Article;

public class ArticleRepositoryMemoryImpl implements ArticleRepository {
	
	public static int lastArticleId = 0;
	
	List<Article> articleList;
	
	public ArticleRepositoryMemoryImpl() {
		
		this.articleList = new ArrayList<>();
		makeTestData();
	}

	// 메서드 ----------------------------------------------------------
	// -----------------------------------------------------------------
	@Override
	public int writeArticle(Article article) {
		
		articleList.add(article);
		return article.getId();
	}

	@Override
	public Article getArticle(int id) {
		
		Article foundArticle = null;
		
		for (Article article : articleList) {
			if (article.getId() == id) {
				foundArticle = article;
			}
		}
		
		return foundArticle;
	}
	
	@Override
	public List<Article> getFreeboardsArticleList(Integer page) {
		
		articleList.sort(new Comparator<Article>() {
			@Override
			public int compare(Article article1, Article article2) {
				if (article1.getId() > article2.getId()) {
					return -1;	
				}
				return 1;
			}
		});
		return articleList;
	}
	
	@Override
	public void modifyArticle(Integer id, Article article) {
		
		articleList.set(id, article);
	}
	
	private void makeTestData() {
		
		articleList.add(new Article(++lastArticleId, TimeUtil.getNowString(), TimeUtil.getNowString(), BoardGroup.GENERAL, 1, 1, "테스트 데이터 제목 1", "테스트 데이터 내용 1"));
		articleList.add(new Article(++lastArticleId, TimeUtil.getNowString(), TimeUtil.getNowString(), BoardGroup.GENERAL, 1, 1, "테스트 데이터 제목 2", "테스트 데이터 내용 2"));
		articleList.add(new Article(++lastArticleId, TimeUtil.getNowString(), TimeUtil.getNowString(), BoardGroup.GENERAL, 1, 1, "테스트 데이터 제목 3", "테스트 데이터 내용 3"));
		articleList.add(new Article(++lastArticleId, TimeUtil.getNowString(), TimeUtil.getNowString(), BoardGroup.GENERAL, 1, 1, "테스트 데이터 제목 4", "테스트 데이터 내용 4"));
		articleList.add(new Article(++lastArticleId, TimeUtil.getNowString(), TimeUtil.getNowString(), BoardGroup.GENERAL, 1, 1, "테스트 데이터 제목 5", "테스트 데이터 내용 5"));
	}

}
