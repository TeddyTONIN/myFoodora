package myFoodora.model;

public class Meal {
	private double price;
	private String category;
	private boolean is_meal_of_the_week = false;
	private Dish item1;
	private Dish item2;
	public Meal(String category, Dish item1, Dish item2) {
		super();
		this.category = category;
		this.item1 = item1;
		this.item2 = item2;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public boolean isIs_meal_of_the_week() {
		return is_meal_of_the_week;
	}
	public void setIs_meal_of_the_week(boolean is_meal_of_the_week) {
		this.is_meal_of_the_week = is_meal_of_the_week;
	}
	public Dish getItem1() {
		return item1;
	}
	public void setItem1(Dish item1) {
		this.item1 = item1;
	}	
	
	public Dish getItem2() {
		return item2;
	}
	public void setItem2(Dish item2) {
		this.item2 = item2;
	}
	

}
