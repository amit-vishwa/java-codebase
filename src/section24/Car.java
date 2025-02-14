package section24;

/**
 * The Car class is sealed class that is extending the sealed class Vehicle and
 * permitting the final class FlyingCar
 * 
 * The sealed classes can extend class, but must permit classes for inheritance
 * 
 * Here sealed interface must be implemented along with its all methods, if
 * class is sealed then permits declaration must come at end
 */
public sealed class Car extends Vehicle implements SmartMediaPlayer permits FlyingCar {

	@Override
	public void connectPhone() {
		System.out.println("Phone connected to Car!");
	}

}
