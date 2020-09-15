/*
 * @lc app=leetcode id=15 lang=java
 *
 * [15] 3Sum
 */

// @lc code=start
class Solution {
  ////////////////// first round(20200112)///////////////////////////////////
  ////////////////// first round(20200112)///////////////////////////////////
  //// ----------------start(Approach1)-------------------------------------
  // 20200112

  // public List<List<Integer>> threeSum(int[] nums) {
  public List<List<Integer>> threeSum1(int[] nums) {
    Arrays.sort(nums);
    List<List<Integer>> lst = new ArrayList<>();
    for (int i = 0; i < nums.length - 2; i++) {
      if (i > 0 && nums[i] == nums[i - 1])
        continue;
      if (nums[i] > 0)
        break;
      int low = i + 1;
      int high = nums.length - 1;
      while (low < high) {
        if (nums[low] + nums[high] == 0 - nums[i]) {
          lst.add(Arrays.asList(nums[i], nums[low], nums[high]));
          while (low < high && nums[low] == nums[low + 1])
            low++;
          while (low < high && nums[high] == nums[high - 1])
            high--;
          low++;
          high--;
        } else if (nums[low] + nums[high] > 0 - nums[i]) {
          high--;
        } else {
          low++;
        }
      }
    }
    return lst;
  }
  //// ---------------- end (Approach1)-------------------------------------
  ////////////////// second round(20200910)///////////////////////////////////
  ////////////////// second round(20200910)///////////////////////////////////
  //// ----------------start(Approach2)-------------------------------------
  // 20200910
  // refer to Approach 1: Two Pointers

  // 318/318 cases passed (18 ms)
  // Your runtime beats 90.66 % of java submissions
  // Your memory usage beats 79.61 % of java submissions (43.4 MB)

  public List<List<Integer>> threeSum(int[] nums) {
    // public List<List<Integer>> threeSum2(int[] nums) {
    int n = nums.length;
    List<List<Integer>> res = new ArrayList<>();
    Arrays.sort(nums);
    for (int i = 0; i < n; i++) {
      if (i == 0 || nums[i - 1] != nums[i]) {
        twoSumSorted2(nums, i, res);
      }
    }
    return res;
  }

  private void twoSumSorted2(int[] nums, int idx, List<List<Integer>> res) {
    int lo = idx + 1, hi = nums.length - 1;
    while (lo < hi) {
      int sum = nums[lo] + nums[hi];
      if (sum > -nums[idx]) {
        hi--;
      } else if (sum < -nums[idx]) {
        lo++;
      } else {
        res.add(Arrays.asList(nums[idx], nums[lo++], nums[hi--]));
        while (lo < hi && nums[lo] == nums[lo - 1]) {
          // while (lo + 1 < hi && nums[lo] == nums[lo + 1]) {
          lo++;
        }
      }
    }
  }
  //// ---------------- end (Approach2)-------------------------------------
}
// @lc code=end
