package myFoodora.Test;

import java.util.ArrayList;

import myFoodora.model.MyFoodoraSystem;
import myFoodora.model.UserInterface;

public class UserInterfaceTestSimple {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<String> para=new ArrayList<String>();
		para.add("TourDargent");
		para.add("45.1,66.2");
		para.add("12345678");
		UserInterface.registerRestaurant(para);
		System.out.println(MyFoodoraSystem.getInstance().getRestaurant("TourDargent").getPassword());
	}

}
