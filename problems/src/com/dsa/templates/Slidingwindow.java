package com.dsa.templates;

public class SlidingWindow {

  //Sliding window
  public int fn(int[] arr) {
    int left = 0, ans = 0, curr = 0;

    for (int right = 0; right < arr.length; right++) {
      // do logic here to add arr[right] to curr

      while (WINDOW_CONDITION_BROKEN) {
        // remove arr[left] from curr
        left++;
      }

      // update ans
    }
    return ans;
  }

//Build a prefix sum
  public int[] fn(int[] arr) {
    int[] prefix = new int[arr.length];
    prefix[0] = arr[0];

    for (int i = 1; i < arr.length; i++) {
      prefix[i] = prefix[i - 1] + arr[i];
    }
    return prefix;
  }
}
