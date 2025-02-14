package section24;

/**
 * As Dog is not permitted by sealed class Vehicle, it cannot inherit
 * 
 * Here Bike is non-sealed class and open for inheritance by any class
 */
//public class Dog extends Vehicle{
public class Dog extends Bike {

	// Abstract method must be implemented of abstract class
	@Override
	public void action() {
		System.out.println("Action to bark");
	}

}
