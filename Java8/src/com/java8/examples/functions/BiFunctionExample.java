package com.java8.examples.functions;

import java.util.function.BiFunction;
import java.util.function.Function;

/**
 * In Java 8, BiFunction is a functional interface; it takes two arguments and returns an object.
 *
 *
 @FunctionalInterface
 public interface BiFunction<T, U, R> {

 R apply(T t, U u);

 }
 T – Type of the first argument to the function.
 U – Type of the second argument to the function.
 R – Type of the result of the function.
 */
public class BiFunctionExample {

  public static void main(String[] args) {

    // takes two Integers and return an Integer
    BiFunction<Integer, Integer, Integer> func = (x1, x2) -> x1 + x2;
    Integer result = func.apply(2, 3);
    System.out.println(result); // 5

    // take two Integers and return an Double
    BiFunction<Integer, Integer, Double> func2 = (x1, x2) -> Math.pow(x1, x2);
    Double result2 = func2.apply(2, 4);
    System.out.println(result2);    // 16.0


    // Math.pow(a1, a2) returns Double
    BiFunction<Integer, Integer, Double> f1 = (a1, a2) -> Math.pow(a1, a2);
    // takes Double, returns String
    Function<Double, String> f2 = (input) -> "Result : " + String.valueOf(input);
    //function chaining.
    String res = f1.andThen(f2).apply(2, 4);
    System.out.println(res);


  }

}
