package examples.java8.patterns.factory;

import java.awt.Color;

public class Circle implements Shape {

  private Color colour;
  private int thickness;

  public Circle() {
  }

  public Circle(Color colour, int thickness) {
    this.colour = colour;
    this.thickness = thickness;
  }

  @Override
  public void draw() {
    System.out.println("Circle::draw() method.");
  }
}
