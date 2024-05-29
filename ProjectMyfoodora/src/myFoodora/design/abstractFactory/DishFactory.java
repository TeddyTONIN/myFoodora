package myFoodora.design.abstractFactory;

import myFoodora.model.Customer;
import myFoodora.model.Dish;
import myFoodora.model.Meal;
import myFoodora.model.Order;
import myFoodora.model.Restaurant;

public class DishFactory extends AbstractFactory {

	@Override
	public Order createOrder(Restaurant restaurant,Customer customer) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Meal createMeal(String name, Dish item1, Dish item2, Dish item3) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Dish createDish(String name, String category, String type,double price) {
		// add errors when the 'category' is not stater,main_dish or dessert
		return new Dish(name,category,type,price);
	}

}
