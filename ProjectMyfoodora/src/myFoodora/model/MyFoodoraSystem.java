package myFoodora.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import myFoodora.Policy.DeliveryPolicy;
import myFoodora.Policy.ShippedOrderSortingPolicy;
import myFoodora.Policy.TargetProfitPolicy;


public class MyFoodoraSystem {
	private static MyFoodoraSystem instance= new MyFoodoraSystem();
	private Map<String,Restaurant> restaurants =new HashMap<>();
	private Map<String,Courrier> courriers =new HashMap<>();
	private Map<String,Manager> managers =new HashMap<>(); 
	private Map<String,Customer> clients =new HashMap<>(); 
	private ArrayList<Order> ordersHistory= new ArrayList<Order>();
	
	private double serviceFee;
	private double markupPercentage;
	private double deliveryCost;
	
	private DeliveryPolicy deliveryPolicy=new DeliveryPolicy.Fair_occupationDelivery();
	private ShippedOrderSortingPolicy shippedOrderSortingPolicy=new ShippedOrderSortingPolicy.SortedOrderedItem_à_la_carte();
	private TargetProfitPolicy targetProfitPolicy=new TargetProfitPolicy.TargetProfit_servicefee();
	
	public static MyFoodoraSystem getInstance() {
		return instance;
	}
	
	public double profitForOneOrder(Order order) {
		return( order.getOrderPrice()*order.getMarkupPercentage()+order.getServiceFee()-order.getDeliveryCost());
	}
	
	public double totalIncome() {
		double S=0;
		for (Order order: ordersHistory) {S=+ order.getTotalFee();}
		return S;	
	}
	
	public double systemProfit() {
		double S=0;
		for (Order order:ordersHistory) {S=+this.profitForOneOrder(order);}
		return S;
	}
	public Map<String, Restaurant> getRestaurantsList() {
		return restaurants;
	}

	
	public Restaurant getRestaurant(String name) {
		return this.getRestaurantsList().get(name);
	}
	
	public Map<String, Customer> getClientsList() {
		return clients;
	}
	public Customer getClient(String firstName) {
		return this.getClientsList().get(firstName);
	}
	
	public Map<String, Courrier> getCourriersList() {
		return courriers;
	}
	public Courrier getCourrier(String name) {
		return this.getCourriersList().get(name);
	}
		
		
}
