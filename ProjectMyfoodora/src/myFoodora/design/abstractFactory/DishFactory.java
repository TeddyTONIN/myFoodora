package myFoodora.design.abstractFactory;

import java.util.ArrayList;


import myFoodora.model.Dish;
import myFoodora.model.DishCategory;
import myFoodora.model.FoodCategory;
import myFoodora.model.MyFoodoraSystem;
import myFoodora.model.Restaurant;

public class DishFactory implements AbstractFactory {



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
	

}
