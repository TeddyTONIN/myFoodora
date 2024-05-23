package myFoodora.Test;

import static org.junit.Assert.*;

import org.junit.Test;

import myFoodora.model.Dish;

public class DishTest {

	@Test
	public void testDish() {
		Dish d1=new Dish(15,"vegetarian");
		assertTrue(d1.getPrice()==15);
	}

}
