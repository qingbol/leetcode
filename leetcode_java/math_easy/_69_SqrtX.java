/*
 * @lc app=leetcode id=69 lang=java
 *
 * [69] Sqrt(x)
 */

// @lc code=start
class Solution {
  public int mySqrt2(int x) {
    if (1 == x) {
      return 1;
    }
    float mid = x / 2;
    float midPrev = mid;
    while (true) {
      if (mid * mid <= x && (mid + 0.1) * (mid + 0.1) > x) {
        return (int) mid;
      } else if (mid * mid > x) {
        mid = mid / 2;
      } else if (mid * mid < x && (mid + 1) * (mid + 1) < x) {
        mid = (mid + x) / 2;
      }
    }
  }

  public int mySqrt(int x) {
    if (x <= 0) {
      return 0;
    }
    int low = 1;
    int high = x;

    while (low <= high) {
      long mid = (high - low) / 2 + low;
      long midSquare = mid * mid;
      // System.out.format("low: %d, high: %d || mid: %d || midSquare: %d\n", low,
      // high, mid, midSquare);
      if (midSquare == x) {
        return (int) mid;
      } else if (midSquare > x) {
        high = (int) mid - 1;
      } else if (midSquare < x) {
        low = (int) mid + 1;
      }
      // System.out.format("low: %d, high: %d || || midSquare: %d\n", low, high,
      // midSquare);
      // System.out.println("-----------------------------");
    }

    if (high * high <= x) {
      return (int) high;
    } else {
      // return (int) low;
      return -1;
    }

  }
}
// @lc code=end
