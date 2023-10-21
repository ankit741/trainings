package com.java8.examples.patterns.factory;

import java.awt.Color;

public class Rectangle implements Shape {

  private Color colour;
  private int thickness;

  public Rectangle() {
  }

  public Rectangle(Color colour, int thickness) {
    this.colour = colour;
    this.thickness = thickness;
  }

  @Override
  public void draw() {
    System.out.println("Rectangle::draw() method.");
  }
}
