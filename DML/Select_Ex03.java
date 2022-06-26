// select - goodsinfo2 테이블 조회
package DML;
import java.sql.*;
public class Select_Ex03 {
	public static void main(String[] args) {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			// 1단계 : JDBC 드라이버를 로드한다
			String driver = "oracle.jdbc.driver.OracleDriver";
			Class.forName(driver);
			
			// 2단계 : DB에 연결한다
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			conn = DriverManager.getConnection(url, "scott", "tiger");
			
			/*  데이터베이스에 있는 테이블의 데이터를 읽어오기 위해서는 Statement 객체가 필요합니다.
			 	2단계에서 얻는 Connection 객체에 대해 createStatement() 메소드를 호출해서 얻습니다.   */
			stmt = conn.createStatement();
			
			/*  Statement 타입
				-java.sql 패키지에 속하는 인터페이스로, select문을 실행하는 executeQuery() 메소드가 있다.
				-executeQuery() 메소드는 파라미터로 select 문장을 넘겨줘야 한다.
				 파라미터로 넘겨준 select문을 데이터베이스로 보내서 실행하고 그 결과로 ResultSet 객체를 리턴한다  */
			String select_sql = "select * from goodsinfo2";
			
			rs = stmt.executeQuery(select_sql);  // select문 데이터베이스로 보내서 실행하고 ResultSet 객체로 리턴
			
			System.out.println("번호\t상품코드\t상품명\t\t가격\t제조사");
			System.out.println("-----------------------------------------------------");
			
			/*  ResultSet 객체로부터 select문의 실행 결과를 얻기 위해서는 먼저 next() 메소드를 호출해야 한다.
				rs.next() - 다음 행 위치로 이동하는 메소드로, 리턴값은 boolean형으로 실제로 행을 읽어 왔는지 여부이다  */
			int i = 0;
			while (rs.next()) { // 더 이상 읽을 데이터가 없을 때까지 반복
				String code = rs.getString("code");

				String name = rs.getString("name");

				int price = rs.getInt("price");

				String maker = rs.getString("maker");

				System.out.printf("%d\t%-7s\t%-10s\t%d\t%-5s\n", ++i, code, name, price, maker);
			} // while 끝

		} catch (ClassNotFoundException cnfe) {
			System.out.println("해당 클래스를 찾을 수 없습니다." + cnfe.getMessage());
		} catch (SQLException se) {
			System.out.println(se.getMessage());
		} finally {
			try {
				if (rs != null) // ResultSet 제일 먼저 닫기
					rs.close();
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
				if (conn != null)
					conn.close(); // 4단계 : DB 연결을 끊는다.
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		} // finally 끝
	}
}
