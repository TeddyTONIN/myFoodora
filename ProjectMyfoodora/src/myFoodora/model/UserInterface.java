package myFoodora.model;


import java.util.ArrayList;

import myFoodora.design.abstractFactory.UserFactory;

public class UserInterface {
	static UserFactory uF= new UserFactory();
	
	public static void registerRestaurant(ArrayList<String> para) {
		MyFoodoraSystem.getInstance().getRestaurantsList().put(para.get(0), (Restaurant) uF.createUser("restaurant",para));
	}
	
	public static void registerCustomer(ArrayList<String> para) {
		MyFoodoraSystem.getInstance().getClientsList().put(para.get(0), (Client) uF.createUser("client",para));
	}
	
	public static void registerCourrier(ArrayList<String> para) {
		MyFoodoraSystem.getInstance().getCourriersList().put(para.get(0), (Courrier) uF.createUser("courrier",para));		
	}
}
