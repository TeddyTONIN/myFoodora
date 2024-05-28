package myFoodora.Policy;

public interface TargetProfitPolicy extends Policy{
	public double criteria (double incomeLM, double target_profit,double criteria1, double criteria2);
	
	static class TargetProfit_servicefee implements TargetProfitPolicy{
		public double criteria(double incomeLM, double target_profit,double deliveryCost, double markupPercentage) {
			return (target_profit+deliveryCost-incomeLM*markupPercentage);
		}
	}
	
	static class TargetProfit_MarkupFee implements TargetProfitPolicy{	
		public double criteria(double incomeLM, double serviceFee, double deliveryCost, double target_profit) {
			return (target_profit-serviceFee+deliveryCost)/incomeLM;
		}
	}
	
	static class TargetProfit_deliveryCost implements TargetProfitPolicy{
		public double criteria(double incomeLM,double target_profit,double serviceFee, double markupPercentage) {
			return (incomeLM*markupPercentage+serviceFee-target_profit);
		}
	}
	
}
