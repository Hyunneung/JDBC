// // �����ͺ��̽��� ������ �����ͺ��̽��� ���̺� ������ �д� ���α׷�
package statement.arraylist_��������1;

import java.sql.*;
import java.util.ArrayList;

public class DAO {
	public ArrayList<Emp> search(String[] searchword) {
		ArrayList<Emp> emplist = null;
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		String select_sql = "select * from emp ";
		String menus[] = { "empno", "ename", "job", "mgr", "hiredate", "sal", "comm", "deptno" };

		// sql�� �ۼ�
		for (int i = 0; i < searchword.length; i++) {
			if (searchword[i] != null) {
				String single = "";
				if (i == 1 || i== 2 || i== 4)
					single = "'";
				if (select_sql.contains("where")) {
					select_sql += " and ";
				} else {
					select_sql += "where ";
				}
				select_sql += menus[i] + " = " + single + searchword[i].toUpperCase() + single;
			}
		} // for ��

		System.out.println(select_sql + "\n");

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "scott", "tiger");
			stmt = conn.createStatement();

			rs = stmt.executeQuery(select_sql);

			int i = 0;
			while (rs.next()) {
				if (i++ == 0) { // emplist�� �����Ͱ� ���� �� 1���� �����
					emplist = new ArrayList<Emp>();
				}

				Emp e = new Emp(); // ������� ��ü ���� ����
				e.setEmpno(rs.getInt(1));
				e.setEname(rs.getString(2));
				e.setJob(rs.getString(3));
				e.setMgr(rs.getInt(4));
				e.setHiredate(rs.getDate(5));
				e.setSal(rs.getInt(6));
				e.setDeptno(rs.getInt(7));

				emplist.add(e);
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
