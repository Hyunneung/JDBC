// delete - goodsinfo2 ���̺� �� ����
package DML;

import java.sql.*;

public class Delete_Ex01 {
	public static void main(String[] args) {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "scott", "tiger");
			stmt = conn.createStatement();

			String delete_sql = "delete goodsinfo2 " + "where code = 'Z1000'";
			System.out.println(delete_sql + "\n");

			int rowNum = stmt.executeUpdate(delete_sql);
			System.out.println(rowNum + "���� �����Ǿ����ϴ�.");

		} catch (ClassNotFoundException cnfe) {
			System.out.println("�ش� Ŭ������ ã�� �� �����ϴ�: " + cnfe.getMessage());
		} catch (SQLException se) {
			System.out.println(se.getMessage());
		} finally {
			try {
				if (rs != null) // ResultSet ���� �ݱ�
					rs.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
			try {
				if (stmt != null) // �������� Statement �ݱ�
					stmt.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
			try {
				if (conn != null) // ������ DB���� ����
					conn.close();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		} // finally ��
	}
}
