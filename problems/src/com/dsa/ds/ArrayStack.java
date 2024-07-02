package com.dsa.ds;


import java.util.EmptyStackException;

public class ArrayStack<E> {

  private E[] stack;
  private int top;

  public ArrayStack(int capacity) {
    stack = (E[]) new Object[capacity];
  }


  public void push(E data) {
    if (top == stack.length) {
      //re size the array   //O(n) worst size
      E[] newArr = (E[]) new Object[2 * stack.length];
      System.arraycopy(stack, 0, newArr, 0, stack.length);
      stack = newArr;
    }
    stack[top++] = data;
  }

  public E pop() {
    if (isEmpty()) {
      throw new EmptyStackException();
    }
    E data = stack[--top];
    stack[top] = null;
    return data;
  }

  public boolean isEmpty() {
    return top == 0;
  }

}
