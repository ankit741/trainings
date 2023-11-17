package com.dsa.questions.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * Given an array nums of size n, return the majority element.
 *
 * The majority element is the element that appears more than ⌊n / 2⌋ times.
 * You may assume that the majority element always exists in the array.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [3,2,3]
 * Output: 3
 *
 * Example 2:
 *
 * Input: nums = [2,2,1,1,1,2,2]
 * Output: 2
 */
public class MajorityElement {

  public static void main(String[] args) {
    int[] arr={2,2,1,1,1,2,2};
    System.out.println(findMajorityElement(arr));
    System.out.println(findMajorityElement1(arr));
  }

  //with extra space
  private static int findMajorityElement(int[] arr) {
    Map<Integer, Integer> frequencyMap = new HashMap<>();
    for (int num : arr) {
      frequencyMap.put(num,frequencyMap.getOrDefault(num,0)+1);
    }
    for(Map.Entry<Integer,Integer> entry: frequencyMap.entrySet()){
      if(entry.getValue()> arr.length / 2){
        return entry.getKey();
      }
    }
    return -1;
  }

  /*
  without extra space (linear time and in O(1) space)- Boyer-Moore Majority Voting Algorithm
 two steps : 1. find the majority element otherwise it returns an candidate element.
 2. check if candidate found in above step is majority element.This step is necessary as there might be no majority element.
   */
  private static int findMajorityElement1(int[] arr) {
    int count = 0;
    int max = arr[0];

    //step 1 : find candidate element
    for (int i = 0; i < arr.length; i++) {
      if (count == 0) {
        max = arr[i];
        count++;
      } else if (max == arr[i]) {
          count++;
        } else {
          count--;
        }
      }

    //step-2 :verify candidate element- although it's given that majority element always exists in the array
    count=0;
    for (int i = 0; i < arr.length; i++) {
      if (arr[i] == max) {
        count++;
      }
    }
    if (count > (arr.length / 2)) {
      return max;
    }
    return -1;
  }
}
