package myFoodora.design.abstractFactory;


import java.util.ArrayList;

import myFoodora.model.*;

public class OrderFactory implements AbstractFactory{
	
	public void createOrder(Customer customer,ArrayList<String> para) {
		Order order=new Order(customer,MyFoodoraSystem.getInstance().getRestaurant(para.get(0)),para.get(1));
		customer.getOrderHistory().put(para.get(1), order);
	}
    
    
}
