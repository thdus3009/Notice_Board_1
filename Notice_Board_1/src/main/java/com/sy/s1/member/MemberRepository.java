package com.sy.s1.member;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MemberRepository {

	public MemberVO memberLogin(MemberVO memberVO) throws Exception;
	
	public MemberVO idCheck(MemberVO memberVO) throws Exception;
	
	public int memberJoin(MemberVO memberVO) throws Exception;
}
