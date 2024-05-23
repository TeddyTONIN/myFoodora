package myFoodora.design.abstractFactory;
import myFoodora.model.*;

public abstract class AbstractFactory {
	public abstract Order createOrder(Restaurant restaurant, double x, double y);
	public abstract Meal createMeal(String category, Dish item1, Dish item2, Dish item3);
}
