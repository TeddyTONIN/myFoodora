package myFoodora.model;
import myFoodora.design.observer.*;

import java.util.ArrayList;

public class Courrier extends User implements Observable{
	
	private ArrayList<Observer> observers = new ArrayList<Observer>();
	private String firstName;
	private String lastName;
	private Coordinate position;
	private int counter = 0;
	private boolean on_duty;
	
	public Courrier(String ID, String username, String password,String firstName, String surname) {
		super(username, password);
		this.firstName = firstName;

	}
	
	//rajout d'un constructeur cohérent à la commande de l'interface 
	public Courrier(String firstName, String lastName,String username,Coordinate adress,String password) {
		super(username, password);
		this.firstName = firstName;
		this.lastName=lastName;
		this.position=adress;
		this.on_duty= true;
	}

	public String getName() {
		return firstName;
	}

	public void setName(String firstName) {
		this.firstName = firstName;
	}

	public Coordinate getPosition() {
		return position;
	}

	public void setPosition(double x, double y) {
		
		Coordinate position = new Coordinate(x,y);
		this.position = position;
	}

	public int getCounter() {
		return counter;
	}

	public void setCounter(int counter) {
		this.counter = counter;
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

	public boolean isOn_duty() {
		return on_duty;
	}

	public void setOn_duty(boolean on_duty) {
		this.on_duty = on_duty;
	}
	
	


}
