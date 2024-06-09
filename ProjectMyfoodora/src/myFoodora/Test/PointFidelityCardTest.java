package myFoodora.Test;

import org.junit.Test;
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
		assert(pointCard.getReste()==7.3);
		
		
		Order order2= new Order(customer1,restaurant1,"FranchBreakfast");
		for (int i =0;i<1000;i++) {
			order2.addMenuItem(dish1);
		}
		customer1.getOrderHistory().put(order2.getOrderName(),order2);
		customer1.getFidelityCard().update();	
		assert(pointCard.getPoints()== 3);
		assert(pointCard.getReste()== 7.3);
				
	}
	

}
