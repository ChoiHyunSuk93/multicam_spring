package com.multi.mvc01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Locale;

import org.springframework.stereotype.Component;


@Component
public class MeetingDAO { // CRUD
	public int insert(MeetingVO bag) {
		// 1. 가방을 받아서 변수에 넣어주세요.
		int result = 0;

		try {
			// 1.오라클 11g와 연결한 부품 설정
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("1.mySQL과 자바 연결할 부품 설정 성공.");
			Locale.setDefault(Locale.US); // 맥 locale에러나신 분들만!!!

			// 2.오라클 11g에 연결해보자.(java --- oracle)
			// String url = "jdbc:mysql://localhost:3306/multi";
			String url = "jdbc:mysql://localhost:3306/multi?serverTimezone=UTC";
			String user = "root";
			String password = "1234";
			Connection con = DriverManager.getConnection(url, user, password); // Connection
			// String data = JOptionPane.showInputDialog("이름입력"); //String, 임아무개
			System.out.println("2. mySQL 연결 성공.");

			String sql = "insert into meeting values (?, ?, ?, ?, ?)";
			PreparedStatement ps = con.prepareStatement(sql); // PreparedStatement

			ps.setString(1, bag.getRank());
			ps.setString(2, bag.getName());
			ps.setString(3, bag.getPhone());
			ps.setString(4, bag.getBoolean2());
			ps.setString(5, bag.getTime());

			System.out.println("3. SQL문 부품(객체)으로 만들어주기 성공.");

			result = ps.executeUpdate(); // 1
			System.out.println("4. SQL문 오라클로 보내기 성공.");
			if (result == 1) {
				System.out.println("회원가입 성공!");
			}
			// System.out.println(result);
		} catch (Exception e) {
			// insert가 제대로 안된 경우, 위험한 상황이라고 판단하고
			// catch가 실행
			// 실행된 Row수가 없으므로 Result에 0을 넣어주자.!
			// result = 0;
			e.printStackTrace();
		}

		System.out.println(result);
		return result;
	}
	
	public int update(MeetingVO bag) {
		int result = 0;
		try {
			// mySql 연결할 부품 설정
			Class.forName("com.mysql.cj.jdbc.Driver");

			// mySql 연결
			String url = "jdbc:mysql://localhost:3306/multi?serverTimezone=UTC";
			String user = "root";
			String password = "1234";
			Connection con = DriverManager.getConnection(url, user, password);

			// 3. SQL문 작성
			String sql = "update meeting set phone = ? where rank = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, bag.getPhone());
			ps.setString(2, bag.getRank());
			// con부품으로 sql스트링에 있는 것 SQL부품으로 만들어주세요.

			// 보내기
			result = ps.executeUpdate(); // insert, update, delete문만! sql문 실행 결과가 int

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} // try-catch
		return result;
	}

	public int delete(MeetingVO bag) {
		int result = 0;
		try {
			// mySql 연결할 부품 설정
			Class.forName("com.mysql.cj.jdbc.Driver");

			// mySql 연결
			String url = "jdbc:mysql://localhost:3306/multi?serverTimezone=UTC";
			String user = "root";
			String password = "1234";
			Connection con = DriverManager.getConnection(url, user, password);

			// 3. SQL문 작성
			String sql = "delete from meeting where rank = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, bag.getRank());

			// 보내기
			result = ps.executeUpdate();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} // try-catch
		return result;
	}
	
	public ArrayList<MeetingVO> list() {
		ResultSet rs = null; // 항목명 + 결과 데이터를 담고 있는 테이블

		ArrayList<MeetingVO> list = new ArrayList<>();

		MeetingVO bag = null;
		try {
			// mySql 연결할 부품 설정
			Class.forName("com.mysql.cj.jdbc.Driver");

			// mySql 연결
			String url = "jdbc:mysql://localhost:3306/multi?serverTimezone=UTC";
			String user = "root";
			String password = "1234";
			Connection con = DriverManager.getConnection(url, user, password);

			// 3. SQL문 작성
			String sql = "select * from meeting";
			PreparedStatement ps = con.prepareStatement(sql);

			// 보내기
			rs = ps.executeQuery(); // select할 때는 executeQuery();
			// 1. 검색결과가 있으면 while문으로 반복해서 실행.
			while (rs.next()) { // 검색결과 있는지 여부는 rs.next()
				// 2. 각 컬럼에서 값들을 꺼내오기.
				String rank = rs.getString(1);
				String name = rs.getString(2);
				String phone = rs.getString(3);
				String boolean2 = rs.getString(4);
				String time = rs.getString(5);
				// 3. 가방을 만들자.
				bag = new MeetingVO();
				bag.setRank(rank);
				bag.setName(name);
				bag.setPhone(phone);
				bag.setBoolean2(boolean2);
				bag.setTime(time);
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

	public MeetingVO one(String rank) {
		ResultSet rs = null; // 항목명 + 결과 데이터를 담고 있는 테이블
		MeetingVO bag = null;
		try {
			// mySql 연결할 부품 설정
			Class.forName("com.mysql.cj.jdbc.Driver");

			// mySql 연결
			String url = "jdbc:mysql://localhost:3306/multi?serverTimezone=UTC";
			String user = "root";
			String password = "1234";
			Connection con = DriverManager.getConnection(url, user, password);

			// 3. SQL문 작성
			String sql = "select * from meeting where rank = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, rank);

			// 보내기
			rs = ps.executeQuery(); // select할 때는 executeQuery();
			if (rs.next()) { // 검색결과 있는지 여부는 rs.next()
				// true -> 검색결과 O, false -> 검색결과 X
				System.out.println("검색결과가 있다.");
				String rank2 = rs.getString(1);
				String name = rs.getString(2);
				String phone = rs.getString(3);
				String boolean2 = rs.getString(4);
				String time = rs.getString(5);
				// 검색결과를 검색화면 UI부분에 주어야 함.
				bag = new MeetingVO();
				bag.setRank(rank2);
				bag.setName(name);
				bag.setPhone(phone);
				bag.setBoolean2(boolean2);
				bag.setTime(time);
			} else {
				System.out.println("검색결과 없음.");
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} // try-catch
		return bag;
	}
}