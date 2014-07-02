package visitRecord;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UpdateMessage extends HttpServlet {
	
	protected void doPost(
			HttpServletRequest request, HttpServletResponse response)
			throws ServletException{
		request.setCharacterEncoding("UTF-8");
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String email,pwd;
		try{
			email = request.getParameter("email");
			pwd = request.getParameter("password");
			
			Class.forName("cubrid.jdbc.driver.CUBRIDDriver");
			conn = DriverManager.getConnection("jdbc:cubrid:localhost:33000:demodb:::", "dba", "1111");				
			stmt = conn.prepareStatement(
					"select from visitRecord where pwd=? ");
			stmt.setString(1, request.getParameter("pwd"));
			rs = stmt.executeQuery("select from visitRecord where pwd=" + request.getParameter("pwd") );
			
			
			if(rs.next() == false)
			{	
				out.println("등록 실패 비번 틀림");
				
				//JOptionPane.showMessageDialog(null,"비번틀림");
				//response.sendRedirect("list");
			}
			
			//Class.forName(this.getInitParameter("driver"));
			//conn = DriverManager.getConnection(
				//	this.getInitParameter("url"),
				//	this.getInitParameter("username"),
				//	this.getInitParameter("password"));
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
