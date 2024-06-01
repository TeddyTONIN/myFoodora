package myFoodora.Test;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import myFoodora.model.MyFoodoraSystem;
import myFoodora.model.UserInterface;

public class UserInterfaceTest {

	@Test
	public void testRegisterRestaurant() {
		ArrayList<String> para=new ArrayList<String>();
		para.add("TourDargent");
		para.add("45.1,66.2");
		para.add("12345678");
		UserInterface.registerRestaurant(para);
		assertTrue(MyFoodoraSystem.getInstance().getRestaurant("TourDargent").getPassword().equals("12345678"));
	}
	
	@Test
	public void testRegisterCustomer() {
		ArrayList<String> para=new ArrayList<String>();
		para.add("Jonathan");
		para.add("olivers");
		para.add("Jonalivers");
		para.add("45,60");
		para.add("test");
		UserInterface.registerCustomer(para);
		assertTrue(MyFoodoraSystem.getInstance().getClient("Jonathan").getUsername()=="Jonalivers");
	}
	
	@Test
	public void testRegisterCourrier() {
		ArrayList<String> para=new ArrayList<String>();
		para.add("Jonathan");
		para.add("olivers");
		para.add("Jonalivers");
		para.add("45,60");
		para.add("test");
		UserInterface.registerCourrier(para);
		assertTrue(MyFoodoraSystem.getInstance().getCourrier("Jonathan").isOn_duty()==true);
	}
}
