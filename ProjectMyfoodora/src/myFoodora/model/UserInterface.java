package myFoodora.model;


import myFoodora.design.abstractFactory.UserFactory;

public class UserInterface {
	public static void registerRestaurant(String name,double x,double y) {
		UserFactory uF= new UserFactory();
		MyFoodoraSystem.getInstance().getRestaurantsList().put(name, (Restaurant) uF.createUser("restaurant",name,x,y));
	}
}
