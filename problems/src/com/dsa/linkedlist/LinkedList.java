package com.dsa.linkedlist;

import java.util.Iterator;

public class LinkedList<E> implements Cloneable, Iterable<E> {

  private int size;
  private Node<E> head;

  public LinkedList() {
    size = 0;
    this.head = null;
  }

  public int getSize() {
    return size;
  }

  public void add(E item) {
    Node<E> node = new Node<>(item);
    if (this.size == 0) {
      head = node;
      size++;
      return;
    }
    Node<E> current = head;
    while (current.next != null) {
      current = current.next;
    }
    current.next = node;
    size++;
  }

  public void addFirst(E item) {
    Node<E> node = new Node<>(item);
    if (this.size == 0) {
      head = node;
      size++;
      return;
    }
    node.next = head;
    this.head = node;
    size++;
  }

  public Node<E> getHead() {
    return head;
  }

  public void printList() {
    if (this.size == 0) {
      return;
    }
    for (E item : this) {
      System.out.println(item);
    }
  }

  @Override
  public Iterator<E> iterator() {
    return new SinglyLinkedListIterator(head);
  }

  public static class Node<E> {
     E data;
     Node<E> next;

    Node(E data, Node<E> next) {
      this.data = data;
      this.next = next;
    }

    Node(E data) {
      this.data = data;
      this.next = null;
    }

    public Node<E> getNext() {
      return next;
    }

    public E getData() {
      return data;
    }
  }

  private static class SinglyLinkedListIterator<E> implements Iterator<E> {

    private Node<E> current;

    public SinglyLinkedListIterator(Node<E> head) {
      this.current = head;
    }

    @Override
    public boolean hasNext() {
      return current != null;
    }
    /**
     * This method returns the current element in the list and makes the cursor
     * pointing to the next element to the list
     */
    @Override
    public E next() {
      Node<E> temp = current;
      current = current.next;
      return temp.data;
    }
  }
}
