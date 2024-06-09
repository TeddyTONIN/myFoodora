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
import myFoodora.model.MyFoodoraSystem;
import myFoodora.model.Restaurant;
import myFoodora.model.UserInterface;

public class MealTest {

	
	@BeforeClass
	public static void initialisation() {
		Coordinate cordR= new Coordinate(45.2, 30);
		//création d'un restaurant
		Restaurant restaurant1=new Restaurant("TourDargent", cordR,"TourDargent","12345678");
		MyFoodoraSystem.getInstance().getRestaurantsList().put("TourDargent", restaurant1);
		
		//création d'un meal vide
		Full_meal meal=new Full_meal("SaveurDAfrique",restaurant1);
		Full_meal meal1=new Full_meal("SaveurDor",restaurant1);
		restaurant1.addMeal(meal);
		
		//ajout d'un dish a un mealVide
		Dish dish1=new Dish("poissonR", DishCategory.main_dish, FoodCategory.standard, 12);
		Dish dish2=new Dish("poulet", DishCategory.main_dish, FoodCategory.standard, 8);
		restaurant1.getMain_dishes().add(dish1);
		meal.setItem1(dish1);
		meal.setItem2(dish2);
		meal1.setItem1(dish1);
		meal1.setItem2(dish1);
		
		ArrayList<String> para=new ArrayList<String>();
		para.add("SaveurDAfrique");
		UserInterface.saveMeal(restaurant1,para);
		
	}
	
	@Test
	public void testComputePrice() {
		Restaurant restaurant = MyFoodoraSystem.getInstance().getRestaurant("TourDargent");
		Meal meal=restaurant.getMealItem("SaveurDAfrique");
		
		assertTrue(meal.getPrice()==19);
	}

}
