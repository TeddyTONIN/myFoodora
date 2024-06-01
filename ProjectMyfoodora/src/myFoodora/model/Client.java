package myFoodora.model;

import myFoodora.design.observer.Observable;
import myFoodora.design.observer.Observer;

public class Client extends User implements Observable{
	private String firstName;
	private String lastName;
	private Coordinate position;
	
	public Client(String firstName, String lastName, String username, Coordinate address , String password) {
		super(username,password);
		this.firstName=firstName;
		this.lastName=lastName;
		this.position=address;
	}

	@Override
	public void notify(Observer observer) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void attach(Observer observer) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void dettach() {
		// TODO Auto-generated method stub
		
	}
}
