// insert - goodsinfo2 테이블 행 추가
package DML;

import java.sql.*;

public class Insert_Ex01 {
	public static void main(String[] args) {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "scott", "tiger");
			stmt = conn.createStatement();

			String insert_sql = "insert into goodsinfo2 " + "values ('Z1000','무선마우스',500,'HP')";
			System.out.println(insert_sql + "\n");

			int rowNum = stmt.executeUpdate(insert_sql);
			System.out.println(rowNum + "행이 추가되었습니다.");

		} catch (ClassNotFoundException cnfe) {
			System.out.println("해당 클래스를 찾을 수 없습니다: " + cnfe.getMessage());
		} catch (SQLException se) {
			System.out.println(se.getMessage());
		} finally {
			try {
				if (rs != null) // ResultSet 먼저 닫기
					rs.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
			try {
				if (stmt != null) // 다음으로 Statement 닫기
					stmt.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
			try {
				if (conn != null) // 끝으로 DB연결 끊기
					conn.close();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		} // finally 끝
	}
}
