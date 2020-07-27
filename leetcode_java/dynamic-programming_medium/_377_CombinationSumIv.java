/*
 * @lc app=leetcode id=377 lang=java
 *
 * [377] Combination Sum IV
 */

// @lc code=start
class Solution {
  /////////////////////////// first round(20200228)//////////////////////////
  /////////////////////////// first round(20200228)//////////////////////////
  //// --------------------start(Apprpach1)------------------------------------
  // 20200228, by myself, backtracking
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
  // 20200228, vanilla recursion
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
  // 20200228, recursion with memo
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
  // 20200228, dp, bottom up
  public int combinationSum4_4(int[] nums, int target) {
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
  //// --------------------start(Apprpach5)------------------------------------
  // 20200407,
  // Your runtime beats 100 % of java submissions
  // public int combinationSum4(int[] nums, int target) {
  public int combinationSum4_5(int[] nums, int target) {
    Integer[] memo = new Integer[target + 1];
    return helper5(nums, target, memo);
  }

  private int helper5(int[] nums, int target, Integer[] memo) {
    if (target == 0) {
      return 1;
    }

    if (memo[target] != null) {
      return memo[target];
    }

    int cnt = 0;
    for (int num : nums) {
      if (target >= num) {
        cnt += helper5(nums, target - num, memo);
      }
    }

    memo[target] = cnt;
    return cnt;
  }
  //// -------------------- end (Apprpach5)------------------------------------
  /////////////////////////// second round(20200726)//////////////////////////
  /////////////////////////// second round(20200726)//////////////////////////
  //// --------------------start(Apprpach6)------------------------------------
  // 20200726. backtracking, by myself.

  // 17/17 cases passed (0 ms)
  // Your runtime beats 100 % of java submissions
  // Your memory usage beats 47.33 % of java submissions (37 MB)

  // public int combinationSum4_6(int[] nums, int target) {
  public int combinationSum4(int[] nums, int target) {
    int[] memo = new int[target + 1];
    Arrays.fill(memo, -1);
    memo[0] = 1;

    helper6(nums, target, memo);
    // System.out.format("memo:%s\n", Arrays.toString(memo));
    return memo[target];
  }

  private int helper6(int[] nums, int target, int[] memo) {
    if (target < 0)
      return -1;
    if (memo[target] != -1)
      return memo[target];
    // if (target == 0)
    // return 1;

    int count = 0;
    for (int i = 0; i < nums.length; i++) {
      // System.out.format("i: %d\n", i);
      int ret = helper6(nums, target - nums[i], memo);
      if (ret != -1) {
        count += ret;
      }
    }

    memo[target] = count;
    return memo[target];
  }
  //// -------------------- end (Apprpach6)------------------------------------
}
// @lc code=end
