package myFoodora.model;
import java.util.HashMap;
import java.util.Map;
import myFoodora.design.abstractFactory.OrderFactory;

public class Order extends OrderFactory {
	
	private Restaurant restaurant;
	private double orderPrice;
	private Map<Dish, Integer> dishQuantityMap = new HashMap<>();
    private Map<Meal, Integer> mealQuantityMap = new HashMap<>();
    private Customer customer;
    private boolean delivered = false;
    
    public Order(Restaurant restaurant, Customer customer) {
    	
    	this.restaurant = restaurant;
    	this.customer = customer;
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
	public double getOrderPrice() {
		return orderPrice;
	}
	public void setOrderPrice(double price) {
		this.orderPrice = price;
	}
	
	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public void setDishQuantityMap(Map<Dish, Integer> dishQuantityMap) {
		this.dishQuantityMap = dishQuantityMap;
	}

	public void setMealQuantityMap(Map<Meal, Integer> mealQuantityMap) {
		this.mealQuantityMap = mealQuantityMap;
	}

	public boolean isDelivered() {
		return delivered;
	}
	public void setDelivered(boolean delivered) {
		this.delivered = delivered;
	}
	
    
    

}

