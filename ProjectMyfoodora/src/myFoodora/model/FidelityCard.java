package myFoodora.model;

public class FidelityCard {
	private Restaurant restaurant;
	private double points = 0;
	
	public FidelityCard(Restaurant restaurant) {
		this.restaurant = restaurant;
	}
	public Restaurant getRestaurant() {
		return restaurant;
	}
	public void setRestaurant(Restaurant restaurant) {
		this.restaurant = restaurant;
	}
	public double getPoints() {
		return points;
	}
	public void setPoints(double points) {
		this.points = points;
	}
	
	
	
}
