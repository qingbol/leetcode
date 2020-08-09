/*
 * @lc app=leetcode id=372 lang=java
 *
 * [372] Super Pow
 */

// @lc code=start
class Solution {
  //// ---------------start(Approach1)---------------------------------
  // 20200718, by myself, refer to labladong
  // 54/54 cases passed (6 ms)
  // Your runtime beats 56 % of java submissions
  public int superPow1(int a, int[] b) {
    // public int superPow(int a, int[] b) {
    if (a % 1337 == 0)
      return 0;
    if (b == null || b.length == 0)
      return 1;
    return superPow1(a, b, b.length - 1);
  }

  private int superPow1(int a, int[] b, int idx) {
    if (idx < 0)
      return 1;
    return myPow1(a, b[idx]) * myPow1(superPow1(a, b, idx - 1), 10) % 1337;
  }

  private int myPow1(int a, int pow) {
    if (pow == 0)
      return 1;
    a %= 1337;
    int res = 1;
    if (pow % 2 == 1) {
      res = a * myPow1(a, pow - 1);
    } else {
      res = myPow1(a, pow / 2);
      res = res * res;
    }
    res %= 1337;
    return res;
  }

  //// --------------- end (Approach1)---------------------------------
  //// ---------------start(Approach2)---------------------------------
  // 20200718, best solution on leetcode discussion
  //refer to labuladong<如何高效进行模幂运算>

  // 54/54 cases passed (8 ms)
  // Your runtime beats 42.35 % of java submissions

  // public int superPow2(int a, int[] b) {
  private static final int MOD = 1337;

  public int superPow(int a, int[] b) {
    if (b == null || b.length == 0)
      return 0;
    a = a % MOD;
    int res = 1;

    for (int i = 0; i < b.length; i++) {
      res = myPow2(res, 10) * myPow2(a, b[i]) % MOD;
    }
    return res;
  }

  private int myPow2(int a, int pow) {
    if (pow == 0)
      return 1;
    if (pow == 1)
      return a;
    int ans = myPow2(a, pow / 2);
    ans = ans * ans % MOD;
    if ((pow & 1) == 1)
      ans = ans * a % MOD;
    return ans;
  }
  //// --------------- end (Approach2)---------------------------------
}
// @lc code=end
