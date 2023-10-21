package com.java8.examples.lamda;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * lambda expressions, also colloquially referred to as closures or anonymous methods. a lambda
 * expression is just a shorter way of writing an implementation of a method for later execution. An
 * arrow (->) is used to separate the list of parameters and the body.
 * <p>
 * A lambda expression cannot have a throws clause. It is inferred from the context of its use and
 * its body. Lambda expressions cannot be generic i.e. they cannot declare type parameters.
 */
public class Test1 {

  public static void main(String[] args) {
 /*

 //Before Java 8:

new Thread(new Runnable() {
    @Override
    public void run() {
        System.out.println("Before Java8, too much code for too little to do");
    }
}).start();

*/

    // Simple lamda examples

    Runnable r = () -> System.out.println("Hello world!");
    r.run();

    new Thread(() -> System.out.println("My Runnable")).start();

    Comparator<String> c = (String a1, String a2) -> a1.compareTo(a2);

    List<String> nameList = new ArrayList();
    nameList.add("Ankit");
    nameList.add("John");
    nameList.forEach(name -> System.out.println(name));


  }
}
