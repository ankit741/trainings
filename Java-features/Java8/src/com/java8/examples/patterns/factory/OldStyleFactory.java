package com.java8.examples.patterns.factory;

import com.java8.examples.patterns.factory.ShapeFactory.ShapeType;
import java.awt.Color;

/**
 *
 * Issues:
 * The use of if conditions to check type normally leads to code duplication
 * Adding a new type implies having to remember that we have to add a new if condition
 * We have to throw IllegalArgumentException, as it’s possible that we forgot to handle a new type
 * Harder to read than the functional approach, as we’ll see shortly
 * Slightly more verbose than the functional approach
 */
public class OldStyleFactory {

  public static Shape getInstance(ShapeType type) {
    if (type.equals(ShapeType.CIRCLE)) {
      return new Circle(Color.black,5);
    } else if (type.equals(ShapeType.RECTANGLE)) {
      return new Rectangle(Color.BLUE,4);
    }
    throw new IllegalArgumentException("No support for type " + type);
  }
}
