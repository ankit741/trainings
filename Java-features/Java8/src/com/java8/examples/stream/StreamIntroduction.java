package com.java8.examples.stream;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class StreamIntroduction {

  /**
   * A stream is a sequence of elements on which we can perform different kinds of sequential and
   * parallel operations. The Stream API was introduced in Java 8 and is used to process collections
   * of objects. Unlike collections, A stream doesn't hold any data,it pulls data from a source(the
   * source may be unbounded) and it doesn't modify the underlying datastructures.
   * <p>
   * The java.util.stream package contains the interfaces and classes to support functional-style
   * operations on streams of elements. In addition to the Stream interface, which is a stream of
   * object references, there are primitive specializations like IntStream, LongStream, and
   * DoubleStream.
   */
  public static void main(String[] args) {

    int[] num = {1, 2, 3, 4, 5};
    Arrays.stream(num).forEach(n -> System.out.println(n));
    Stream.of(num).forEach(n -> System.out.println(n));
    /**
     Obtaining Stream From Static Factory Methods on the Stream Classes.
     */
    Stream<Integer> stream = Stream.of(3, 4, 6, 2);
    IntStream integerStream = IntStream.of(3, 4, 6, 2);
    LongStream longStream = LongStream.of(3l, 4l, 6l, 2l);
    DoubleStream doubleStream = DoubleStream.of(3.0, 4.5, 6.7, 2.3);

    /**
     Obtain stream from file.
     */
    try (Stream<String> lines = Files.lines(Paths.get("filePath"))) {
      lines.forEach(System.out::println);
    } catch (IOException e) {

    }

    /**
     * Streams can also be generated directly without specifying literals beforehand.
     * The method iterate() creates an infinite stream of consecutive numbers, starting here with 0.
     */
    Stream.iterate(0, i -> i + 1).limit(10).forEach(System.out::println);

    /**
     * Handling Nullable Streams
     * we used the static factory method of Stream: Stream.of() to create a stream with elements.
     * We will get a NullPointerException if the value in the stream is null
     * The ofNullable method was introduced in Java 9 to mitigate this behavior. In java 8 please use null check.
     */

    /**
     Type of Operations on Streams
     The operations that we can perform on a stream are broadly categorized into two types:

     Intermediate operations:
     =======================
     Intermediate operations transform one stream into another stream. An example of an Intermediate operation is map()
     which transforms one element into another by applying a function (called a Function) on each element.

     Terminal operations:
     ====================
     Terminal operations are applied on a stream to get a single result like a primitive or object or collection or may not return anything.
     An example of a Terminal operation is count() which counts the total number of elements in a stream.
     */

    mapExample();

    filterExample();

    reduceExample();

  }

  private static void mapExample() {
    /**
     * map() Operation
     * The map() operation takes a function as an input and returns a stream consisting of the results of applying
     * the supplied function to each element of the stream.
     */
    String s = "1 2 3 4 5 6 7 8 9 10";
    List<Integer> integerList = Arrays.stream(s.split("\\s+")).map(Integer::parseInt)
        .collect(Collectors.toList());
    integerList.forEach(System.out::println);
  }

  public static void filterExample() {

    /**
     * filter() Operation
     * filter() is an intermediate operation of the Stream interface that allows us to
     * filter elements of a stream that match a given condition (known as predicate).
     */

    List<String> words = Arrays
        .asList("tst", "one", "two", "three", "four", "five", "rotator", "deified");
    List<String> longWords = words.stream().filter(w -> w.length() > 3)
        .collect(Collectors.toList());
    System.out.println(longWords);

    List<Integer> numbers = new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4, 5));
    List<Integer> odds = numbers.stream().filter(number -> number % 2 == 1)
        .collect(Collectors.toList());

    // outputs "[1, 3, 5]"
    System.out.println(odds);
  }


  public static void reduceExample() {
    /**
     * Specialized Reduction Functions
     * The Stream interface provides reduction operations that
     * perform a specific task like finding the average, sum, minimimum, and maximum of values present in a stream
     */
    int[] numbers = {5, 2, 8, 4, 55, 9};
    int sum = Arrays.stream(numbers).sum();
    OptionalInt max = Arrays.stream(numbers).max();
    OptionalInt min = Arrays.stream(numbers).min();
    long count = Arrays.stream(numbers).count();
    OptionalDouble average = Arrays.stream(numbers).average();

    List<Integer> number = new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4, 5));
    int sum1 = number.stream().reduce(50, Integer::sum);

    // we can emulate collect(Collectors.toList()) using the reduce operation!
    // this overload of the method reduce() accepts three parameters: initial value, accumulator and combiner
    // the accumulator function accumulates an item from the stream into the current accumulation
    // and the combiner function is used to combine two accumulations in case they run in parallel
    // so it's safe to say that the combiner function is a fail-safe mechanism for concurrency cases
    List<Integer> asList = number.stream().reduce(new ArrayList<Integer>(), (list, e) -> {
      list.add(e);
      return list;
    }, (list1, list2) -> {
      list1.addAll(list2);
      return list1;
    });

    // outputs "65"
    System.out.println(sum1);

    // outputs "[1, 2, 3, 4, 5]"
    System.out.println(asList);
  }
}
