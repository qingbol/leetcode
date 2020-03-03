package easy;
/*
 * @lc app=leetcode id=231 lang=java
 *
 * [231] Power of Two
 */

// @lc code=start
class Solution {
  public boolean isPowerOfTwo(int n) {
    return (n > 0) && ((n & (n - 1)) == 0);
  }

  public boolean isPowerOfTwo2(int n) {
    if (1 == n) {
      return true;
    }
    int flag = 0;
    while (n > 1 && 0 == flag) {
      flag = n % 2;
      n /= 2;
    }
    return 1 == flag ? false : true;
  }
}
// @lc code=end
