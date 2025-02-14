package section18;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;

/**
 * Demonstrates the use of LocalDateTime
 */
public class LocalDateTimeExample {

	public static void main(String[] args) {
		createLocalDateTime();
		getValuesFromLocalDateTime();
		modifyLocalDateTimeValues();
		conversionToDiffTypes();
	}

	/**
	 * Multiple ways of creating the localDateTime object
	 */
	private static void createLocalDateTime() {
		LocalDateTime localDateTime = LocalDateTime.now();
		System.out.println("LocalDateTime using now: " + localDateTime);
		LocalDateTime localDateTime2 = LocalDateTime.of(2025, 02, 06, 21, 9, 9, LocalTime.now().getNano());
		System.out.println("LocalDateTime using of: " + localDateTime2);
		LocalDateTime localDateTime3 = LocalDateTime.of(LocalDate.now(), LocalTime.now());
		System.out.println("LocalDateTime using LocalDate and LocalTime: " + localDateTime3);
	}

	/**
	 * Access values from object of LocalDateTime
	 */
	private static void getValuesFromLocalDateTime() {
		LocalDateTime localDateTime = LocalDateTime.now();
		System.out.println("LocalDateTime: " + localDateTime);
		System.out.println("LocalDateTime hour: " + localDateTime.getHour());
		System.out.println("LocalDateTime minute: " + localDateTime.get(ChronoField.MINUTE_OF_HOUR));
		System.out.println("LocalDateTime day of month: " + localDateTime.getDayOfWeek());
	}

	/**
	 * Updating local date time object will create a new copy of object
	 */
	private static void modifyLocalDateTimeValues() {
		LocalDateTime localDateTime = LocalDateTime.now();
		System.out.println("LocalDateTime: " + localDateTime);
		System.out.println("LocalDateTime plus 2 hours: " + localDateTime.plusHours(2));
		System.out.println("LocalDateTime minus 5 minutes: " + localDateTime.minus(5, ChronoUnit.MINUTES));
		System.out.println("LocalDateTime with 10 months: " + localDateTime.withMonth(10));
		System.out.println("LocalDateTime with max: " + localDateTime.with(LocalDateTime.MAX));
		System.out.println("LocalDateTime with min: " + localDateTime.with(LocalDateTime.MIN));
	}

	/**
	 * Converts LocalDate & LocalTime to LocalDateTime and vice-versa
	 */
	private static void conversionToDiffTypes() {
		LocalDate localDate = LocalDate.now();
		LocalTime localTime = LocalTime.now();
		LocalDateTime localDateTime1 = localDate.atTime(localTime); // LocalDate -> LocalDateTime
		LocalDateTime localDateTime2 = localTime.atDate(localDate); // LocalTime -> LocalDateTime
		System.out.println("LocalDateTime using LocalDate at time: " + localDateTime1);
		System.out.println("LocalDateTime using LocalTime at date: " + localDateTime2);
		System.out.println("Are both local date time objects equal: " + localDateTime1.equals(localDateTime2));
		System.out.println("LocalDate fetched from LocalDateTime: " + localDateTime1.toLocalDate()); // LocalDateTime ->
																										// LocalDate
		System.out.println("LocalTime fetched from LocalDateTime: " + localDateTime1.toLocalTime()); // LocalDateTime ->
																										// LocalTime
	}

}
