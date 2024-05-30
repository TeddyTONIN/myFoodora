package myFoodora.Test;


import myFoodora.model.MyFoodoraSystem;
import myFoodora.model.UserInterface;

public class UserInterfaceTestSimple {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		UserInterface userI= new UserInterface();
		userI.setup("1");
		System.out.println(MyFoodoraSystem.getInstance().getRestaurant("moi").getName());
	}
}
