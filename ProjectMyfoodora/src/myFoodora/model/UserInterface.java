package myFoodora.model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import myFoodora.Policy.DeliveryPolicy;
import myFoodora.Policy.TargetProfitPolicy;
import myFoodora.design.abstractFactory.DishFactory;
import myFoodora.design.abstractFactory.MealFactory;
import myFoodora.design.abstractFactory.OrderFactory;
import myFoodora.design.abstractFactory.UserFactory;

public class UserInterface {
	static UserFactory uF = new UserFactory();
	static DishFactory dF = new DishFactory();
	static OrderFactory oF = new OrderFactory();
	static MealFactory mF = new MealFactory();

	public static void registerRestaurant(ArrayList<String> para) {
		MyFoodoraSystem.getInstance().getRestaurantsList().put(para.get(2),
				(Restaurant) uF.createUser("restaurant", para));
	}

	public static void registerCustomer(ArrayList<String> para) {
		MyFoodoraSystem.getInstance().getClientsList().put(para.get(2), (Customer) uF.createUser("Customer", para));
	}

	public static void registerCourrier(ArrayList<String> para) {
		MyFoodoraSystem.getInstance().getCourriersList().put(para.get(2), (Courrier) uF.createUser("courrier", para));
	}

	public static void addDishRestaurantMenu(String RestaurantName, ArrayList<String> para) {
		dF.createDish(RestaurantName, para.get(1), para);
	}

	public static void createOrder(Customer customer, ArrayList<String> para) {
		oF.createOrder(customer, para);
	}

	public static void addItem2Order(Customer customer, ArrayList<String> para) {
		Order order = customer.getOrderHistory().get(para.get(0));
		Restaurant restaurant = order.getRestaurant();
		MenuItem command = null;
		boolean mealFound = false;
		if (restaurant.getMeal_of_the_week() != null) {
			if (para.get(1).equals(restaurant.getMeal_of_the_week().getName())) {
				command = restaurant.getMeal_of_the_week();
				mealFound = true;
				order.addMenuItem(command);
			}

		}
		if (mealFound == false) {
			if (restaurant.getStarters() != null) {
				for (MenuItem dish : restaurant.getStarters()) {
					if (dish.getName().equals(para.get(1))) {
						command = dish;
						mealFound = true;
						order.addMenuItem(command);
						break;
					}
				}
			}

		}
		if (mealFound == false) {
			if (restaurant.getMain_dishes() != null) {
				for (MenuItem dish : restaurant.getMain_dishes()) {
					if (dish.getName().equals(para.get(1))) {
						command = dish;
						mealFound = true;
						order.addMenuItem(command);
						break;
					}
				}
			}

		}
		if (mealFound == false) {
			if (restaurant.getDesserts() != null) {
				for (MenuItem dish : restaurant.getDesserts()) {
					if (dish.getName().equals(para.get(1))) {
						command = dish;
						mealFound = true;
						order.addMenuItem(command);
						break;
					}
				}
			}

		}
		if (mealFound == false) {
			if (restaurant.getMeals() != null) {
				for (MenuItem dish : restaurant.getMeals()) {
					if (dish.getName().equals(para.get(1))) {
						command = dish;
						mealFound = true;
						order.addMenuItem(command);
						break;
					}
				}
			}

		}
		if (mealFound == false)
			System.out.println(
					"le repas commandé n'existe pas dans ce restaurant.\n Veuillez entrez un repas qui existe");

	}

	public static void endOrder(Customer customer, ArrayList<String> para) {
		Order order = customer.getOrderHistory().get(para.get(0));
		Restaurant restaurant = order.getRestaurant();
		restaurant.getOrderHystory().put(order.getOrderName(), order);
		String[] datepara = para.get(1).split("/");
		int day = Integer.parseInt(datepara[0]);
		int month = Integer.parseInt(datepara[1]);
		int year = Integer.parseInt(datepara[2]);
		order.setDate(new Date(day, month, year));

		order.setFinalOrderPrice(order.getOrderPrice());
		MyFoodoraSystem.getInstance().getOrdersHistory().add(order);
		customer.getFidelityCard().update();

	}

	public static void onDuty(Courrier courier, ArrayList<String> para) {
		courier.setOn_duty(true);
	}

	public static void offDuty(Courrier courier, ArrayList<String> para) {
		courier.setOn_duty(false);
	}

	public static void setDeliveryPolicy(ArrayList<String> para) {
		if (para.get(0).equalsIgnoreCase("FastestDelivery"))
			MyFoodoraSystem.getInstance().setDeliveryPolicy(new DeliveryPolicy.FastestDelivery());
		else if (para.get(0).equalsIgnoreCase("Fair_occupationDelivery"))
			MyFoodoraSystem.getInstance().setDeliveryPolicy(new DeliveryPolicy.Fair_occupationDelivery());
		else
			System.out.println("La policie n'a pas été reconnu. \n veuillez entrer une policie existante");
	}

	public static void setProfitPolicy(ArrayList<String> para) {
		if (para.get(0).equalsIgnoreCase("TargetProfit_servicefee"))
			MyFoodoraSystem.getInstance().setTargetProfitPolicy(new TargetProfitPolicy.TargetProfit_servicefee());
		else if (para.get(0).equalsIgnoreCase("TargetProfit_MarkupFee"))
			MyFoodoraSystem.getInstance().setTargetProfitPolicy(new TargetProfitPolicy.TargetProfit_MarkupFee());
		else if (para.get(0).equalsIgnoreCase("TargetProfit_deliveryCost"))
			MyFoodoraSystem.getInstance().setTargetProfitPolicy(new TargetProfitPolicy.TargetProfit_deliveryCost());
	}

	public static void showCustomers() {
		System.out.println("Ci- dessous la liste des customers");
		MyFoodoraSystem.getInstance().showCustomer();
	}

	public static void showMenuItem(ArrayList<String> para) {
		Restaurant restaurant = MyFoodoraSystem.getInstance().getRestaurant(para.get(0));
		restaurant.showMenuItem();
	}

	public static void showtotalProfit() {
		double profit = MyFoodoraSystem.getInstance().getSystemProfit();
		System.out.println("The total profit of system is: " + profit + "€");
	}

	public static User login(ArrayList<String> para) {
		if (MyFoodoraSystem.getInstance().getRestaurantsList().containsKey(para.get(0))) {
			Restaurant restaurant = MyFoodoraSystem.getInstance().getRestaurant(para.get(0));
			if (restaurant.getPassword().equals(para.get(1))) {
				System.out.println("connexion restaurant réussie");
				return (restaurant);
			} else {
				System.out.println("Le mot de passe entrée est incorrect");
				return null;
			}
		} else if (MyFoodoraSystem.getInstance().getClientsList().containsKey(para.get(0))) {
			Customer client = MyFoodoraSystem.getInstance().getClient(para.get(0));
			if (client.getPassword().equals(para.get(1))) {
				System.out.println("connexion customer réussie ");
				return (client);
			} else {
				System.out.println("Le mot de passe entrée est incorrect");
				return null;
			}
		} else if (MyFoodoraSystem.getInstance().getManagersList().containsKey(para.get(0))) {
			Manager manager = MyFoodoraSystem.getInstance().getManager(para.get(0));
			if (manager.getPassword().equals(para.get(1))) {
				System.out.println("connexion manager réussie");
				return (manager);
			} else {
				System.out.println("Le mot de passe entrée est incorrect");
				return null;
			}
		} else if (MyFoodoraSystem.getInstance().getCourriersList().containsKey(para.get(0))) {
			Courrier courier = MyFoodoraSystem.getInstance().getCourrier(para.get(0));
			if (courier.getPassword().equals(para.get(1))) {
				System.out.println("connexion  courrier réussie");
				return (courier);
			} else {
				System.out.println("Le mot de passe entrée est incorrect");
				return null;
			}
		}
		System.out.println("utiliseur non reconnue par le système");
		return null;
	}

	public static void createMeal(Restaurant restaurant, ArrayList<String> para) {
		Full_meal meal = mF.createMeal(para.get(0),restaurant );
		ArrayList<MenuItem> meals = restaurant.getMenu().get("meals");
		meals.add(meal);
	}

	public static void addDish2Meal(Restaurant restaurant, ArrayList<String> para) {
		Full_meal meal = (Full_meal) restaurant.getMealItem(para.get(1));
		Dish dish = restaurant.getDishItem(para.get(0));
		if (meal.getItem1() == null) {
			meal.setItem1(dish);
		} else if (meal.getItem2() == null) {
			meal.setItem2(dish);
		} else {
			meal.setItem3(dish);
		}
	}

	public static void showMeal(Restaurant restaurant, ArrayList<String> para) {
		restaurant.ShowMeal(para.get(0));
	}

	public static void saveMeal(Restaurant restaurant, ArrayList<String> para) {
		Meal meal = (Full_meal) restaurant.getMealItem(para.get(0));
		if (((Full_meal) meal).getItem3() == null) {
			meal = (Meal) meal;
			meal.computePrice(restaurant.getGenericDiscountFactor());
			System.out.println("Half_meal sauvegardé");
		} else {
			meal = (Full_meal) meal;
			meal.computePrice(restaurant.getGenericDiscountFactor());
			System.out.println(" Full meal sauvegardé");
		}
	}

	public static void setSpecialOffer(Restaurant restaurant, ArrayList<String> para) {
		restaurant.setMeal_of_the_week(restaurant.getMealItem(para.get(0)));
	}

	public static void removeFromSpecialOffer(Restaurant restaurant, ArrayList<String> para) {
		restaurant.setMeal_of_the_week(null);
	}

	public static void showTotalProfit() {
		System.out.println("The total profit of the system is :" + MyFoodoraSystem.getInstance().getSystemProfit() + " €.");
	}

	public static void showTotalProfit(ArrayList<String> para) {
		String[] datepara1 = para.get(0).split("/");
		int day1 = Integer.parseInt(datepara1[0]);
		int month1 = Integer.parseInt(datepara1[1]);
		int year1 = Integer.parseInt(datepara1[2]);
		Date startDate = new Date(day1, month1, year1);

		String[] datepara2 = para.get(0).split("/");
		int day2 = Integer.parseInt(datepara2[0]);
		int month2 = Integer.parseInt(datepara2[1]);
		int year2 = Integer.parseInt(datepara2[2]);
		Date endDate = new Date(day2, month2, year2);

		double profit = MyFoodoraSystem.getInstance().getSystemProfit(startDate, endDate);
		System.out.println("The total profit of the system between" + startDate.toString() + " and" + endDate.toString()
				+ " is:" + profit + " €.");

	}

	public static void associateCard(ArrayList<String> para) {
		Customer customer = MyFoodoraSystem.getInstance().getClient(para.get(0));
		FidelityCard fcard =customer.getFidelityCard();
		if (para.get(1)=="BasicFidelityCard") {
			fcard=new BasicFidelityCard(customer);
		}
		else if (para.get(1)=="LotteryFidelityCard") {
			fcard=new LotteryFidelityCard(customer);
		}
		else if (para.get(1)=="PointFidelityCard"){
			fcard=new PointFidelityCard(customer);
		}
		else System.out.println("The card type is unknown");	
	}


	public void showCourierDeliveries() {
	}

}
