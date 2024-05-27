package myFoodora.Policy;

public class TargetProfitPolicy implements Policy{
	
	public double targetProfit_ServiceFee(double incomeLM, double target_profit,double deliveryCost, double markupPercentage) {
		return (target_profit+deliveryCost-incomeLM*markupPercentage);
	}
	
	public double targetProfit_MarkupFee(double incomeLM, double serviceFee, double deliveryCost, double target_profit) {
		return (target_profit-serviceFee+deliveryCost)/incomeLM;
	}
	
	public double TargetProfit_DeliveryCost(double incomeLM,double target_profit,double serviceFee, double markupPercentage) {
		return (incomeLM*markupPercentage+serviceFee-target_profit);
	}
}
