package myFoodora.model;

import java.util.ArrayList;

public class Menu {
	private ArrayList<Meal> meals;
	private ArrayList<Dish> starters;
	private ArrayList<Dish> mainDishes;
	private ArrayList<Dish> desserts;
	
	public Menu() {
		super();
		this.meals = new ArrayList<Meal>();
		this.starters = new ArrayList<Dish>();
		this.mainDishes = new ArrayList<Dish>();
		this.desserts = new ArrayList<Dish>();
	}
	
	public void addMeal(Meal meal) {
		meals.add(meal);
	}
	public void removeMeal(Meal meal) {
		meals.remove(meal);
	}
}
