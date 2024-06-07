package myFoodora.model;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import myFoodora.design.abstractFactory.OrderFactory;

public class Order extends OrderFactory {
	
	private Restaurant restaurant;
	private double orderPrice;
	private ArrayList<MenuItem> itemsOrdered;
    private Customer customer;
    private boolean delivered = false;
    private double totalFee;
	private double serviceFee;
	private double markupPercentage;
	private double deliveryCost;
	private String orderName;
    
    public Order(Restaurant restaurant, Customer customer) {
    	
    	this.restaurant = restaurant;
    	this.customer = customer;
    }
    public Order(Customer customer,Restaurant restaurant,String orderName) {
    	this.customer= customer;
    	this.restaurant=restaurant;
    	this.orderName=orderName;
    	this.itemsOrdered=new ArrayList<MenuItem>();
    }

    public void addMenuItem(MenuItem menuItem) {
        itemsOrdered.add(menuItem);
    }

	public Restaurant getRestaurant() {
		return restaurant;
	}
	public void setRestaurant(Restaurant restaurant) {
		this.restaurant = restaurant;
	}
	public double getOrderPrice() {
		return orderPrice;
	}
	public void setOrderPrice(double price) {
		this.orderPrice = price;
	}
	
	public ArrayList<MenuItem> getItemsOrdered() {
		return itemsOrdered;
	}
	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public boolean isDelivered() {
		return delivered;
	}
	public void setDelivered(boolean delivered) {
		this.delivered = delivered;
	}

	public double getServiceFee() {
		return serviceFee;
	}

	public void setServicefee(double servicefee) {
		this.serviceFee = servicefee;
	}

	public double getMarkupPercentage() {
		return markupPercentage;
	}

	public void setMarkupPercentage(double markupPercentage) {
		this.markupPercentage = markupPercentage;
	}

	public double getDeliveryCost() {
		return deliveryCost;
	}

	public void setDeliveryCost(double deliveryCost) {
		this.deliveryCost = deliveryCost;
	}

	public double getTotalFee() {
		return totalFee;
	}
	
	public String getOrderName() {
		return orderName;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this==obj)return true;
		else if (this.getClass()==obj.getClass()) {
			if(this.orderName==((Order)obj).getOrderName())return true ;
			else return false;
		}
		return false;
	}
	@Override
	public String toString() {
		return "Order [itemsOrdered=" + itemsOrdered + ", orderName=" + orderName + "]";
	}
	

}

