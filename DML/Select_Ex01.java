// select - emp ���̺� ��ȸ
package DML;

import java.sql.*;

public class Select_Ex01 {
	public static void main(String[] args) {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "scott", "tiger");
			stmt = conn.createStatement();
			
			String sql = "select * from emp";
			System.out.println(sql + "\n");
			
			System.out.println("��ȣ\t�����ȣ\t����̸�\t����\t\t���\t�Ի���\t\t�޿�\tĿ�̼�\t�μ���ȣ");
			System.out.println("---------------------------------------------------------------------------------------------------");

			rs = stmt.executeQuery(sql);
			int i = 0;
			while (rs.next()) {
				int empno = rs.getInt("empno");
				String ename = rs.getString("ename");
				String job = rs.getString("job");
				int mgr = rs.getInt("mgr");
				Date hiredate = rs.getDate("hiredate");
				int sal = rs.getInt("sal");
				int comm = rs.getInt("comm");
				int deptno = rs.getInt("deptno");

				System.out.printf("%3d\t%5d\t%-3s\t%-10s\t%-5d\t%s\t%3d\t%4d\t%5d\n", ++i, empno, ename, job,
						mgr, hiredate, sal, comm, deptno);
			} // while ��
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
