// insert - goodsinfo2 ���̺� �� �߰�
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

			String insert_sql = "insert into goodsinfo2 " + "values ('Z1000','�������콺',500,'HP')";
			System.out.println(insert_sql + "\n");

			int rowNum = stmt.executeUpdate(insert_sql);
			System.out.println(rowNum + "���� �߰��Ǿ����ϴ�.");

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
