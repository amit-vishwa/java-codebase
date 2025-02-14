package section24;

/**
 * The Truck is final class inheriting the sealed class Vehicle
 */
public final class Truck extends Vehicle implements SmartMediaPlayer {

	@Override
	public void connectPhone() {
		System.out.println("Phone connected to Truck!");
	}

}
