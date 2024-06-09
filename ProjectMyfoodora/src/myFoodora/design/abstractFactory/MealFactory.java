package myFoodora.design.abstractFactory;


import java.util.ArrayList;

import myFoodora.model.Dish;
import myFoodora.model.Full_meal;
import myFoodora.model.Meal;
import myFoodora.model.MenuItem;
import myFoodora.model.Restaurant;


public class MealFactory implements AbstractFactory {
	
    public Full_meal createMeal(String name, Restaurant restaurant) {
		return new Full_meal(name,restaurant);
    	
    }
	

}
