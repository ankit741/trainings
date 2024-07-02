package com.dsa.templates;

public class Search {

  //Binary search
  public int fn(int[] arr, int target) {
    int left = 0;
    int right = arr.length - 1;
    while (left <= right) {
      int mid = left + (right - left) / 2;
      if (arr[mid] == target) {
        // do something
        return mid;
      }
      if (arr[mid] > target) {
        right = mid - 1;
      } else {
        left = mid + 1;
      }
    }

    // left is the insertion point
    return left;
  }

  //Binary search: duplicate elements, left-most insertion point
  public int fn1(int[] arr, int target) {
    int left = 0;
    int right = arr.length;
    while (left < right) {
      int mid = left + (right - left) / 2;
      if (arr[mid] >= target) {
        right = mid;
      } else {
        left = mid + 1;
      }
    }
    return left;
  }

  //Binary search: duplicate elements, right-most insertion point
  public int fn2(int[] arr, int target) {
    int left = 0;
    int right = arr.length;
    while (left < right) {
      int mid = left + (right - left) / 2;
      if (arr[mid] > target) {
        right = mid;
      } else {
        left = mid + 1;
      }
    }

    return left;
  }

  //Binary search: for greedy problems
  public int fn(int[] arr) {
    int left = MINIMUM_POSSIBLE_ANSWER;
    int right = MAXIMUM_POSSIBLE_ANSWER;
    while (left <= right) {
      int mid = left + (right - left) / 2;
      if (check(mid)) {
        right = mid - 1;
      } else {
        left = mid + 1;
      }
    }

    return left;
  }

  public boolean check(int x) {
    // this function is implemented depending on the problem
    return BOOLEAN;
  }

  //Backtracking
  public int backtrack(STATE curr, OTHER_ARGUMENTS...) {
    if (BASE_CASE) {
      // modify the answer
      return 0;
    }

    int ans = 0;
    for (ITERATE_OVER_INPUT) {
      // modify the current state
      ans += backtrack(curr, OTHER_ARGUMENTS...)
      // undo the modification of the current state
    }
  }


}
