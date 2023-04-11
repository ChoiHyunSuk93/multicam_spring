package com.multi.mvc300;


import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;

//테이블 하나당 DAO하나! ==> CUD를 완성!! 
@Component
public class BbsDAO {

	@Autowired
	SqlSessionTemplate my;

	public int insert(BbsVO bag) {
		int result = my.insert("bbs.create", bag);
		return result;
	}
	
	public int update(BbsVO bag) {
		int result = my.update("bbs.up", bag);
		return result;
	}
	
	public int delete(int no) {
		int result = my.delete("bbs.del", no);
		return result;
	}
	
	public BbsVO one(int no) {
		BbsVO bag = my.selectOne("bbs.one", no);
		return bag;
	}
}
