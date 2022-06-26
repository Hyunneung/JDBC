// select - goodsinfo2 ���̺� ��ȸ
package DML;
import java.sql.*;
public class Select_Ex03 {
	public static void main(String[] args) {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			// 1�ܰ� : JDBC ����̹��� �ε��Ѵ�
			String driver = "oracle.jdbc.driver.OracleDriver";
			Class.forName(driver);
			
			// 2�ܰ� : DB�� �����Ѵ�
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			conn = DriverManager.getConnection(url, "scott", "tiger");
			
			/*  �����ͺ��̽��� �ִ� ���̺��� �����͸� �о���� ���ؼ��� Statement ��ü�� �ʿ��մϴ�.
			 	2�ܰ迡�� ��� Connection ��ü�� ���� createStatement() �޼ҵ带 ȣ���ؼ� ����ϴ�.   */
			stmt = conn.createStatement();
			
			/*  Statement Ÿ��
				-java.sql ��Ű���� ���ϴ� �������̽���, select���� �����ϴ� executeQuery() �޼ҵ尡 �ִ�.
				-executeQuery() �޼ҵ�� �Ķ���ͷ� select ������ �Ѱ���� �Ѵ�.
				 �Ķ���ͷ� �Ѱ��� select���� �����ͺ��̽��� ������ �����ϰ� �� ����� ResultSet ��ü�� �����Ѵ�  */
			String select_sql = "select * from goodsinfo2";
			
			rs = stmt.executeQuery(select_sql);  // select�� �����ͺ��̽��� ������ �����ϰ� ResultSet ��ü�� ����
			
			System.out.println("��ȣ\t��ǰ�ڵ�\t��ǰ��\t\t����\t������");
			System.out.println("-----------------------------------------------------");
			
			/*  ResultSet ��ü�κ��� select���� ���� ����� ��� ���ؼ��� ���� next() �޼ҵ带 ȣ���ؾ� �Ѵ�.
				rs.next() - ���� �� ��ġ�� �̵��ϴ� �޼ҵ��, ���ϰ��� boolean������ ������ ���� �о� �Դ��� �����̴�  */
			int i = 0;
			while (rs.next()) { // �� �̻� ���� �����Ͱ� ���� ������ �ݺ�
				String code = rs.getString("code");

				String name = rs.getString("name");

				int price = rs.getInt("price");

				String maker = rs.getString("maker");

				System.out.printf("%d\t%-7s\t%-10s\t%d\t%-5s\n", ++i, code, name, price, maker);
			} // while ��

		} catch (ClassNotFoundException cnfe) {
			System.out.println("�ش� Ŭ������ ã�� �� �����ϴ�." + cnfe.getMessage());
		} catch (SQLException se) {
			System.out.println(se.getMessage());
		} finally {
			try {
				if (rs != null) // ResultSet ���� ���� �ݱ�
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
				if (conn != null)
					conn.close(); // 4�ܰ� : DB ������ ���´�.
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		} // finally ��
	}
}
