package myFoodora.model;
import java.util.ArrayList;
import myFoodora.design.observer.*;

public class Customer extends User implements Observer {
	
	private String name;
	private String surname;
	private Coordinate address;
	private String email;
	private String phone;
	private boolean specialOffers = false;
	private  ArrayList<Order> OrderHistory;
	private ArrayList<FidelityCard> FidelityPlan;
	
	public Customer(String ID, String username, String password, Coordinate address, String email,String phone) {
		super(ID,username,password);
		this.address = address;
		this.email = email;
		this.phone = phone;
		
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

	public ArrayList<Order> getOrderHistory() {
		return OrderHistory;
	}

	public void setOrderHistory(ArrayList<Order> orderHistory) {
		OrderHistory = orderHistory;
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
		
		OrderHistory.add(order);
		
	}
	
	public void update(){
		
	}
	

}
