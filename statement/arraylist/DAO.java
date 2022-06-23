// 데이터베이스와 연동해 데이터베이스의 테이블 내용을 읽는 프로그램
package statement.arraylist;

import java.sql.*;
import java.util.ArrayList;

public class DAO {

	public ArrayList<Emp> selectAll() {
		ArrayList<Emp> emplist = null;
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
				if (i++ == 0) { // emplist는 데이터가 있을 때 1번만 만든다
					emplist = new ArrayList<Emp>();
				}

				Emp e = new Emp(); // 사원마다 객체 각각 생성
				e.setEmpno(rs.getInt(1));
				e.setEname(rs.getString(2));
				e.setJob(rs.getString(3));
				e.setMgr(rs.getInt(4));
				e.setHiredate(rs.getDate(5));
				e.setSal(rs.getInt(6));
				e.setDeptno(rs.getInt(7));

				emplist.add(e);
			} // while 끝
		} catch (ClassNotFoundException cnfe) {
			System.out.println("해당 클래스를 찾을 수 없습니다." + cnfe.getMessage());
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
		} // try-catch-finally 끝

		return emplist;
	}
}
