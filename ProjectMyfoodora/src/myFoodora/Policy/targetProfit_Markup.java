package myFoodora.Policy;

public class targetProfit_Markup implements TargetProfitPolicy {

	@Override
	public double targetProfitCriteria(double incomeLM, double serviceFee, double deliveryCost, double target_profit) {
		// TODO Auto-generated method stub
		return (target_profit-serviceFee+deliveryCost)/incomeLM;
	}

}
