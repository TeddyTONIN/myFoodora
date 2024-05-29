package myFoodora.design.abstractFactory;


import myFoodora.model.*;

public class OrderFactory extends AbstractFactory{
	
	public Order createOrder(Restaurant restaurant,Customer customer) {
		
		Order order = new Order(restaurant, customer);	
		return order;
	}
	public Meal createMeal(String name, Dish item1, Dish item2, Dish item3) {
		return null;
	}
    public Dish createDish(String name, String category, String type,double price)  {
    	return null;
    }
}
