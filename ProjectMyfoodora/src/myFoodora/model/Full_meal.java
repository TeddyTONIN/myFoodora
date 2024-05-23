package myFoodora.model;

public class Full_meal extends Meal {
	private Dish item3;
	
	
	public Full_meal(String category, Dish item1, Dish item2, Dish item3) {
		super(category, item1, item2);
		// TODO Auto-generated constructor stub
		this.item3 = item3;
	}


	public Dish getItem3() {
		return item3;
	}


	public void setItem3(Dish item3) {
		this.item3 = item3;
	}
	
	
	
}
