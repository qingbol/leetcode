/*
 * @lc app=leetcode id=1011 lang=java
 *
 * [1011] Capacity To Ship Packages Within D Days
 */

// @lc code=start
class Solution {
  //// ---------------start(Approach1)------------------------------
  // 20200718, by myself.
  //83/83 cases passed (9 ms)
// Your runtime beats 65.17 % of java submissions
  // public int shipWithinDays(int[] weights, int D) {
  public int shipWithinDays1(int[] weights, int D) {
    if (weights == null || weights.length == 0)
      return -1;
    int lo = getMaxSum1(weights)[0];
    int hi = getMaxSum1(weights)[1] + 1;

    while (lo < hi) {
      int mid = lo + (hi - lo) / 2;
      // System.out.format("lo: %d, hi: %d, mid: %d\n", lo, hi, mid);
      if (canShip1(weights, mid, D)) {
        hi = mid;
      } else {
        lo = mid + 1;
      }
    }

    return lo;
  }

  private int[] getMaxSum1(int[] weights) {
    int max = 0;
    int sum = 0;
    for (int weight : weights) {
      max = Math.max(max, weight);
      sum += weight;
    }
    return new int[] { max, sum };
  }

  private boolean canShip1(int[] weights, int capacity, int D) {
    int cap = capacity;
    for (int weight : weights) {
      if (cap > weight) {
        cap -= weight;
      } else if (cap < weight) {
        D--;
        cap = capacity - weight;
      } else if (cap == weight) {
        D--;
        cap = capacity;
      }
    }
    if (cap > 0 && cap < capacity)
      D--;
    // System.out.format("D: %d\n", D);
    return D >= 0;
  }
  //// --------------- end (Approach1)------------------------------
  //// ---------------start(Approach2)-----------------------------
  // 20200718, refer to labdadong. modified the canShip method. 
  //83/83 cases passed (8 ms)
// Your runtime beats 95.04 % of java submissions
  public int shipWithinDays(int[] weights, int D) {
  // public int shipWithinDays2(int[] weights, int D) {
    if (weights == null || weights.length == 0)
      return -1;
    int lo = getMaxSum2(weights)[0];
    int hi = getMaxSum2(weights)[1] + 1;

    while (lo < hi) {
      int mid = lo + (hi - lo) / 2;
      // System.out.format("lo: %d, hi: %d, mid: %d\n", lo, hi, mid);
      if (canShip2(weights, mid, D)) {
        hi = mid;
      } else {
        lo = mid + 1;
      }
    }

    return lo;
  }

  private int[] getMaxSum2(int[] weights) {
    int max = 0;
    int sum = 0;
    for (int weight : weights) {
      max = Math.max(max, weight);
      sum += weight;
    }
    return new int[] { max, sum };
  }

  private boolean canShip2(int[] weights, int capacity, int D) {
    int j = 0; 
    for (int day = 0; day < D; day++) {
      int cap = capacity;
      // cap -= weights[j];
      while ((cap -= weights[j]) >= 0) {
        j++;
        // cap -= weights[j];
        if (j >= weights.length) {
          return true;
        }
      }
    }
    return false;
  }
  //// --------------- end (Approach2)------------------------------
}
// @lc code=end
