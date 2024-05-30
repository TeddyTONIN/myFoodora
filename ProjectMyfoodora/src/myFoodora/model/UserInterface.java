package myFoodora.model;

import java.util.Scanner;

import myFoodora.design.abstractFactory.UserFactory;

public class UserInterface {
	
	public void setup(String restaurants) { 
		Scanner scanner=new Scanner(System.in);
		UserFactory userFactory=new UserFactory();
		int numRestaurants = Integer.parseInt(restaurants);
		for (int i=1; i<=numRestaurants;i++) {
			System.out.println("Quel est le nom du restaurant N"+i+" ?");
			String restaurantName=scanner.nextLine();
			MyFoodoraSystem.getInstance().getRestaurantsList().put(restaurantName, (Restaurant) userFactory.createUser("restaurant", restaurantName));		
		}
	}
}
