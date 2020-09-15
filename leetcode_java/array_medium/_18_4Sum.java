/*
 * @lc app=leetcode id=18 lang=java
 *
 * [18] 4Sum
 */

// @lc code=start
class Solution {
  ////////////////// first round(20200113)///////////////////////////////////
  ////////////////// first round(20200113)///////////////////////////////////
  //// ----------------start(Approach1)-------------------------------------
  // 20200113

  // public List<List<Integer>> fourSum(int[] nums, int target) {
  public List<List<Integer>> fourSum1(int[] nums, int target) {
    List<List<Integer>> res = new ArrayList<>();
    if (null == nums || nums.length < 4) {
      return res;
    }
    Arrays.sort(nums);
    for (int i = 0; i < nums.length - 3; i++) {
      if (i > 0 && nums[i] == nums[i - 1])
        continue;
      for (int j = i + 1; j < nums.length - 2; j++) {
        if (j > i + 1 && nums[j] == nums[j - 1])
          continue;
        int lo = j + 1;
        int hi = nums.length - 1;
        while (lo < hi) {
          // System.out.format("i: %d, j: %d, lo: %d, hi:%d\n", i, j, lo, hi);
          int sum = nums[i] + nums[j] + nums[lo] + nums[hi];
          if (sum == target) {
            res.add(Arrays.asList(nums[i], nums[j], nums[lo], nums[hi]));
            while (lo < hi && nums[lo] == nums[lo + 1])
              lo++;
            while (lo < hi && nums[hi] == nums[hi - 1])
              hi--;
            lo++;
            hi--;
          } else if (sum > target) {
            // while (nums[hi] == nums[hi - 1])
            // hi--;
            hi--;
          } else {
            // while (nums[lo] == nums[lo + 1])
            // lo++;
            lo++;
          }
        }
      }
    }
    return res;
  }
  //// ---------------- end (Approach1)-------------------------------------
  ////////////////// second round(20200910)///////////////////////////////////
  ////////////////// second round(20200910)///////////////////////////////////
  //// ----------------start(Approach2)-------------------------------------
  // 20200910,
  // refer to leetcode standard solution: Approach 1: Two Pointers

  // 282/282 cases passed (4 ms)
  // Your runtime beats 96.68 % of java submissions
  // Your memory usage beats 94.08 % of java submissions (39.5 MB)

  public List<List<Integer>> fourSum(int[] nums, int target) {
    // public List<List<Integer>> fourSum2(int[] nums, int target) {
    Arrays.sort(nums);
    return ksum2(nums, 0, 4, target);
  }

  private List<List<Integer>> ksum2(int[] nums, int start, int k, int target) {
    List<List<Integer>> res = new ArrayList<>();
    // dont forget to check this boundary cases:
    if (start == nums.length || nums[start] * k > target || nums[nums.length - 1] * k < target)
      return res;
    if (k == 2) {
      return twosum2(nums, start, target);
    }

    for (int i = start; i < nums.length; i++) {
      if (i != start && nums[i] == nums[i - 1])
        continue;
      var ret = ksum2(nums, i + 1, k - 1, target - nums[i]);
      // System.out.format("ret: %s\n", ret);
      for (var lst : ret) {
        // System.out.format("lst: %s\n", lst);
        // res.add(Arrays.asList(nums[i]));
        res.add(new ArrayList(Arrays.asList(nums[i])));
        res.get(res.size() - 1).addAll(lst);
      }
    }
    return res;
  }

  private List<List<Integer>> twosum2(int[] nums, int start, int target) {
    List<List<Integer>> res = new ArrayList<>();
    int lo = start, hi = nums.length - 1;
    while (lo < hi) {
      int sum = nums[lo] + nums[hi];
      if (sum > target || (hi < nums.length - 1 && nums[hi] == nums[hi + 1])) {
        hi--;
      } else if (sum < target || (lo > start && nums[lo] == nums[lo - 1])) {
        lo++;
      } else {
        res.add(Arrays.asList(nums[lo], nums[hi]));
        // res.add(new ArrayList<>(Arrays.asList(nums[lo], nums[hi])));
        // dont forget the following statments
        lo++;
        hi--;
      }
    }
    return res;
  }
  //// ---------------- end (Approach2)-------------------------------------
}
// @lc code=end
