package myFoodora.model;


public class BasicFidelityCard extends FidelityCard{
	

	public BasicFidelityCard(Customer customer) {
		super(customer);
		// TODO Auto-generated constructor stub
	}

	public double computeDiscount(Order order,double priceWithoutDiscount) {
		if (order.getItemsOrdered().contains(order.getRestaurant().getMeal_of_the_week())) {
			return order.getRestaurant().getMeal_of_the_week().getPrice();
		}
		return 0.0;
	
	}
	
	
}

