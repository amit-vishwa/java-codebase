package section18;

import java.time.Duration;
import java.time.Instant;
import java.time.temporal.ChronoField;

/**
 * Instant is unit of time which is understandable by machine. The epoch second
 * starts from 1st January of 1970 with 0 as time
 */
public class InstantExample {

	public static void main(String[] args) {
		Instant instant = Instant.now();
		System.out.println("Current instant: " + instant);
		System.out.println("Nano seconds from current instant: " + instant.getNano());
		System.out.println("Instant seconds from current instant: " + instant.getLong(ChronoField.INSTANT_SECONDS));
		System.out.println("Seconds starting from 1970-01-01T00:00:00Z: " + instant.getEpochSecond());

		Instant newInstant = Instant.ofEpochSecond(0);
		System.out.println("New instant: " + newInstant);
		Duration duration = Duration.between(instant, newInstant);
		System.out.println("Duration between instants: " + duration.getNano());
	}

}
