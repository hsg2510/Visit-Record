package visitRecord;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import value.RecordSet;


public class LogInServlet extends HttpServlet {
	
	@Override
	protected void doGet(
			HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/auth/LogInForm.jsp");
		rd.forward(request, response);		
	}
	
	@Override
	protected void doPost(
			HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection conn = null;
		PreparedStatement stmt = null;
		PreparedStatement stmt2 = null;
		//Statement stmt2 = null;
		ResultSet rs = null;
		
		try{
			ServletContext sc = this.getServletContext();
			conn = (Connection) sc.getAttribute("conn");
			stmt = conn.prepareStatement("select * from visitRecord where email=? and pwd=?");
			stmt.setString(1, request.getParameter("email"));
			stmt.setString(2, request.getParameter("password"));
			rs = stmt.executeQuery();
			response.setContentType("text/html; charset=UTF-8");
			if(rs.next()) {
				//RecordSet record = new RecordSet()
				//				.setEmail(rs.getString("email"))
				//				.setPwd(rs.getString("pwd"));
				//HttpSession session = request.getSession();
				//session.setAttribute("record", record);
				stmt2 = conn.prepareStatement(
						"update visitRecord set contents=?"
						+ " where email=?");
				System.out.println(request.getParameter("email"));
				System.out.println(request.getParameter("contents"));
				stmt2.setString(1, request.getParameter("contents"));
				stmt2.setString(2, request.getParameter("email"));
				stmt2.executeUpdate();
				response.sendRedirect("../visitRecord/list");
			}
			else{
				RequestDispatcher rd = request.getRequestDispatcher("/auth/LogInFail.jsp");
				rd.forward(request, response);				
			}
		} catch (Exception e){
			throw new ServletException(e);
		} finally {
			try {if (rs != null) rs.close();} catch (Exception e) {}
			try {if (stmt != null) stmt.close();} catch (Exception e) {}
			try {if (stmt2 != null) stmt2.close();} catch (Exception e) {}
		}
	}
}
