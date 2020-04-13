package com.naver.spring_1;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "index";
	}
	
	@RequestMapping(value = "/test", method =RequestMethod.GET )//어떤 주소가 들어왔을 때 요청을 매핑 할것인가
	// value("URL 주소")== command.equals
	public String test() {
		System.out.println("Test 실행");
		return "test";
	}
	@RequestMapping(value = "/test2", method = RequestMethod.GET)
	public String test2() {
		System.out.println("test2 실행");
		return "test2";
	}
	@RequestMapping(value = "/test3", method = RequestMethod.GET)
	public String test3() {
		System.out.println("test3 실행");
		return "sub/test3";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
