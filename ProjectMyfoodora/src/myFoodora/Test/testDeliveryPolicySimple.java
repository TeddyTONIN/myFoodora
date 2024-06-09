package myFoodora.Test;

import java.util.ArrayList;

import myFoodora.model.Coordinate;
import myFoodora.model.Courrier;
import myFoodora.model.MyFoodoraSystem;
import myFoodora.model.Order;
import myFoodora.model.UserInterface;

public class testDeliveryPolicySimple {

	public static void main(String[] args) {
		//création d'un customer
		ArrayList<String> paraCustomer=new ArrayList<String>();
		paraCustomer.add("Jonathan");
		paraCustomer.add("olivers");
		paraCustomer.add("JonaliversCustomer");
		paraCustomer.add("45,60");
		paraCustomer.add("test");
		UserInterface.registerCustomer(paraCustomer);
		
		//création d'un restaurant
		ArrayList<String> paraRestau=new ArrayList<String>();
		paraRestau.add("TourDargent");
		paraRestau.add("25,15");
		paraRestau.add("TourDargent");
		paraRestau.add("12345678");	
		UserInterface.registerRestaurant(paraRestau);
		
		//création d'un order
		Order orderVide= new Order(MyFoodoraSystem.getInstance().getClient("JonaliversCustomer"),MyFoodoraSystem.getInstance().getRestaurant("TourDargent"),"vide");
		MyFoodoraSystem.getInstance().getClient("JonaliversCustomer").getOrderHistory().put("vide", orderVide);
		
		//création de courrier
		ArrayList<Courrier> courriers=new ArrayList<Courrier>();
		Courrier courrier1= new Courrier("courier1", "courrier1", "courier1",new Coordinate(50,45), "000");
		courrier1.setNbCompletedOrder(4);
		courriers.add(courrier1);
		MyFoodoraSystem.getInstance().getCourriersList().put(courrier1.getName(), courrier1);
		Courrier courrier2= new Courrier("courier2", "courrier2", "courier2", new Coordinate(76,45), "000");
		courrier2.setNbCompletedOrder(3);
		courriers.add(courrier2);
		MyFoodoraSystem.getInstance().getCourriersList().put(courrier2.getName(), courrier2);
		Courrier courrier3= new Courrier("courier3", "courrier1", "courier3",new Coordinate(25,45), "000");
		courrier3.setNbCompletedOrder(2);
		courriers.add(courrier3);
		MyFoodoraSystem.getInstance().getCourriersList().put(courrier3.getName(), courrier3);
		Courrier courrier4= new Courrier("courier4", "courrier1", "courier4", new Coordinate(0,15), "000");
		courrier4.setNbCompletedOrder(1);
		courriers.add(courrier4);
		courrier4.setOn_duty(false);
		MyFoodoraSystem.getInstance().getCourriersList().put(courrier4.getName(), courrier4);
		Courrier courrier5= new Courrier("courier5", "courrier1", "courier5",new Coordinate(25,15), "000");
		courrier5.setNbCompletedOrder(14);
		courriers.add(courrier5);
		MyFoodoraSystem.getInstance().getCourriersList().put(courrier5.getName(), courrier5);
		
		UserInterface.showCourierDeliveries();
		
	}
}
