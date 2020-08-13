/*
 * @lc app=leetcode id=416 lang=java
 *
 * [416] Partition Equal Subset Sum
 */

// @lc code=start
class Solution {

  ////////////////// first round(20200809)///////////////////////////////////
  ////////////////// first round(20200809)///////////////////////////////////
  // -------------------start(Approach1)-------------------
  // 20200809, by myself. backtrack

  // public boolean canPartition(int[] nums) {
  public boolean canPartition1(int[] nums) {
    int sum = 0;
    for (int num : nums)
      sum += num;
    return helper1(nums, 0, (float) sum / 2);
  }

  private boolean helper1(int[] nums, int pos, float target) {
    if (pos >= nums.length)
      return false;
    if (target < 0)
      return false;
    if (target == 0)
      return true;

    if (helper1(nums, pos + 1, target - nums[pos]) || helper1(nums, pos + 1, target))
      return true;

    return false;
  }
  // ------------------- end (Approach1)-------------------
  // -------------------start(Approach2)-------------------
  // 20200809, by myself. backtrack + memo

  // 105/105 cases passed (26 ms)
  // Your runtime beats 60.69 % of java submissions
  // Your memory usage beats 29.84 % of java submissions (43.1 MB)

  enum Flag2 {
    GOOD, BAD, UNKNOWN
  }

  // public boolean canPartition(int[] nums) {
  public boolean canPartition2(int[] nums) {
    int n = nums.length;
    int sum = 0;
    for (int num : nums)
      sum += num;
    if (sum % 2 == 1)
      return false;

    Flag2[][] memo = new Flag2[n + 1][sum / 2 + 1];
    Arrays.stream(memo).forEach(a -> Arrays.fill(a, Flag2.UNKNOWN));
    // System.out.format("memo: %s\n", Arrays.deepToString(memo));
    return helper2(nums, 1, sum / 2, memo);
  }

  private boolean helper2(int[] nums, int item, int target, Flag2[][] memo) {
    if (item > nums.length)
      return false;
    if (target < 0)
      return false;
    if (target == 0)
      return true;
    if (!memo[item][target].equals(Flag2.UNKNOWN)) {
      return memo[item][target] == Flag2.GOOD ? true : false;
    }

    if (helper2(nums, item + 1, target - nums[item - 1], memo) || helper2(nums, item + 1, target, memo)) {
      memo[item][target] = Flag2.GOOD;
      return true;
    }

    memo[item][target] = Flag2.BAD;
    return false;
  }
  // ------------------- end (Approach2)-------------------
  // -------------------start(Approach3)-------------------
  // 20200809, dp
  // refer to labuladong<经典动态规划：子集背包问题>

  public boolean canPartition(int[] nums) {
    // public boolean canPartition3(int[] nums) {
    int n = nums.length;
    int sum = 0;
    for (int num : nums)
      sum += num;
    if (sum % 2 == 1)
      return false;
    int half = sum / 2;

    boolean[][] dp = new boolean[n + 1][half + 1];
    for (int i = 0; i <= n; i++)
      dp[i][0] = true;

    for (int i = 1; i <= n; i++) {
      for (int j = 1; j <= half; j++) {
        if (nums[i - 1] > j) {
          dp[i][j] = dp[i - 1][j];
        } else {
          dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i - 1]];
        }
        // if (dp[i][j])
        //   return true;
      }
    }

    return dp[n][half];
    // return false;
  }
  // ------------------- end (Approach3)-------------------
}
// @lc code=end
