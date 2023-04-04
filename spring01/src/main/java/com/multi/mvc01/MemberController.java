package com.multi.mvc01;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller // 스프링에서 제어하는 역할로 등록
public class MemberController {
	
	@Autowired // 싱글톤 부품을 찾아주는 역할
	MemberDAO3 dao; // 전역변수(글로벌 변수)
	// 컨트롤 하는 기능(CRUD)
	// 회원가입, 수정, 탈퇴, 정보
	
	@RequestMapping("login")
	public String login(MemberVO bag, HttpSession session) {
		System.out.println(bag);
		int result = dao.login(bag);
		if (result == 1) {
			// 로그인 성공하면,세션을 잡아두자.!!
			session.setAttribute("id", bag.getId());
			return "ok";
		} else {
			return "redirect:member.jsp";
		}
		
	}
	
	@RequestMapping("insert")
	public void insert(MemberVO bag) {
		// 메서드의 입력변수(파라메터)로 변수를 선언해두면,
		// 컨트롤러 내의 메서드 내에서는
		// 1)bag을 만들어서
		// 2)클라이언트로 부터 전달된 데이터도 받아줌
		// 3)bag에 데이터 다 넣어줌
		System.out.println("insert 요청됌");
		System.out.println(bag);
		dao.insert(bag);
	}
	
	@RequestMapping("update")
	public void update(MemberVO bag) {
		System.out.println("update 요청됌");
		System.out.println(bag);
		dao.update(bag);
	}
	
	@RequestMapping("delete")
	public void delete(MemberVO bag) {
		System.out.println("delete 요청됌");
		System.out.println(bag);
		dao.delete(bag);
	}
	
	@RequestMapping("one")
	public void one(String id, Model model) {
		MemberVO vo = dao.one(id);
		model.addAttribute("vo", vo);
	}
	
	@RequestMapping("list")
	public void list(Model model) {
		ArrayList<MemberVO> list = dao.list();
		model.addAttribute("list", list);
	}
	
	
}
