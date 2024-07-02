package com.dsa.ds;

import java.util.LinkedList;

public class Stack<E> {

  private LinkedList<E> list;

  public Stack() {
    list = new LinkedList<>();
  }

  public void push(E data) {
    list.push(data);
  }

  public E pop() {
    return list.pop();
  }

  public E peek() {
    return list.peek();
  }

  public boolean isEmpty() {
    return list.isEmpty();
  }
}
