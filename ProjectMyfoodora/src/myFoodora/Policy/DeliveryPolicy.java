package myFoodora.Policy;


import java.util.ArrayList;

import myFoodora.model.Courrier;
import myFoodora.model.Order;

public interface DeliveryPolicy extends Policy {
	public Courrier allocateCourrier(ArrayList<Courrier> courriers,Order order);
}
