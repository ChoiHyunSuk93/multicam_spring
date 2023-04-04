package com.multi.mvc200;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller // 스프링에서 제어하는 역할로 등록
public class BbsController {
	
	@Autowired
	BbsDAO dao;
	
	@Autowired
	ReplyDAO dao2;

	// 컨트롤 하는 기능(CRUD)
	// 회원가입, 수정, 탈퇴, 정보
	
	@RequestMapping("insert2.multi")
	public void insert(BbsVO bag) {
		// 메서드의 입력변수(파라메터)로 변수를 선언해두면,
		// 컨트롤러 내의 메서드 내에서는
		// 1)bag을 만들어서
		// 2)클라이언트로 부터 전달된 데이터도 받아줌
		// 3)bag에 데이터 다 넣어줌
		System.out.println("insert 요청됌");
		System.out.println(bag);
		dao.insert(bag);
	}
	
	@RequestMapping("update2.multi")
	public void update(BbsVO bag) {
		System.out.println("update 요청됌");
		System.out.println(bag);
		dao.update(bag);
	}
	
	@RequestMapping("delete2.multi")
	public void delete(BbsVO bag) {
		System.out.println("delete 요청됌");
		System.out.println(bag);
		dao.delete(bag);
	}
	
	@RequestMapping("one2.multi")
	public void one(int no, Model model) {
		BbsVO vo = dao.one(no);
		ArrayList<ReplyVO> list = dao2.list(no);
		model.addAttribute("list", list);
		model.addAttribute("vo", vo);
		
		
	}
	
	@RequestMapping("one6")
	public void one6(int no, Model model) {
		BbsVO vo = dao.one(no);
		ArrayList<ReplyVO> list = dao2.list(no);
		model.addAttribute("list", list);
		model.addAttribute("vo", vo);
		
		
	}
	
	@RequestMapping("list2.multi")
	public void list(Model model) {
		ArrayList<BbsVO> list = dao.list();
		model.addAttribute("list", list);
	}
	
	@RequestMapping("list5.multi")
	public void list2(Model model) {
		ArrayList<BbsVO> list = dao.list();
		model.addAttribute("list", list);
	}
	
	@RequestMapping("list7")
	public void list7(String writer, Model model) {
		ArrayList<BbsVO> list = dao.list7(writer);
		model.addAttribute("list", list);
	}
	
}
