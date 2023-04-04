package com.multi.mvc01;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BookController {

	@Autowired
	BookDAO dao;
	
	@RequestMapping("insert3.multi")
	public void insert(BookVO bag) {
		dao.insert(bag);
	}
	
	@RequestMapping("one3.multi")
	public void one(int id, Model model) {
		BookVO vo = dao.one(id);
		model.addAttribute("vo", vo);		
	}
	
	@RequestMapping("delete3.multi")
	public void delete(BookVO bag) {
		dao.delete(bag);
	}
	
	@RequestMapping("update3.multi")
	public void update(BookVO bag) {
		dao.update(bag);
	}
	
	@RequestMapping("list3.multi")
	public void list(Model model) {
		ArrayList<BookVO> list = dao.list();
		model.addAttribute("list", list);
	}
}
