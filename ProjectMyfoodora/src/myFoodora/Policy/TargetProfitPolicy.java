package myFoodora.Policy;

public interface TargetProfitPolicy extends Policy{
	
	double targetProfitCriteria(double incomeLM, double criteria1, double criteria2,double target_profit);
}
