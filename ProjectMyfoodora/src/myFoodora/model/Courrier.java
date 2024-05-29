package myFoodora.model;
import myFoodora.design.observer.*;

import java.util.ArrayList;

public class Courrier extends User implements Observable{
	
	private ArrayList<Observer> observers = new ArrayList<Observer>();
	private String name;
	private String surname;
	private Coordinate position;
	private int counter = 0;
	private boolean on_duty;
	
	public Courrier(String ID, String username, String password,String name, String surname) {
		super(ID, username, password);
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
	
	public void attach(Observer ) {
		
	}
	public void dettach(Observer ) {
		
	}
	
	public void notify(){	
	}

}
