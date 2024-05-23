package myFoodora.model;

public class Dish {
	private double price;
	private String category; // vegetarian, gluten-free or standard
	public Dish(double price, String category) {
		super();
		this.price = price;
		this.category = category;
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
	
	

}
