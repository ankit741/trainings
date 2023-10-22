package com.java8.examples.optional;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class Test1 {
  /**
   * Java 8 introduced the Optional class to make handling of nulls less error-prone.
   *
   * opt = Optional.of(notNull);
   *
   * opt = Optional.ofNullable(mayBeNull);
   *
   * opt = Optional.empty();
   *
   * if (x != null) {
   *     print(x);
   * }
   * can be replaced with higher-order function ifPresent():
   *
   * opt.ifPresent(x -> print(x));
   * opt.ifPresent(this::print);
   *
   * if (x != null && x.contains("ab")) {
   *     print(x);
   * }
   * This can be replaced with Optional.filter() that turns present (set) Optional to empty Optional if underlying value does not meet given predicate. If input Optional was empty, it is returned as-is:
   *
   * opt.
   *    filter(x -> x.contains("ab")).
   *    ifPresent(this::print);
   *
   *     int len = (x != null)? x.length() : -1;
   *     With Optional we can say:
   *
   *     int len = opt.map(String::length).orElse(-1);
   *
   *     There is also a version that accepts Supplier<T> if computing default value is slow, expensive or has side-effects:
   *
   * int len = opt.
   *     map(String::length).
   *     orElseGet(() -> slowDefault());
   *
   *
   *     opt.
   *     filter(s -> !s.isEmpty()).
   *     map(s -> s.charAt(0)).
   *     orElseThrow(IllegalArgumentException::new);
   */

  public static void main(String[] args) {

    Optional<Double> opt = Optional.empty();

    System.out.println(opt.orElse(Double.NaN)); //
    System.out.println(opt.orElseGet(Math::random)); // public T orElseGet(Supplier<? extends T> supplier) {
    System.out.println(opt.orElseThrow(IllegalStateException::new));

    Optional<Object> optional = Optional.of(null); //NPE
    Optional<String> opt1 = Optional.ofNullable("Hello");

    //Before
    List<String> names = Arrays
        .asList("Rita", "Gita", "Nita", "Ritesh", "Nitesh", "Ganesh", "Yogen", "Prateema");

     String winner = null;
    for (String name : names) {
      if (name.startsWith("A")) {
        winner = name;
        break;
      }
    }
    String name1 = null != winner ? winner : "No winner";

    //after
    final Optional<String> winnerName = names.stream().filter(name -> name.startsWith("A"))
        .findFirst();
    String name2 = winnerName.isPresent() ? winnerName.get() : "No winner";

    /**
     * The Optional  class, however, supports other techniques that are superior to checking nulls.
     * The above code can be re-written as below with  orElse()  method as below:
     *
     * The method orElse()  is invoked with the condition "If X is null, populate X. Return X.",
     * so that the default value can be set if the optional value is not present.
     */
    final Optional<String> luckyName = names.stream().filter(name -> name.startsWith("A"))
        .findFirst();
    String name3 = luckyName.orElse("No winner");


    Optional<String> winnerName2 = names.stream().filter(name -> name.startsWith("A")).findFirst();
    winnerName2.orElseThrow(() -> new RuntimeException("There is no name starting with letter A."));

  }

}
