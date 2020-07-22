/*
 * @lc app=leetcode id=45 lang=java
 *
 * [45] Jump Game II
 */

// @lc code=start
class Solution {
  ///////////////////////// first round(20200323)/////////////////////////
  ///////////////////////// first round(20200323)/////////////////////////
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
  //// ----------------start(Approach2)------------------------
  // 20200323, by myself.
  // greedy
  // Your runtime beats 100 % of java submissions

  // public int jump(int[] nums) {
  public int jump2(int[] nums) {
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
  //// ---------------- end (Approach2)------------------------
  ///////////////////////// second round(20200719)/////////////////////////
  ///////////////////////// second round(20200719)/////////////////////////
  //// ----------------start(Approach3)------------------------
  // 20200719. backtracking
  // This is not a good example for backtracking.
  // Time Limit Exceeded
  // 71/92 cases passed (N/A)

  // public int jump(int[] nums) {
  public int jump3(int[] nums) {
    int[] minJump = new int[] { Integer.MAX_VALUE };
    helper3(nums, 0, 0, minJump);
    return minJump[0];
  }

  private void helper3(int[] nums, int pos, int curJump, int[] minJump) {
    if (pos == nums.length - 1) {
      if (minJump[0] > curJump) {
        minJump[0] = curJump;
      }
      return;
    }

    int curFurthestPos = Math.min(pos + nums[pos], nums.length - 1);
    for (int nextPos = pos + 1; nextPos <= curFurthestPos; nextPos++) {
      helper3(nums, nextPos, curJump + 1, minJump);
    }
  }
  //// ---------------- end (Approach3)------------------------
  //// ----------------start(Approach4)------------------------
  // 20200719. backtracking
  // Time Limit Exceeded
  // 71/92 cases passed (N/A)

  // public int jump(int[] nums) {
  public int jump4(int[] nums) {
    return helper4(nums, 0);
  }

  private int helper4(int[] nums, int pos) {
    if (pos == nums.length - 1) {
      return 0;
    }

    int curPosJump = Integer.MAX_VALUE;
    int curFurthestPos = Math.min(pos + nums[pos], nums.length - 1);
    for (int nextPos = pos + 1; nextPos <= curFurthestPos; nextPos++) {
      int nextPosJump = helper4(nums, nextPos);
      if (nextPosJump != Integer.MAX_VALUE) {
        curPosJump = Math.min(curPosJump, nextPosJump + 1);
      }
    }

    return curPosJump;
  }
  //// ---------------- end (Approach4)------------------------
  //// ----------------start(Approach5)------------------------
  // 20200719. backtracking + memoizaiton(top down dp)
  // Time Limit Exceeded
  // 91/92 cases passed (N/A)

  public int jump5(int[] nums) {
    // public int jump(int[] nums) {
    int[] memo = new int[nums.length];
    Arrays.fill(memo, Integer.MAX_VALUE);
    memo[nums.length - 1] = 0;

    return helper5(nums, 0, memo);
  }

  private int helper5(int[] nums, int pos, int[] memo) {
    if (memo[pos] != Integer.MAX_VALUE) {
      return memo[pos];
    }

    int curLimitPos = Math.min(pos + nums[pos], nums.length - 1);
    for (int nextPos = pos + 1; nextPos <= curLimitPos; nextPos++) {
      int nextJump = helper5(nums, nextPos, memo);
      if (nextJump != Integer.MAX_VALUE) {
        memo[pos] = Math.min(memo[pos], 1 + nextJump);
      }
    }

    return memo[pos];
  }
  //// ---------------- end (Approach5)------------------------
  //// ----------------start(Approach6)------------------------
  // 20200719. bottom up dp
  // Time Limit Exceeded
  // 91/92 cases passed (N/A)

  public int jump6(int[] nums) {
    // public int jump(int[] nums) {
    int[] memo = new int[nums.length];
    Arrays.fill(memo, Integer.MAX_VALUE);
    memo[nums.length - 1] = 0;

    for (int i = nums.length - 2; i >= 0; i--) {
      for (int j = i + 1; j <= Math.min(i + nums[i], nums.length - 1); j++) {
        if (memo[j] != Integer.MAX_VALUE) {
          memo[i] = Math.min(memo[i], 1 + memo[j]);
        }
      }
    }
    return memo[0];
  }
  //// ---------------- end (Approach6)------------------------
  //// ----------------start(Approach7)------------------------
  // 20200719. greedy algo
  // 92/92 cases passed (2 ms)
  // Your runtime beats 60.29 % of java submissions
  // Your memory usage beats 8.66 % of java submissions (43.6 MB)

  // public int jump7(int[] nums) {
  public int jump(int[] nums) {
    if (nums.length < 2)
      return 0;

    // max postion one could reach starting from index <= i;
    int maxPos = nums[0];
    // max number of steps one could do inside this jump
    int maxStep = nums[0];
    int jump = 1;

    for (int i = 1; i < nums.length; i++) {
      // if to reach tis point, one needs one more jump
      if (i > maxStep) {
        jump++;
        maxStep = maxPos;
      }

      maxPos = Math.max(maxPos, i + nums[i]);
    }

    return jump;
  }
  //// ---------------- end (Approach7)------------------------
}
// @lc code=end
