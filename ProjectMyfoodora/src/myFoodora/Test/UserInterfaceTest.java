package myFoodora.Test;

import static org.junit.Assert.*;

import java.lang.reflect.Array;
import java.util.ArrayList;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import myFoodora.model.Coordinate;
import myFoodora.model.Courrier;
import myFoodora.model.Customer;
import myFoodora.model.Date;
import myFoodora.model.Dish;
import myFoodora.model.DishCategory;
import myFoodora.model.FoodCategory;
import myFoodora.model.Full_meal;
import myFoodora.model.Manager;
import myFoodora.model.Meal;
import myFoodora.model.MenuItem;
import myFoodora.model.MyFoodoraSystem;
import myFoodora.model.Order;
import myFoodora.model.Restaurant;
import myFoodora.model.UserInterface;

public class UserInterfaceTest {

	
	@BeforeClass
	public static void initialisation() {
		//Création du manager initial du système
		Manager ceo=new Manager("ceo","123456789","Teddy","Olivers");
		MyFoodoraSystem.getInstance().getManagersList().put("ceo", ceo);
		
		//création d'un restaurant
		ArrayList<String> paraRestau=new ArrayList<String>();
		paraRestau.add("TourDargent");
		paraRestau.add("45.1,66.2");
		paraRestau.add("TourDargent");
		paraRestau.add("12345678");	
		UserInterface.registerRestaurant(paraRestau);
		
		//création d'un customer
		ArrayList<String> paraCustomer=new ArrayList<String>();
		paraCustomer.add("Jonathan");
		paraCustomer.add("olivers");
		paraCustomer.add("JonaliversCustomer");
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
		Order orderVide= new Order(MyFoodoraSystem.getInstance().getClient("JonaliversCustomer"),MyFoodoraSystem.getInstance().getRestaurant("TourDargent"),"vide");
		MyFoodoraSystem.getInstance().getClient("JonaliversCustomer").getOrderHistory().put("vide", orderVide);
		//Création d'un meal vide 
		Restaurant restaurant =MyFoodoraSystem.getInstance().getRestaurant("TourDargent");
		Full_meal meal=new Full_meal("SaveurDAfrique");
		restaurant.addMeal(meal);
		
		//ajout d'un dish a un mealVide
		Dish dish1=new Dish("poissonR", DishCategory.main_dish, FoodCategory.standard, 12);
		meal.setItem1(dish1);
	}
	
	
	@Test
	public void testRegisterRestaurant() {
		assertTrue(MyFoodoraSystem.getInstance().getRestaurant("TourDargent").getPassword().equals("12345678"));
	}
	
	@Test
	public void testRegisterCustomer() {
		assertTrue(MyFoodoraSystem.getInstance().getClient("JonaliversCustomer").getFirstName()=="Jonathan");
	}
	
	@Test
	public void testRegisterCourrier() {
		Courrier courier=MyFoodoraSystem.getInstance().getCourrier("Jonalivers");
		Coordinate coordinate=courier.getPosition();
		assertTrue(coordinate.toString().equals("Coordinate [x=45.0, y=60.0]"));
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
		Customer customer=MyFoodoraSystem.getInstance().getClient("JonaliversCustomer");
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
		UserInterface.createOrder(MyFoodoraSystem.getInstance().getClient("JonaliversCustomer"), orderVide);
		
		//ajout d'un item dans order
		ArrayList<String> orderAddItem=new ArrayList<String>();
		orderAddItem.add("vide");
		orderAddItem.add("pouletDg");
		UserInterface.addItem2Order(MyFoodoraSystem.getInstance().getClient("JonaliversCustomer"), orderAddItem);
		
		//test
		assertTrue(MyFoodoraSystem.getInstance().getClient("JonaliversCustomer").getOrderHistory().get("vide").getItemsOrdered().contains(dish));
	}
	
	@Test
	public void testCreateMeal() {
		Restaurant restaurant =MyFoodoraSystem.getInstance().getRestaurant("TourDargent");
		ArrayList<String> mealName=new ArrayList<String>();
		mealName.add("riz");
		UserInterface.createMeal(restaurant,mealName);
		assertNotNull(restaurant.getMealItem("riz"));;
	}
	
	@Test
	public void testAddDish2Meal() {
		Restaurant restaurant =MyFoodoraSystem.getInstance().getRestaurant("TourDargent");
		Meal meal=restaurant.getMealItem("SaveurDAfrique");
		ArrayList<String> paraAdd=new ArrayList<String>();
		paraAdd.add("poissonR");
		paraAdd.add("SaveurDAfrique");
		UserInterface.addDish2Meal(restaurant,paraAdd);
		assertTrue(restaurant.getMealItem("SaveurDAfrique").getItem1().getName().equals("poissonR"));
	}
	
	@Test 
	public void testCreatOrder() {
		
	}
	@Test
	public void testEndOrder() {
		Customer customer = MyFoodoraSystem.getInstance().getClient("JonaliversCustomer");
		ArrayList<String> para=new ArrayList<String>();
		para.add("vide");
		para.add("9/6/2024");
		UserInterface.endOrder(customer, para);
		Date date= new Date(9,6,2024);
		assertTrue(customer.getOrderHistory().get("vide").getDate().equals(date));
	}
	
}
