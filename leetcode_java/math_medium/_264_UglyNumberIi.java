/*
 * @lc app=leetcode id=264 lang=java
 *
 * [264] Ugly Number II
 */

// @lc code=start
class Solution {
  public int nthUglyNumber1(int n) {
    if (1 == n) {
      return 1;
    }
    int sequence = 1;
    int upTo = 2;
    while (n != sequence) {
      if (true == isUgly(upTo)) {
        sequence++;
      }
      upTo++;
    }
    return --upTo;
  }

  private boolean isUgly(int x) {
    while (0 == x % 2) {
      x /= 2;
    }
    while (0 == x % 3) {
      x /= 3;
    }
    while (0 == x % 5) {
      x /= 5;
    }
    return 1 == x;
  }

  // optimal solution
  public int nthUglyNumber(int n) {
    int[] uglyArray = new int[n];
    uglyArray[0] = 1;
    int index2 = 0;
    int index3 = 0;
    int index5 = 0;
    for (int i = 1; i < n; i++) {
      uglyArray[i] = Math.min(uglyArray[index2] * 2, Math.min(uglyArray[index3] * 3, uglyArray[index5] * 5));
      if (uglyArray[i] == uglyArray[index2] * 2) {
        index2++;
      }
      if (uglyArray[i] == uglyArray[index3] * 3) {
        index3++;
      }
      if (uglyArray[i] == uglyArray[index5] * 5) {
        index5++;
      }
    }
    return uglyArray[n - 1];
  }
}
// @lc code=end
