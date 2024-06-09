package myFoodora.model;

public class FidelityCard  {
	private Customer customer;
	
	public FidelityCard(Customer customer) {
		this.customer = customer;
		
	}
	
	
	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public void update() {
		
	}
	
	public double computeDiscount(double priceWithoutDiscount) {
		return 0.0;
	}
}
