package value;

public class RecordSet {
	protected String email;
	protected String pwd;
	protected String contents;
	
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

}
