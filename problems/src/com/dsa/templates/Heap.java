package com.dsa.templates;

import java.util.PriorityQueue;

public class Heap {

  //Find top k elements with heap
  public int[] fn(int[] arr, int k) {
    PriorityQueue<Integer> heap = new PriorityQueue<>(CRITERIA);
    for (int num: arr) {
      heap.add(num);
      if (heap.size() > k) {
        heap.remove();
      }
    }

    int[] ans = new int[k];
    for (int i = 0; i < k; i++) {
      ans[i] = heap.remove();
    }

    return ans;
  }

}
