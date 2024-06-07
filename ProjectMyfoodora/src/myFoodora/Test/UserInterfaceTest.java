package myFoodora.Test;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import myFoodora.model.Dish;
import myFoodora.model.DishCategory;
import myFoodora.model.FoodCategory;
import myFoodora.model.MyFoodoraSystem;
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
		
		//création d'un repas 
		ArrayList<String> paraDish=new ArrayList<String>();
		paraDish.add("pouletDg");
		paraDish.add("main_dish");
		paraDish.add("standard");
		paraDish.add("25");
		UserInterface.addDishRestaurantMenu("TourDargent",paraDish);
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
}
