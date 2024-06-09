package myFoodora.model;

public class User {
	private static int IDunique=0;
	private int ID;
	private String username;
	private String password;
	
	public User(String username, String password) {
		this.ID = IDunique;
		IDunique=+1;
		this.username = username;
		this.password = password;
	}
	
	
	public int getID() {
		return ID;
	}
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public User(String username) {
		this.ID = IDunique;
		IDunique=+1;
		this.username = username;
		this.password = "0000";
	}


	@Override
	public String toString() {
		return "username=" + username;
	}
	
	
}
