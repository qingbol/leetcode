/*
 * @lc app=leetcode id=55 lang=java
 *
 * [55] Jump Game
 */

// @lc code=start
class Solution {
  //// --------------start1(Approach1)----------------------
  // 20200322
  // backtrack; by myself
  // 74/75 cases passed (N/A) Time Limit Exceeded
  public boolean canJump1(int[] nums) {
    return helper1(nums, 0, nums.length - 1);
  }

  private boolean helper1(int[] nums, int idx, int end) {
    System.out.format("idx: %d, end: %d\n", idx, end);
    if (idx >= end) {
      // return false;
      return true;
    }

    for (int i = nums[idx]; i > 0; i--) {
      // System.out
      if (helper1(nums, i + idx, end)) {
        return true;
      }
    }
    return false;
  }

  //// -------------- end (Approach1)----------------------
  //// --------------start1(Approach2)----------------------
  // 20200322
  // backtrack + momoization
  // Approach 2: Dynamic Programming Top-down
  // Your runtime beats 5.06 % of java submissions
  enum Flag2 {
    BAD, GOOD, UNKNOWN
  }

  public boolean canJump2(int[] nums) {
    Flag2[] memo = new Flag2[nums.length];
    for (int i = 0; i < nums.length; i++) {
      memo[i] = Flag2.UNKNOWN;
    }
    memo[nums.length - 1] = Flag2.GOOD;

    return helper2(memo, nums, 0, nums.length - 1);
  }

  private boolean helper2(Flag2[] memo, int[] nums, int idx, int end) {
    if (memo[idx] != Flag2.UNKNOWN) {
      return memo[idx] == Flag2.GOOD ? true : false;
    }
    // System.out.format("idx: %d, end: %d\n", idx, end);
    //// since memo(end) == Flag2.GOOD, we don't need the below termination
    //// condition any longer.
    // if (idx == end) {
    // return false;
    // memo[idx] = Flag2.GOOD;
    // return true;
    // }

    int furthestIdx = Math.min((idx + nums[idx]), end);
    for (int nextIdx = furthestIdx; nextIdx > idx; nextIdx--) {
      if (helper2(memo, nums, nextIdx, end)) {
        memo[idx] = Flag2.GOOD;
        return true;
      }
    }

    memo[idx] = Flag2.BAD;
    return false;
  }

  //// -------------- end (Approach2)----------------------
  //// --------------start(Approach3)----------------------
  // 20200322, bottom up
  // Approach 3: Dynamic Programming Bottom-up
  // Your runtime beats 28.59 % of java submissions
  enum Flag3 {
    GOOD, BAD, UNKNOWN
  }

  public boolean canJump3(int[] nums) {
    int n = nums.length;
    Flag3[] memo = new Flag3[n];
    for (int i = 0; i < n; i++) {
      memo[i] = Flag3.UNKNOWN;
    }
    memo[n - 1] = Flag3.GOOD;

    for (int idx = n - 2; idx >= 0; idx--) {
      int furthestIdx = Math.min(idx + nums[idx], n - 1);
      for (int nextIdx = furthestIdx; nextIdx > idx; nextIdx--) {
        if (memo[nextIdx] == Flag3.GOOD) {
          memo[idx] = Flag3.GOOD;
          break;
        }
      }
    }

    return memo[0] == Flag3.GOOD;
  }

  //// -------------- end (Approach3)----------------------
  //// --------------start(Approach4)----------------------
  // 20200322. greedy by myself.
  // wrong for test case: [0, 2, 3]
  public boolean canJump4(int[] nums) {
    int n = nums.length;
    int sum = 0;
    for (int i = n - 2; i >= 0; i--) {
      sum += nums[i];
      if (sum < n - 1 - i) {
        return false;
      }
    }
    return true;
  }

  //// -------------- end (Approach4)----------------------
  //// --------------start(Approach5)----------------------
  // 20200322, greedy by cson + best solution
  // Your runtime beats 98.56 % of java submissions
  public boolean canJump5(int[] nums) {
    // the furthest point you can reach from this point or a previous point
    int maxDistance = 0;
    for (int i = 0; i < nums.length; i++) {
      // if (maxDistance > nums.length - 1) {
      // return true;
      // } else if (maxDistance < i) {
      if (maxDistance < i) {
        return false;
      }
      maxDistance = Math.max(maxDistance, i + nums[i]);
    }
    return true;
  }

  //// -------------- end (Approach5)----------------------
  //// --------------start(Approach6)----------------------
  // 20200322
  // Approach 4: Greedy
  // Your runtime beats 98.53 % of java submissionso
  // optimal, more easy to understand than approach5
  public boolean canJump(int[] nums) {
    int leftmostGoodIdx = nums.length - 1;
    for (int curIdx = nums.length - 2; curIdx >= 0; curIdx--) {
      if (curIdx + nums[curIdx] >= leftmostGoodIdx) {
        leftmostGoodIdx = curIdx;
      }
    }
    return leftmostGoodIdx == 0;
  }
  //// -------------- end (Approach6)----------------------
}
// @lc code=end
