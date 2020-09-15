/*
 * @lc app=leetcode id=334 lang=java
 *
 * [334] Increasing Triplet Subsequence
 */

// @lc code=start
class Solution {
  ////////////////// first round(20200108)///////////////////////////////////
  ////////////////// first round(20200108)///////////////////////////////////
  //// ----------------start(Approach1)-------------------------------------
  // 20200108
  // refer to leetcode standard solution

  // public boolean increasingTriplet(int[] nums) {
  public boolean increasingTriplet1(int[] nums) {
    int localMin1 = Integer.MAX_VALUE;
    int localMin2 = Integer.MAX_VALUE;
    int localMin3 = Integer.MAX_VALUE;

    for (int i = 0; i < nums.length; i++) {
      if (nums[i] <= localMin1) {
        localMin1 = nums[i];
      } else if (nums[i] <= localMin2) {
        localMin2 = nums[i];
      } else if (nums[i] < localMin3) {
        // } else if (nums[i] > localMin2) {
        localMin3 = nums[i];
        return true;
      }
    }
    return false;
  }
  //// ---------------- end (Approach1)-------------------------------------
  ////////////////// second round(20200907)///////////////////////////////////
  ////////////////// second round(20200907)///////////////////////////////////
  //// ----------------start(Approach2)-------------------------------------
  // 20200907
  // can't come up with an approach by myself.
  // https://leetcode.com/problems/increasing-triplet-subsequence/solution/
  // This is a special case of LIS.
  // LIS can be solved with O(N log M) where M is the length of sequences (generally M is N).
  // In this question, we can set M as 3 thus the problem can be solved with O(N) with the general
  // LIS approach.
  // See approach 4 in the solution for LIS:
  // https://leetcode.com/problems/longest-increasing-subsequence/solution/

  // 62/62 cases passed (1 ms)
  // Your runtime beats 51.5 % of java submissions
  // Your memory usage beats 95.89 % of java submissions (39 MB)

  public boolean increasingTriplet(int[] nums) {
    // public boolean increasingTriplet2(int[] nums) {
    int[] dp = new int[3];
    int piles = 0;
    for (int num : nums) {
      int idx = binaryFind(dp, 0, piles, num);
      if (idx == piles) {
        piles++;
        if (piles == 3)
          return true;
      }
      dp[idx] = num;
    }
    return false;
  }

  private int binaryFind(int[] nums, int lo, int hi, int target) {
    while (lo < hi) {
      int mid = lo + (hi - lo) / 2;
      if (nums[mid] >= target) {
        hi = mid;
      } else if (nums[mid] < target) {
        lo = mid + 1;
      }
    }
    return hi;
  }
  //// ---------------- end (Approach2)-------------------------------------
}
// @lc code=end
