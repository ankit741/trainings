package com.java8.examples.patterns.factory;

import java.awt.Color;

@FunctionalInterface
interface ShapeConstructor {

  Shape create(Color colour, int thickness);
}

public class ShapeFactory2 {

  public static Shape createShape(ShapeType2 type, Color colour, int thickness) {
    return type.getConstructor().create(colour, thickness);
  }

  public enum ShapeType2 {
    CIRCLE((c, t) -> new Circle(c, t)),
    RECTANGLE((c, t) -> new Rectangle(c, t));

    private final ShapeConstructor constructor;

    ShapeType2(ShapeConstructor constructor) {
      this.constructor = constructor;
    }

    private ShapeConstructor getConstructor() {
      return constructor;
    }
  }
}
