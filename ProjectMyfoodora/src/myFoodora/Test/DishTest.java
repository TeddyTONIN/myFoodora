package myFoodora.Test;

import static org.junit.Assert.*;

import org.junit.Test;

import myFoodora.model.Dish;

public class DishTest {

	@Test
	public void testDish() {
		Dish d1=new Dish("poulet","main-dish","vegetarian",15);
		assertTrue(d1.getPrice()==15);
	}
}

