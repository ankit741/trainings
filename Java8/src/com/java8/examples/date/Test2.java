package com.java8.examples.date;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class Test2 {

  public static void main(String[] args) {

    LocalDate now = LocalDate.now();
    System.out.println(now);

    LocalDate date = LocalDate.of(2021, 1, 21);
    System.out.println(date);

    LocalDate date2 = LocalDate.of(2021, Month.JANUARY, 28);
    System.out.println(date2);

    LocalTime now1 = LocalTime.now();
    System.out.println(now1);

    LocalTime midnight = LocalTime.of(23, 0);
    System.out.println(midnight);

    LocalDateTime newYear = LocalDateTime.of(LocalDate.of(2023, 12, 31), LocalTime.of(11, 59));
    System.out.println(newYear);

    ZonedDateTime zonedDateTime = ZonedDateTime.of(2018, 3, 1, 0, 0, 0, 0, ZoneId.systemDefault());
    System.out.println(zonedDateTime);

    LocalDateTime localDateTime = zonedDateTime.toLocalDateTime(); // doesn't carry timezone information
    System.out.println(localDateTime);

    // instant also doesn't carry timezone information but IT DIFFERS from LocalDateTime because it is considered to be in UTC
    Instant instant = Instant.from(zonedDateTime);
    System.out.println(instant);

    ZonedDateTime zonedDateTime1 = ZonedDateTime.now(ZoneId.of("US/Eastern"));
    Instant now2 = Instant.from(zonedDateTime);

    Instant now3 = Instant.from(zonedDateTime);
    System.out.println(now2);

    Instant instant4 = Instant.parse("2010-01-20T11:33:45Z");
    System.out.println(instant);

    Instant epoch = Instant.ofEpochMilli(0);
    System.out.println(epoch);

    /*
	Should application use LocalDateTime or ZonedDateTime?
	Short answer: ZonedDateTime.
	Long answer:

	For internal calculations both can be used, having in mind that:
	  - LocalDateTime shouldn't ever be passed outside the service, for example to the browser or to other service possibly
		working in different time zone. Browser will consider this is UTC time or browser timezone time (depending on parser
		implementation) while the other service will consider it a timestamp in its timezone. If the timezone of browser or
		other service will be different than timezone of your service, the timestamp information will be broken.
	  - LocalDateTime shouldn't ever be saved to database, because it will be considered a timestamp with UTC timezone, what
		is not true.
	For both above usages you should use ZonedDateTime, so the cheat answer for "should application use LocalDateTime or
	ZonedDateTime?" question is: use ZonedDateTime and it will be safer.
 */
  }

}
