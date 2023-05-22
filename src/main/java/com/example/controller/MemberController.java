package com.example.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.projectInnerUtil.UtilURL;
import com.example.repository.MemberRepository;
import com.example.vo.Member;
import com.example.vo.Result;

@Controller
@RequestMapping("/member")
public class MemberController {
	
	MemberRepository memberRepository;
	@Autowired
	MessageSource ms;
	
	public MemberController(MemberRepository memberRepository) {

		this.memberRepository = memberRepository;
	}
	
//	@GetMapping({"", "/main", "/home/main"})
//	public String showMain(HttpServletRequest request, Model model) {
//		
//		HttpSession session = request.getSession(false);
//		if (session == null) {
//			model.addAttribute("loginedMember", null);
//			return "/main";
//		}
//		
//		Member loginedMember = (Member)session.getAttribute("loginedMember");
//		model.addAttribute("loginedMember", loginedMember);
//		
//		return "/main";
//	}

	@GetMapping("/getLoginedMemberNickname")
	@ResponseBody
	public Result<String> getLoginedMemberNickname(HttpServletRequest request) {
		
		HttpSession session = request.getSession(false);
		
		if (session == null || session.getAttribute("loginedMember") == null) {
			return new Result<String>(null, "loginedMemberNickname", "로그인 중이 아닙니다");
		}
		
		Member loginedMember = (Member)session.getAttribute("loginedMember");
		
		return new Result<String>(loginedMember.getNickname(), "loginedMemberNickname", "성공");
				
	}

	@GetMapping("/login")
	public String showLoginForm() {
		return "/member/login";
	}
	
	@PostMapping("/login")
	@ResponseBody
	public /*String*/ Result<String> login(@RequestParam String email, @RequestParam String loginPw, HttpServletRequest request) {
		
		Member foundMember = memberRepository.getMemberByEmail(email);
		if (foundMember == null) {
			/* return UtilURL.historyBack("일치하는 회원 정보가 존재하지 않습니다."); */
			return new Result<String>("", "LoginedMemberNickname", ms.getMessage("member.login.fail.emailNotExists", null, null));
		}
		
		if (!foundMember.getLoginPw().equals(loginPw) ) {
			/* return UtilURL.historyBack("비밀번호가 일치하지 않습니다."); */
			return new Result<String>("", "LoginedMemberNickname", ms.getMessage("member.login.fail.loginPwMismatch", null, null));
		}
		
		HttpSession session = request.getSession();
		session.setAttribute("loginedMember", foundMember);
		/* return UtilURL.replace("로그인 성공!", "/main"); */
		return new Result<String>(foundMember.getNickname(), "LoginedMemberNickname", ms.getMessage("member.login.success", null, null));
	}
	
	@GetMapping("/logout")
	@ResponseBody
	public String logout(HttpServletRequest request) {
		
		HttpSession session = request.getSession(false);
		if (session != null) {
			session.invalidate();
		}
		
		return UtilURL.replace("로그아웃 성공!", "/main");
	}
	
	@PostMapping("/join")
	@ResponseBody
	public String doJoin(String email, String loginPw, String nickname, HttpServletResponse response) {
		
		if (memberRepository.getMemberByEmail(email) != null) {
			return UtilURL.historyBack("이미 사용 중인 메일 주소입니다.");
		}
		
		System.out.println(email);
		System.out.println(loginPw);
		if (loginPw == null || loginPw.equals("")) {
			return UtilURL.historyBack("비밀번호를 입력해주세요.");
		} else if (loginPw.trim().length() < 5) {
			return UtilURL.historyBack("비밀번호는 5글자 이상이어야 합니다.");
		} else if (loginPw.contains(" ")) {
			return UtilURL.historyBack("비밀번호에는 공백이 포함될 수 없습니다.");
		}
		
		memberRepository.join(email, loginPw, nickname);
		
		//return "redirect:/login";
		//return UtilURL.replace("회원가입 성공", "/login");
		return "회원가입 성공";
	}
	
	@GetMapping("/checkDupEmail")
	@ResponseBody
	public String checkDupEmail(String email) {
		
		if (memberRepository.getMemberByEmail(email) == null) {
			return "Y";
		}
		return "N";
	}
}
