package section24;

/**
 * The Bike is non-sealed class that must extend a sealed class Vehicle where it
 * is permitted for inheritance
 * 
 * Here, Bike is now open for inheritance to any classes
 * 
 * Abstract keyword here will act similar to abstract classes
 */
public abstract non-sealed class Bike extends Vehicle {

	public abstract void action();

}
