package myFoodora.model;

public class Manager extends User {
	private String name;
	private String surname;
	public Manager(String username, String password, String name, String surname) {
		super(username, password);
		this.name = name;
		this.surname = surname;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	

}
