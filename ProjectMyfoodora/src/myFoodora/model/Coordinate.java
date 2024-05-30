package myFoodora.model;

import java.util.Random;

public class Coordinate {
	private double x;
	private double y;
	public Coordinate(double x, double y) {
		this.x = x;
		this.y = y;
	}
	public Coordinate() {
			Random rand = new Random();
	        this.x= rand.nextDouble()*100;
	        this.y= rand.nextDouble()*100;       
	}
	public double getX() {
		return x;
	}
	public void setX(double x) {
		this.x = x;
	}
	public double getY() {
		return y;
	}
	public void setY(double y) {
		this.y = y;
	}
	@Override
	public String toString() {
		return "Coordinate [x=" + x + ", y=" + y + "]";
	}
	
}
