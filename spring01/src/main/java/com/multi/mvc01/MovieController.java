package com.multi.mvc01;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller // 스프링에서 제어하는 역할로 등록
public class MovieController {
	
	@RequestMapping("movie")
	public String movie(String movie) {
		System.out.println("브라우저로부터 전달받은 값은 "  + movie);
		if (movie.equals("드라마")) {
			return "drama";
		} else if (movie.equals("코믹")) {
			return "comic";
		} else {
			return "action";
		}
	}
	
	
}
