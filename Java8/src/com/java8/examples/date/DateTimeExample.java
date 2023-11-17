package com.java8.examples.date;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.chrono.JapaneseDate;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;


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
public class DateTimeExample {

  /**
   ew Date and Time API. An instance of this class is an immutable object representing just a plain date without the time of day.
   In particular, it doesn’t carry any information about the time zone.
   */
  public static void main(String[] args) {

    LocalDate now = LocalDate.now();
    System.out.println(now);

    LocalDate date = LocalDate.of(2021, 1, 21);
    System.out.println(date);

    //Reading LocalDate values using a TemporalField
    int year = date.get(ChronoField.YEAR);
    int month = date.get(ChronoField.MONTH_OF_YEAR);
    int day = date.get(ChronoField.DAY_OF_MONTH);

    LocalDate date2 = LocalDate.of(2021, Month.JANUARY, 28);
    System.out.println(date2);

    LocalTime now1 = LocalTime.now();
    System.out.println(now1);

    LocalTime midnight = LocalTime.of(23, 0);
    System.out.println(midnight);

    LocalDateTime newYear = LocalDateTime.of(LocalDate.of(2023, 12, 31), LocalTime.of(11, 59));
    System.out.println(newYear);

    LocalDate date1 = LocalDate.parse("2014-03-18");
    LocalTime time = LocalTime.parse("13:45:20");
    LocalDateTime dt1 = LocalDateTime.of(2014, Month.MARCH, 18, 13, 45, 20);
    LocalDateTime dt2 = LocalDateTime.of(date1, time);
    LocalDateTime dt3 = date1.atTime(13, 45, 20);
    LocalDateTime dt4 = date1.atTime(time);
    LocalDateTime dt5 = time.atDate(date1);

    // Days between dates
    LocalDate today = LocalDate.now();
    LocalDate threeDaysAgo = today.minusDays(3);
    long days = ChronoUnit.DAYS.between(threeDaysAgo, today);


    //The ISO-8601 calendar system is the de facto world civil calendar system.
    // But four additional calendar systems are provided in Java 8
    LocalDate jdate = LocalDate.of(2014, Month.MARCH, 18);
    JapaneseDate japaneseDate = JapaneseDate.from(jdate);
  }
}
