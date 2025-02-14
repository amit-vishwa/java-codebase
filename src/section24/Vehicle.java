package section24;

/**
 * Sealed classes are used to control inheritance property. Sealed classes can
 * be inherited by permitted classes only.
 */
public sealed class Vehicle permits Car, Bike, Truck {

	public static void main(String[] args) {
		validateInstances();
	}

	private static void validateInstances() {
		var dog = new Dog();
		var car = new Car();
		var truck = new Truck();
		// Getting for below as Dog is not permitted -> Incompatible conditional operand
		// types Dog and Vehicle
//		System.out.println("Dog is an instance of Vehicle? " + (dog instanceof Vehicle));
		System.out.println("Car is an instance of Vehicle? " + (car instanceof Vehicle));
		System.out.println("Truck is an instance of Vehicle? " + (truck instanceof Vehicle));
		// Here, Bike broke the inheritance restriction by being non-sealed class, hence
		// Dog is instance of Vehicle now
		System.out.println("Dog is an instance of Vehicle? " + (dog instanceof Vehicle));
		truck.connectPhone();
		dog.action();
	}

}
