package myFoodora.Test;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import myFoodora.model.Customer;
import myFoodora.model.Dish;
import myFoodora.model.DishCategory;
import myFoodora.model.FoodCategory;
import myFoodora.model.MyFoodoraSystem;
import myFoodora.model.Order;
import myFoodora.model.Restaurant;
import myFoodora.model.UserInterface;

public class UserInterfaceTest {

	
	@BeforeClass
	public static void initialisation() {
		//création d'un restaurant
		ArrayList<String> paraRestau=new ArrayList<String>();
		paraRestau.add("TourDargent");
		paraRestau.add("45.1,66.2");
		paraRestau.add("12345678");	
		UserInterface.registerRestaurant(paraRestau);
		
		//création d'un customer
		ArrayList<String> paraCustomer=new ArrayList<String>();
		paraCustomer.add("Jonathan");
		paraCustomer.add("olivers");
		paraCustomer.add("Jonalivers");
		paraCustomer.add("45,60");
		paraCustomer.add("test");
		UserInterface.registerCustomer(paraCustomer);		
		
		//création d'un courrier
		ArrayList<String> paraCourier=new ArrayList<String>();
		paraCourier.add("Jonathan");
		paraCourier.add("olivers");
		paraCourier.add("Jonalivers");
		paraCourier.add("45,60");
		paraCourier.add("test");
		UserInterface.registerCourrier(paraCourier);
		
		//ajout  d'un dish au restaurant Tour dargent 
		ArrayList<String> paraDish=new ArrayList<String>();
		paraDish.add("pouletDg");
		paraDish.add("main_dish");
		paraDish.add("standard");
		paraDish.add("25");
		UserInterface.addDishRestaurantMenu("TourDargent",paraDish);
		
		//création d'un order vide
		Order orderVide= new Order(MyFoodoraSystem.getInstance().getClient("Jonathan"),MyFoodoraSystem.getInstance().getRestaurant("TourDargent"),"vide");
		
	}
	
	
	@Test
	public void testRegisterRestaurant() {
		assertTrue(MyFoodoraSystem.getInstance().getRestaurant("TourDargent").getPassword().equals("12345678"));
	}
	
	@Test
	public void testRegisterCustomer() {
		assertTrue(MyFoodoraSystem.getInstance().getClient("Jonathan").getUsername()=="Jonalivers");
	}
	
	@Test
	public void testRegisterCourrier() {
		assertTrue(MyFoodoraSystem.getInstance().getCourrier("Jonathan").isOn_duty()==true);
	}
	
	@Test
	public void testAddDishRestaurantMenu() {
		DishCategory cat= DishCategory.main_dish;
		FoodCategory fcat=FoodCategory.standard;
		Dish dish=new Dish("pouletDg",cat,fcat,25);	
		assertTrue(MyFoodoraSystem.getInstance().getRestaurant("TourDargent").getMain_dishes().contains(dish));
	}
	
	@Test
	public void testCreateOrder() {
		Customer customer=MyFoodoraSystem.getInstance().getClient("Jonathan");
		Restaurant restaurant=MyFoodoraSystem.getInstance().getRestaurant("TourDargent");
		Order order= new Order(customer,restaurant,"test");
		ArrayList<String> paraOrder=new ArrayList<String>();
		paraOrder.add("TourDargent");
		paraOrder.add("test");
		UserInterface.createOrder(customer, paraOrder);
		assertTrue(customer.getOrderHistory().containsValue(order));
	}
	
	@Test
	public void testAddItem2Order() {
		//création d'un dish
		DishCategory cat= DishCategory.main_dish;
		FoodCategory fcat=FoodCategory.standard;
		Dish dish=new Dish("pouletDg",cat,fcat,25);
		
		//création d'un order pour le restau tour dargent
		ArrayList<String> orderVide=new ArrayList<String>();
		orderVide.add("TourDargent");
		orderVide.add("vide");
		UserInterface.createOrder(MyFoodoraSystem.getInstance().getClient("Jonathan"), orderVide);
		
		//ajout d'un item dans order
		ArrayList<String> orderAddItem=new ArrayList<String>();
		orderAddItem.add("vide");
		orderAddItem.add("pouletDg");
		UserInterface.addItem2Order(MyFoodoraSystem.getInstance().getClient("Jonathan"), orderAddItem);
		
		//test
		assertTrue(MyFoodoraSystem.getInstance().getClient("Jonathan").getOrderHistory().get("vide").getItemsOrdered().contains(dish));
	}
	
}
