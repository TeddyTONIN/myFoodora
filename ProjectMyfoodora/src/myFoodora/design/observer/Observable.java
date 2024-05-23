package myFoodora.design.observer;

public interface Observable {
	
	void notify(Observer observer);
	void attach(Observer observer);
	void dettach();
}
