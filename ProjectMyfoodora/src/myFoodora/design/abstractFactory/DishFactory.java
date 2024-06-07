package myFoodora.design.abstractFactory;

import java.util.ArrayList;

import myFoodora.model.Customer;
import myFoodora.model.Dish;
import myFoodora.model.DishCategory;
import myFoodora.model.FoodCategory;
import myFoodora.model.Meal;
import myFoodora.model.MyFoodoraSystem;
import myFoodora.model.Order;
import myFoodora.model.Restaurant;

public class DishFactory extends AbstractFactory {

// ajout du constructeur createDish adapté à la forme de la commande de l'interface
	
	public void createDish(String restaurantName,String dishCategory, ArrayList<String> para) {
		// TODO Auto-generated method stub
		Restaurant restaurant=MyFoodoraSystem.getInstance().getRestaurant(restaurantName);
		FoodCategory fcat=null;
		if (para.get(2)=="vegetarian") {fcat= FoodCategory.vegetarian;}
		if (para.get(2)=="glutenFree") {fcat= FoodCategory.glutenFree;}
		if (para.get(2)=="standard") {fcat= FoodCategory.standard;}
			
		
		if(dishCategory.equalsIgnoreCase(DishCategory.starter.toString())) {
			restaurant.getStarters().add(new Dish(para.get(0),DishCategory.starter,fcat,Double.parseDouble(para.get(3))));
		}
		if(dishCategory.equalsIgnoreCase(DishCategory.main_dish.toString())) {
			restaurant.getMain_dishes().add(new Dish(para.get(0),DishCategory.main_dish,fcat,Double.parseDouble(para.get(3))));
		}
		if(dishCategory.equalsIgnoreCase(DishCategory.dessert.toString())) {
			restaurant.getDesserts().add(new Dish(para.get(0),DishCategory.dessert,fcat,Double.parseDouble(para.get(3))));
		}
	}
	
	
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
	public Dish createDish(String name, String category, String type, double price) {
		// TODO Auto-generated method stub
		return null;
	}

}
