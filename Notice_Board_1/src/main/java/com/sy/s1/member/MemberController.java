package com.sy.s1.member;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/member/**/")
public class MemberController {
	
	@Autowired
	MemberService memberService;
	
	
	@GetMapping("memberJoin")
	public ModelAndView memberJoin(ModelAndView mv) throws Exception {
		mv.setViewName("member/memberJoin");
		//mv.addObject("memberVO", memberVO); // form error쓰려면 이거 추가

		return mv;
	}
	
	@GetMapping("memberLogin")
	public ModelAndView memberLogin(ModelAndView mv) throws Exception {
		mv.setViewName("member/memberLogin");
		//mv.addObject("memberVO", memberVO); // form error쓰려면 이거 추가

		return mv;
	}
	@PostMapping("memberLogin")
	public ModelAndView memberLogin(ModelAndView mv, MemberVO memberVO, HttpSession session) throws Exception {
		System.out.println("ddd");
		memberVO = memberService.memberLogin(memberVO);
		System.out.println(memberVO);

		if (memberVO != null) {
			session.setAttribute("member", memberVO);// 로그아웃할 때까지 jsp에서 ${member}로 사용할 수 있음
			mv.setViewName("redirect:../");
		} else {
			mv.addObject("result", "Login Fail");
			mv.addObject("path", "../");
			mv.setViewName("common/result");
		}

		// 로그인 성공이면 index
		// 로그인 실패 하면 로그인 실패 alert login form 이동

		return mv;
	}
	
}
