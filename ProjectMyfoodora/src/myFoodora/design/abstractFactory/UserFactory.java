package myFoodora.design.abstractFactory;

import myFoodora.model.Customer;
import myFoodora.model.Dish;
import myFoodora.model.Meal;
import myFoodora.model.Order;
import myFoodora.model.Restaurant;
import myFoodora.model.User;

public class UserFactory extends AbstractFactory{
	public User createUser(String userType,String name,double x,double y) {
		if(userType.equalsIgnoreCase("restaurant")) {
			return new Restaurant(name,x,y);
		}
		return null;
	}

	@Override
	public Order createOrder(Restaurant restaurant, Customer customer) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Meal createMeal(String name, Dish item1, Dish item2, Dish item3) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Dish createDish(String name, String category, String type, double price) {
		// TODO Auto-generated method stub
		return null;
	}
}
