<%@ page contentType="text/html; charset=utf-8"%>
<%@ page import="java.sql.*"%>
<%
	Connection con = null;
try {
	/**************** Oracle 연결 설정 *****************************/
 	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	String user = "scott";
	String password = "tiger";	

	/***************** My-SQL 연결 설정 ***************************/
// 	 String driver = "com.mysql.cj.jdbc.Driver";
// 	 String url = "jdbc:mysql://localhost:3306/jsptest";
// 	 String user = "jspid";
// 	 String password = "jsppass";	

	Class.forName(driver);
	con = DriverManager.getConnection(url, user, password);

	out.println("연결되었습니다.");

} catch (Exception e) {
	e.printStackTrace();
} finally {
	try{
		if(con != null)  con.close();
	}catch(Exception e){
		out.println("⚠️ DB 연결 중 에러가 발생했습니다: " + e.getMessage());
		
		// 상세한 에러 추적 경로까지 브라우저 화면에 싹 다 뿌려주는 코드입니다.
		out.println("<pre>");
		java.io.PrintWriter pw = new java.io.PrintWriter(out);
		e.printStackTrace(pw);
		out.println("</pre>");	}
}
%>
