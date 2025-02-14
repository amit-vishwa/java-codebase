package section24;

/**
 * Sealed can work similar with interfaces
 * */
public sealed interface SmartMediaPlayer permits Truck, Car {

	void connectPhone();

}
