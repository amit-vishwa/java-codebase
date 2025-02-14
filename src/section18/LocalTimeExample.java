package section18;

import java.time.LocalTime;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;

/**
 * Demonstrates the use of local time
 */
public class LocalTimeExample {

	public static void main(String[] args) {
		createLocalTime();
		localTimeValues();
		getFromLocalTime();
		updateLocalTime();
	}

	/**
	 * Create local time operations
	 */
	private static void createLocalTime() {
		LocalTime localTime = LocalTime.now();
		System.out.println("Local time now: " + localTime);
		LocalTime localTimeOf = LocalTime.of(19, 59);
		System.out.println("Local time of hr and min: " + localTimeOf);
		LocalTime localTimeOfValues = LocalTime.of(19, 50, 58);
		System.out.println("Local time of hr, min and sec: " + localTimeOfValues);
		LocalTime localTimeOfNanoSec = LocalTime.of(17, 7, 45, 234523568);
		System.out.println("Local time of hr, min, sec and nano: " + localTimeOfNanoSec);
	}

	/**
	 * Different local time values like max, min, noon and midnight
	 */
	private static void localTimeValues() {
		System.out.println("Local time min: " + LocalTime.MIN);
		System.out.println("Local time max: " + LocalTime.MAX);
		System.out.println("Local time noon: " + LocalTime.NOON);
		System.out.println("Local time midnight: " + LocalTime.MIDNIGHT);
	}

	/**
	 * Fetch values from local time
	 */
	private static void getFromLocalTime() {
		LocalTime localTime = LocalTime.now();
		System.out.println("Local time hour: " + localTime.getHour());
		System.out.println("Local time minutes: " + localTime.getMinute());
		System.out.println("Local time seconds: " + localTime.getSecond());
		System.out.println("Local time nanoseconds: " + localTime.get(ChronoField.NANO_OF_SECOND));
		System.out.println("Second of day: " + localTime.toSecondOfDay());
	}

	/**
	 * Update local time values
	 */
	private static void updateLocalTime() {
		LocalTime localTime = LocalTime.now();
		System.out.println("Local time minus 2 hours: " + localTime.minusHours(2));
		System.out.println("Local time plus 20 seconds: " + localTime.plusSeconds(20));
		System.out.println(
				"Local time minus 15 minutes using temporal field: " + localTime.minus(15, ChronoUnit.MINUTES));
		System.out.println("Local time with midnight: " + localTime.with(LocalTime.MIDNIGHT));
		System.out.println("Local time with hour of day: " + localTime.with(ChronoField.HOUR_OF_DAY, 9));
		System.out.println("Local time with hour 10: " + localTime.withHour(10));
	}

}
