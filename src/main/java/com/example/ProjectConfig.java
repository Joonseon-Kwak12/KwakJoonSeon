package com.example;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.controller.ArticleController;
import com.example.controller.ArticleControllerImpl;
import com.example.controller.GatheringController;
import com.example.controller.GatheringControllerImpl;
import com.example.service.ArticleService;

@Configuration
public class ProjectConfig {

	@Bean
	public ArticleController articleController(ArticleService articleService) {

		return new ArticleControllerImpl(articleService);
	}

	@Bean
	public GatheringController gatheringController(ArticleService articleService) {

		return new GatheringControllerImpl(articleService);
	}

	
//	 @Bean
//	 public ArticleRepository articleRepository() {
//	 
//	 return new ArticleRepositoryMemoryImpl();
//	 }
	 
}
