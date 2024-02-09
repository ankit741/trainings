package com.dsa.questions.easy;

/**
 * Given an integer n, return true if it is a power of two. Otherwise, return false.
 * <p>
 * An integer n is a power of two, if there exists an integer x such that n == 2x.
 */
public class PowerOfTwo {

  public static void main(String[] args) {
    int num = 16;
    System.out.println(isPowerOfTwo(num));
    System.out.println(num > 0 && (num & num - 1) == 0);
  }

  //with loop
  public static boolean isPowerOfTwo(int n) {
    if (n == 0) {
      return false;
    }
    while (n > 0) {
      if (n % 2 != 0) {
        return false;
      }
      n = n / 2;
    }
    return true;
  }
}
