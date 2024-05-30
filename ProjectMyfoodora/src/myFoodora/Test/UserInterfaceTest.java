package myFoodora.Test;

import static org.junit.Assert.*;

import org.junit.Test;

import myFoodora.model.MyFoodoraSystem;
import myFoodora.model.UserInterface;

public class UserInterfaceTest {
	UserInterface userI= new UserInterface();
	@Test
	public void testSetup() {
		userI.setup("1");
		assertNotNull((MyFoodoraSystem.getInstance().getRestaurant("moi")));
	}

}
