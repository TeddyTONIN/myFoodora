package myFoodora.Policy;


import java.util.ArrayList;

import myFoodora.model.Courrier;
import myFoodora.model.Order;

public interface DeliveryPolicy extends Policy {
	
	public Courrier allocateCourrier(ArrayList<Courrier> courriers, Order order);

	
	static class Fair_occupationDelivery implements DeliveryPolicy {

		@Override
		public Courrier allocateCourrier(ArrayList<Courrier> courriers, Order order) {
			// TODO Auto-generated method stub
			return null;
		}

	}
	static class FastestDelivery implements DeliveryPolicy {

		@Override
		public Courrier allocateCourrier(ArrayList<Courrier> courriers, Order order) {
			// TODO Auto-generated method stub
			return null;
		}

	}

}



