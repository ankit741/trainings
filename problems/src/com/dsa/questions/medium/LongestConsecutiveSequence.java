package com.dsa.questions.medium;

import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence {

  /**
   * Given an unsorted array of integers nums, return the length of the longest consecutive elements
   * sequence.
   * <p>
   * You must write an algorithm that runs in O(n) time.
   * <p>
   * Example 1:
   * <p>
   * Input: nums = [100,4,200,1,3,2] Output: 4 Explanation: The longest consecutive elements
   * sequence is [1, 2, 3, 4]. Therefore its length is 4. Example 2:
   * <p>
   * Input: nums = [0,3,7,2,5,8,4,6,0,1] Output: 9
   */
  public static void main(String[] args) {
    int[] nums = {0, 3, 7, 2, 5, 8, 4, 6, 0, 1};
    System.out.println(findConsecutiveElements(nums));
    System.out.println(findConsecutiveElements1(nums));
  }



  private static int findConsecutiveElements(int[] nums) {
    Set<Integer> set = new HashSet<Integer>();
    int max = 0;
    //Add all elements into set
    for (int num : nums) {
      set.add(num);
    }
    for (int i = 0; i < nums.length; i++) {
       int count=1;
      // look left
      int num=nums[i];
      while(set.contains(--num)){
        count++;
        set.remove(num);
      }
      // look right
      num = nums[i];
      while (set.contains(++num)) {
        count++;
        set.remove(num);
      }
      max=Math.max(max,count);
    }
    return max;
  }
  private static int findConsecutiveElements1(int[] nums) {
    Set<Integer> set = new HashSet<>();
    Set<Integer> visited = new HashSet<>();
    int max = 0;

    for (Integer i : nums)
      set.add(i);

    for (Integer i : set) {
      if (visited.add(i)) {
        int k = i + 1;
        int count = 1;
        while (set.contains(k)) {
          visited.add(k);
          count++;
          k++;
        }
        max = Math.max(count, max);
      }
    }
    return max;
  }
}
