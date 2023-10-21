package com.java8.examples.patterns.factory;

import com.java8.examples.patterns.factory.ShapeFactory.ShapeType;
import com.java8.examples.patterns.factory.ShapeFactory2.ShapeType2;
import com.java8.examples.patterns.factory.ShapeFactory3.ShapeType3;
import java.awt.Color;

public class Test {

  public static void main(String[] args) {
    //call draw method of circle
    ShapeFactory.createShape(ShapeType.CIRCLE).draw();
    //call draw method of Rectangle
    ShapeFactory.createShape(ShapeType.RECTANGLE).draw();

    ShapeFactory2.createShape(ShapeType2.CIRCLE, Color.RED, 2).draw();

    ShapeFactory2.createShape(ShapeType2.RECTANGLE, Color.black, 3).draw();

    ShapeFactory3.createFactory(ShapeType3.CIRCLE).create(Color.RED, 2).draw();

    ShapeFactory3 factory = ShapeFactory3.createFactory(ShapeType3.RECTANGLE);

  }

}
