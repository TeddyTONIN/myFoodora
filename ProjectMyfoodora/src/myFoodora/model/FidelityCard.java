package myFoodora.model;

public class FidelityCard  {

	private Restaurant restaurant;
	
	private Customer customer;
	
	public FidelityCard(Restaurant restaurant,Customer customer) {
		this.restaurant = restaurant;
		this.customer = customer;
	}
	
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public Restaurant getRestaurant() {
		return restaurant;
	}
	public void setRestaurant(Restaurant restaurant) {
		this.restaurant = restaurant;
	}

	public void update() {
		
	}
	
	public double computeDiscount(double priceWithoutDiscount) {
		return 0.0;
	}
}
