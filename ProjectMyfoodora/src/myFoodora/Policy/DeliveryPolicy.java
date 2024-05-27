package myFoodora.Policy;


import java.util.ArrayList;

import myFoodora.model.Courrier;
import myFoodora.model.Order;

public interface DeliveryPolicy extends Policy {
	
	public Courrier fair_occupationDelivery(ArrayList<Courrier> courriers, Order order);
	
	public Courrier fastestDelivery(ArrayList<Courrier> courriers, Order order);

}
