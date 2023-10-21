package com.java8.examples.patterns.factory;

import java.awt.Color;

public interface ShapeFactory3 {

  static ShapeFactory3 createFactory(ShapeType3 type) {
    return type.getConstructor();
  }

  Shape create(Color colour, int thickness);

  public static enum ShapeType3 {
    CIRCLE((c, t) -> new Circle(c, t)),
    RECTANGLE((c, t) -> new Rectangle(c, t));

    private final ShapeFactory3 constructor;

    ShapeType3(ShapeFactory3 constructor) {
      this.constructor = constructor;
    }

    public ShapeFactory3 getConstructor() {
      return constructor;
    }
  }
}
