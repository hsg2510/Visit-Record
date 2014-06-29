package value;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;


public class RecordSet {
	protected String email;
	protected String pwd;
	protected String contents;
	protected String subject;
	protected Date cre_date;
	protected Date mod_date;
	
	public String getEmail(){
		return email;
	}
	public RecordSet setEmail(String email){
		this.email = email;
		return this;		
	}
	public String getPwd(){
		return pwd;
	}
	public RecordSet setPwd(String pwd){
		this.pwd = pwd;
		return this;
	}
	public String getContents(){
		return contents;
	}
	public RecordSet setContents(String contents){
		this.contents = contents;
		return this;
	}
	public String getSubject(){
		return subject;
	}
	public RecordSet setSubject(String subject){
		this.subject = subject;
		return this;
	}
	public Date getCreDate(){
		return cre_date;
	}
	public RecordSet setCreDate(Date cre_date){
		this.cre_date = cre_date;
		return this;
	}
	public Date getModDate(){
		return mod_date;
	}
	public RecordSet setModDate(Date mod_date){
		this.mod_date = mod_date;
		return this;
	}
public boolean isMember(String email, String pwd) throws RuntimeException, ClassNotFoundException {
		

		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		
		try {
			Class.forName("cubrid.jdbc.driver.CUBRIDDriver");
			conn = DriverManager.getConnection("jdbc:cubrid:localhost:33000:demodb:::", "dba", "1111");
			//stmt = conn.createStatement();
			
			stmt = conn.prepareStatement("select email from visitRecord where email = ? and pwd = ?");
			stmt.setString(1, email);
			stmt.setString(2, pwd);

			rs = stmt.executeQuery();
			
			if(rs.next()){
				return true;
			}
		} 
		catch (SQLException e) {
			throw new RuntimeException("����� ��ȸ ���� �߻�", e);
		} 
		finally {
			try{
				if (rs != null)	rs.close();
				if (stmt != null)	stmt.close();
				if (conn != null)	conn.close();
			}
			catch(Exception e){	}
		}
		return false;
	}

}
