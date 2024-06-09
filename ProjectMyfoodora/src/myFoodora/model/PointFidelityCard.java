package myFoodora.model;

import java.util.ArrayList;
import java.util.Collection;

public class PointFidelityCard extends FidelityCard {
	private int points;
	private double reste ;

	public PointFidelityCard(Customer customer) {
		super(customer);
		// TODO Auto-generated constructor stub
	}

	public double getReste() {
		return reste;
	}

	public int getPoints() {
		return points;
	}
	public void setPoints(int  points) {
		this.points = points;
	}
	
	@Override
	public void update() {
		// first get the last order
		Collection <Order> collectionOrderHistory = super.getCustomer().getOrderHistory().values();
		ArrayList<Order> orderHistory = new ArrayList<>(collectionOrderHistory);
		Order lastOrder = orderHistory.get(orderHistory.size() - 1);
		
		// now udpdate reste and point
		reste+=lastOrder.getFinalOrderPrice();
		points+=(int)(reste/10);
		reste=reste%10;
		
	}
	
	@Override
	public double computeDiscount(double priceWithoutDiscount) {

		if ((points/100)>0) {
			int res = ((points)/100)*10;
			points = points%100;
			return res;
		}
		return 0.0;
	}

	@Override
	public String toString() {
		return "PointFidelityCard [points=" + points + ", reste=" + reste + "]";
	}

}
