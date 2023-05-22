package com.example.repository;

import org.apache.ibatis.annotations.Mapper;

import com.example.vo.Member;

@Mapper
public interface MemberRepository {

	public void join(String email, String loginPw, String nickname);
	
	public Member getMemberById(int id);

	public int getLastInsertId();
	
	public Member getMemberByEmail(String email);

}
