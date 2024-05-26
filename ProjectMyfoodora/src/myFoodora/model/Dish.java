package myFoodora.model;

public class Dish implements MenuItem {
	private double price;
	private String category; // Starter, main_dish, dessert
	private String name;
	private String type; // vegetarian, gluten-free or standard
	
	
	public Dish(String name, String category,String type,double price) {
		super();
		this.price = price;
		this.category = category;
		this.name = name;
		this.type = type;
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
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
    @Override
    public String toString() {
        return "Dish{name='" + name + "', category ='"+category+" ', price=" + price + '}';
    }
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	

}
