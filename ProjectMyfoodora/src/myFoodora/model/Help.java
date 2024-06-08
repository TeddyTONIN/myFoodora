package myFoodora.model;

public class Help {
	private static String help ="• login <username> <password> : to allow a user to perform the login \n"+
			 "• logout <> : \n"+
			 "• registerRestaurant <name> <address> <username> <password> :\n"+
			 "• registerCustomer <firstName> <lastName> <username> <address> <password> \n"+
			 "• registerCourier <firstName> <lastName> <username> <position> <password>: \n"+
			 "• addDishRestauarantMenu <dishName> <dishCategory> <foodCategory> <unitPrice>: \n"+
			 "• createMeal <mealName> : \n"+ 
			 "• addDish2Meal <dishName> <mealName> : \n"+
			 "• showMeal <mealName> : \n"+
			 "• saveMeal <mealName> : \n"+
			 "• setSpecialOffer <mealName> : \n"+
			 "• removeFromSpecialOffer <mealName> : \n"+
			 "• createOrder <restaurantName> <orderName> : \n"+
			 "• addItem2Order <orderName> <itemName> : \n"+
			 "• endOrder <orderName> < date> :\n"+
			 "• onDuty <username> : \n"+
			 "• offDuty <username> : \n"+
			 "• findDeliverer <orderName> : \n"+
			 "• setDeliveryPolicy <delPolicyName> : \n"+
			 "• setProfitPolicy <ProfitPolicyName> : \n" +
			 "• associateCard <userName> <cardType> : \n" +
			 "• showCourierDeliveries <> : \n"+
			 "• showRestaurantTop <> : \n"+
			 "• showCustomers <> \n"+
			 "• showMenuItem <restaurant-name> \n"+
			 "• showTotalProfit<> \n"+
			 "• showTotalProfit <startDate> <endDate> \n"+
			 "• runTest <testScenario-file> \n"+
			 "• help <> \n" ;

	public static String getHelp() {
		return help;
	}
	
	
}
