package myFoodora.Policy;

public class TargetProfit_DeliveryCost implements TargetProfitPolicy{

	@Override
	public double targetProfitCriteria(double incomeLM,double target_profit,double serviceFee, double markupPercentage) {
		// TODO Auto-generated method stub
		return (incomeLM*markupPercentage+serviceFee-target_profit);
	}

}
