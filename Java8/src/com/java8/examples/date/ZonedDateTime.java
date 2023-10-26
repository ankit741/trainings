package com.java8.examples.date;

import java.time.DayOfWeek;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.temporal.TemporalAdjusters;
import java.util.Date;

public class ZonedDateTime {

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

    Instant instant = Instant.now();
    java.time.ZonedDateTime dateTime = java.time.ZonedDateTime.ofInstant(
        instant,
        ZoneId.of("Europe/Warsaw")
    );
    System.out.println(dateTime);

    java.time.ZonedDateTime zonedDateTime = java.time.ZonedDateTime.of(2018, 3, 1, 0, 0, 0, 0, ZoneId.systemDefault());
    System.out.println(zonedDateTime);

    LocalDateTime localDateTime = zonedDateTime.toLocalDateTime(); // doesn't carry timezone information
    System.out.println(localDateTime);

    // Convert java.util.Date to java.time.ZonedDateTime
    Date now = new Date();
    java.time.ZonedDateTime utc = java.time.ZonedDateTime.ofInstant(now.toInstant(), ZoneOffset.UTC);
    java.time.ZonedDateTime auckland = java.time.ZonedDateTime
        .ofInstant(now.toInstant(), ZoneId.of("Pacific/Auckland"));
    java.time.ZonedDateTime plusOne = java.time.ZonedDateTime.ofInstant(now.toInstant(), ZoneOffset.of("+1"));

// Convert java.time.ZonedDateTime to java.util.Date
    java.time.ZonedDateTime utc1 = java.time.ZonedDateTime.now(ZoneOffset.UTC);
    Date now1 = Date.from(utc1.toInstant());

// Convert java.time.ZonedDateTime to milliseconds from Epoch (java.util.Date#getTime)
    java.time.ZonedDateTime utc2 = java.time.ZonedDateTime.now(ZoneOffset.UTC);
    utc2.toInstant().toEpochMilli();

// Start of today
    java.time.ZonedDateTime startOfToday = LocalDate.now().atStartOfDay(ZoneOffset.UTC);

// Start of this week (Monday)
    java.time.ZonedDateTime startOfWeek = LocalDate.now().atStartOfDay(ZoneId.of("Europe/London")).with(
        TemporalAdjusters.previousOrSame(DayOfWeek.MONDAY));

// Start of this month
    java.time.ZonedDateTime a = LocalDate.now().atStartOfDay(ZoneOffset.UTC)
        .with(TemporalAdjusters.firstDayOfMonth());
  }

}
