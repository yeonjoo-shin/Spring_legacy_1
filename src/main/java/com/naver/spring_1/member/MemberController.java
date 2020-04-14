package com.naver.spring_1.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping(value = "/member/**")
public class MemberController {
	@Autowired
	private MemberService memberService;

	@RequestMapping(value = "/memberJoin")
	public void memberJoin(Model model) {// 파라미터 num//매개변수를 원하는 타입으로 받아줌//파라미터와 동일한 데이터 타입과 변수명

		// model.addAttribute("id","test");

	}

	@RequestMapping(value = "/memberJoin", method = RequestMethod.POST)
	public void memberJoin2(MemberVO memberVO) {
		// memberVO의 멤버 변수의 값으로 파라미터 값 넣기
		// 출력

		System.out.println(memberVO.getId());
		System.out.println(memberVO.getUpw());
		System.out.println(memberVO.getAge());
		System.out.println(memberVO.getEmail());
		System.out.println(memberVO.getPhone());
		System.out.println(memberVO.getUname());

	}

	@RequestMapping(value = "/memberLogin")
	public void memberLogin() {

	}
	
	  @RequestMapping(value = "memberLogin", method = RequestMethod.POST) //로그인성공하면 index로 이동 //로그인 실패하면 로그인 실패 alert창으로 다시 로그인폼으로
	  public void memberLogin2(HttpSession session, MemberVO memberDTO) throws Exception {
		memberDTO = memberService.memberLogin(memberDTO);
		
		System.out.println(memberDTO.getId());;
		System.out.println(memberDTO.getUpw());
	  
 
	  /*
	  String path="";
	  if(memberDTO != null) { //session.addAttribute("member",memberDTO);
	  path="redirect:../"; }else { model.addAttribute("result", "login fail");
	  model.addAttribute("path","./memberLogin"); path= "common/result"; }
	  */
	  }
	 

	@RequestMapping(value = "/memberPage")
	public void memberPage() {

	}

	@RequestMapping(value = "memberUpdate")
	public void memeberUpdate() {

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
