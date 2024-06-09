package myFoodora.model;

public class Full_meal extends Meal {
	private Dish item3;
	
	
	public Full_meal(String name, Dish item1, Dish item2, Dish item3) {
		super(name, item1, item2);
		// TODO Auto-generated constructor stub
		this.item3 = item3;
		if(item1.getType()==item2.getType() && item3.getType() == item3.getType()) {
			super.type =  item3.getType();		
		}
	}
	public Full_meal(String name) {
		super(name);
	}


	public Dish getItem3() {
		return item3;
	}


	public void setItem3(Dish item3) {
		this.item3 = item3;
		if (item3.getType()!=type) {
			type=FoodCategory.standard;
		}
	}
	@Override 
	public void computePrice(double discountfactor) {
		if (item3==null) {
			setPrice((1-discountfactor)*(getItem1().getPrice()+getItem2().getPrice()));
		}
		else
		setPrice((1-discountfactor)*(getItem1().getPrice()+getItem2().getPrice()+item3.getPrice()));
	}
	
	@Override
	public String toString() {
		return super.toString()+ "item3=" + item3 + ", type=" + type + "]";
	}
	
	
	
}
