package myFoodora.model;
import java.util.ArrayList;
import myFoodora.design.abstractFactory.*;
import java.util.HashMap;


public class Restaurant extends User {
	private String name;
	private Coordinate location;
	private  HashMap<String, ArrayList<MenuItem>> menu = new HashMap<>();
	private Meal meal_of_the_week;

	private  double genericDiscountFactor ;

	private double specialDiscountFactor;

	
	public Restaurant(String ID, String username, String password, String name, Coordinate location) {
		super(username,password);
		this.name = name;
		this.location = location;
		// Initialize the menu with empty ArrayLists for each category
		menu.put("starter", new ArrayList<MenuItem>());
        menu.put("main_dish", new ArrayList<MenuItem>());
        menu.put("dessert", new ArrayList<MenuItem>());
        menu.put("meals",new ArrayList<MenuItem>());
	}
	
	public Restaurant(String name) {
		super(name);
		this.name = name;
		this.location = new Coordinate();
		menu.put("starter", new ArrayList<MenuItem>());
        menu.put("main_dish", new ArrayList<MenuItem>());
        menu.put("dessert", new ArrayList<MenuItem>());
        menu.put("meals",new ArrayList<MenuItem>());
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Coordinate getLocation() {
		return location;
	}

	public void setLocation(Coordinate location) {
		this.location = location;
	}

	public HashMap<String, ArrayList<MenuItem>> getMenu() {
		return menu;
	}

	public void setMenu(HashMap<String,ArrayList<MenuItem>> menu) {
		this.menu = menu;
	}

	public ArrayList<MenuItem> getMeals() {
		return menu.get("meals");
	}


	public Meal getMeal_of_the_week() {
		return meal_of_the_week;
	}

	public void setMeal_of_the_week(Meal meal_of_the_week) {
		this.meal_of_the_week = meal_of_the_week;
	}

	public double getGenericDiscountFactor() {
		return genericDiscountFactor;
	}

	public void setGenericDiscountFactor(double genericDiscountFactor) {
		this.genericDiscountFactor = genericDiscountFactor;
	}

	public double getSpecialDiscountFactor() {
		return specialDiscountFactor;
	}

	public void setSpecialDiscountFactor(double specialDiscountFactor) {
		this.specialDiscountFactor = specialDiscountFactor;
	}
	
	public void addDish(String name, String category, String type,double price) {
		DishFactory dishFactory = new DishFactory();
		Dish dish = dishFactory.createDish(name,category,type,price);
		ArrayList<MenuItem> dishes = menu.get(category);
		dishes.add(dish);
		
	}
	
	public void removeDish(Dish dish) {
		String category = dish.getCategory();
		ArrayList<MenuItem> dishes = menu.get(category);
		dishes.remove(dish);
	}
	public void addMeal(String name, Dish item1, Dish item2,Dish item3) {
		MealFactory mealFactory = new MealFactory();
		Meal meal = mealFactory.createMeal(name,item1,item2,item3);
		if (meal.Is_meal_of_the_week()) {
			meal.computePrice(specialDiscountFactor);
		}
		else {
			meal.computePrice(genericDiscountFactor);
		}
		
		ArrayList<MenuItem> meals = menu.get("meals");
		meals.add(meal);
		
	}
	public void removeMeal(Meal meal) {
		ArrayList<MenuItem> meals = menu.get("meals");
		meals.add(meal);
		meals.remove(meal);
	}

	@Override
	public String toString() {
		return "Restaurant [name=" + name + ", location=" + location + "]";
	}
	
	
}
