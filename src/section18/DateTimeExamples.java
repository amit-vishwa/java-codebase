package section18;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

/**
 * The program demonstrates the basic use of LocalDate, LocalTime and
 * LocalDateTime
 */
public class DateTimeExamples {

	public static void main(String[] args) {
		LocalDate localDate = LocalDate.now();
		LocalTime localTime = LocalTime.now();
		LocalDateTime localDateTime = LocalDateTime.now();
		System.out.println("Local date: " + localDate);
		System.out.println("Local time: " + localTime);
		System.out.println("Local date time: " + localDateTime);
	}

}
