package visitRecord;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import value.RecordSet;

public class RecordUpdate extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
	                      throws ServletException, IOException {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try{
			DriverManager.registerDriver(new com.mysql.jdbc.Driver());
			conn = DriverManager.getConnection("jdbc:mysql://localhost/studydb", "study", "study");
			//Class.forName(this.getInitParameter("driver"));
			//conn = DriverManager.getConnection(this.getInitParameter("url"),this.getInitParameter("username"),
			//									this.getInitParameter("password"));
			stmt = conn.createStatement();
	
			rs = stmt.executeQuery( "select * from visitRecord where email = '" + request.getParameter("email") + "'");
			rs.next();
			
			response.setContentType("text/html; charset=UTF-8");
			
			ArrayList<RecordSet> records = new ArrayList<RecordSet>();
			records.add(new RecordSet()
							.setEmail(rs.getString("email"))
							.setPwd(rs.getString("pwd"))
							.setContents(rs.getString("contents"))
					);	
			
			request.setAttribute("records",records);
			
			RequestDispatcher rd = request.getRequestDispatcher("/visitRecord/update.jsp");
			rd.include(request, response);
			/*PrintWriter out = response.getWriter();
			out.println("<html><head><title>방명록 수정</title></head>");
			out.println("<body><h1>내 용</h1>");
			out.println("<form action='update' method='post'>");
			out.println("이메일: <input type='text' name='email' value='" + rs.getString("email") + "' readonly><br>'");
			out.println("내용: <input type='text' name='contents' value='" + rs.getString("contents") + "' <br>");
			//out.println("가입일: " + rs.getDate("CRE_DATE") + "<br>");
			out.println("<input type ='submit' value='수정'>");
			out.println("<input type = 'button' value='취소' onclick='location.href=\"list\"'>");
			out.println("</form>");
			out.println("</body></html>");*/
		} catch(Exception e) {
			throw new ServletException(e);
		} finally {
					try {if (rs != null) rs.close(); } catch(Exception e){}
					try {if (stmt != null) stmt.close(); } catch(Exception e){}
					try {if (conn != null) conn.close(); } catch(Exception e){}			
			
		}
	}
	
	protected void doPost(
			HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException{
		request.setCharacterEncoding("UTF-8");
		Connection conn = null;
		PreparedStatement stmt = null;
		try{
			Class.forName(this.getInitParameter("driver"));
			conn = DriverManager.getConnection(
					this.getInitParameter("url"),
					this.getInitParameter("username"),
					this.getInitParameter("password"));
			stmt = conn.prepareStatement(
					"update visitRecord set contents=?"
					+ " where email=?");
			stmt.setString(1, request.getParameter("contents"));
			stmt.setString(2, request.getParameter("email"));
			stmt.executeUpdate();
			
			response.sendRedirect("list");
		
		} catch(Exception e) {
			throw new ServletException(e);			
		} finally {
			try { if (stmt !=null) stmt.close();} catch(Exception e){}
			try { if (conn !=null) conn.close();} catch(Exception e){}
		}
		
	
}

}