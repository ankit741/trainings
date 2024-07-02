package com.dsa.templates;

public class LinkedList {

  //Linked list: fast and slow pointer
  public int fn(ListNode head) {
    ListNode slow = head;
    ListNode fast = head;
    int ans = 0;

    while (fast != null && fast.next != null) {
      // do logic
      slow = slow.next;
      fast = fast.next.next;
    }

    return ans;
  }
//Reversing a linked list
public ListNode fn(ListNode head) {
  ListNode curr = head;
  ListNode prev = null;
  while (curr != null) {
    ListNode nextNode = curr.next;
    curr.next = prev;
    prev = curr;
    curr = nextNode;
  }

  return prev;
}

}
