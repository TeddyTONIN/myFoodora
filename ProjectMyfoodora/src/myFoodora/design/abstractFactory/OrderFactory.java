package myFoodora.design.abstractFactory;


import java.util.ArrayList;

import myFoodora.model.*;

public class OrderFactory extends AbstractFactory{
	
	public void createOrder(Customer customer,ArrayList<String> para) {
		Order order=new Order(customer,MyFoodoraSystem.getInstance().getRestaurant(para.get(0)),para.get(1));
		customer.getOrderHistory().put(para.get(1), order);
	}
	public Meal createMeal(String name, Dish item1, Dish item2, Dish item3) {
		return null;
	}
    public Dish createDish(String name, String category, String type,double price)  {
    	return null;
    }
    
    
	@Override
	public Order createOrder(Restaurant restaurant, Customer customer) {
		// TODO Auto-generated method stub
		return null;
	}
}
