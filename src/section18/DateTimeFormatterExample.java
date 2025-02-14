package section18;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

/**
 * DateTimeFormatter is used to parse and format date. Parsing refers to
 * conversion of String to LocalDate, LocalTime or LocalDateTime. Formatting
 * refers to conversion of LocalDate, LocalTime or LocalDateTime to String.
 */
public class DateTimeFormatterExample {

	public static void main(String[] args) {
		localDateOperations();
		localTimeOperations();
		localDateTimeOperations();
	}

	/**
	 * Format/parse LocalDate using LocalDateFormatter
	 */
	private static void localDateOperations() {
		// parse to LocaDate from String
		String date = "2025-02-06";
		System.out.println("String date: " + date);
		LocalDate localDate = LocalDate.parse(date);
		System.out.println("Local date: " + localDate);

		// Built-in formatter
		LocalDate formattedLocalDate = LocalDate.parse(date, DateTimeFormatter.ISO_LOCAL_DATE);
		System.out.println("Local date using built-in formatter: " + formattedLocalDate);
		LocalDate newFormattedLocalDate = LocalDate.parse(date.replaceAll("-", ""), DateTimeFormatter.BASIC_ISO_DATE);
		System.out.println("Local date using built-in formatter: " + newFormattedLocalDate);

		// Custom formatter
		LocalDate localDate1 = LocalDate.parse("2025|02|10", DateTimeFormatter.ofPattern("yyyy|MM|dd"));
		System.out.println("Local date using custom formatter: " + localDate1);
		LocalDate localDate2 = LocalDate.parse("10*02&2025", DateTimeFormatter.ofPattern("dd*MM&yyyy"));
		System.out.println("Local date using custom formatter: " + localDate2);

		// LocalDate to String
		LocalDate localDateObject = LocalDate.now();
		String stringDate = localDateObject.toString(); // normal to string
		System.out.println("LocalDate to String: " + stringDate);
		// proper string conversion using format
		String customStringDate = localDateObject.format(DateTimeFormatter.ofPattern("yyyy|MM|dd"));
		System.out.println("LocalDate to String: " + customStringDate);
	}

	/**
	 * Format/parse LocalTime using LocalDateFormatter
	 */
	private static void localTimeOperations() {
		// parse to LocalTime from String
		String time = "21:00";
		System.out.println("Time: " + time);
		LocalTime localTime = LocalTime.parse(time);
		System.out.println("LocalTime: " + localTime);
		// built-in formatter
		LocalTime localTimeParse = LocalTime.parse("21:42", DateTimeFormatter.ISO_LOCAL_TIME);
		System.out.println("LocalTime using built-in formatter: " + localTimeParse);
		LocalTime isoTime = LocalTime.parse("21:42:45+05:00", DateTimeFormatter.ISO_TIME);
		System.out.println("LocalTime using built-in formatter: " + isoTime);
		// custom formatter
		LocalTime customLocalTime = LocalTime.parse("21|42*57", DateTimeFormatter.ofPattern("HH|mm*ss"));
		System.out.println("LocalTime using custom formatter: " + customLocalTime);

		// format LocalTime
		String stringTime = customLocalTime.toString(); // simple to string
		System.out.println("String time: " + stringTime);
		// below formats LocalTime to String using specified formatter
		String stringNewTime = customLocalTime.format(DateTimeFormatter.ofPattern("HH*mm*ss")); // simple to string
		System.out.println("String time using custom formatter: " + stringNewTime);
	}

	/**
	 * Format/parse LocalDateTime using LocalDateFormatter
	 */
	private static void localDateTimeOperations() {
		String dateTime = "2025-02-08T21:55:57";
		// parse to LocalDateTime from String
		// built-in formatter
		System.out.println("DateTime: " + LocalDateTime.parse(dateTime) + " | "
				+ LocalDateTime.parse(dateTime, DateTimeFormatter.ISO_LOCAL_DATE_TIME));
		// custom formatter
//		LocalDateTime customLocalDateTime = LocalDateTime.parse("08/02/202521+55-57",
//				DateTimeFormatter.ofPattern("dd/MM/yyyyHH+mm-ss"));
//		LocalDateTime customLocalDateTime = LocalDateTime.parse("08/02/2025abc21+55-57",
//		DateTimeFormatter.ofPattern("dd/MM/yyyy'abc'HH+mm-ss"));
		LocalDateTime customLocalDateTime = LocalDateTime.parse("08/02/2025T21+55-57",
				DateTimeFormatter.ofPattern("dd/MM/yyyy'T'HH+mm-ss")); // above also works just use single quotes
		System.out.println("LocalDateTime using custom formatter: " + customLocalDateTime);

		// format LocalDateTime
		String stringLocalDateTime = customLocalDateTime.format(DateTimeFormatter.ofPattern("dd/MM/yyyy'T'HH-mm-ss"));
		System.out.println("String LocalDateTime using simple toString: " + customLocalDateTime.toString());
		System.out.println("String LocalDateTime using formatter: " + stringLocalDateTime);
	}

}
