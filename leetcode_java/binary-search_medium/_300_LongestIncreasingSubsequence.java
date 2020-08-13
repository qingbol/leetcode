/*
 * @lc app=leetcode id=300 lang=java
 *
 * [300] Longest Increasing Subsequence
 */

// @lc code=start
class Solution {
  ////////////////// first round(20200302)///////////////////////////////////
  ////////////////// first round(20200302)///////////////////////////////////
  // -------------------start(Approach1)-------------------
  // 20200302,
  // Approach 1: Brute Force
  public int lengthOfLIS1(int[] nums) {
    return lengthOfLIS(nums, Integer.MIN_VALUE, 0);
  }

  public int lengthOfLIS(int[] nums, int prev, int curpos) {
    // System.out.format(" befor return||curpos:%d, prev:%d\n", curpos, prev);
    if (curpos == nums.length) {
      return 0;
    }
    // System.out.format(" ------||curpos:%d,nums[curpos]:%d, prev:%d\n", curpos,
    // nums[curpos], prev);
    // System.out.println("------------------------------");
    int taken = 0;
    int notTaken = 0;
    if (nums[curpos] > prev) {
      taken = 1 + lengthOfLIS(nums, nums[curpos], curpos + 1);
    }
    notTaken = lengthOfLIS(nums, prev, curpos + 1);
    // System.out.format("curpos:%d, curval:%d, prev:%d,taken:%d, notTanken:%d\n",
    // curpos, nums[curpos], prev, taken,
    // notTaken);
    return Math.max(taken, notTaken);
  }

  // ------------------- end (Approach1)-------------------
  // -------------------start(Approach2)-------------------
  // 20200302,
  /// Approach 2: Recursion with Memoization
  public int lengthOfLIS2(int[] nums) {
    int[][] memo = new int[nums.length + 1][nums.length];
    for (int[] l : memo) {
      Arrays.fill(l, -1);
    }
    return lengthOfLIS(nums, -1, 0, memo);
  }

  private int lengthOfLIS(int[] nums, int prevIdx, int curpos, int[][] memo) {
    if (curpos == nums.length) {
      return 0;
    }
    if (memo[prevIdx + 1][curpos] > -1) {
      return memo[prevIdx + 1][curpos];
    }
    int taken = 0;
    int notTaken = 0;
    if (prevIdx < 0 || nums[curpos] > nums[prevIdx]) {
      taken = 1 + lengthOfLIS(nums, curpos, curpos + 1, memo);
    }
    notTaken = lengthOfLIS(nums, prevIdx, curpos + 1, memo);
    int maxLen = Math.max(taken, notTaken);
    memo[prevIdx + 1][curpos] = maxLen;
    return maxLen;
  }

  // ------------------- end (Approach2)-------------------
  // -------------------start(Approach3)-------------------
  // 20200302,
  // Approach 3: Dynamic Programming
  public int lengthOfLIS3(int[] nums) {
    if (null == nums || 0 == nums.length) {
      return 0;
    }
    int[] dp = new int[nums.length];
    dp[0] = 1;
    int res = 1;
    for (int i = 1; i < nums.length; i++) {
      int localMax = 0;
      for (int j = 0; j < i; j++) {
        if (nums[i] > nums[j]) {
          localMax = Math.max(localMax, dp[j]);
        }
      }
      // System.out.format("i:%d, localMax: %d\n", i, localMax);
      dp[i] = localMax + 1;
      res = Math.max(res, dp[i]);
    }
    return res;
  }

  // ------------------- end (Approach3)-------------------
  // -------------------start(Approach4)-------------------
  // 20200302,
  // Approach 4: Dynamic Programming with Binary Search
  public int lengthOfLIS4(int[] nums) {
    int[] dp = new int[nums.length];
    int len = 0;
    for (int i = 0; i < nums.length; i++) {
      int idx = binaryFind(dp, 0, len, nums[i]);
      System.out.format("idx:%d, nums[i]: %d, dp:%s\n", idx, nums[i], Arrays.toString(dp));
      dp[idx] = nums[i];
      if (idx == len) {
        len++;
      }
    }
    System.out.format("idx:, nums[i]: , dp:%s\n", Arrays.toString(dp));
    return len;
  }

  private int binaryFind(int[] arr, int start, int end, int val) {
    int lo = start;
    int hi = end - 1;
    while (lo <= hi) {
      int mid = lo + (hi - lo) / 2;
      if (arr[mid] == val) {
        return mid;
      } else if (arr[mid] > val) {
        hi = mid - 1;
      } else {
        lo = mid + 1;
      }
    }
    return lo;
  }

  // ------------------- end (Approach4)-------------------
  // -------------------start(Approach5)-------------------
  // 20200302,
  // Approach 4: Dynamic Programming with Binary Search
  public int lengthOfLIS5(int[] nums) {
    int[] sequence = new int[nums.length];
    int maxLen = 0;
    for (int num : nums) {
      int i = 0;
      int j = maxLen;
      while (i != j) {
        int mid = (i + j) / 2;
        // System.out.format("i: %d, mid: %d, j: %d\n", i, mid, j);
        if (sequence[mid] < num) {
          i = mid + 1;
        } else {
          j = mid;
        }
      }

      // System.out.format("i: %d, j: %d, sequence: %s\n", i, j,
      // Arrays.toString(sequence));
      sequence[i] = num;
      // System.out.format("i: %d, j: %d, sequence: %s\n", i, j,
      // Arrays.toString(sequence));
      // System.out.println("------------------------");
      if (i == maxLen) {
        maxLen++;
      }
    }
    return maxLen;
  }

  // ------------------- end (Approach5)-------------------
  // -------------------start(Approach6)-------------------
  // 20200324, try to write it again by myself when learning dp
  // Your runtime beats 36.24 % of java submissions
  public int lengthOfLIS6(int[] nums) {
    int n = nums.length;
    if (n <= 1) {
      return n;
    }
    int[] dp = new int[n];
    Arrays.fill(dp, 1);
    int res = 1;

    for (int i = 1; i < n; i++) {
      for (int j = i - 1; j >= 0; j--) {
        if (nums[i] > nums[j]) {
          dp[i] = Math.max(dp[i], dp[j] + 1);
          res = Math.max(res, dp[i]);
          // break;
        }
      }
    }

    return res;
  }
  // ------------------- end (Approach6)-------------------
  ////////////////// second round(20200808)///////////////////////////////////
  ////////////////// second round(20200808)///////////////////////////////////
  // -------------------start(Approach7)-------------------
  // 20200808. dp + bottom up. by myselft
  // refer to labuladong<动态规划设计：最长递增子序列>

  // 24/24 cases passed (34 ms)
  // Your runtime beats 9.21 % of java submissions
  // Your memory usage beats 6.81 % of java submissions (40 MB)

  public int lengthOfLIS7(int[] nums) {
    // public int lengthOfLIS(int[] nums) {
    if (nums.length == 0)
      return 0;
    int[] dp = new int[nums.length];
    Arrays.fill(dp, 1);
    int res = 1;

    for (int i = 1; i < nums.length; i++) {
      for (int j = 0; j < i; j++) {
        if (nums[i] > nums[j]) {
          dp[i] = Math.max(dp[i], dp[j] + 1);
          res = Math.max(res, dp[i]);
        }
      }
    }
    // System.out.format("dp: %s\n", Arrays.toString(dp));

    return res;
  }
  // ------------------- end (Approach7)-------------------
  // -------------------start(Approach8)-------------------
  // 20200808. binary search

  // 24/24 cases passed (1 ms)
  // Your runtime beats 90.51 % of java submissions
  // Your memory usage beats 16.4 % of java submissions (39.6 MB)

  // public int lengthOfLIS8(int[] nums) {
  public int lengthOfLIS(int[] nums) {
    int[] pile = new int[nums.length];
    int cnt = 0;

    for (int num : nums) {
      int idx = leftBound8(pile, cnt, num);
      if (idx == cnt)
        cnt++;
      pile[idx] = num;
    }

    return cnt;
  }

  private int leftBound8(int[] pile, int cnt, int num) {
    int lo = 0, hi = cnt;
    while (lo < hi) {
      int mid = lo + (hi - lo) / 2;
      if (pile[mid] >= num) {
        hi = mid;
      } else {
        lo = mid + 1;
      }
    }

    return lo;
  }
  // ------------------- end (Approach8)-------------------
}
// @lc code=end
