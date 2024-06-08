package myFoodora.design.abstractFactory;
import java.util.ArrayList;

import myFoodora.model.*;

public interface  AbstractFactory {
	
	default Order createOrder(Restaurant restaurant,Customer customer){
		return null;
	}
	default Meal createMeal(String name, Dish item1, Dish item2, Dish item3){
		return null;
	}
	
	default void createDish(String restaurantName,String dishCategory, ArrayList<String> para){}
	
	default User createUser(String userType,ArrayList<String> para){
		return null;
	}
}
