package com.java8.examples.functions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class FunctionChaining {

  public static void main(String[] args) {
    List<String> values = Arrays.asList("one", "two", "three", "four", "five");
    List<String> newList=new ArrayList<>();

    Consumer<String> c1 = System.out::println;
    Consumer<String> c2 = newList::add;
    //consumer chain
    values.forEach(c1.andThen(c2));

    System.out.println(newList.size());

    List<Integer> numberList=Arrays.asList(1,2,3,4,5,6,7,8,9,10);
    Predicate<Integer> p1=i->i<5;
    Predicate<Integer> p2=i->i>5;
    Predicate<Integer> p3=i->i==0;

    //predicate chain
    Predicate<Integer> p4=p1.or(p2).and(p3); //(p1 & p2) || p3

    Consumer<Integer> c11 = System.out::println;
    numberList.stream().filter(p4).forEach(c11);
  }
}
