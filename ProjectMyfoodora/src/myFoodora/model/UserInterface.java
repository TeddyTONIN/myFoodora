package myFoodora.model;


import java.util.ArrayList;

import myFoodora.design.abstractFactory.DishFactory;
import myFoodora.design.abstractFactory.OrderFactory;
import myFoodora.design.abstractFactory.UserFactory;

public class UserInterface {
	static UserFactory uF= new UserFactory();
	static DishFactory dF = new DishFactory();
	static OrderFactory oF= new OrderFactory();
	
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
	
	public static void createOrder(Customer customer,ArrayList<String> para) {
		oF.createOrder(customer, para);
	}
	public static void addItem2Order(Customer customer,ArrayList<String> para) {
		Order order=customer.getOrderHistory().get(para.get(0));
		Restaurant restaurant=order.getRestaurant();
		MenuItem command=null;
		boolean mealFound=false;
		if(restaurant.getMeal_of_the_week()!=null) {
			if(para.get(1).equals(restaurant.getMeal_of_the_week().getName())) {
				command=restaurant.getMeal_of_the_week();
				mealFound=true;
				order.addMenuItem(command);		
		}

		}
		if (mealFound==false){
			if (restaurant.getStarters()!=null) {
				for (MenuItem dish:restaurant.getStarters()) {
					if (dish.getName().equals(para.get(1))){
						command=dish;
						mealFound=true;
						order.addMenuItem(command);
						break;}
				}
			}
			
		}
		if (mealFound==false) {
			if  (restaurant.getMain_dishes()!=null) {
				for (MenuItem dish:restaurant.getMain_dishes()) {
					if (dish.getName().equals(para.get(1))){
						command=dish;
						mealFound=true;
						order.addMenuItem(command);
						break;}
				}
			}
			
		}
		if (mealFound==false) {
			if  (restaurant.getDesserts()!=null){
				for (MenuItem dish:restaurant.getDesserts()) {
					if (dish.getName().equals(para.get(1))){
						command=dish;
						mealFound=true;
						order.addMenuItem(command);
						break;}
				}
			}
			
		}
		if (mealFound==false){
			if (restaurant.getMeals()!=null) {
				for (MenuItem dish:restaurant.getMeals()) {
					if (dish.getName().equals(para.get(1))){
						command=dish;
						mealFound=true;
						order.addMenuItem(command);
						break;}
				}
			}
			
		}
		if (mealFound==false)System.out.println("le repas commandé n'existe pas dans ce restaurant.\n Veuillez entrez un repas qui existe");

	}
}
