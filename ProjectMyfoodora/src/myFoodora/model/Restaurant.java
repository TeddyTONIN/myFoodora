package myFoodora.model;

import java.util.ArrayList;
import myFoodora.design.abstractFactory.*;
import java.util.HashMap;

public class Restaurant extends User {
	private String name;
	private Coordinate location;
	private HashMap<String, ArrayList<MenuItem>> menu = new HashMap<>();
	private Meal meal_of_the_week;
	private HashMap<Customer, FidelityCard> customerFidelityPlans = new HashMap<Customer, FidelityCard>();
	private HashMap<String, Order> orderHystory;

	private double genericDiscountFactor = 0.5;

	private double specialDiscountFactor = 0.1;

	// rajout d'un constructeur ci-dessous pour qu'il match avec les arguments de
	// l'interface
	public Restaurant(String name, Coordinate location, String username, String password) {
		super(username, password);
		this.name = name;
		this.location = location;
		menu.put("starter", new ArrayList<MenuItem>());
		menu.put("main_dish", new ArrayList<MenuItem>());
		menu.put("dessert", new ArrayList<MenuItem>());
		menu.put("meals", new ArrayList<MenuItem>());
		this.orderHystory = new HashMap<String, Order>();
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

	public void setMenu(HashMap<String, ArrayList<MenuItem>> menu) {
		this.menu = menu;
	}

	public ArrayList<MenuItem> getMeals() {
		return menu.get("meals");
	}

	public ArrayList<MenuItem> getStarters() {
		return menu.get("starter");
	}

	public ArrayList<MenuItem> getMain_dishes() {
		return menu.get("main_dish");
	}

	public ArrayList<MenuItem> getDesserts() {
		return menu.get("dessert");
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

	public void removeDish(Dish dish) {
		DishCategory category = dish.getCategory();
		String cat = category.toString();
		ArrayList<MenuItem> dishes = menu.get(cat);
		dishes.remove(dish);
	}

	public void addMeal(Meal meal) {
		menu.get("meals").add(meal);
	}

	public void removeMeal(Meal meal) {
		ArrayList<MenuItem> meals = menu.get("meals");
		meals.add(meal);
		meals.remove(meal);
	}

	public Dish getDishItem(String name) {

		for (MenuItem dish : menu.get("starter")) {
			if (dish.getName().equals(name)) {
				return (Dish) dish;
			}
		}
		for (MenuItem dish : menu.get("main_dish")) {
			if (dish.getName().equals(name)) {
				return (Dish) dish;
			}
		}
		for (MenuItem dish : menu.get("dessert")) {
			if (dish.getName().equals(name)) {
				return (Dish) dish;
			}
		}
		System.out.print("item non existant");
		return null;
	}

	public Meal getMealItem(String name) {
		for (MenuItem dish : menu.get("meals")) {
			if (dish.getName().equals(name)) {
				return (Meal) dish;
			}
		}
		System.out.println("item non existant");
		return null;
	}

	public void ShowMeal(String name) {
		Full_meal meal = (Full_meal) this.getMealItem(name);
		if (meal.getItem1() != null) {
			System.out.println("Item 1: " + meal.getItem1().toString());
			if (meal.getItem2() != null) {
				System.out.println("Item 2: " + meal.getItem2().toString());
				if (meal.getItem3() != null) {
					System.out.println("Item 3: " + meal.getItem3().toString());
				}
			}
		}
	}

	@Override
	public String toString() {
		return "Restaurant [name=" + name + ", location=" + location + "]";
	}

	public void showMenuItem() {
		if (getMeal_of_the_week() != null) {
			System.out.println("The meal of the week is: \n ");
			System.out.println(meal_of_the_week);
		}
		if (menu.get("starter") != null) {
			System.out.println("The starter are : \n ");
			for (MenuItem menuItem : menu.get("starter")) {
				System.out.println(menuItem);
			}
		}
		if (menu.get("main_dish") != null) {
			System.out.println("The main_dish are : \n ");
			for (MenuItem menuItem : menu.get("main_dish")) {
				System.out.println(menuItem);
			}
		}
		if (menu.get("dessert") != null) {
			System.out.println("The main_dish are : \n ");
			for (MenuItem menuItem : menu.get("dessert")) {
				System.out.println(menuItem);
			}
		}
		if (menu.get("meals") != null) {
			System.out.println("The main_dish are : \n ");
			for (MenuItem menuItem : menu.get("meals")) {
				System.out.println(menuItem);
			}
		}
	}

	public HashMap<String, Order> getOrderHystory() {
		return orderHystory;
	}

}
