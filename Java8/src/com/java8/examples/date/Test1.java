package com.java8.examples.date;

import java.time.Instant;
import java.time.LocalDate;
import java.time.Month;
import java.time.ZoneId;
import java.time.ZonedDateTime;

/**
 * For practical reasons in computer systems we store time in discrete integer, mainly because
 * computer clocks tick discretely. Therefore we can store time as an integer value. By convention
 * we assign time = 0 to January 1st, 1970 but in Java we increment this value every millisecond,
 * not second like in UNIX time. Historically using 32-bit signed integer in UNIX time will cause
 * year 2038 problem. Thus Java stores time in 64-bit integer, which is sufficient even if you
 * increment it thousand times more often. That being said the simplest, yet valid way of storing
 * time in Java is... long primitive:
 * <p>
 * long timestamp = System.currentTimeMillis(); The problem with long is that it's so prevalent that
 * using it for storing time undermines the type system. It may be an ID, may be hash value, can be
 * anything. Also long doesn't have any meaningful methods related to time domain. The very first
 * approach to wrap long in more meaningful object was java.util.Date known since Java 1.0:
 * <p>
 * Date now = new Date(); Date class however has numerous flaws:
 * <p>
 * It does not represent... date. Seriously, officially date is "[...] the day of the month or year
 * as specified by a number [...]" [1] whereas in Java it represents point in time without any
 * specific calendar (day/month/year). Its toString() is misleading, displaying calendar date and
 * time in system timezone. Not only it misled thousands of developers to think that Date has a
 * timezone attached. Moreover it shows time, but date should only represent day, not hour. It has
 * 20+ deprecated methods, including getYear(), parse(String) and many constructors. These methods
 * are deprecated for a reason, because they lead you to believe Date represents, you know, date.
 * java.sql.Date extends java.util.Date and is actually much more accurate because it indeed
 * represents calendar date (DATE in SQL). However this narrows the functionality of base class
 * Date, thus violating Liskov substitution principle. Don't believe me? java.util.Date.toInstant()
 * works as expected but java.sql.Date.toInstant() fails unconditionally with
 * UnsupportedOperationException... Worst of them all, Date is mutable. Ever wondered why old and
 * grumpy developers in your team are so excited about immutability? Imagine a piece of code that
 * adds one minute to any Date. Simple, huh?
 * <p>
 * Date addOneMinute(Date in) { in.setTime(in.getTime() + 1_000 * 60); return in; } Looks fine,
 * right? All test cases pass because who on earth would ever validate that input parameters are
 * intact after testing code?
 * <p>
 * Date now = new Date(); System.out.println(now); System.out.println(addOneMinute(now));
 * System.out.println(now); The output may look as follows:
 * <p>
 * Tue Jul 26 22:59:22 CEST 2016 Tue Jul 26 23:00:22 CEST 2016 Tue Jul 26 23:00:22 CEST 2016 Did you
 * notice that now value was actually changed after adding one minute? When you have a function that
 * takes Date and returns Date you would never expect it to modify its parameters! It's like having
 * a function taking x and y numbers and retuning sum of them. If you discover that x was somehow
 * modified during the course of addition, all your assumptions are ruined. By the way that is the
 * reason why java.lang.Integer is immutable. Or String. Or BigDecimal.
 */
public class Test1 {

  /**
   * Instant now = Instant.now();
   * System.out.println(now);
   *
   * ZonedDateTime dateTime = ZonedDateTime.ofInstant(
   *         now,
   *         ZoneId.of("Europe/Warsaw")
   *     );
   *
   * System.out.println(dateTime);
   * The output is as follows:
   *
   * 2016-08-05T07:00:44.057Z
   * 2016-08-05T09:00:44.057+02:00[Europe/Warsaw]
   *
   * Notice that Instant (for convenience) displays date formatted in UTC
   * whereas ZonedDateTime uses supplied ZoneId (+2 hours during summer, more on that later).
   */

  /**
   * By default you should store and send time either as timestamp (long value) or as ISO 8601 which
   * is basically what Instant.toString() does as per the documentation.Prefer long value as it is
   * more compact, unless you need more readable format in some text encoding like JSON Also long is
   * timezone-agnostic so you are not pretending that the timezone you send/store has any meaning.
   */

  public static void main(String[] args) {

    long timestamp = System.currentTimeMillis();
    System.out.println(timestamp);
    Instant now = Instant.now();
    System.out.println(now);

    ZonedDateTime dateTime = ZonedDateTime.ofInstant(
        now,
        ZoneId.of("Europe/Warsaw")
    );
    System.out.println(dateTime);

    LocalDate.of(1985, Month.DECEMBER, 25);
  }

  /**
   * I will celebrate my birthday that day no matter where I am. This means party will start at approximately:
   *
   * //20:00
   * LocalTime.of(20, 0, 0)
   * Irrespective to time zone. I can even say that my birthday party this year will be precisely at:
   *
   * //2016-12-25T20:00
   * LocalDateTime party = LocalDateTime.of(
   *         LocalDate.of(2016, Month.DECEMBER, 25),
   *         LocalTime.of(20, 0, 0)
   * );
   * But as long as I don't provide you a location, you don't know what is the time zone I live in,
   * thus what is the actual start time. It's impossible (or very foolish) to convert from LocalDateTime to Instant or ZonedDateTime
   * (which both point to a precise moment in time) without giving a time zone.
   */

}
