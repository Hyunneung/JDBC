package transaction;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Transaction_Ex01 {

	public static void main(String[] args) {
		Connection conn = null;
		PreparedStatement pstmt = null;

		StringBuilder insert_sql = new StringBuilder();
		insert_sql.append("insert into goodsinfo2 ");
		insert_sql.append("values (?,?,?,?) ");

		StringBuilder update_sql = new StringBuilder();
		update_sql.append("update goodsinfo2 ");
		update_sql.append("set price =? ");
		update_sql.append("where code =? ");

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "scott", "tiger");

			conn.setAutoCommit(false);

			// insert
			pstmt = conn.prepareStatement(insert_sql.toString());
			pstmt.setString(1, "10007");
			pstmt.setString(2, "냉장고");
			pstmt.setInt(3, 10000);
			pstmt.setString(4, "삼성");
			int result = pstmt.executeUpdate();
			pstmt.close();

			// update
			pstmt = conn.prepareStatement(update_sql.toString());
			pstmt.setInt(1, 10000);
			pstmt.setString(2, "10001");
			result += pstmt.executeUpdate();

			if (result == 2) {
				System.out.println("db에 반영됨 . . . .");
			} else {
				System.out.println("db에 반영되지 않음 . . . .");
			}

		} catch (ClassNotFoundException cnfe) {
			System.out.println("클래스를 찾을 수 없습니다.");
		} catch (SQLException se) {
			se.printStackTrace();
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
			} catch (SQLException se) {
				se.printStackTrace();
			}
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException se) {
				se.printStackTrace();
			}
		} // try-catch-finally 끝
	}
}
