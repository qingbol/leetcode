/*
 * @lc app=leetcode id=276 lang=java
 *
 * [276] Paint Fence
 */

// @lc code=start
class Solution {
  //// -------------------start(Approach1)-------------------------
  // 20200407
  // refer to
  //// https://leetcode.com/problems/paint-fence/discuss/71156/O(n)-time-java-solution-O(1)-space
  // Your runtime beats 100 % of java submissions
  public int numWays(int n, int k) {
    // base case
    if (n == 0) {
      return 0;
    }
    if (n == 1) {
      return k;
    }

    // initialize the recursive variables. when n == 2;
    int diffcolorWithPrevious = k * (k - 1);
    int sameColorWithPrevious = k * 1;

    for (int i = 3; i <= n; i++) {
      int tmp = diffcolorWithPrevious;
      diffcolorWithPrevious = (diffcolorWithPrevious + sameColorWithPrevious) * (k - 1);
      sameColorWithPrevious = tmp * 1;
    }

    return diffcolorWithPrevious + sameColorWithPrevious;
  }
  //// ------------------- end (Approach1)-------------------------
}
// @lc code=end
