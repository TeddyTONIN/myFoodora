package myFoodora.design.abstractFactory;

import java.util.ArrayList;

import myFoodora.model.Coordinate;
import myFoodora.model.Courrier;
import myFoodora.model.Customer;
import myFoodora.model.Dish;
import myFoodora.model.Meal;
import myFoodora.model.Order;
import myFoodora.model.Restaurant;
import myFoodora.model.User;

public class UserFactory extends AbstractFactory{

	public User createUser(String userType,ArrayList<String> para) {
		if(userType.equalsIgnoreCase("restaurant")) {
			String [] coordinate=para.get(1).split(",");
			double x=Double.parseDouble(coordinate[0]);
			double y=Double.parseDouble(coordinate[1]);
			Coordinate location=new Coordinate(x, y);
			return new Restaurant(para.get(0),location,para.get(2),para.get(3));
		}
		if(userType.equalsIgnoreCase("customer")) {
			String [] coordinate=para.get(3).split(",");
			double x=Double.parseDouble(coordinate[0]);
			double y=Double.parseDouble(coordinate[1]);
			Coordinate position= new Coordinate(x,y);
			return new Customer(para.get(0), para.get(1),para.get(2), position, para.get(4));
		}
		if(userType.equalsIgnoreCase("courrier")) {
			String [] coordinate=para.get(3).split(",");
			double x=Double.parseDouble(coordinate[0]);
			double y=Double.parseDouble(coordinate[1]);
			Coordinate position= new Coordinate(x,y);
			return new Courrier(para.get(0), para.get(1),para.get(2), position, para.get(4));		
		}
		return null;
	}

	@Override
	public Order createOrder(Restaurant restaurant, Customer customer) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Meal createMeal(String name, Dish item1, Dish item2, Dish item3) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Dish createDish(String name, String category, String type, double price) {
		// TODO Auto-generated method stub
		return null;
	}
}
