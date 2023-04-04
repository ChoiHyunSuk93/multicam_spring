package com.multi.mvc200;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ReplyController {
	
	@Autowired
	ReplyDAO dao;
	
	@RequestMapping("insert4")
	public void insert(ReplyVO vo) {
		System.out.println(vo);
		dao.insert(vo);
	}
	
	@RequestMapping("list6")
	public void list6(int bbsno, Model model) {
		ArrayList<ReplyVO> list = dao.list(bbsno);
		model.addAttribute("list", list);
	}
	
	@RequestMapping("list8")
	public void list8(String writer, Model model) {
		ArrayList<ReplyVO> list = dao.list8(writer);
		model.addAttribute("list", list);
	}
}
