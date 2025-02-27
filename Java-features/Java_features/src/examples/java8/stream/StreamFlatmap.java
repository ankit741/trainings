package examples.java8.stream;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * It’s challenging to process a Stream containing more than one level, like Stream<String[]> or
 * Stream<List<LineItem>> or Stream<Stream<String>>. And we flat the 2 levels Stream into one level,
 * like Stream<String> or Stream<LineItem>, so that we can easily loop the Stream and process it.
 * <p>
 * Stream<String[]>      -> flatMap ->	Stream<String> Stream<Set<String>>   -> flatMap
 * ->	Stream<String> Stream<List<String>>  -> flatMap ->	Stream<String> Stream<List<Object>>  ->
 * flatMap ->	Stream<Object>
 * <p>
 * That’s it. Just remember that flatMap = map + flatten.
 */
public class StreamFlatmap {

  public static void main(String[] args) {

    /**
     *  Map basically allows you to apply the method to the element inside the wrapper and possibly change its type:
     */
    Function<String, Long> toLong = Long::parseLong; // function that maps String to Long

    Optional<String> someString = Optional.of("12L");
    Optional<Long> someLong = someString
        .map(toLong); //applying the function to the possible String inside

    Stream<String> someStrings = Stream.of("10L", "11L");
    Stream<Long> someLongs = someStrings.map(toLong); //applying the function to all Strings inside

    String[][] array = {{"a", "b"}, {"c", "d"}, {"e", "f"}};
    // same result
    Stream<String[]> stream1 = Stream.of(array);
    List<String> collect2 = stream1.flatMap(Stream::of).collect(Collectors.toList());

    Stream<List<Integer>> listStream = Stream
        .of(Arrays.asList(1, 2, 3, 4), Arrays.asList(5, 6, 7, 8));

    // to convert that into a list of numbers we will use
    // the flatMap function
    List<Integer> flattenedList
        = listStream
        .flatMap(l -> l.stream())
        .collect(Collectors.toList());

    //Example -1 :  we want to filter out the a and print out all the characters.

    String[][] arr = new String[][]{{"a", "b"}, {"c", "d"}, {"e", "f"}};

    // array to a stream
    Stream<String[]> stream2 = Arrays.stream(arr);

    // x is a String[]
    List<String[]> result = stream2
        .filter(x -> {
          for (String s : x) {      // really?
            if (s.equals("a")) {
              return false;
            }
          }
          return true;
        }).collect(Collectors.toList());

    // print array
    result.forEach(x -> System.out.println(Arrays.toString(x)));

    //In the above case, the Stream#filter will filter out the entire [a, b], but we want to filter out only one character a

    //java-8
    List<String> collect = Stream.of(arr)     // Stream<String[]>
        .flatMap(Stream::of)                // Stream<String>
        .filter(x -> !"a".equals(x))        // filter out the a
        .collect(Collectors.toList());      // return a List

    collect.forEach(System.out::println);

  }
}
