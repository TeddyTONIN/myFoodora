package myFoodora.Test;

import org.junit.Test;
import org.junit.Before;


import myFoodora.model.*;

public class OrderTest {
	protected Order order;
	protected Customer customer1;
	protected Restaurant restaurant1;
	protected Full_meal meal1;
	protected Dish dish2;
	protected Dish dish1;
	protected FidelityCard card1;
	
	 @Before
	public void initialisation() {
		Coordinate cordR= new Coordinate(45.2, 30);
		//création d'un restaurant
		restaurant1=new Restaurant("TourDargent", cordR,"TourDargent","12345678");
		MyFoodoraSystem.getInstance().getRestaurantsList().put("TourDargent", restaurant1);
		
		//création d'un meal vide
		meal1=new Full_meal("SaveurDAfrique",restaurant1);

		restaurant1.addMeal(meal1);

		
		//ajout d'un dish a un mealVide
		dish1=new Dish("poissonR", DishCategory.main_dish, FoodCategory.standard, 12);
		dish2=new Dish("Croissant", DishCategory.starter, FoodCategory.standard,2);
		restaurant1.getMain_dishes().add(dish1);
		restaurant1.getStarters().add(dish1);
		meal1.setItem1(dish1);
		meal1.setItem2(dish2);
		
		//création d'un Customer
		customer1 = new Customer("Teddy","TONIN","TedTon",new Coordinate(49,50), "12342342");
		card1 = new PointFidelityCard(customer1);
		customer1.setFidelityCard(card1);

		
		//Création d'un Order
		order = new Order(customer1,restaurant1,"DiscoverAfrica");
		

		
	}
	
	@Test
	public void testAddMenuItem() {
		this.initialisation();
		order.addMenuItem(dish1);
		assert(order.getItemsOrdered().get(0).equals(dish1));
		
	}

	@Test
	public void testGetOrderPriceWithoutDiscount() {
		this.initialisation();
		order.addMenuItem(dish1);
		order.addMenuItem(dish1);
		order.addMenuItem(meal1);
		
		order.setFinalOrderPrice(order.getOrderPrice());
		
		double s =0 ;
		s+=2*dish1.getPrice()+ meal1.getPrice();

		assert(order.getFinalOrderPrice()== s);
		assert(order.getFinalOrderPrice()== 37.3);
		
	}


}
