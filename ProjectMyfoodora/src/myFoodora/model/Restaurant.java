package myFoodora.model;
import java.util.ArrayList;

public class Restaurant extends User {
	private String name;
	private Coordinate location;
	private Menu menu;
	private ArrayList<Meal> meals;
	private Meal meal_of_the_week;
	private double genericDiscountFactor = 0.05;
	private double specialDiscountFactor;

}
