package visitRecord;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.GenericServlet;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//@WebServlet("/visitRecord/main")
public class VisitRecord extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TOsDO Auto-generated method stub
		
		response.setContentType("text/html; charset=UTF-8");
		RequestDispatcher rd = request.getRequestDispatcher("/visitRecord/main.jsp");
		rd.include(request, response);
		
		/*PrintWriter out = response.getWriter();
		out.println("<html><head><title>방명록</title></head>");
		out.println("<body><h1>방 명 록</h1>");
		out.println("<form action='main' method='post'>");
		out.println("이메일: <input type='text' name='email'><br>");
		out.println("비밀번호: <input type='password' name='password'><br>");
		out.println("방명록: <input type='text' name='visitRecord'><br>");
		out.println("<input type='submit' value='등록'>");
		out.println("</form>");
		out.println("</body></html>");
		*/
		
				
				

	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
							throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		Connection conn = null;
		PreparedStatement stmt = null;
		
		try{
			
			Class.forName("cubrid.jdbc.driver.CUBRIDDriver");
			conn = DriverManager.getConnection("jdbc:cubrid:localhost:33000:demodb:::", "dba", "1111");
			//DriverManager.registerDriver(new com.mysql.jdbc.Driver());
			//conn = DriverManager.getConnection("jdbc:mysql://localhost/studydb", "study", "study");
			stmt = conn.prepareStatement("Insert into visitRecord (email, pwd, contents, subject, cre_date, mod_date)" +
			                              " values (?, ?, ?, ?, now(), now())");
			stmt.setString(1, request.getParameter("email"));
			stmt.setString(2, request.getParameter("password"));
			stmt.setString(3, request.getParameter("visitRecord"));
			stmt.setString(4, request.getParameter("subject"));
			stmt.executeUpdate();
			
			response.addHeader("Refresh", "1;url=list");
			
		} catch (Exception e) {
			throw new ServletException(e);
		} finally {
			try { if (stmt != null) stmt.close();} catch(Exception e) {}
			try { if (conn != null) conn.close();} catch(Exception e) {}
		}
	}
}
