package com.sy.s1.member;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/member/**/")
public class MemberController {
	
	@GetMapping("memberJoin")
	public ModelAndView memberJoin(ModelAndView mv) throws Exception {
		mv.setViewName("member/memberJoin");
		//mv.addObject("memberVO", memberVO); // form error쓰려면 이거 추가

		return mv;
	}

}
