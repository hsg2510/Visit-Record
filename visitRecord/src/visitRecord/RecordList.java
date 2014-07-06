package visitRecord;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.GenericServlet;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import value.RecordSet;


public class RecordList extends GenericServlet {

	@Override
	public void service(ServletRequest request, ServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			ServletContext sc = this.getServletContext();
			conn = (Connection) sc.getAttribute("conn");
			
			//Class.forName("cubrid.jdbc.driver.CUBRIDDriver");
			//conn = DriverManager.getConnection("jdbc:cubrid:localhost:33000:demodb:::", "dba", "1111");
			stmt = conn.createStatement();
			rs = stmt.executeQuery("select * from visitRecord");
			response.setContentType("text/html; charset=UTF-8");
			ArrayList<RecordSet> records = new ArrayList<RecordSet>();
			while(rs.next()){
				records.add(new RecordSet()
								.setEmail(rs.getString("email"))
								.setPwd(rs.getString("pwd"))
								.setContents(rs.getString("contents"))
								.setSubject(rs.getString("subject"))
								.setCreDate(rs.getDate("cre_date"))
								.setModDate(rs.getDate("mod_date"))
						);	
			}
			
			request.setAttribute("records",records);
			
			RequestDispatcher rd = request.getRequestDispatcher("/visitRecord/records.jsp");
			rd.include(request, response);
			/*PrintWriter out = response.getWriter();
			out.println("<html><head><title>방명록 리스트</title></head>");
			out.println("<body><h1>방명록 리스트</h1>");
			while(rs.next()){
				out.println(
						     rs.getString("email") + "," + 
				             rs.getString("pwd") + "," + 
						    "<a href='update?email=" + rs.getString("email") + "&" + "contents=" 
				             + rs.getString("contents") + "'>" + rs.getString("contents") + "</a>" + 
				            "<br>" );						 
			}
			out.println("</body></html>");*/
		} catch(Exception e) {
			throw new ServletException(e);
		} finally{
			try { if (rs != null) rs.close();} catch(Exception e){}
			try { if (stmt != null) stmt.close();} catch(Exception e){}
			//try { if (conn != null) conn.close();} catch(Exception e){}
		}

	}

}
