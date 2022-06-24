// �����ͺ��̽��� ������ �����ͺ��̽��� ���̺� ������ �д� ���α׷�
package preparedstatement;

import java.sql.*;
import java.util.ArrayList;

public class DAO {

	public ArrayList<Emp> selectAll() {
		ArrayList<Emp> emplist = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "scott", "tiger");

			String select_sql = "select * from emp " + "where empno = ?";
			pstmt = conn.prepareStatement(select_sql);
			int select_num = 7788;
			pstmt.setInt(1, 7788);
			
			System.out.println(select_sql.replace("?", "") + select_num);
			rs = pstmt.executeQuery();

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
				if (pstmt != null)
					pstmt.close();
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
