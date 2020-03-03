/*
 * @lc app=leetcode id=377 lang=java
 *
 * [377] Combination Sum IV
 */

// @lc code=start
class Solution {
  //// --------------------start(Apprpach1)------------------------------------
  // by myself, backtracking
  int res1 = 0;

  public int combinationSum4_1(int[] nums, int target) {
    // int res = 0;
    // List<List<Integer>> res = new ArrayList<>();

    if (nums == null || nums.length == 0) {
      return res1;
    }
    helper1(nums, target);
    // helper1(res, new ArrayList<>(), nums, target);
    return res1;
    // return res.size();
  }

  private void helper1(int[] nums, int target) {
    // private void helper1(List<List<Integer>> res, List<Integer> lst, int[] nums,
    // int target) {
    if (target < 0) {
      return;
    }
    if (target == 0) {
      // res.add(new ArrayList<>(lst));
      res1++;
      return;
    }

    for (int i = 0; i < nums.length; i++) {
      // lst.add(nums[i]);
      helper1(nums, target - nums[i]);
      // helper1(res, lst, nums, target - nums[i]);
      // lst.remove(lst.size() - 1);
    }
  }

  //// -------------------- end (Apprpach1)------------------------------------
  //// --------------------start(Apprpach2)------------------------------------
  // vanilla recursion
  public int combinationSum4_2(int[] nums, int target) {
    return helper2(nums, target);
  }

  private int helper2(int[] nums, int goal) {
    if (goal == 0) {
      return 1;
    }

    int ret = 0;
    for (int num : nums) {
      if (goal >= num) {
        ret += combinationSum4(nums, goal - num);
      }
    }
    return ret;
  }

  //// -------------------- end (Apprpach2)------------------------------------
  //// --------------------start(Apprpach3)------------------------------------
  // recursion with memo
  public int combinationSum4_3(int[] nums, int target) {
    int[] dp = new int[target + 1];
    Arrays.fill(dp, -1);
    dp[0] = 1;
    int res = helper3(dp, nums, target);
    return res;
  }

  private int helper3(int[] dp, int[] nums, int goal) {
    if (dp[goal] != -1) {
      return dp[goal];
    }
    // use dp[0] = 1 to replace if (target == 0) return 1;
    int res = 0;
    for (int num : nums) {
      if (goal >= num) {
        res += helper3(dp, nums, goal - num);
      }
    }

    dp[goal] = res;
    return res;

  }

  //// -------------------- end (Apprpach3)------------------------------------
  //// --------------------start(Apprpach4)------------------------------------
  // dp, bottom up
  public int combinationSum4(int[] nums, int target) {
    int[] dp = new int[target + 1];
    dp[0] = 1;
    for (int i = 1; i <= target; i++) {
      for (int num : nums) {
        if (i >= num) {
          dp[i] += dp[i - num];
        }
      }
    }
    return dp[target];
  }
  //// -------------------- end (Apprpach4)------------------------------------
}
// @lc code=end
