package myFoodora.Policy;

public class targetProfit_ServiceFee implements TargetProfitPolicy {

	@Override
	public double targetProfitCriteria(double incomeLM, double target_profit,double deliveryCost, double markupPercentage) {
		// TODO Auto-generated method stub
		return (target_profit+deliveryCost-incomeLM*markupPercentage);
	}

}
