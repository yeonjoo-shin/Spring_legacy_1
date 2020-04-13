package com.naver.spring_1;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/sub/**")
public class SubController {
	//일반 멤버메서드 생성
	@RequestMapping(value = "sub1")
	public void sub1() {
		// URI와 view의 경로가 같은면 void 로 해도됨
	}
	@RequestMapping(value = "sub2")
	public String sub2() {
		return "sub/sub2";
	}
}
