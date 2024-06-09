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
			if (courriers.size()==0) {
				System.out.println("The system doesn't have any courrier at all");
				return null;
			}
			else {
				Collections.sort(courriers);
				int i=0;
				while(courriers.get(i).isOn_duty()==false) {
					if(i+1<courriers.size()) {
						i=i+1;
					}
					else {
						System.out.println("There is no courier available");
						return null;
					}
				}
			}
			System.out.println("The system has found a courier available");
			return courriers.get(0);
		}

	}
	static class FastestDelivery implements DeliveryPolicy {
		
		public double computeDistance(Coordinate c1,Coordinate c2) {
			return (Math.sqrt(Math.pow(c1.getX()-c2.getX(), 2)+Math.pow(c1.getY()-c2.getY(),2)));
		}
		
		@Override
		public Courrier allocateCourrier(ArrayList<Courrier> courriers, Order order) {
			Coordinate restauCord=order.getRestaurant().getLocation();
			int i=0;
			int positionCourierList=0;
			if (courriers.size()==0) {
				System.out.println("The system doesn't have any courrier at all");
				return null;
			}
			else {
				while(courriers.get(i).isOn_duty()==false) {
					if(i+1<courriers.size()) {
						//System.out.println(i);
						i=i+1;
						//System.out.println(i);
						//System.out.println(courriers.get(i));
					}
					else {
						System.out.println("There is no courier available");
						return null;
					}
				}
				double d=computeDistance(restauCord, courriers.get(i).getPosition());
				for (int j=i;j<courriers.size();j++) {
					if(courriers.get(j).isOn_duty()==true) {
						//System.out.println(j);
						//System.out.println(courriers.get(j));
						if(d>computeDistance(restauCord, courriers.get(j).getPosition())) {
							d=computeDistance(restauCord, courriers.get(j).getPosition());
							positionCourierList=j;
							Courrier courier=courriers.get(positionCourierList);
							//System.out.println(courier);
						}
					}	
				}
			}
			System.out.println("Courrier  choosed is"+courriers.get(positionCourierList));
			return(courriers.get(positionCourierList));
		}

	}

}



