package myFoodora.model;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import myFoodora.design.observer.*;

public class Customer extends User implements Observer {
	private String lastName;
	private String firstName;
	private Coordinate address;
	private String email;
	private String phone;
	private boolean specialOffers = false;
	private Map<String,Order> OrderHistory;
	private ArrayList<FidelityCard> FidelityPlan;
	
	
	public Customer(String username, String password, Coordinate address, String email) {
		super(username,password);
		this.address = address;
		this.email = email;

	}
	public Customer(String firstName,String lastName,String username,Coordinate address,String password) {
		super(username,password);
		this.address=address;
		this.lastName=lastName;
		this.firstName=firstName;
		this.OrderHistory=new HashMap<>();
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String name) {
		this.firstName = name;
	}


	public Coordinate getAddress() {
		return address;
	}

	public void setAddress(Coordinate address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public boolean isSpecialOffers() {
		return specialOffers;
	}

	public void setSpecialOffers(boolean specialOffers) {
		this.specialOffers = specialOffers;
	}

	public Map<String, Order> getOrderHistory() {
		return OrderHistory;
	}


	public ArrayList<FidelityCard> getFidelityPlan() {
		return FidelityPlan;
	}

	public void setFidelityPlan(ArrayList<FidelityCard> fidelityPlan) {
		FidelityPlan = fidelityPlan;
	}
	
	public void registerFidelity(FidelityCard card) {
		
		FidelityPlan.add(card);
	}
	public void unregisterFidelity(FidelityCard card) {
		FidelityPlan.remove(card);
	}
	
	public void placeOrder(Order order) {
		
		OrderHistory.put(order.getOrderName(),order);
		
	}
	
	public void update(){
		
	}
	

}
