package examples.java8.date;

import java.time.Instant;
import java.time.temporal.ChronoField;

public class InstantExample {

  /**
   * As humans we’re used to thinking of dates and time in terms of weeks, days, hours, and minutes.
   * Nonetheless, this representation isn’t easy for a computer to deal with. From a machine point
   * of view, the most natural format to model time is with a single large number representing a
   * point on a continuous timeline. This is the approach used by the new java.time.Instant class,
   * which basically represents the number of seconds passed since the Unix epoch time, set by
   * convention to midnight of January 1, 1970 UTC.
   *
   * Instant provides/captures instantaneous moment or current date/time in UTC/GMT in the below format,
   * yyyy-MM-ddTHH:mm:ss.nnnZ
   * Where Z indicates zero or +00:00 or GMT/UTC time
   * For example, 2022-06-29T12:01:25.369081700Z
   * Note:- Instant date/time are time-zone unaware and it always returns current date/time at UTC/GMT
   */
  public static void main(String[] args) {
    // Instant - current date/time in UTC
    Instant now = Instant.now();
    int day = now.get(ChronoField.DAY_OF_MONTH);
    Instant later   = now.plusSeconds(3);
    Instant earlier = now.minusSeconds(3);

    Instant timestamp = Instant.now();
    System.out.println("Current Timestamp = "+timestamp);

    //Instant from timestamp
    Instant specificTime = Instant.ofEpochMilli(timestamp.toEpochMilli());
    System.out.println("Specific Time = "+specificTime);
  }

}
