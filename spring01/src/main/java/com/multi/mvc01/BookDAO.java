package com.multi.mvc01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import org.springframework.stereotype.Component;

// 테이블 하나당 dao 하나!
// CUD를 완성!

@Component
public class BookDAO {
	public int insert(BookVO bag) {
		int result = 0;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			// mySql 연결
			String url = "jdbc:mysql://localhost:3306/multi?serverTimezone=UTC";
			String user = "root";
			String password = "1234";
			Connection con = DriverManager.getConnection(url, user, password);

			// sql문 작성
			String sql = "insert into book (name, url, img) values (?, ?, ?)";

			PreparedStatement ps = con.prepareStatement(sql);

			// R빼고, 인덱스는 0부터 시작!
			// 유일하게 db는 인덱스가 1부터 시작!

			ps.setString(1, bag.getName());
			ps.setString(2, bag.getUrl());
			ps.setString(3, bag.getImg());

			// 보내기
			result = ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} // try-catch
		return result;
	}

	public BookVO one(int id) {
		ResultSet rs = null; // 항목명 + 결과 데이터를 담고 있는 테이블
		BookVO bag = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			// mySql 연결
			String url = "jdbc:mysql://localhost:3306/multi?serverTimezone=UTC";
			String user = "root";
			String password = "1234";
			Connection con = DriverManager.getConnection(url, user, password);

			// 3. SQL문 작성
			String sql = "select * from book where id = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);

			// 보내기
			rs = ps.executeQuery(); // select할 때는 executeQuery();
			if (rs.next()) { // 검색결과 있는지 여부는 rs.next()
				// true -> 검색결과 O, false -> 검색결과 X
				int id2 = Integer.parseInt(rs.getString(1));
				String name = rs.getString(2);
				String url2 = rs.getString(3);
				String img = rs.getString(4);
				// 검색결과를 검색화면 UI부분에 주어야 함.
				bag = new BookVO();
				bag.setId(id2);
				bag.setName(name);
				bag.setUrl(url2);
				bag.setImg(img);
			} else {
				System.out.println("검색결과 없음.");
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} // try-catch
		return bag;
	}
	
	public int update(BookVO bag) {
		int result = 0;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			// mySql 연결
			String url = "jdbc:mysql://localhost:3306/multi?serverTimezone=UTC";
			String user = "root";
			String password = "1234";
			Connection con = DriverManager.getConnection(url, user, password);

			// 3. SQL문 작성
			String sql = "update book set name = ? where id = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, bag.getName());
			ps.setInt(2, bag.getId());
			// con부품으로 sql스트링에 있는 것 SQL부품으로 만들어주세요.

			// 보내기
			result = ps.executeUpdate(); // insert, update, delete문만! sql문 실행 결과가 int

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} // try-catch
		return result;
	}

	public int delete(BookVO bag) {
		int result = 0;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			// mySql 연결
			String url = "jdbc:mysql://localhost:3306/multi?serverTimezone=UTC";
			String user = "root";
			String password = "1234";
			Connection con = DriverManager.getConnection(url, user, password);

			// 3. SQL문 작성
			String sql = "delete from book where id = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, bag.getId());

			// 보내기
			result = ps.executeUpdate();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} // try-catch
		return result;
	}
	
	public ArrayList<BookVO> list() {
		ResultSet rs = null; // 항목명 + 결과 데이터를 담고 있는 테이블

		ArrayList<BookVO> list = new ArrayList<>();

		BookVO bag = null;
		try {
			// mySql 연결할 부품 설정
			Class.forName("com.mysql.cj.jdbc.Driver");

			// mySql 연결
			String url = "jdbc:mysql://localhost:3306/multi?serverTimezone=UTC";
			String user = "root";
			String password = "1234";
			Connection con = DriverManager.getConnection(url, user, password);

			// 3. SQL문 작성
			String sql = "select * from book";
			PreparedStatement ps = con.prepareStatement(sql);

			// 보내기
			rs = ps.executeQuery(); // select할 때는 executeQuery();
			// 1. 검색결과가 있으면 while문으로 반복해서 실행.
			while (rs.next()) { // 검색결과 있는지 여부는 rs.next()
				// 2. 각 컬럼에서 값들을 꺼내오기.
				int id = rs.getInt(1);
				String name = rs.getString(2);
				String url2 = rs.getString(3);
				String img = rs.getString(4);
				// 3. 가방을 만들자.
				bag = new BookVO();
				bag.setId(id);
				bag.setName(name);
				bag.setUrl(url2);
				bag.setImg(img);
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
}
