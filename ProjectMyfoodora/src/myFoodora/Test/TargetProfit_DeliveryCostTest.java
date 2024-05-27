package myFoodora.Test;

import static org.junit.Assert.*;

import org.junit.Test;

import myFoodora.Policy.TargetProfit_DeliveryCost;

public class TargetProfit_DeliveryCostTest {

	@Test
	public void testTargetProfitCriteria() {
		TargetProfit_DeliveryCost p1=new TargetProfit_DeliveryCost();
		double cost=p1.targetProfitCriteria(15, 0.15, 18, 0.05);
		
		assertTrue(cost==18.6);
	}

}
