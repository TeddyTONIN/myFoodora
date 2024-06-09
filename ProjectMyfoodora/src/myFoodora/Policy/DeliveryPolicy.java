package myFoodora.Policy;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;

import myFoodora.model.Coordinate;
import myFoodora.model.Courrier;
import myFoodora.model.Manager;
import myFoodora.model.Order;
import myFoodora.model.Restaurant;

public interface DeliveryPolicy extends Policy {
	
	public Courrier allocateCourrier(ArrayList<Courrier> courriers, Order order);

	
	static class Fair_occupationDelivery implements DeliveryPolicy {

		@Override
		public Courrier allocateCourrier(ArrayList<Courrier> courriers, Order order) {
			Courrier cour=null;
			ArrayList<Courrier> courierLibre=new ArrayList<Courrier>();
			for (Courrier courier : courriers) {
				if(courier.isOn_duty()==true) {
					courierLibre.add(courier);
				}
			}
			if (courierLibre.size()!=0) {
				Collections.sort(courierLibre);
				cour=courierLibre.get(0);
			}
			else {
				System.out.println("No courier available now for this delivery");
				return null;
			}
			System.out.println("Le courrier "+cour.getName()+" will deliver this order");
			return cour;
		}

	}
	static class FastestDelivery implements DeliveryPolicy {
		
		public double computeDistance(Coordinate c1,Coordinate c2) {
			return (Math.sqrt(Math.pow(c1.getX()-c2.getX(), 2)+Math.pow(c1.getY()-c2.getY(),2)));
		}
		
		@Override
		public Courrier allocateCourrier(ArrayList<Courrier> courriers, Order order) {
			Coordinate restauCord=order.getRestaurant().getLocation();
			ArrayList<Courrier> courierLibre=new ArrayList<Courrier>();
			for (Courrier courier : courriers) {
				if(courier.isOn_duty()==true) {
					courierLibre.add(courier);
				}
			}
			Courrier courierIni=null;
			if (courierLibre.size()!=0) {
				courierIni= courierLibre.get(0);
				double d=computeDistance(restauCord, courierIni.getPosition());
				for(Courrier courier : courierLibre) {
					if(d>=computeDistance(restauCord, courier.getPosition())) {
						courierIni=courier;
					}
				}
			}
			else {
				System.out.println("No courier available now for this delivery");
				return null;
			}
			System.out.println("Le courrier "+courierIni.getName()+" will deliver this order");
			return courierIni;
		}
	}
}



