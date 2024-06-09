package myFoodora.Test;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

import org.junit.Before;

import myFoodora.model.*;


public class PointFidelityCardTest extends OrderTest {
	@Before
	@Override
	public void initialisation() {
		super.initialisation();
		order.addMenuItem(dish1);
		order.addMenuItem(dish1);
		order.addMenuItem(meal1);

		customer1.getOrderHistory().put(order.getOrderName(),order);
		customer1.getFidelityCard().update();
	}
	
	@Test
	public void testGetPoints() {
		this.initialisation();
		
		PointFidelityCard pointCard = (PointFidelityCard) card1;
		assert(pointCard.getPoints()== 3);
		
		
		Order order2= new Order(customer1,restaurant1,"FranchBreakfast");
		for (int i =0;i<1000;i++) {
			order2.addMenuItem(dish1);
		}
		customer1.getOrderHistory().put(order2.getOrderName(),order2);
		customer1.getFidelityCard().update();

		System.out.println(pointCard);
		order2.getOrderPrice();
		System.out.println(pointCard);
		assert(pointCard.getPoints()== 3);

				
	}
	
	@Test
	public void testPricingWithPointsDiscount(){
		
		this.initialisation();
		PointFidelityCard pointCard = (PointFidelityCard) card1;		
		
		Order order2= new Order(customer1,restaurant1,"FranchBreakfast");
		for (int i =0;i<100;i++) {
			order2.addMenuItem(dish1);
		}
		customer1.getOrderHistory().put(order2.getOrderName(),order2);
		customer1.getFidelityCard().update();
		assertTrue(order2.getPriceWithoutDiscount()==1200.0);
		assertTrue(pointCard.computeDiscount(order2.getPriceWithoutDiscount())==0.0);
		
		
	}
	

}
