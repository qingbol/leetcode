import java.util.Arrays;

/*
 * @lc app=leetcode id=16 lang=java
 *
 * [16] 3Sum Closest
 */

// @lc code=start
class Solution {
  ////////////////// first round(20200112)///////////////////////////////////
  ////////////////// first round(20200112)///////////////////////////////////
  //// ----------------start(Approach1)-------------------------------------
  // 20200112

  // public int threeSumClosest(int[] nums, int target) {
  public int threeSumClosest1(int[] nums, int target) {
    Arrays.sort(nums);
    int res = nums[0] + nums[1] + nums[nums.length - 1];
    for (int i = 0; i < nums.length - 2; i++) {
      int lo = i + 1;
      int hi = nums.length - 1;
      while (lo < hi) {
        int sum = nums[i] + nums[lo] + nums[hi];
        if (sum > target) {
          hi--;
        } else {
          lo++;
        }
        if (Math.abs(sum - target) < Math.abs(res - target)) {
          res = sum;
        }
      }
    }
    return res;
  }
  //// ---------------- end (Approach1)-------------------------------------
  ////////////////// second round(20200910)///////////////////////////////////
  ////////////////// second round(20200910)///////////////////////////////////
  //// ----------------start(Approach2)-------------------------------------
  // 20200910
  // refer to Approach 1: Two Pointers

  // 131/131 cases passed (4 ms)
  // Your runtime beats 89.83 % of java submissions
  // Your memory usage beats 69.2 % of java submissions (39.1 MB)

  // public int threeSumClosest(int[] nums, int target) {
  public int threeSumClosest2(int[] nums, int target) {
    int n = nums.length;
    Arrays.sort(nums);
    int diff = Integer.MAX_VALUE;
    for (int i = 0; i < n - 2; i++) {
      int lo = i + 1, hi = n - 1;
      while (lo < hi) {
        int sum = nums[i] + nums[lo] + nums[hi];
        if (sum > target) {
          hi--;
        } else if (sum < target) {
          lo++;
        } else {
          return sum;
        }
        // compare the sum of every tuple.
        if (Math.abs(sum - target) < Math.abs(diff)) {
          diff = target - sum;
        }
      }
    }
    return target - diff;
  }
  //// ---------------- end (Approach2)-------------------------------------
  //// ----------------start(Approach3)-------------------------------------
  // 20200910
  // refer to Approach 2: Binary Search

  // 131/131 cases passed (10 ms)
  // Your runtime beats 29.67 % of java submissions
  // Your memory usage beats 59.27 % of java submissions (39.2 MB)

  public int threeSumClosest(int[] nums, int target) {
    // public int threeSumClosest3(int[] nums, int target) {
    int n = nums.length;
    Arrays.sort(nums);
    int diff = Integer.MAX_VALUE;

    for (int i = 0; i < n - 2; i++) {
      for (int j = i + 1; j < n - 1; j++) {
        int complement = target - nums[i] - nums[j];
        int idx = Arrays.binarySearch(nums, j + 1, n - 1, complement);
        if (idx >= 0)
          return target;
        int hi = ~idx;
        int lo = hi - 1;
        if (hi < n && Math.abs(nums[hi] - complement) < Math.abs(diff))
          diff = complement - nums[hi];
        if (lo > j && Math.abs(complement - nums[lo]) < Math.abs(diff))
          diff = complement - nums[lo];

      }
    }
    return target - diff;

  }
  //// ---------------- end (Approach3)-------------------------------------
}
// @lc code=end
