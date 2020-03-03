package easy;
/*
 * @lc app=leetcode id=191 lang=java
 *
 * [191] Number of 1 Bits
 */

public class _191_NumberOf1Bits {
  Solution solution = new Solution();
}

// @lc code=start
class Solution {
  // you need to treat n as an unsigned value
  public int hammingWeight(int n) {
    int res = 0;
    while (n != 0) {
      res++;
      n &= n - 1;
    }
    return res;
  }

  public int hammingWeight2(int n) {
    int res = 0;
    while (n > 0) {
      res += n & 1;
      n >>>= 1;
    }
    return res;
  }
}
// @lc code=end
