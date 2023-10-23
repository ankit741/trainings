package com.java8.examples.date;

import java.time.DayOfWeek;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;
import java.util.Date;

public class Test3 {

  public static void main(String[] args) {
    // Convert java.util.Date to java.time.ZonedDateTime
    Date now = new Date();
    ZonedDateTime utc = ZonedDateTime.ofInstant(now.toInstant(), ZoneOffset.UTC);
    ZonedDateTime auckland = ZonedDateTime
        .ofInstant(now.toInstant(), ZoneId.of("Pacific/Auckland"));
    ZonedDateTime plusOne = ZonedDateTime.ofInstant(now.toInstant(), ZoneOffset.of("+1"));

// Convert java.time.ZonedDateTime to java.util.Date
    ZonedDateTime utc1 = ZonedDateTime.now(ZoneOffset.UTC);
    Date now1 = Date.from(utc.toInstant());

// Convert java.time.ZonedDateTime to milliseconds from Epoch (java.util.Date#getTime)
    ZonedDateTime utc2 = ZonedDateTime.now(ZoneOffset.UTC);
    utc2.toInstant().toEpochMilli();

// Start of today
    ZonedDateTime startOfToday = LocalDate.now().atStartOfDay(ZoneOffset.UTC);

// Start of this week (Monday)
    ZonedDateTime startOfWeek = LocalDate.now().atStartOfDay(ZoneId.of("Europe/London")).with(
        TemporalAdjusters.previousOrSame(DayOfWeek.MONDAY));

// Start of this month
    ZonedDateTime a = LocalDate.now().atStartOfDay(ZoneOffset.UTC)
        .with(TemporalAdjusters.firstDayOfMonth());

// Days between dates
    LocalDate today = LocalDate.now();
    LocalDate threeDaysAgo = today.minusDays(3);
    long days = ChronoUnit.DAYS.between(threeDaysAgo, today);

// java.sql.date to java.time.Instant
    java.sql.Date sqlDate = new java.sql.Date(1446853831381L);
    Instant i = Instant.ofEpochMilli(sqlDate.getTime());

//Can also convert to LocalDate directly
    sqlDate.toLocalDate();
  }

}
