package myFoodora.model;
import java.util.Random;

public class LotteryFidelityCard extends FidelityCard {
	
	
	public LotteryFidelityCard(Restaurant restaurant) {
		super(restaurant);
	}
	
	public double computeDiscount(double priceWithoutDiscount) {
		boolean outcome = bernoulliTrial(super.getRestaurant().getP());
		return outcome ?  priceWithoutDiscount : 0;
	}
	
    public static boolean bernoulliTrial(double p) {
        Random random = new Random();

        // Generate a random number between 0.0 (inclusive) and 1.0 (exclusive)
        double randomValue = random.nextDouble();

        return randomValue < p;
    }

}
