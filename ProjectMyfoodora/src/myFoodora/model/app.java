package myFoodora.model;

public class app {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String command=args[0];
		
		switch(command) {
		case "setup" :
			break;
		case "registerRestaurant":
			double x = Double.parseDouble(args[2]);
			double y = Double.parseDouble(args[3]);
			UserInterface.registerRestaurant(args[1], x, y);
			break;
		
		default:
			break;
		}
	}

}
