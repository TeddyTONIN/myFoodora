package myFoodora.design.observer;

public interface Observable {
	
	default void notify(Observer observer) {};
	default void attach(Observer observer) {};
	default void dettach() {};
}
