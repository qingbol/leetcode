/*
 * @lc app=leetcode id=259 lang=java
 *
 * [259] 3Sum Smaller
 */

// @lc code=start
class Solution {
  ////////////////// first round(20200113)///////////////////////////////////
  ////////////////// first round(20200113)///////////////////////////////////
  //// ----------------start(Approach1)-------------------------------------
  // 20200113

  // public int threeSumSmaller(int[] nums, int target) {
  public int threeSumSmaller1(int[] nums, int target) {
    Arrays.sort(nums);
    int res = 0;
    for (int i = 0; i < nums.length - 2; i++) {
      int lo = i + 1;
      int hi = nums.length - 1;
      while (lo < hi) {
        int sum = nums[i] + nums[lo] + nums[hi];
        if (sum < target) {
          res += hi - lo;
          lo++;
        } else {
          hi--;
        }
      }
    }
    return res;
  }
  //// ---------------- end (Approach1)-------------------------------------
  ////////////////// second round(20200910)///////////////////////////////////
  ////////////////// second round(20200910)///////////////////////////////////
  //// ----------------start(Approach2)-------------------------------------
  // 20200910, two points.
  // idea: fix one num, then it becomes a two sum problem.

  // 314/314 cases passed (6 ms)
  // Your runtime beats 43.75 % of java submissions
  // Your memory usage beats 77.1 % of java submissions (39 MB)

  public int threeSumSmaller(int[] nums, int target) {
    // public int threeSumSmaller2(int[] nums, int target) {
    int n = nums.length;
    int res = 0;
    Arrays.sort(nums);

    for (int i = 0; i < n - 2; i++) {
      int lo = i + 1, hi = n - 1;
      while (lo < hi) {
        int sum = nums[i] + nums[lo] + nums[hi];
        if (sum >= target) {
          hi--;
        } else if (sum < target) {
          res += hi - lo;
          lo++;
        }
      }
    }
    return res;
  }
  //// ---------------- end (Approach2)-------------------------------------
}
// @lc code=end
