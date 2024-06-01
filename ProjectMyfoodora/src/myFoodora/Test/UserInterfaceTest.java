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

}
