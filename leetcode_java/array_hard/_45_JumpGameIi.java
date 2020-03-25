/*
 * @lc app=leetcode id=45 lang=java
 *
 * [45] Jump Game II
 */

// @lc code=start
class Solution {
  //// ----------------start(Approach1)------------------------
  // 20200323, by myself.
  // greedy or dp? should be dp.
  // Your runtime beats 30.14 % of java submissions
  public int jump1(int[] nums) {
    if (nums == null || nums.length == 0) {
      return 0;
    }
    int n = nums.length;
    int[] minJump = new int[n];
    Arrays.fill(minJump, Integer.MAX_VALUE);
    minJump[n - 1] = 0;

    for (int i = n - 2; i >= 0; i--) {
      int curMin = minJump[i];
      int upper = Math.min(i + nums[i], n - 1);
      for (int j = i + 1; j <= upper; j++) {
        curMin = Math.min(curMin, minJump[j]);
      }
      if (curMin != Integer.MAX_VALUE) {
        minJump[i] = curMin + 1;
      }
    }

    return minJump[0];
  }

  //// ---------------- end (Approach1)------------------------
  //// ----------------start(Approach1)------------------------
  // 20200323, by myself.
  // greedy
  // Your runtime beats 100 % of java submissions
  public int jump(int[] nums) {
    // if (nums == null || nums.length == 0) {
    // return 0;
    // }
    if (nums.length < 2) {
      return 0;
    }
    int n = nums.length;

    int maxPos = nums[0];
    int maxStep = nums[0];
    int jump = 1;

    for (int i = 1; i < n; i++) {
      if (maxStep < i) {
        jump++;
        maxStep = maxPos;
      }
      maxPos = Math.max(maxPos, i + nums[i]);
    }
    return jump;
  }
  //// ---------------- end (Approach1)------------------------
}
// @lc code=end
