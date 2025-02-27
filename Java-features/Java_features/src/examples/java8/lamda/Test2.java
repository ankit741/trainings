package examples.java8.lamda;

import java.util.function.Function;

public class Test2 {

  /**
   * Lambda Scopes :
   * Accessing outer scope variables from lambda expressions is very similar to anonymous objects.
   * You can access final variables from the local outer scope as well as instance fields and static variables.
   */

  static int a;
  int b;

  public static void main(String[] args) {

   //Accessing local variables
    localVariableExample();

    //Accessing fields and static variables
    Test2 test2=new Test2();
    test2.fieldAndStaticVariableExample();

  }

  private  void fieldAndStaticVariableExample() {
    /**
     * In contrast to local variables, we have both read and write access to instance fields and static variables from within lambda expressions.
     * This behaviour is well known from anonymous objects.
     */
    Function<Integer, String> stringConverter1 = (from) -> {
      b = 20;
      return String.valueOf(from+b);
    };

    Function<Integer, String> stringConverter2 = (from) -> {
      a = 50;
      return String.valueOf(from+a);
    };
    System.out.println(stringConverter1.apply(5));
    System.out.println(stringConverter2.apply(6));
  }

  private static void localVariableExample() {
    final int num = 1;
    Function<Integer, String> stringConverter =
        (from) -> String.valueOf(from + num);
    System.out.println(stringConverter.apply(2));     // 3
    //num = 3; num must be implicitly final for the code to compile.
    //Writing to num from within the lambda expression is also prohibited.
  }

}
