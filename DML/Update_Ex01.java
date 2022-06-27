// update - goodsinfo2 테이블 행 수정
package DML;

import java.sql.*;

public class Update_Ex01 {
	public static void main(String[] args) {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "scott", "tiger");
			stmt = conn.createStatement();

			String update_sql = "update goodsinfo2 "
								+ "set maker = '오라클' "
								+ "where code = '10004'";
			System.out.println(update_sql + "\n");

			int rowNum = stmt.executeUpdate(update_sql);
			System.out.println(rowNum + "행이 수정되었습니다.");

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
