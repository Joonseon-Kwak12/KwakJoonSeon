package com.example.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.dto.ArticleDto;
import com.example.dto.ArticleDtoForWriteArticle;
import com.example.service.ArticleService;
import com.example.vo.Member;

@RequestMapping("/article/general")
public class ArticleControllerImpl implements ArticleController{
	
	ArticleService articleService;
	
	public ArticleControllerImpl(ArticleService articleService) {
		
		this.articleService = articleService;
	}
	
	/**
	 * 일반 게시판 글쓰기 뷰 jsp로 연결하는 메서드
	 * 매개변수: 없음
	 * 반환값: String(jsp 경로)
	 */
	@GetMapping("/write")
	@Override
	public String viewWriteArticleWindow(HttpServletRequest request, Model model) {
		
		Member loginedMember = (Member) request.getSession().getAttribute("loginedMember");
		model.addAttribute("loginedMemberId", loginedMember.getId());
		
		return "/usr/article/general/write";
	}
	
	/**
	 * 일반 게시판 글 데이터 저장 메서드
	 * 매개변수: ArticleDto 타입 게시물 데이터, Model 스프링프레임워크 모델
	 * 반환값: String(게시물 뷰 jsp 경로: showArticle 메서드 호출 -> 저장된 글 id와 모델을 매개변수로 넘김)
	 */
	@PostMapping("/write")
	@Override
	public String writeArticle(ArticleDtoForWriteArticle articleData, Model model) {
		
		int id = articleService.writeArticle(articleData);
		return showArticle(id, model);
	}
	
	/**
	 * 일반 게시판 글 목록 뷰 jsp로 연결하는 메서드
	 * 메서드 내부에서 글 목록 가져오는 메서드 호출해서 List를 Model에 담아서 뷰로 넘김
	 * *** 인터페이스에서 override한 메서드 아님 ***
	 * 매개변수: Model 스프링프레임워크 모델, Integer 게시판 아이디(디폴트 값 0), Integer 게시판 페이지 값 
	 * 반환값: String(jsp 경로)
	 */
	@GetMapping // http://localhost:8081/article?boardId=0
	public String viewArticleList(Model model, @RequestParam(defaultValue = "0") Integer boardId, @RequestParam(defaultValue = "1") Integer page) {
		
		List<ArticleDto> articles = showArticleList(boardId, page);
		model.addAttribute("articles", articles);
		
		return "/usr/article/general/list";
	}
	
	/**
	 * 일반 게시판 글 목록 가져오는 메서드
	 * 매개변수: Integer 게시판 아이디(디폴트 값 0), Integer 게시판 페이지 값
	 * 반환값: List<ArticleDto> 게시물 목록
	 */
	//url 매핑 없으나, ArticleController 인터페이스 유지하기 위해 남겨놓는 부분 시작 - viewArticleList 관련
//	@GetMapping("/list")
//	@ResponseBody
	@Override
	public List<ArticleDto> showArticleList(Integer boardId, Integer page) {
		
		if (boardId == 0) {
			return articleService.showFreeboardsArticleList(page);
		}
		
		return articleService.showArticleList(boardId, page);
	}
	//url 매핑 없으나, ArticleController 인터페이스 유지하기 위해 남겨놓는 부분 끝 - viewArticleList 관련

	/**
	 * 일반 게시판 게시물을 보여주는 메서드
	 * 매개변수: int 게시물 아이디, Integer 게시판 페이지 값, Model 스프링프레임워크 모델
	 * 반환값: String(jsp 경로)
	 */
	@GetMapping("/{articleId}")
	@Override
	public String showArticle(@PathVariable("articleId") int id, Model model) {
		
		ArticleDto articleData = articleService.showArticle(id);
		model.addAttribute("articleData", articleData);
		
		return "/usr/article/general/detail";
	}
	
	/**
	 * 일반 게시판 게시물을 수정하는 뷰 jsp로 연결하는 메서드
	 * 매개변수: int 게시물 아이디, Model 스프링프레임워크 모델
	 * 반환값: String(jsp 경로)
	 */
	@GetMapping("/{articleId}/modify")
	@Override
	public String viewModifyArticleWindow(@PathVariable("articleId") int id, Model model) {
		
		ArticleDto articleData = articleService.showArticle(id);
		model.addAttribute("articleData", articleData);
		
		return "/usr/article/general/modify";
	}
	
	/**
	 * 일반 게시판 게시물을 내용을 수정하도록 저장하는 메서드
	 * 매개변수: int 게시물 아이디, ArticleDto 타입 수정할 게시물 데이터
	 * 반환값: String(리다이렉트 url)
	 */
	@PostMapping("/{articleId}/modify")
	@Override
	public String modifyArticle(@PathVariable("articleId") Integer id, ArticleDto articleData) {
		
		if (id == null) {
			return null;
		} else if (id != articleData.getId()) {
			return null;
		}
		// TODO url articleId와 articleData의 id 검증 수정
		articleService.modifyArticle(id, articleData);
		
		return "redirect:/article/{articleId}";
	}
	
	/**
	 * 일반 게시판 게시물을 삭제하는 메서드
	 * 매개변수: int 게시물 아이디
	 * 반환값: 없음
	 */
	@PostMapping("/{articleId}/delete")
	@Override
	public void deleteArticle(@PathVariable("articleId") int id) {
		
		// TODO boardId 저장해서 리다이렉트 되도록 수정
		articleService.deleteArticle(id);
		return;
	}	

}
