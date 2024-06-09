package myFoodora.Test;

import static org.junit.Assert.*;


import java.util.ArrayList;

import org.junit.BeforeClass;
import org.junit.Test;

import myFoodora.model.Coordinate;
import myFoodora.model.Dish;
import myFoodora.model.DishCategory;
import myFoodora.model.FoodCategory;
import myFoodora.model.Full_meal;
import myFoodora.model.Meal;
import myFoodora.model.MenuItem;
import myFoodora.model.MyFoodoraSystem;
import myFoodora.model.Restaurant;


public class RestaurantTest {

	@BeforeClass
	public static void initialisation() {
		Coordinate cordR= new Coordinate(45.2, 30);
		//création d'un restaurant
		Restaurant restaurant1=new Restaurant("TourDargent", cordR,"TourDargent","12345678");
		MyFoodoraSystem.getInstance().getRestaurantsList().put("TourDargent", restaurant1);
		
		//création d'un meal vide
		Full_meal meal=new Full_meal("SaveurDAfrique",restaurant1);
		restaurant1.addMeal(meal);
		
		//ajout d'un dish a un mealVide
		Dish dish1=new Dish("poissonR", DishCategory.main_dish, FoodCategory.standard, 12);
		restaurant1.getMain_dishes().add(dish1);
		meal.setItem1(dish1);
		
	}
	
	@Test
	public void testAddMeal() {
		ArrayList<MenuItem> meals =MyFoodoraSystem.getInstance().getRestaurant("TourDargent").getMeals();
		for (MenuItem meal:meals) {
			if (meal.getName().equals("SaveurDAfrique")) {
				Meal meal1=(Meal)meal;
				assertTrue(meal1.getItem1().getName().equals("poissonR"));
			}
		}
	}
	
	
	@Test
	public void testGetDishItem() {
		Restaurant restaurant1 =MyFoodoraSystem.getInstance().getRestaurant("TourDargent");
		assertNotNull(restaurant1.getDishItem("poissonR"));
	}
	
	@Test
	public void testGetMealItem() {
		Restaurant restaurant1 =MyFoodoraSystem.getInstance().getRestaurant("TourDargent");
		assertNotNull(restaurant1.getMealItem("SaveurDAfrique"));
	}
	

}
