package myFoodora.model;



public class PointFidelityCard extends FidelityCard {
	private int points = 0;
	private int pointsBeforeLastOrder ;

	public PointFidelityCard(Restaurant restaurant, Customer customer) {
		super(restaurant,customer);
	}
	public int getPoints() {
		return points;
	}
	public void setPoints(int  points) {
		this.points = points;
	}
	@Override
	public void update() {
		double totalSpentBeforeLastOrder = 0.0;

		int numOrder = MyFoodoraSystem.getInstance().getOrdersHistory().size();
		if(numOrder >=2) {
			for (int i=0;i<numOrder-1;i++) {
				Order order = MyFoodoraSystem.getInstance().getOrdersHistory().get(i);
				if((order.getCustomer().equals(super.getCustomer())) && (order.getRestaurant().equals(super.getRestaurant()))) {
					totalSpentBeforeLastOrder+=order.getOrderPrice();	
				}
			}
		}
		int copyPoints = points;
		points+=(totalSpentBeforeLastOrder-10*pointsBeforeLastOrder)%10;
		pointsBeforeLastOrder = copyPoints;
	}
	
	@Override
	public double computeDiscount(double priceWithoutDiscount) {
		if ((points>pointsBeforeLastOrder) && (points%100==0)) {
			return ((points-pointsBeforeLastOrder)%100+1)*10;
		}
		return 0.0;
	}
	


}
