package com.sy.s1.member;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/member/**/")
public class MemberController {
	
	@Autowired
	MemberService memberService;
	
	
	@GetMapping("memberJoin")
	public ModelAndView memberJoin(ModelAndView mv, MemberVO memberVO) throws Exception {
		mv.setViewName("member/memberJoin");
		mv.addObject("memberVO", memberVO); // 중요! form error쓰려면 이거 추가

		return mv;
	}
	@PostMapping("memberJoin")
	public ModelAndView memberJoin(ModelAndView mv, @Valid MemberVO memberVO, BindingResult bindingResult) throws Exception {
		boolean result = memberService.memberError(memberVO, bindingResult);
		
		//result = true > 에러
		
		if(result) {
			//에러가 있다면 다시 회원가입 화면
			mv.setViewName("member/memberJoin");
		}else { 
			//없다면 db로 정보 보내기 //insert : 성공하면 숫자출력
			int insert_result = memberService.memberJoin(memberVO); 
			
			if (insert_result > 0) {
				mv.addObject("result", "Join Success");
				mv.addObject("path", "redirect:../../");
				mv.setViewName("common/result");
			} else {
				mv.addObject("result", "Join Fail");
				mv.addObject("path", "memberJoin");
				mv.setViewName("common/result");
			}
		}
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

		memberVO = memberService.memberLogin(memberVO);
		System.out.println("결과 "+memberVO);

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
	
	@GetMapping("memberLogOut")
	public String memberLogOut(HttpSession session)throws Exception {
		System.out.println("logout");
		session.invalidate();
		return "redirect:../";
	}
}
