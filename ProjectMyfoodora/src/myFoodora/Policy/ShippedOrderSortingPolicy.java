package myFoodora.Policy;

import java.util.ArrayList;

import myFoodora.model.Order;

public interface ShippedOrderSortingPolicy extends Policy {
	public ArrayList<Order> sortedOrderedHalf_Meal (ArrayList<Order> shippedorders);
	
	public ArrayList<Order> sortedOrderedItem_à_la_carte (ArrayList<Order> shippedorders);
}
