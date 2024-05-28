package myFoodora.Policy;

import java.util.ArrayList;

import myFoodora.model.Order;

public interface ShippedOrderSortingPolicy extends Policy {
	
	public ArrayList<Order> MostsortedList (ArrayList<Order> shippedorders);
	public ArrayList<Order> LeastsortedList (ArrayList<Order> shippedorders);

	public class SortedOrderedHalf_Meal implements ShippedOrderSortingPolicy {

		@Override
		public ArrayList<Order> MostsortedList(ArrayList<Order> shippedorders) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public ArrayList<Order> LeastsortedList(ArrayList<Order> shippedorders) {
			// TODO Auto-generated method stub
			return null;
		}

	}
	
	public class SortedOrderedItem_à_la_carte implements ShippedOrderSortingPolicy {

		@Override
		public ArrayList<Order> MostsortedList(ArrayList<Order> shippedorders) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public ArrayList<Order> LeastsortedList(ArrayList<Order> shippedorders) {
			// TODO Auto-generated method stub
			return null;
		}

	}
}
