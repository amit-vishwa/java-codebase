package section18;

import java.time.Duration;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

/**
 * Compare time using Duration, only compatible with LocalTime. Throws
 * RuntimeException with LocalDate
 */
public class TimeDurationExample {

	public static void main(String... args) {

		LocalTime localTime1 = LocalTime.of(21, 40, 10);
		LocalTime localTime2 = LocalTime.of(21, 49, 6);
		System.out.println("Time1: " + localTime1 + ", Time2: " + localTime2);
		long durationSeconds = localTime1.until(localTime2, ChronoUnit.MINUTES); // create duration using until
		System.out.println("Duration between minutes of two times: " + durationSeconds);

		Duration duration = Duration.between(localTime1, localTime2); // create duration using between
		System.out.println("Duration: " + duration);
		System.out.println("Hours: " + duration.toHours() + ", Minutes: " + duration.toMinutes() + ", Seconds: "
				+ duration.getSeconds());

		Duration durationDays = Duration.ofDays(20);
		Duration durationHours = Duration.ofHours(2);
		Duration durationSecAndNano = Duration.ofSeconds(30, 1234523450);
		System.out.println("Duration 20 days to hours: " + durationDays.toHours());
		System.out.println("Duration hours: " + durationHours.toHours());
		System.out.println("Duration seconds: " + durationSecAndNano.getSeconds());
		System.out.println("Duration nanoseconds: " + durationSecAndNano.getNano());

	}

}
