/*
 * @lc app=leetcode id=312 lang=java
 *
 * [312] Burst Balloons
 */

// @lc code=start
class Solution {
  //// -----------------start(Approach1)--------------------
  // 20200408, by myself. backtracking
  // Time Limit Exceeded 24/70 cases passed (N/A)
  // Testcase [7,9,8,0,7,1,3,5,5,2,3]
  public int maxCoins1(int[] nums) {
    LinkedList<Integer> digits = new LinkedList<>();
    for (int num : nums) {
      digits.add(num);
    }
    digits.addFirst(1);
    digits.add(1);
    // System.out.format("digits:%s\n", digits);

    return helper1(digits);
  }

  private int helper1(LinkedList<Integer> digits) {
    if (digits.size() == 2) {
      return 0;
    }

    int ret = 0;
    for (int i = 1; i < digits.size() - 1; i++) {
      int curr = digits.get(i);
      int currProduct = curr * digits.get(i - 1) * digits.get(i + 1);
      digits.remove(i);
      int next = helper1(digits);
      digits.add(i, curr);
      // System.out.format("currP: %d, next: %d\n", currProduct, next);
      ret = Math.max(ret, currProduct + next);
    }
    return ret;
  }

  //// ----------------- end (Approach1)--------------------
  //// -----------------start(Approach2)--------------------
  // 20200408, dp + top down + memoization
  // Your runtime beats 55.9 % of java submissions
  public int maxCoins2(int[] nums) {
    int n = nums.length + 2;
    int[] arrs = new int[n];
    System.arraycopy(nums, 0, arrs, 1, nums.length);
    arrs[0] = arrs[n - 1] = 1;
    // System.out.format("arrs:%s\n", Arrays.toString(arrs));

    int[][] memo = new int[n][n];
    return helper2(arrs, 0, n - 1, memo);
  }

  private int helper2(int[] arrs, int l, int r, int[][] memo) {
    if (l + 1 == r) {
      return 0;
    }
    if (memo[l][r] > 0) {
      return memo[l][r];
    }

    int ret = 0;
    for (int i = l + 1; i < r; i++) {
      ret = Math.max(ret, arrs[l] * arrs[i] * arrs[r] + helper2(arrs, l, i, memo) + helper2(arrs, i, r, memo));
    }

    memo[l][r] = ret;
    return ret;
  }

  //// ----------------- end (Approach2)--------------------
  //// -----------------start(Approach3)--------------------
  // 20200408, dp + bottom up + tabulation
  // Your runtime beats 81.09 % of java submissions
  public int maxCoins(int[] nums) {
    int n = nums.length + 2;
    int[] arrs = new int[n];
    System.arraycopy(nums, 0, arrs, 1, nums.length);
    arrs[0] = arrs[n - 1] = 1;

    int[][] dp = new int[n][n];

    for (int left = n - 2; left > -1; left--) {
      for (int right = left + 2; right < n; right++) {
        for (int i = left + 1; i < right; i++) {
          dp[left][right] = Math.max(dp[left][right], arrs[left] * arrs[i] * arrs[right] + dp[left][i] + dp[i][right]);
        }
      }
    }

    return dp[0][n - 1];
  }
  //// ----------------- end (Approach3)--------------------
}
// @lc code=end
