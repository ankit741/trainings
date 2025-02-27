package examples.java8.stream;

import java.util.function.Function;

/**
 *
 *  Method reference is used to refer method of the functional interface.
 *  It is a compact and easy form of a lambda expression.
 *  Each time when you are using a lambda expression to just referring a method, you can replace your lambda expression with a method reference.
 * In general, we can provide Method references in three ways, sometimes called the types of it.
 *
 * Static Method References
 * Instance method/non-static Method References
 * Constructor References
 */
public class MethodReference {

  public static void main(String[] args) {
    // 2. Method reference to a static method of a class
    //before
    Function<Integer, Double> sqrt = (num) -> Math.sqrt(num);
    System.out.println(sqrt.apply(4));

    //after
    Function<Integer, Double> sqrtRef = Math::sqrt;
    System.out.println(sqrtRef.apply(4));

    //*** Using Lambda Expression ***//
    FunctionalInterface a1 = (x) -> {
      return x > -10 && x < 10;
    };
    System.out.println(a1.checkSingleDigit(10));

    //*** Using Method Reference ***//
    FunctionalInterface a2 = Digit::isSingleDigit;
    System.out.println(a2.checkSingleDigit(9));
  }
}

interface FunctionalInterface {

  public boolean checkSingleDigit(int x);
}

class Digit {

  public static boolean isSingleDigit(int x) {
    return x > -10 && x < 10;
  }
}
