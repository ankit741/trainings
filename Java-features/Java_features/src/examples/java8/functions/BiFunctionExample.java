package examples.java8.functions;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Function;

/**
 * In Java 8, BiFunction is a functional interface; it takes two arguments and returns an object.
 *
 *
 '@FunctionalInterface'
 public interface BiFunction<T, U, R> {

 R apply(T t, U u);

 }
 T – Type of the first argument to the function.
 U – Type of the second argument to the function.
 R – Type of the result of the function.
 */
public class BiFunctionExample {

  public static void main(String[] args) {

    BiFunction<Integer, Integer, Integer> mul = (x, y) -> x * y;
    Function<Integer, Integer> times2 = x -> x * 2;
    Function<Integer, Integer> minus1 = x -> x - 1;

     // r = ((3 * 3) * 2) - 1
    Integer r = mul.andThen(times2).andThen(minus1).apply(3, 3);
    System.out.println(r);

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

    hashMapBiFunctionExample1();

    hashMapBiFunctionExample2();

  }

  private static void hashMapBiFunctionExample1() {
    Map<Integer, String> hashMap = new HashMap<Integer, String>();
    hashMap.put(1, "Ankit");
    hashMap.put(2, "Ajay");
    hashMap.put(3, "Amit");
    hashMap.put(4, null);

    hashMap.compute(4,(key, oldValue)->null==oldValue?"new value":oldValue.concat("new value"));
    System.out.println("HashMap: " + hashMap);

    // using replaceAll(key, value, BiFunction)
    BiFunction<Integer, String, String> f1 = (key, value) -> value.replace("new value", "hello"); // null will throw NPE
    hashMap.replaceAll(f1);
    System.out.println("HashMap using replaceAll() -> " + hashMap);
  }

  private static void hashMapBiFunctionExample2() {
    Map<Integer, String> m = new HashMap<>();
    m.put(1, "Ankit");
    m.put(2, "Ajay");
    m.put(3, "Amit");
    m.put(4, "Ankit");
    m.put(5, "Ajay");
    m.put(6, "Amit");
    m.put(7, "Ankit");

    BiFunction<Integer, String, String> f =
        (key, value) -> "[Key="+key+", "+value+"]";

    m.forEach((k,v)-> System.out.println(f.apply(k, v)));
  }

}
