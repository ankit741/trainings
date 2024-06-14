package com.dsa.questions.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class TopKFrequentElements {

  /*
  Given an integer array nums and an integer k, return the k most frequent elements. You may return the answer in any order.

  Example 1:

  Input: nums = [1,1,1,2,2,3], k = 2
  Output: [1,2]
  Example 2:

  Input: nums = [1], k = 1
  Output: [1]

Constraints:

1 <= nums.length <= 105
-104 <= nums[i] <= 104
k is in the range [1, the number of unique elements in the array].
It is guaranteed that the answer is unique.

*/
  public static void main(String[] args) {
    int[] nums = {1,1,1,2,2,3,4,4,4,4,6,6,6,1,1};
    topKFrequentElements(nums, 2);
  }

  private static void topKFrequentElements(int[] nums, int k) {
    //calculate the frequency of each element.
    HashMap<Integer, Integer> freqMap = new HashMap<>();
    for (int i = 0; i < nums.length; i++) {
      freqMap.put(nums[i], freqMap.getOrDefault(nums[i], 0) + 1);
    }
    //using min heap  O(n log k)
    System.out.println("Max Heap :" + Arrays.toString(maxHeapSolution(freqMap, k)));

    System.out.println("Min Heap :" + Arrays.toString(minHeapSolution(freqMap, k)));

    //using bucket sort solution O(n) //O(n + k)
    System.out.println("Bucket logic :" + Arrays.toString(bucketSortSolution(nums, freqMap, k)));

  }



  private static int[] bucketSortSolution(int[] nums, HashMap<Integer, Integer> freqMap, int k) {
    // +1 because we could have 0 counts. Also could have full length
    List<Integer>[] bucket = new List[nums.length + 1];
    for (int key : freqMap.keySet()) {
      int frequency = freqMap.get(key);
      if (bucket[frequency] == null) {
        bucket[frequency] = new ArrayList<>();
      }
      bucket[frequency].add(key);
    }

    // In case we want to return less than k elements, k could be greater than the number of distinct elements in nums.
    // per problem description not possible
    int[] result = new int[Math.min(freqMap.size(), k)];  // In case we want to return less than k elements, k could be greater than the number of distinct elements in nums.
    int resIdx = 0;
    for (int i = bucket.length - 1; i >= 0; --i) {
      if (bucket[i] == null) {
        continue;  // Because we only initialized buckets that we inserted elements into, empty buckets are null values.
      }
      for (int currNum : bucket[i]) {
        result[resIdx++] = currNum;
        if (resIdx == result.length) {
          return result;
        }
      }
    }
    return result;
  }

  private static int[] maxHeapSolution(HashMap<Integer, Integer> freqMap, int k) {
    // Using a maxHeap to auto-sort the EntrySet according to the occurences of elements,
    // so we need to Override the compare method (Using  Lambda Expression)
    Queue<Integer> heap = new PriorityQueue<>((a, b) -> freqMap.get(b).compareTo(freqMap.get(a)));
    for(int key : freqMap.keySet())
    {
      heap.offer(key);
    }
    int[] res = new int[k];
    for (int i = 0; i < k; i++) {
      res[i] = heap.poll();
    }
    return res;
  }
  private static int[] minHeapSolution(HashMap<Integer, Integer> freqMap, int k) {
    PriorityQueue<Integer> minHeap = new PriorityQueue<>(Comparator.comparingInt(freqMap::get));
    for (int num : freqMap.keySet()) {
      minHeap.offer(num);
      if (minHeap.size() > k) {
        minHeap.poll();
      }
    }
    int[] res = new int[k];
    int resIndex=0;
    while(!minHeap.isEmpty()){
      res[resIndex++]=minHeap.poll();
    }
    //can reverse the array.
    return res;
  }
}
