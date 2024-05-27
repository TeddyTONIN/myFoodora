package myFoodora.Policy;

import java.util.ArrayList;

import myFoodora.model.Order;

public interface ShippedOrderSortingPolicy extends Policy {
	public ArrayList<Order> MostsortedList (ArrayList<Order> shippedorders);
	public ArrayList<Order> LeastsortedList (ArrayList<Order> shippedorders);
}
