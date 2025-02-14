package section18;

import java.time.LocalDate;
import java.time.Period;

/**
 * Compare dates using Period, only compatible with LocalDate. Throws
 * RuntimeException with LocalTime
 */
public class DatePeriodExample {

	public static void main(String... args) {

		LocalDate localDate1 = LocalDate.of(2024, 01, 01);
		LocalDate localDate2 = LocalDate.of(2024, 12, 31);
		Period period = localDate1.until(localDate2); // create period using local date
		System.out.println("Date1: " + localDate1 + ", Date2: " + localDate2);
		System.out.println("Period: " + period);
		System.out.println(
				"Days: " + period.getDays() + ", Months: " + period.getMonths() + ", Years: " + period.getYears());

		Period periodDays = Period.ofDays(20);
		Period periodYears = Period.ofYears(2);
		System.out.println("Period days: " + periodDays.getDays()); // month and year will be 0 here
		System.out.println("Period years: " + periodYears.getYears());
		System.out.println("Period years to months: " + periodYears.toTotalMonths());

		Period periodBetween = Period.between(localDate1, localDate2); // create period using between
		System.out.println("Days: " + periodBetween.getDays() + ", Months: " + periodBetween.getMonths() + ", Years: "
				+ periodBetween.getYears());

	}

}
