package com.spring.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShapeService {
  @Autowired
  private Shape shape;

  public String getShape() {
    if (shape != null) {
      return shape.draw();
    } else {
     return "No shape set.";
    }
  }
}
