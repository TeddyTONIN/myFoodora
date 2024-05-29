package myFoodora.design.abstractFactory;
import myFoodora.model.*;

public abstract class AbstractFactory {
	public abstract Order createOrder(Restaurant restaurant,Customer customer);
	public abstract Meal createMeal(String name, Dish item1, Dish item2, Dish item3);
	public abstract Dish createDish(String name, String category, String type,double price) ;
}
