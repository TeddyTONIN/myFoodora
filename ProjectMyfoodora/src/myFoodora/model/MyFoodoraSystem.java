package myFoodora.model;

import java.util.ArrayList;

import myFoodora.Policy.DeliveryPolicy;
import myFoodora.Policy.ShippedOrderSortingPolicy;
import myFoodora.Policy.TargetProfitPolicy;


public class MyFoodoraSystem {
	private static MyFoodoraSystem instance= new MyFoodoraSystem();
	
	private ArrayList<Courrier> courriers= new ArrayList<Courrier>();
	private ArrayList<Manager>  managers= new ArrayList<Manager>(); 
	private ArrayList<Restaurant> restaurants = new ArrayList<Restaurant>();
	private ArrayList<Client> clients = new ArrayList<Client>() ; 
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
		return( order.getPrice()*order.getMarkupPercentage()+order.getServiceFee()-order.getDeliveryCost());
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
}
