package myFoodora.model;

public class Dish implements MenuItem {
	private double price;
	private DishCategory category; // Starter, main_dish, dessert
	private String name;
	private FoodCategory type; // vegetarian, gluten-free or standard
	
	
	public Dish(String name, DishCategory category,FoodCategory type,double price) {
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
	public DishCategory getCategory() {
		return category;
	}
	public void setCategory(DishCategory category) {
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
	public FoodCategory getType() {
		return type;
	}
	public void setType(FoodCategory type) {
		this.type = type;
	}
	
	
	@Override
	public boolean equals(Object obj) {
		if (obj==this)return true;
		if(obj!=null && obj.getClass()==this.getClass())
			return ((Dish)obj).getPrice()==this.price
			&& ((Dish)obj).getCategory()==this.category;
		return false;
	}

}
