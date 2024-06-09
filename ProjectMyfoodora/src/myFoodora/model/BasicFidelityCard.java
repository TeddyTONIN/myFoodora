package myFoodora.model;


public class BasicFidelityCard extends FidelityCard{

	
	public BasicFidelityCard(Restaurant restaurant,Customer customer) {
		super(restaurant,customer);
	}

	public double computeDiscount(Order order,double priceWithoutDiscount) {
		if (order.getItemsOrdered().contains(super.getRestaurant().getMeal_of_the_week())) {
			return super.getRestaurant().getMeal_of_the_week().getPrice();
		}
		return 0.0;
	
	}
	
	
}

