package myFoodora.model;
import java.util.HashMap;
import java.util.Map;
import myFoodora.design.abstractFactory.OrderFactory;

public class Order extends OrderFactory {
	
	private Restaurant restaurant;
	private double price;
	private Map<Dish, Integer> dishQuantityMap = new HashMap<>();
    private Map<Meal, Integer> mealQuantityMap = new HashMap<>();
    private Coordinate position;
    private boolean delivered = false;
    
    public Order(Restaurant restaurant, double x,double y ) {
    	position = new Coordinate (x,y);
    	this.restaurant = restaurant;
    }

    public void addDish(Dish dish, int quantity) {
        dishQuantityMap.put(dish, quantity);
    }
    public void addMeal(Meal meal, int quantity) {
        mealQuantityMap.put(meal, quantity);
    }

    public Map<Dish, Integer> getDishQuantityMap() {
        return dishQuantityMap;
    }
    public Map<Meal, Integer> getMealQuantityMap() {
        return mealQuantityMap;
    }
	public Restaurant getRestaurant() {
		return restaurant;
	}
	public void setRestaurant(Restaurant restaurant) {
		this.restaurant = restaurant;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public Coordinate getPosition() {
		return position;
	}
	public void setPosition(Coordinate position) {
		this.position = position;
	}
	public boolean isDelivered() {
		return delivered;
	}
	public void setDelivered(boolean delivered) {
		this.delivered = delivered;
	}
	
    
    

}

