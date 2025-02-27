package examples.java8.patterns.factory;

import java.util.function.Supplier;

public class ShapeFactory {

  public static Shape createShape(ShapeType type) {
    return type.getConstructor().get();
  }

  public enum ShapeType {
    CIRCLE(Circle::new),
    RECTANGLE(Rectangle::new);

    private final Supplier<Shape> constructor;

    ShapeType(Supplier<Shape> constructor) {
      this.constructor = constructor;
    }

    private Supplier<Shape> getConstructor() {
      return constructor;
    }
  }
}
