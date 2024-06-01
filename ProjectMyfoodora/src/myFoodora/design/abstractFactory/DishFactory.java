package myFoodora.design.abstractFactory;

import java.util.ArrayList;

import myFoodora.model.Customer;
import myFoodora.model.Dish;
import myFoodora.model.Meal;
import myFoodora.model.MyFoodoraSystem;
import myFoodora.model.Order;
import myFoodora.model.Restaurant;

public class DishFactory extends AbstractFactory {

	@Override
	public Dish createDish(String name, String category, String type,double price) {
		// add errors when the 'category' is not stater,main_dish or dessert
		return new Dish(name,category,type,price);
	}
// ajout du constructeur createDish adapté à la forme de la commande de l'interface
	
	public void createDish(String restaurantName,String dishCategory, ArrayList<String> para) {
		// TODO Auto-generated method stub
		Restaurant restaurant=MyFoodoraSystem.getInstance().getRestaurant(restaurantName);
		if(dishCategory.equalsIgnoreCase("starter")) {
			restaurant.getStarters().add(new Dish(para.get(0),para.get(1),para.get(2),Double.parseDouble(para.get(3))));
		}
		if(dishCategory.equalsIgnoreCase("main_dish")) {
			restaurant.getMain_dishes().add(new Dish(para.get(0),para.get(1),para.get(2),Double.parseDouble(para.get(3))));
		}
		if(dishCategory.equalsIgnoreCase("dessert")) {
			restaurant.getDesserts().add(new Dish(para.get(0),para.get(1),para.get(2),Double.parseDouble(para.get(3))));
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

}
