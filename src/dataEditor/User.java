package dataEditor;
 
public class    User {
	private String accout; 
	private String pass; 
 
	public User() {
		super();
	}
 
	public User(String accout, String pass) {
		super();
		this.accout = accout;
		this.pass = pass;
	}
 
	public String getAccout() {
		return accout;
	} 
	public void setAccout(String accout) {
		this.accout = accout;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	
}
