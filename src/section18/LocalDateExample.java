package section18;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;

/**
 * The program demonstrates the create, modify and get operations
 */
public class LocalDateExample {

	public static void main(String[] args) {
		createLocalDate();
		getFromLocalDate();
		modifyLocalDate();
		additionalLocalDateOperations();
	}

	/**
	 * Created local data using now(), of() and ofYearDay()
	 */
	private static void createLocalDate() {
		LocalDate localDate = LocalDate.now();
		System.out.println("Local date: " + localDate);
		// below takes year, month and day as parameters
		LocalDate localDateOf = LocalDate.of(1997, 01, 14);
		System.out.println("Local date of: " + localDateOf);
		// below takes year, day of the year as parameters and calculates month
		LocalDate localDateOfYear = LocalDate.ofYearDay(1997, 37);
		System.out.println("Local date of year: " + localDateOfYear);
	}

	/**
	 * Fetched values from local data
	 */
	private static void getFromLocalDate() {
		LocalDate localDate = LocalDate.now();
		System.out.println("Local date: " + localDate);
		System.out.println("Day of week using temporal field: " + localDate.get(ChronoField.DAY_OF_WEEK));
		System.out.println("Day of the week: " + localDate.getDayOfWeek());
		System.out.println("Day of the year: " + localDate.getDayOfYear());
		System.out.println("Month of the year: " + localDate.getMonth());
		System.out.println("Month value of year: " + localDate.getMonthValue());
		System.out.println("Year: " + localDate.getYear());
	}

	/**
	 * Modify local date using various methods
	 */
	private static void modifyLocalDate() {
		LocalDate localDate = LocalDate.now();
		System.out.println("Local date: " + localDate);
		System.out.println("Local date plus 5 days: " + localDate.plusDays(5));
		System.out.println("Local date plus 3 months: " + localDate.plusMonths(3));
		System.out.println("Local date minus 3 days: " + localDate.minusDays(3));
		System.out.println("Local date with year 2026: " + localDate.withYear(2026));
		System.out.println("Local date with year 2020 using chronofield: " + localDate.with(ChronoField.YEAR, 2020));
		System.out.println("Local date with previous year using chronounit: " + localDate.minus(1, ChronoUnit.YEARS));
		System.out.println("Local date with temporal adjusters having first day of next month: "
				+ localDate.with(TemporalAdjusters.firstDayOfNextMonth()));
		System.out.println("Local date with temporal adjusters showing 2nd Friday of the month: "
				+ localDate.with(TemporalAdjusters.dayOfWeekInMonth(2, DayOfWeek.FRIDAY)));
	}

	/**
	 * Demonstrates various operations on local date
	 */
	private static void additionalLocalDateOperations() {
		LocalDate localDate = LocalDate.now();
		System.out.println("Local date: " + localDate);
		System.out.println("Is Local date a leap year: " + localDate.isLeapYear());
		System.out.println("Is Local date after 2025-01-20: " + localDate.isAfter(LocalDate.of(2025, 01, 20)));
		System.out.println("Is Local date before 2025-01-20: " + localDate.isBefore(LocalDate.of(2025, 01, 20)));
		System.out.println("Is Local date equal to current date: " + localDate.isEqual(LocalDate.now()));
		// supported or unsupported operations
		System.out.println("Is supported with minutes: " + localDate.isSupported(ChronoUnit.MINUTES));
		System.out.println("Is supported with years: " + localDate.isSupported(ChronoUnit.YEARS));
	}

}
