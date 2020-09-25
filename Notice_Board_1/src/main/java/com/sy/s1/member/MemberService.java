package com.sy.s1.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

@Service
public class MemberService {
	   @Autowired
	   private MemberRepository memberRepository;
	   
		public MemberVO memberLogin(MemberVO memberVO) throws Exception {

			return memberRepository.memberLogin(memberVO);
		}
		
		public int memberJoin(MemberVO memberVO) throws Exception {
			
			return memberRepository.memberJoin(memberVO);
		}
		
		
		public boolean memberError(MemberVO memberVO, BindingResult bindingResult) throws Exception {
			
			boolean result = false; // 에러가 없음
			// 단일 if문으로 작성

			// 1. 기본 제공 검증
			if (bindingResult.hasErrors()) {
				
				result = true;
				
			} else {
				// 2. pw가 일치하는지 검증하기
				if (!memberVO.getPw().equals(memberVO.getPwCheck())) {
					System.out.println("test03");
					bindingResult.rejectValue("pwCheck", "memberVO.password.notSame");
					                          // error가 있을때 form:errors의 path(변수이름),"message.properties에 적은 변수명"
					result = true;
				}

				// 3. id 중복검증 (DB조회)
				// memberVO.getId(): String 타입
				memberVO = memberRepository.idCheck(memberVO);

				if (memberVO != null) { // null이 아니라면 이미 있는 아이디 이다.
					bindingResult.rejectValue("id", "memberVO.id.already");
					result = true;
				}
				/*  idCheck로 정보조회가 안되면 null이 들어간다.
					그러면 memberVO자체가 null이된다.
					이런 없는 개체인 상태에서 memberVO.getId처럼 id를 꺼내주려고 하면 값을 못꺼내서 에러가 생긴다. */
				
			}
			return result;
		}
	
}
