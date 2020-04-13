package com.naver.spring_1;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/member/**")
public class MemberController {
	
	@RequestMapping(value = "/memberJoin")
	public void memberJoin(){
		
	}
	@RequestMapping(value = "/memberJoin", method = RequestMethod.POST)
	public void memberJoin2() {
		System.out.println("member join post");
	}
	
	@RequestMapping(value = "/memberLogin")
	public void memberLogin() {
	
	}
	@RequestMapping(value = "memberLogin", method = RequestMethod.POST)
	public String memberLogin2() {
		System.out.println("member login post");
		return "redirect:../";
	}
	
	@RequestMapping(value = "/memberPage")
	public void memberPage() {

	}
	@RequestMapping(value = "memberUpdate")
	public void  memeberUpdate() {

	}
	@RequestMapping(value = "memberUpdate", method = RequestMethod.POST)
	public void memberUpdate2() {
		System.out.println("member update post");
	}
	@RequestMapping(value = "memberDelete")
	public void memberDelete() {
		System.out.println("member delete post");
	}
}
