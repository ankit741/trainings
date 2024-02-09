package com.dsa.questions.easy;

/**
 * Given two strings s and t, return true if t is an anagram of s, and false otherwise.
 *
 * An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase,
 * typically using all the original letters exactly once.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "anagram", t = "nagaram"
 * Output: true
 * Example 2:
 *
 * Input: s = "rat", t = "car"
 * Output: false
 */
public class Anagram {

  public static void main(String[] args) {
    System.out.println(isAnagram("anagram","nagaram"));
  }

  private static boolean isAnagram(String s1, String s2) {
    if(s1.length() != s2.length()) return false;
    int[] chars = new int[26];
    for(char c: s1.toCharArray()){
      chars[c-'a']++;
    }
    for(char c: s2.toCharArray()){
      if(chars[c-'a']==0){
        return false;
      }
      chars[c-'a']--;
    }
    return true;
  }

}
