// 데이터베이스 테이블로부터 조건에 맞는 데이터를 입력받아 처리하는 프로그램 (Scanner 통해 사원번호 조회)
package DML;

import java.sql.*;
import java.util.Scanner;

public class Select_Ex02 {
	public static void main(String[] args) {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		Scanner sc = new Scanner(System.in);

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "scott", "tiger");
			stmt = conn.createStatement();

			System.out.print("조회할 사원번호를 입력해주세요.>");
			String sql = "select * from emp "
						 + "where empno = " + sc.nextInt();
			
			System.out.println(sql + "\n");
			
			System.out.println("번호\t사원번호\t사원이름\t직급\t\t상사\t입사일\t\t급여\t커미션\t부서번호");
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
			} // while 끝
		} catch (ClassNotFoundException cnfe) {
			System.out.println("해당 클래스를 찾을 수 없습니다: " + cnfe.getMessage());
		} catch (SQLException se) {
			System.out.println(se.getMessage());
		} finally {
			try {
				if (rs != null) // ResultSet 먼저 닫기
					rs.close();
					sc.close();
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
