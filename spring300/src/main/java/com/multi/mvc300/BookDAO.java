package com.multi.mvc300;


import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class BookDAO {
	
	@Autowired
	SqlSessionTemplate my;
	
	public int insert(BookVO bag) {
		System.out.println("------" + my);
		int result = my.insert("book.create", bag);
		return result;
	}
	
	public int delete(int id) {
		int result = my.delete("book.del", id);
		return result;
	}
	
	public int update(BookVO bag) {
		int result = my.update("book.up", bag);
		return result;
	}
	
	public BookVO one(int id) {
		BookVO bag = my.selectOne("book.one", id);
		return bag;
	}
	
	public List<BookVO> list() {
		List<BookVO> list = my.selectList("book.all");
		return list;
	}
}