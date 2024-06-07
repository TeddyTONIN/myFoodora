package myFoodora.Test;

import static org.junit.Assert.*;

import org.junit.Test;

import myFoodora.model.Dish;
import myFoodora.model.DishCategory;
import myFoodora.model.FoodCategory;

public class DishTest {

	@Test
	public void testDish() {
		Dish d1=new Dish("poulet",DishCategory.main_dish,FoodCategory.standard,15);
		assertTrue(d1.getPrice()==15);
	}
}

