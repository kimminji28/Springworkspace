package com.yedam.app.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Hello world!
 *
 */
public class App 
{
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// 1. JDBC Driver Load
		Class.forName("oracle.jdbc.OracleDriver");
		
		// 2. DB접속 : 연결할 DB정보 필요
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String username = "hr";
		String password = "hr";
		
		Connection conn 
		= DriverManager.getConnection(url, username, password);
		
		// 3. SQL문 실행
		// 3-1. Statement or PreparedStatement 객체 생성
		Statement stmt = conn.createStatement();
		
		// 3-2. SQL문 전달 및 실행
		String sql = "SELECT * FROM employees";
		ResultSet rs =stmt.executeQuery(sql);
		// DML : executeUpdate();

		// 3-3. 결과 반환받고 처리
		// 다건조회일때
		while(rs.next()) {
			// 현재 커서가 가리키는 데이터가 있는 경우
			String firstName = rs.getString("first_name");
			String lastName = rs.getString("last_name");
			System.out.printf("이름 : %s, %s\n", firstName, lastName);			
		}
		
		// 4. 자원해제
		if(rs != null) rs.close();
		if(stmt != null) stmt.close();
		if(conn != null) conn.close();

	}

}
