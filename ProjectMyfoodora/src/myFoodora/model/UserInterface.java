package myFoodora.model;


import java.util.ArrayList;

import myFoodora.design.abstractFactory.DishFactory;
import myFoodora.design.abstractFactory.UserFactory;

public class UserInterface {
	static UserFactory uF= new UserFactory();
	static DishFactory dF = new DishFactory();
	
	public static void registerRestaurant(ArrayList<String> para) {
		MyFoodoraSystem.getInstance().getRestaurantsList().put(para.get(0), (Restaurant) uF.createUser("restaurant",para));
	}
	
	public static void registerCustomer(ArrayList<String> para) {
		MyFoodoraSystem.getInstance().getClientsList().put(para.get(0), (Customer) uF.createUser("Customer",para));
	}
	
	public static void registerCourrier(ArrayList<String> para) {
		MyFoodoraSystem.getInstance().getCourriersList().put(para.get(0), (Courrier) uF.createUser("courrier",para));		
	}
	
	public static void addDishRestaurantMenu(String RestaurantName,ArrayList<String> para) {
		dF.createDish(RestaurantName,para.get(1),para);
	}
}
