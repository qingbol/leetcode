/*
 * @lc app=leetcode id=370 lang=java
 *
 * [370] Range Addition
 */

// @lc code=start
class Solution {
  ////////////////// first round(20200116)///////////////////////////////////
  ////////////////// first round(20200116)///////////////////////////////////
  //// ----------------start(Approach1)-------------------------------------
  // 20200116
  public int[] getModifiedArray1(int length, int[][] updates) {
    int[] nums = new int[length];
    for (int i = 0; i < updates.length; i++) {
      for (int j = updates[i][0]; j <= updates[i][1]; j++) {
        nums[j] += updates[i][2];
      }
      // System.out.println("nums: " + Arrays.toString(nums));
    }
    return nums;
  }

  //// ---------------- end (Approach1)-------------------------------------
  //// ----------------start(Approach2)-------------------------------------
  // refer to Approach 2: Range Caching
  // public int[] getModifiedArray(int length, int[][] updates) {
  public int[] getModifiedArray2(int length, int[][] updates) {
    int[] nums = new int[length];
    for (int[] update : updates) {
      nums[update[0]] += update[2];
      if (update[1] + 1 < length) {
        nums[update[1] + 1] -= update[2];
      }
    }
    for (int i = 1; i < length; i++) {
      nums[i] += nums[i - 1];
    }
    return nums;
  }
  //// ---------------- end (Approach2)-------------------------------------
  ////////////////// second round(20200911)///////////////////////////////////
  ////////////////// second round(20200911)///////////////////////////////////
  //// ----------------start(Approach3)-------------------------------------
  // 20200911, the naive O(nk) approach is easy to come up. but the novel O(n + k) approach is hard
  //// to come up
  // refer to Approach 2: Range Caching

  // 18/18 cases passed (3 ms)
  // Your runtime beats 55.88 % of java submissions
  // Your memory usage beats 10.16 % of java submissions (55.5 MB)

  public int[] getModifiedArray(int length, int[][] updates) {
    // public int[] getModifiedArray3(int length, int[][] updates) {
    int[] res = new int[length];
    // 1. distribute
    for (int[] tuple : updates) {
      res[tuple[0]] += tuple[2];
      if (tuple[1] < length - 1)
        res[tuple[1] + 1] -= tuple[2];
    }
    // 2. collect
    for (int i = 1; i < length; i++) {
      res[i] += res[i - 1];
    }
    return res;
  }
  //// ---------------- end (Approach3)-------------------------------------
}
// @lc code=end
