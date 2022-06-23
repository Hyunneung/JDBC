// // �����ͺ��̽��� ������ �����ͺ��̽��� ���̺� ������ �д� ���α׷�
package statement.arraylist_map;

import java.sql.*;
import java.util.*;

public class DAO {

	public ArrayList<Map<String, Object>> selectAll() {
		ArrayList<Map<String, Object>> emplist = null;
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "scott", "tiger");
			stmt = conn.createStatement();

			String select_sql = "select * from emp";
			System.out.println(select_sql + "\n");
			rs = stmt.executeQuery(select_sql);

			int i = 0;
			while (rs.next()) {
				if (i++ == 0) { // emplist�� �����Ͱ� ���� �� 1���� �����
					emplist = new ArrayList<Map<String, Object>>();
				}
				Map map = new HashMap<String, Object>();

				map.put("empno", rs.getInt(1));
				map.put("ename", rs.getString(2));
				map.put("job", rs.getString(3));
				map.put("mgr", rs.getInt(4));
				map.put("hiredate", rs.getDate(5));
				map.put("sal", rs.getInt(6));
				map.put("comm", rs.getInt(7));
				map.put("deptno", rs.getInt(8));

				emplist.add(map);
			} // while ��
		} catch (ClassNotFoundException cnfe) {
			System.out.println("�ش� Ŭ������ ã�� �� �����ϴ�." + cnfe.getMessage());
		} catch (SQLException se) {
			System.out.println(se.getMessage());
		} finally {
			try {
				if (rs != null)
					rs.close();
			} catch (SQLException se) {
				System.out.println(se.getMessage());
			}
			try {
				if (stmt != null)
					stmt.close();
			} catch (SQLException se) {
				System.out.println(se.getMessage());
			}
			try {
				if (conn != null)
					conn.close();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		} // try-catch-finally ��

		return emplist;
	}
}
