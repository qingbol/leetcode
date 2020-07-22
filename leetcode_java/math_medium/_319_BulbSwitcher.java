/*
 * @lc app=leetcode id=319 lang=java
 *
 * [319] Bulb Switcher
 */

// @lc code=start
class Solution {
  ////////////////////// first round(20200722)/////////////////////
  //// ----------------------start(Approach1)---------------------
  // 20200722. brute force.
  // refer to labuladong's idea, implemented by myself.

  //// Time Limit Exceeded
  // 27/35 cases passed (N/A)
  // Testcase
  // 99999

  // public int bulbSwitch(int n) {
  public int bulbSwitch1(int n) {
    boolean[] bulbs = new boolean[n];
    for (int mod = 1; mod <= n; mod++) {
      for (int i = 0; i < n; i++) {
        if ((i + 1) % mod == 0) {
          bulbs[i] = !bulbs[i];
        }
      }
    }

    int count = 0;
    for (boolean bulb : bulbs) {
      if (bulb) {
        count++;
      }
    }
    return count;
  }
  //// ---------------------- end (Approach1)---------------------
  //// ----------------------start(Approach2)---------------------
  // 20200722. brute force.
  // refer to labuladong< 一行代码就能解决的算法题>三、电灯开关问题>

  // 35/35 cases passed (0 ms)
  // Your runtime beats 100 % of java submissions
  // Your memory usage beats 5.2 % of java submissions (37.8 MB)

  public int bulbSwitch(int n) {
    // public int bulbSwitch2(int n) {
    return (int) Math.sqrt(n);
  }
  //// ---------------------- end (Approach2)---------------------
}
// @lc code=end
