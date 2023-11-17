package com.dsa.questions.easy;

import java.util.Arrays;

/*
Always remember : Binary search works on sorted elements.
time complexity :  O(log N)

Given an array of integers nums which is sorted in ascending order, and an integer target,
write a function to search target in nums. If target exists, then return its index. Otherwise, return -1.
You must write an algorithm with O(log n) runtime complexity.

Example 1:

Input: nums = [-1,0,3,5,9,12], target = 9
Output: 4
Explanation: 9 exists in nums and its index is 4
Example 2:

Input: nums = [-1,0,3,5,9,12], target = 2
Output: -1
Explanation: 2 does not exist in nums so return -1


Note :

Second of all, start + (end - start) / 2 won't overflow if start and end are large positive numbers. With signed operands, overflow is undefined:
int start = 0x7ffffffe, end = 0x7fffffff;
int mid = start + (end - start) / 2; // works as expected
int mid = (start + end) / 2;         // overflow... undefined

*/
public class BinarySearch {

  public static void main(String[] args) {
    int[] arr = {-1, 0, 3, 5, 9, 12};
    // built-in java method.
    System.out.println(Arrays.binarySearch(arr, 9));
    System.out.println(isElementExist(arr, 9));
  }

  private static int isElementExist(int[] arr, int target) {
    if (null == arr || arr.length == 0) {
      return -1;
    }
    int start = 0;
    int end = arr.length - 1;
    while (start <= end) {
      int mid = start + (end - start) / 2;
      if (arr[mid] == target) {
        return mid;
      } else if (target > arr[mid]) {
        start = mid + 1;
      } else {
        end = mid - 1;
      }
    }
    return -1;
  }

}
