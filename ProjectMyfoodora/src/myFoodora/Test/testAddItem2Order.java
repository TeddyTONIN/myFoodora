package myFoodora.Test;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import myFoodora.model.Dish;
import myFoodora.model.DishCategory;
import myFoodora.model.FoodCategory;
import myFoodora.model.MyFoodoraSystem;
import myFoodora.model.UserInterface;

public class testAddItem2Order {

	public static void main(String[] args) {
		
		// TODO Auto-generated method stub
		//création d'un customer
				ArrayList<String> paraCustomer=new ArrayList<String>();
				paraCustomer.add("Jonathan");
				paraCustomer.add("olivers");
				paraCustomer.add("Jonalivers");
				paraCustomer.add("45,60");
				paraCustomer.add("test");
				UserInterface.registerCustomer(paraCustomer);
				
				//création d'un restaurant
				ArrayList<String> paraRestau=new ArrayList<String>();
				paraRestau.add("TourDargent");
				paraRestau.add("45.1,66.2");
				paraRestau.add("12345678");	
				paraRestau.add("TourDargent");
				UserInterface.registerRestaurant(paraRestau);
				
				//ajout d'un dish au restau
				ArrayList<String> paraDish=new ArrayList<String>();
				paraDish.add("pouletDg");
				paraDish.add("main_dish");
				paraDish.add("standard");
				paraDish.add("25");
				UserInterface.addDishRestaurantMenu("TourDargent",paraDish);
				System.out.println(MyFoodoraSystem.getInstance().getRestaurant("TourDargent").getMain_dishes().getFirst());
				
				//création d'un order pour le restau tour dargent
				ArrayList<String> orderVide=new ArrayList<String>();
				orderVide.add("TourDargent");
				orderVide.add("vide");
				UserInterface.createOrder(MyFoodoraSystem.getInstance().getClient("Jonathan"), orderVide);
				
				//ajout d'un item dans order
				ArrayList<String> orderAddItem=new ArrayList<String>();
				orderAddItem.add("vide");
				orderAddItem.add("pouletDg");
				UserInterface.addItem2Order(MyFoodoraSystem.getInstance().getClient("Jonathan"), orderAddItem);
				System.out.println(MyFoodoraSystem.getInstance().getClient("Jonathan").getOrderHistory().get("vide"));
				
	}

}
