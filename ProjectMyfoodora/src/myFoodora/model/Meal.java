package myFoodora.model;

public class Meal implements MenuItem{
	private String name;
	private double price;
	protected FoodCategory type  = null; // vegetarian, gluten-free or standard
	private boolean is_meal_of_the_week = false;
	private Dish item1;
	private Dish item2;
	private Restaurant restaurant;
	
	public Meal(String name,Restaurant restaurant) {
		super();
		this.restaurant = restaurant;
		this.name=name;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void computePrice(double discountfactor) {
		price = (1-discountfactor)*(item1.getPrice()+item2.getPrice());
	}
	public double getPrice() {
		if(!is_meal_of_the_week) {
			this.computePrice(restaurant.getGenericDiscountFactor());
		}
		else this.computePrice(restaurant.getSpecialDiscountFactor());
		
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public FoodCategory getType() {
		return type;
	}


	public boolean Is_meal_of_the_week() {
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

	@Override
	public String toString() {
		return "Meal [name=" + name + ", price=" + price + ", type=" + type + ", is_meal_of_the_week="
				+ is_meal_of_the_week + ", item1=" + item1 + ", item2=" + item2 + "]";
	}
	
	
}
