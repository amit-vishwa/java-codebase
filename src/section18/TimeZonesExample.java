package section18;

import java.time.Clock;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;

/**
 * Demonstrates the use of ZonedDateTime, ZoneId, ZoneOffset
 */
public class TimeZonesExample {

	public static void main(String args[]) {
		zonedDateTimeExample();
		localDateTimeZoneExample();
		conversionBetweenDates();
	}

	/**
	 * Create ZonedDateTime using default now and with parameters like ZoneId and
	 * Clock. Fetch zone and offset related information from its object.
	 */
	private static void zonedDateTimeExample() {
		ZonedDateTime zonedDateTime = ZonedDateTime.now();
		System.out.println("Current ZonedDateTime: " + zonedDateTime);
		System.out.println("Current ZoneOffset: " + zonedDateTime.getOffset()); // w.r.t. UTC
		System.out.println("Current ZoneId: " + zonedDateTime.getZone());

		System.out.print("Available ZoneIds: ");
		ZoneId.getAvailableZoneIds().forEach(zone -> System.out.print(zone + " "));
		System.out.print("\nAvailable ZoneIds count: " + ZoneId.getAvailableZoneIds().size());

		// Different US time zones - CST (Central), EST (Eastern), MST (Mountain), PST
		// (Pacific)
		System.out.println("Chicago timezone - CST: " + ZonedDateTime.now(ZoneId.of("America/Chicago")));
		System.out.println("Detroit timezone - EST: " + ZonedDateTime.now(ZoneId.of("America/Detroit")));
		System.out.println("Los Angeles timezone - PST: " + ZonedDateTime.now(ZoneId.of("America/Los_Angeles")));
		System.out.println("Denver timezone - MST: " + ZonedDateTime.now(ZoneId.of("America/Denver")));

		// Implement above using clock
		System.out.println(
				"Calcutta timezone using clock - IST: " + ZonedDateTime.now(Clock.system(ZoneId.of("Asia/Calcutta"))));
	}

	/**
	 * Create LocalDateTime using ZoneId, Clock and Instant
	 */
	private static void localDateTimeZoneExample() {
		LocalDateTime localDateTimeZone = LocalDateTime.now(ZoneId.of("America/Chicago"));
		System.out.println("LocalDateTime of Chicago: " + localDateTimeZone);
		LocalDateTime localDateTimeClock = LocalDateTime.now(Clock.system(ZoneId.of("Etc/GMT+9")));
		System.out.println("LocalDateTime of GMT+9: " + localDateTimeClock);
		LocalDateTime localDateTimeInstantZone = LocalDateTime.ofInstant(Instant.now(), ZoneId.systemDefault());
		System.out.println("LocalDateTime of System: " + localDateTimeInstantZone);
	}

	/**
	 * Convert LocalDateTime & Instant to ZonedDateTime
	 */
	private static void conversionBetweenDates() {
		// return current local date time
		LocalDateTime localDateTime = LocalDateTime.now();
		System.out.println("LocalDateTime: " + localDateTime);
		// appends offset and zone with current local date time
		ZonedDateTime zonedDateTime = localDateTime.atZone(ZoneId.of("America/Chicago"));
		System.out.println("ZonedDateTime: " + zonedDateTime);
		// returns date time w.r.t. UTC
		Instant instant = Instant.now();
		System.out.println("Instant: " + instant);
		// converts instant to zoned date time with specified zone
		ZonedDateTime zonedDateTimeInstant = instant.atZone(ZoneId.of("America/Detroit"));
		System.out.println("ZonedDateTime: " + zonedDateTimeInstant);

		// it appends offset to local date time and returns offset date time
		OffsetDateTime offsetDateTime = localDateTime.atOffset(ZoneOffset.ofHours(-6));
		System.out.println("OffsetDateTime: " + offsetDateTime);
	}

}
