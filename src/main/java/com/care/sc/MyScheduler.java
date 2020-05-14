package com.care.sc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class MyScheduler {
	private int i = 1;

	public void schedul() {
		String sql = "select count(*) from userlog";
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			Connection conn = DriverManager.getConnection(url, "jsp", "1234");
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			int result = 0;
			if(rs.next())
				result = rs.getInt(1);
			System.out.println(i + "분 : " + result + "개");
			i++;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
