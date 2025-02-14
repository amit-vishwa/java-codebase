package section18;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.Date;

/**
 * Convert java.util.Date & java.sql.Date to LocalDate
 */
public class DateConversionExample {

	public static void main(String args[]) {
		utilDateConversion();
		sqlDateConversion();
	}

	/**
	 * Convert java.util.Date to LocalDate and vice-versa
	 */
	private static void utilDateConversion() {
		Date date = new Date();
		System.out.println("Util Date: " + date);
		LocalDate localDate = date // java.util.Date
				.toInstant() // convert date to instant
				.atZone(ZoneId.systemDefault()) // convert instant to zoned date time
				.toLocalDate(); // convert zoned date time to local date
		System.out.println("LocalDate: " + localDate);
		LocalTime localTime = date // java.util.Date
				.toInstant() // convert date to instant
				.atZone(ZoneId.systemDefault()) // convert instant to zoned date time
				.toLocalTime(); // convert zoned date time to local time
		System.out.println("LocalTime: " + localTime);

		Date newDate = Date.from(localDate // LocalDate object
				.atTime(LocalTime.now()) // takes LocalTime and returns LocalDateTime
				.atZone(ZoneId.systemDefault()) // takes ZoneId, return ZonedDateTime
				.toInstant()); // converted ZonedDateTime to Instant, i.e. passed as argument of Date
//		Date newDate = Date.from(localDate.atTime(LocalTime.now()).atZone(ZoneId.of("America/Chicago")).toInstant());
		System.out.println("Date from LocalDate: " + newDate);
	}

	/**
	 * Convert java.sql.Date to LocalDate and vice-versa
	 */
	private static void sqlDateConversion() {
		LocalDate localDate = LocalDate.now();
		System.out.println("LocalDate: " + localDate);
		java.sql.Date date = java.sql.Date.valueOf(localDate);
		System.out.println("Sql Date: " + date);
		System.out.println("Sql Date to LocalDate: " + date.toLocalDate());
	}

}
