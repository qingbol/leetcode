/*
 * @lc app=leetcode id=69 lang=java
 *
 * [69] Sqrt(x)
 */

// @lc code=start
class Solution {
  ////////////////// first round(20200105)///////////////////////////////////
  ////////////////// first round(20200105)///////////////////////////////////
  //// ----------------start(Approach1)-------------------------
  // 20200105

  public int mySqrt1(int x) {
    // public int mySqrt(int x) {
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

  //// ---------------- end (Approach1)-------------------------
  //// ----------------start(Approach2)-------------------------
  // public int mySqrt(int x) {
  public int mySqrt2(int x) {
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
  //// ---------------- end (Approach2)-------------------------
  ////////////////// second round(20200906)///////////////////////////////////
  //// ----------------start(Approach1)-------------------------
  // 20200906
  // refer to leetcode standard solution
  //1017/1017 cases passed (1 ms)
// Your runtime beats 100 % of java submissions
// Your memory usage beats 80.3 % of java submissions (36.7 MB)

  // public int mySqrt3(int x) {
  public int mySqrt(int x) {
    //for x > 2, why square root is alwayse smaller than x/2?

    if (x < 2) return x;
    int lo = 2, hi = x / 2;

    while (lo <= hi) {
      int mid = (hi - lo) / 2 + lo;
      long midSquare = (long)mid * mid;
      if (midSquare > x) {
        hi = mid -1;
      } else if (midSquare < x) {
        lo = mid + 1;
      } else {
        return mid;
      }
    }

    return hi;
  }
  //// ---------------- end (Approach3)-------------------------
}
// @lc code=end
