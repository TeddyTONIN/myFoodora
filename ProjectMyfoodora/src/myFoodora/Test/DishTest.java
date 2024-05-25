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
	@Test
	public void testDishEquals() {
		Dish d1=new Dish(15,"vegetarian");
		Dish d2=new Dish(16,"vegetarian");
		assertFalse(d1.equals(d2));
	}
}
