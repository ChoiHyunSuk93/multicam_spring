package com.multi.mvc300;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component // 싱글톤으로 만들어주는 역할
public class MemberDAO {
	
	// 싱글톤 객체 찾아서 주소를 넣어주기!
	@Autowired
	SqlSessionTemplate my;
	
//	public ArrayList<MemberVO> list() {
//		
//		return list;
//	}
//
	public MemberVO one(String id) {
		MemberVO bag = my.selectOne("member.one", id);
		return bag;
	}
	public int update(MemberVO bag) {
		int result = my.update("member.up",bag);
		return result;
	}

	public int delete(MemberVO bag) {
		int result = my.delete("member.del", bag);
		return result;
	}

	public int insert(MemberVO bag) { // 1. 가방을 받아서 변수에 넣어주기
		int result = my.insert("member.create",bag);
		return result;
	}

//	public int login(MemberVO bag) {
//		
//		return result;
//	} // login

}
