package myFoodora.design.abstractFactory;

import myFoodora.model.Dish;
import myFoodora.model.Full_meal;
import myFoodora.model.Meal;
import myFoodora.model.Order;
import myFoodora.model.Restaurant;

public class MealFactory extends AbstractFactory {
	

	public Order createOrder(Restaurant restaurant,double x,double y){
		return null;
	}
	
    public Meal createMeal(String name, Dish item1, Dish item2, Dish item3) {
        if (item3 == null) {
            // If item3 is not provided, create a regular Meal

            return new Meal(name,item1,item2);
            } 
        else{
            // If item3 is provided, create a Full_meal
            return new Full_meal(name, item1, item2, item3);
        }
    }
    public Dish createDish(String name, String category, String type,double price)  {
    	return null;
    }
	

}
