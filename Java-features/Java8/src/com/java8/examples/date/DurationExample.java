package com.java8.examples.date;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Period;
import java.time.temporal.ChronoUnit;

public class DurationExample {

  /**
   * the Duration class is used to represent an amount of time measured in seconds and eventually nanoseconds,
   * you can’t pass a LocalDate to the between method.
   The between static factory method of the Duration class serves exactly this purpose.
   You can create a duration between two LocalTimes, two LocalDateTimes, or two Instants as follows.

   Because LocalDateTime and Instant are made for different purposes, one to be used by humans and the other by machines,
   you’re not allowed to mix them.
   If you try to create a duration between them, you’ll only obtain a DateTimeException.
   */
  public static void main(String[] args) {
    //can create a duration between two LocalTimes, two LocalDateTimes, or two Instants as follows:
    LocalTime time1 = LocalTime.now();
    LocalTime time2 = LocalTime.now();
    Duration d1 = Duration.between(time1, time2);
    LocalDateTime dateTime1 = LocalDateTime.now();
    LocalDateTime dateTime2 = LocalDateTime.now();
    Duration d2 = Duration.between(dateTime1, dateTime2);
    Instant instant1 = Instant.now();
    Instant instant2 = Instant.now();
    Duration d3 = Duration.between(instant1, instant2);

    //Because LocalDateTime and Instant are made for different purposes,
    // one to be used by humans and the other by machines, you’re not allowed to mix them.
    //Moreover, because the Duration class is used to represent an amount of time measured in seconds and eventually nanoseconds

    //When you need to model an amount of time in terms of years, months, and days, you can use the Period class.
    // You can find out the difference between two LocalDates with the between factory method of that class
    Period tenDays = Period.between(LocalDate.of(2014, 3, 8),
        LocalDate.of(2014, 3, 18));
    System.out.println(tenDays);


    Duration threeMinutes = Duration.ofMinutes(3);
    Duration threeMinutes1 = Duration.of(3, ChronoUnit.MINUTES);

    Period tenDays1 = Period.ofDays(10);
    Period threeWeeks = Period.ofWeeks(3);
    Period twoYearsSixMonthsOneDay = Period.of(2, 6, 1);

  }

}
