package myFoodora.model;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import myFoodora.Policy.DeliveryPolicy;
import myFoodora.Policy.TargetProfitPolicy;
import myFoodora.design.abstractFactory.DishFactory;
import myFoodora.design.abstractFactory.OrderFactory;
import myFoodora.design.abstractFactory.UserFactory;

public class UserInterface {
	static UserFactory uF= new UserFactory();
	static DishFactory dF = new DishFactory();
	static OrderFactory oF= new OrderFactory();
	
	public static void registerRestaurant(ArrayList<String> para) {
		MyFoodoraSystem.getInstance().getRestaurantsList().put(para.get(2), (Restaurant) uF.createUser("restaurant",para));
	}
	
	public static void registerCustomer(ArrayList<String> para) {
		MyFoodoraSystem.getInstance().getClientsList().put(para.get(2), (Customer) uF.createUser("Customer",para));
	}
	
	public static void registerCourrier(ArrayList<String> para) {
		MyFoodoraSystem.getInstance().getCourriersList().put(para.get(2), (Courrier) uF.createUser("courrier",para));		
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
	
	public static void endOrder(Customer customer,ArrayList<String> para) {
		Order order=customer.getOrderHistory().get(para.get(0));
		String [] datepara=para.get(1).split("/");
		int day=Integer.parseInt(datepara[0]);
		int month=Integer.parseInt(datepara[0]);
		int year=Integer.parseInt(datepara[0]);		
		order.setDate(new Date(day,month,year));
		order.getOrderPrice();
		MyFoodoraSystem.getInstance().getOrdersHistory().add(order);
		FidelityCard card = order.getRestaurant().getCustomerFidelityPlans().get(customer);
		card.update();

		
	}
	
	public static void onDuty(Courrier courier,ArrayList<String> para) {
		courier.setOn_duty(true);
	}
	
	public static void offDuty(Courrier courier,ArrayList<String> para) {
		courier.setOn_duty(false);
	}
	
	public static void setDeliveryPolicy(ArrayList<String> para) {
		if(para.get(0).equalsIgnoreCase("FastestDelivery"))
			MyFoodoraSystem.getInstance().setDeliveryPolicy(new DeliveryPolicy.FastestDelivery());
		else if (para.get(0).equalsIgnoreCase("Fair_occupationDelivery"))
			MyFoodoraSystem.getInstance().setDeliveryPolicy(new DeliveryPolicy.Fair_occupationDelivery());
		else System.out.println("La policie n'a pas été reconnu. \n veuillez entrer une policie existante");
	}
	
	public static void setProfitPolicy(ArrayList<String> para) {
		if(para.get(0).equalsIgnoreCase("TargetProfit_servicefee")) 
			MyFoodoraSystem.getInstance().setTargetProfitPolicy(new TargetProfitPolicy.TargetProfit_servicefee());
		else if(para.get(0).equalsIgnoreCase("TargetProfit_MarkupFee")) 
			MyFoodoraSystem.getInstance().setTargetProfitPolicy(new TargetProfitPolicy.TargetProfit_MarkupFee());
		else if (para.get(0).equalsIgnoreCase("TargetProfit_deliveryCost"))
			MyFoodoraSystem.getInstance().setTargetProfitPolicy(new TargetProfitPolicy.TargetProfit_deliveryCost());
	}
	public static void showCustomers() {
		System.out.println("Ci- dessous la liste des customers");
		MyFoodoraSystem.getInstance().showCustomer();
		}
	
	public static void showMenuItem(ArrayList<String> para) {
		Restaurant restaurant=MyFoodoraSystem.getInstance().getRestaurant(para.get(0));
		restaurant.showMenuItem();
	}
	public static void showtotalProfit() {
		double profit =MyFoodoraSystem.getInstance().getSystemProfit();
		System.out.println("The total profit of system is: "+profit+"€");
	}
	
	public static User login(ArrayList<String> para) {
		if (MyFoodoraSystem.getInstance().getRestaurantsList().containsKey(para.get(0))) {
			Restaurant restaurant=MyFoodoraSystem.getInstance().getRestaurant(para.get(0));
			if (restaurant.getPassword().equals(para.get(1))) {
				System.out.println("connexion réussie restaurant réussie");
				return(restaurant);
			}
			else {
				System.out.println("Le mot de pass entrée est incorrect");
				return null;
			}
		}
		else if (MyFoodoraSystem.getInstance().getClientsList().containsKey(para.get(0))) {
			Customer client=MyFoodoraSystem.getInstance().getClient(para.get(0));
			if (client.getPassword().equals(para.get(1))) {
				System.out.println("connexion customer réussie ");
				return(client);
			}
			else {
				System.out.println("Le mot de pass entrée est incorrect");
				return null;
			}
		}
		else if (MyFoodoraSystem.getInstance().getManagersList().containsKey(para.get(0))) {
			Manager manager=MyFoodoraSystem.getInstance().getManager(para.get(0));
			if (manager.getPassword().equals(para.get(1))) {
				System.out.println("connexion manager réussie");
				return(manager);
			}
			else {
				System.out.println("Le mot de pass entrée est incorrect");
				return null;
			}
		}
		else if (MyFoodoraSystem.getInstance().getCourriersList().containsKey(para.get(0))) {
			Courrier courier=MyFoodoraSystem.getInstance().getCourrier(para.get(0));
			if (courier.getPassword().equals(para.get(1))) {
				System.out.println("connexion  courrier réussie");
				return(courier);
			}
			else {
				System.out.println("Le mot de passe entrée est incorrect");
				return null;
			}
		}
		System.out.println("utiliseur non reconnue par le système");
		return null;
	}
	
	public static void processAction(String line) {
		
		
		}

}

