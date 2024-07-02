package com.dsa.questions.medium;

import java.util.HashSet;
import java.util.Set;


public class LengthOfLongestSubstring {

  /**
   * Given a string s, find the length of the longest substring without repeating characters.
   * <p>
   * Example 1:
   * <p>
   * Input: s = "abcabcbb" Output: 3 Explanation: The answer is "abc", with the length of 3. Example
   * 2:
   * <p>
   * Input: s = "bbbbb" Output: 1 Explanation: The answer is "b", with the length of 1. Example 3:
   * <p>
   * Input: s = "pwwkew" Output: 3 Explanation: The answer is "wke", with the length of 3. Notice
   * that the answer must be a substring, "pwke" is a subsequence and not a substring.
   */

  public static void main(String[] args) {
    System.out.println(lengthOfLongestSubstring("abcabcbb"));

    System.out.println(lengthOfLongestSubstring1("abcabcbb"));

  }


  //two pointers and sliding window
  public static int lengthOfLongestSubstring(String s) {
    Set<Character> set = new HashSet<>();
    int i = 0, j = 0, max = 0;
    while (j < s.length()) {
      if (!set.contains(s.charAt(j))) {
        set.add(s.charAt(j++));
        max = Math.max(max, set.size());
      } else {
        set.remove(s.charAt(i++));
      }
    }
    return max;
  }

  private static int lengthOfLongestSubstring1(String s) {
    int[] arr = new int[128];
    int i = 0, j = 0, max = 0;
    while (j < s.length()) {
      char c = s.charAt(j);
      arr[c]++;
      while (arr[c] > 1) {
        char r = s.charAt(i++); //increment left pointer
        arr[r]--;
      }
      //length of sliding window in last occurrence, before we found a repeating character.
      max = Math.max(max, j - i + 1);
      j++; //increment right pointer
    }
    return max;
  }
}
