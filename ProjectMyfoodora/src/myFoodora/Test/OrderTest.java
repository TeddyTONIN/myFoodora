package myFoodora.Test;

import org.junit.BeforeClass;

import myFoodora.model.*;

public class OrderTest {
	
	@BeforeClass
	public static void initialisation() {
		Coordinate cordR= new Coordinate(45.2, 30);
		//création d'un restaurant
		Restaurant restaurant1=new Restaurant("TourDargent", cordR,"TourDargent","12345678");
		MyFoodoraSystem.getInstance().getRestaurantsList().put("TourDargent", restaurant1);
		
		//création d'un meal vide
		Full_meal meal1=new Full_meal("SaveurDAfrique");
		Full_meal meal2=new Full_meal("SaveurDAfrique");
		meal1.setPrice(1000);
		meal2.setPrice(99);
		restaurant1.addMeal(meal1);
		restaurant1.addMeal(meal2);
		
		//ajout d'un dish a un mealVide
		Dish dish1=new Dish("poissonR", DishCategory.main_dish, FoodCategory.standard, 12);
		restaurant1.getMain_dishes().add(dish1);
		meal1.setItem1(dish1);
		
		//création d'un Customer
		Customer customer1 = new Customer("Teddy","TONIN","TedTon",new Coordinate(49,50), "12342342");
		FidelityCard card = new PointFidelityCard(customer1);
		customer1.setFidelityCard(card);
		
		//Création d'un Order
		
		
		Order order = new Order(customer1,restaurant1,"HungryForFish");
		
	}
	

}
