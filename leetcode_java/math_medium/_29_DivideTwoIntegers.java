/*
 * @lc app=leetcode id=29 lang=java
 *
 * [29] Divide Two Integers
 */

// @lc code=start
class Solution {
  ////////////////// first round(20200105)///////////////////////////////////
  ////////////////// first round(20200105)///////////////////////////////////
  //// ----------------start(Approach1)-------------------------
  // 20200105

  // public int divide(int dividend, int divisor) {
  public int divide1(int dividend, int divisor) {
    long res = 0;
    int sign = 1;
    // if (1 == divisor) {
    // return dividend;
    // } else if (-1 == divisor) {
    // res = -1 * dividend;
    // }
    if (dividend < 0 && divisor < 0) {
      dividend *= -1;
      divisor *= -1;
    } else if (dividend < 0 && divisor > 0) {
      dividend *= -1;
      sign = -1;
    } else if (dividend > 0 && divisor < 0) {
      divisor *= -1;
      sign = -1;
    }
    while (dividend - divisor >= 0) {
      res++;
      dividend -= divisor;
    }
    System.out.println(res);
    if (res * sign > Integer.MAX_VALUE) {
      return Integer.MAX_VALUE;
    }
    if (res * sign < Integer.MIN_VALUE) {
      return Integer.MIN_VALUE;
    }

    return (int) res * sign;
  }
  //// ---------------- end (Approach1)-------------------------
  //// ----------------start(Approach2)-------------------------

  // optimal solution
  // public int divide(int dividend, int divisor) {
  public int divide2(int dividend, int divisor) {
    int sign = 1;
    if (dividend < 0 && divisor > 0 || dividend > 0 && divisor < 0) {
      sign = -1;
    }
    long dividendLong = Math.abs((long) dividend);
    long divisorLong = Math.abs((long) divisor);
    // System.out.format("dividendLong: %d\n", dividendLong);
    if (dividendLong < divisorLong || 0 == dividendLong) {
      return 0;
    }

    long resLong = divideHelper(dividendLong, divisorLong);
    // System.out.format("resLong: %d\n", resLong);

    if (resLong > Integer.MAX_VALUE) {
      return 1 == sign ? Integer.MAX_VALUE : Integer.MIN_VALUE;
    } else {
      return (int) (sign * resLong);
    }
  }

  private long divideHelper(Long dividend, Long divisor) {
    if (dividend < divisor) {
      return 0;
    }
    long divisorBoost = divisor;
    long factor = 1;
    while (divisorBoost + divisorBoost < dividend) {
      divisorBoost += divisorBoost;
      factor += factor;
    }

    return factor + divideHelper(dividend - divisorBoost, divisor);
  }
  ////////////////// first round(20200906)///////////////////////////////////
  //// ----------------start(Approach1)-------------------------
  // 20200906

  public int divide(int dividend, int divisor) {
  // public int divide3(int dividend, int divisor) {
  }
}
// @lc code=end
