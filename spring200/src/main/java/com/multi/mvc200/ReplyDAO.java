package com.multi.mvc200;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import org.springframework.stereotype.Component;

// 테이블 하나당 dao 하나!
// CUD를 완성!

@Component
public class ReplyDAO {
	public ArrayList<ReplyVO> list(int bbsno) {
		ResultSet rs = null; // 항목명 + 결과 데이터를 담고 있는 테이블

		ArrayList<ReplyVO> list = new ArrayList<>();

		ReplyVO bag = null;
		try {
			// mySql 연결할 부품 설정
			Class.forName("com.mysql.cj.jdbc.Driver");

			// mySql 연결
			String url = "jdbc:mysql://localhost:3306/multi?serverTimezone=UTC";
			String user = "root";
			String password = "1234";
			Connection con = DriverManager.getConnection(url, user, password);

			// 3. SQL문 작성
			String sql = "select * from reply where bbsno = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, bbsno);
			// 보내기
			rs = ps.executeQuery(); // select할 때는 executeQuery();
			// 1. 검색결과가 있으면 while문으로 반복해서 실행.
			while (rs.next()) { // 검색결과 있는지 여부는 rs.next()
				// 2. 각 컬럼에서 값들을 꺼내오기.
				int no = rs.getInt(1);
				int bbsno2 = rs.getInt(2);
				String content = rs.getString(3);
				String writer = rs.getString(4);
				// 3. 가방을 만들자.
				bag = new ReplyVO();
				bag.setNo(no);
				bag.setBbsno(bbsno2);
				bag.setContent(content);
				bag.setWriter(writer);
				// 4. list에 bag을 추가.
				list.add(bag);
			}
			ps.close();
			rs.close();
			con.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} // try-catch
		return list;
	}
	
	public ArrayList<ReplyVO> list8(String writer) {
		ResultSet rs = null; // 항목명 + 결과 데이터를 담고 있는 테이블

		ArrayList<ReplyVO> list = new ArrayList<>();

		ReplyVO bag = null;
		try {
			// mySql 연결할 부품 설정
			Class.forName("com.mysql.cj.jdbc.Driver");

			// mySql 연결
			String url = "jdbc:mysql://localhost:3306/multi?serverTimezone=UTC";
			String user = "root";
			String password = "1234";
			Connection con = DriverManager.getConnection(url, user, password);

			// 3. SQL문 작성
			String sql = "select * from reply where writer = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, writer);
			// 보내기
			rs = ps.executeQuery(); // select할 때는 executeQuery();
			// 1. 검색결과가 있으면 while문으로 반복해서 실행.
			while (rs.next()) { // 검색결과 있는지 여부는 rs.next()
				// 2. 각 컬럼에서 값들을 꺼내오기.
				int no = rs.getInt(1);
				int bbsno2 = rs.getInt(2);
				String content = rs.getString(3);
				String writer2 = rs.getString(4);
				// 3. 가방을 만들자.
				bag = new ReplyVO();
				bag.setNo(no);
				bag.setBbsno(bbsno2);
				bag.setContent(content);
				bag.setWriter(writer2);
				// 4. list에 bag을 추가.
				list.add(bag);
			}
			ps.close();
			rs.close();
			con.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} // try-catch
		return list;
	}

	public int insert(ReplyVO bag) {
		int result = 0;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			// mySql 연결
			String url = "jdbc:mysql://localhost:3306/multi?serverTimezone=UTC";
			String user = "root";
			String password = "1234";
			Connection con = DriverManager.getConnection(url, user, password);

			// sql문 작성
			String sql = "insert into reply (bbsno, content, writer) values (?, ?, ?)";

			PreparedStatement ps = con.prepareStatement(sql);

			// R빼고, 인덱스는 0부터 시작!
			// 유일하게 db는 인덱스가 1부터 시작!

			ps.setInt(1, bag.getBbsno());
			ps.setString(2, bag.getContent());
			ps.setString(3, bag.getWriter());


			// 보내기
			result = ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} // try-catch
		return result;
	}
}
