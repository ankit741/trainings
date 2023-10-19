package com.java8.examples.stream;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.stream.*;

public class StreamIntroduction {

    /**
     *
     * A stream is a sequence of elements on which we can perform different kinds of sequential and parallel operations.
     * The Stream API was introduced in Java 8 and is used to process collections of objects.
     * Unlike collections, A stream doesn't hold any data,it pulls data from a source(the source may be unbounded) and it doesn't modify the underlying datastructures.
     * <p>
     * The java.util.stream package contains the interfaces and classes to support functional-style operations on streams of elements.
     * In addition to the Stream interface, which is a stream of object references, there are primitive specializations like IntStream, LongStream, and DoubleStream.
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

        /**
         * map() Operation
         * The map() operation takes a function as an input and returns a stream consisting of the results of applying
         * the supplied function to each element of the stream.
         */
        String s = "1 2 3 4 5 6 7 8 9 10";
        List<Integer> integerList = Arrays.stream(s.split("\\s+")).map(Integer::parseInt).collect(Collectors.toList());
        integerList.forEach(System.out::println);

        /**
         * filter() Operation
         * filter() is an intermediate operation of the Stream interface that allows us to
         * filter elements of a stream that match a given condition (known as predicate).
         */

        List<String> words = Arrays.asList("tst", "one", "two", "three", "four", "five", "rotator", "deified");
        List<String> longWords = words.stream().filter(w -> w.length() > 3).collect(Collectors.toList());
        System.out.println(longWords);

        /**
         * collect() Operation
         * The collect() operation seen in an earlier example is another commonly used reduction operation to get
         * the elements from a stream after completing all the processing:
         */

        /**
         * Specialized Reduction Functions
         * The Stream interface provides reduction operations that
         * perform a specific task like finding the average, sum, minimimum, and maximum of values present in a stream
         */
        int[] numbers = {5, 2, 8, 4,55, 9};
        int sum = Arrays.stream(numbers).sum();
        OptionalInt max = Arrays.stream(numbers).max();
        OptionalInt min = Arrays.stream(numbers).min();
        long count = Arrays.stream(numbers).count();
        OptionalDouble average  = Arrays.stream(numbers).average();
        
    }
}
