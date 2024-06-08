package myFoodora.model;

public class FidelityCard  {
	private Restaurant restaurant;
	
	private Customer customer;
	
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public FidelityCard(Restaurant restaurant) {
		this.restaurant = restaurant;
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
