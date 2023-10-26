package com.java8.examples.patterns.builder;

import com.java8.examples.patterns.builder.OldEmployee.Sex;

public class Test {

  /**
   * The main purpose of the Builder pattern is to provide a way of constructing an object in steps,
   * separating the construction logic from its representation.
   */
  public static void main(String[] args) {

    /**
     * The non-functional way of creating a Builder, although is very robust and very easy to use by a client,
     * it has a problem; it’s very verbose.
     */
    final OldEmployee oldEmployee = OldEmployee.builderOf("John", "Doe")
        .withAge(40)
        .withPhoneNumber("95994524455")
        .withSex(Sex.MALE)
        .withAddress("xyz")
        .build();
    System.out.println(oldEmployee);

/**
 * functional approach drastically reduce the amount of code needed to implement a Builder
 */

    final Employee employee = new Employee.Builder("John", "Doe")
        .with(builder -> {
          builder.age = 40;
          builder.address = "10,XYZ";
          builder.phoneNumber = "956555226252";
          builder.sex = Employee.Sex.MALE;
        })
        .build();
    System.out.println(employee);

  }

}
