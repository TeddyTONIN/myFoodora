package myFoodora.design.abstractFactory;


import myFoodora.model.*;

public class OrderFactory extends AbstractFactory{
	
	public Order createOrder(Restaurant restaurant,double x,double y) {
		
		Order order = new Order(restaurant, x,y);	
		return order;
	}
	public Meal createMeal(String category, Dish item1, Dish item2, Dish item3) {
		return null;
	}
}
