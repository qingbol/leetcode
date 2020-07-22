/*
 * @lc app=leetcode id=55 lang=java
 *
 * [55] Jump Game
 */

// @lc code=start
class Solution {
  //////////////////////// first round(20200322)///////////////////////
  //////////////////////// first round(20200322)///////////////////////
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
  // public boolean canJump(int[] nums) {
  public boolean canJump6(int[] nums) {
    int leftmostGoodIdx = nums.length - 1;
    for (int curIdx = nums.length - 2; curIdx >= 0; curIdx--) {
      if (curIdx + nums[curIdx] >= leftmostGoodIdx) {
        leftmostGoodIdx = curIdx;
      }
    }
    return leftmostGoodIdx == 0;
  }
  //// -------------- end (Approach6)----------------------
  //////////////////////// second round(20200719)///////////////////////
  //////////////////////// second round(20200719)///////////////////////
  //// --------------start(Approach7)----------------------
  // 20200719, greedy
  // i can't figure it out myself
  // refer to labuladong <如何运用贪心思想玩跳跃游戏>
  // Approach 4: Greedy
  // 75/75 cases passed (2 ms)
  // Your runtime beats 49.57 % of java submissions
  // Your memory usage beats 18.75 % of java submissions (43.5 MB)

  public boolean canJump7(int[] nums) {
    // public boolean canJump(int[] nums) {
    int farthest = 0;
    for (int i = 0; i < nums.length - 1; i++) {
      farthest = Math.max(farthest, i + nums[i]);
      // at the same time, we need to check if its possible to reach beyond here
      if (farthest <= i) {
        return false;
      }
    }

    return farthest >= nums.length - 1;
  }
  //// -------------- end (Approach7)----------------------
  //// --------------start(Approach8)----------------------
  // 20200719, backtracking. backtrack is the easiest approach to figure out
  // refer to leetcode standard solution
  // Time Limit Exceeded
  // 74/75 cases passed (N/A)

  public boolean canJump8(int[] nums) {
    // public boolean canJump(int[] nums) {
    return helper8(nums, 0);
  }

  private boolean helper8(int[] nums, int pos) {
    if (pos == nums.length - 1) {
      return true;
    }

    int curFurthestPos = Math.min(pos + nums[pos], nums.length - 1);
    for (int nexPos = pos + 1; nexPos <= curFurthestPos; nexPos++) {
      if (helper8(nums, nexPos)) {
        return true;
      }
    }

    return false;
  }
  //// -------------- end (Approach8)----------------------
  //// --------------start(Approach8)----------------------
  // 20200719, top down dp
  // refer to leetcode standard solution
  // 75/75 cases passed (1943 ms)
  // Your runtime beats 5.02 % of java submissions
  // Your memory usage beats 5.01 % of java submissions (46.9 MB)

  enum Flag9 {
    GOOD, BAD, UNKNOW
  }

  public boolean canJump9(int[] nums) {
    // public boolean canJump(int[] nums) {
    Flag9[] memo = new Flag9[nums.length];
    Arrays.fill(memo, Flag9.UNKNOW);
    memo[nums.length - 1] = Flag9.GOOD;

    return helper9(nums, 0, memo);
  }

  private boolean helper9(int[] nums, int pos, Flag9[] memo) {
    if (memo[pos] != Flag9.UNKNOW) {
      return memo[pos] == Flag9.GOOD ? true : false;
    }

    int curFurthestPos = Math.min(pos + nums[pos], nums.length - 1);
    for (int nextPos = curFurthestPos; nextPos >= pos + 1; nextPos--) {
      if (helper9(nums, nextPos, memo)) {
        memo[pos] = Flag9.GOOD;
        return true;
      }
    }

    memo[pos] = Flag9.BAD;
    return false;
  }
  //// -------------- end (Approach9)----------------------
  //// --------------start(Approach10)----------------------
  // 20200719, bottom up
  // refer to leetcode standard solution
  // 75/75 cases passed (382 ms)
  // Your runtime beats 22.22 % of java submissions
  // Your memory usage beats 10.02 % of java submissions (44 MB)

  enum Flag10 {
    GOOD, BAD, UNKNOW
  }

  // public boolean canJump9(int[] nums) {
  public boolean canJump(int[] nums) {
    Flag10[] memo = new Flag10[nums.length];
    Arrays.fill(memo, Flag10.UNKNOW);
    memo[nums.length - 1] = Flag10.GOOD;

    for (int i = nums.length - 2; i >= 0; i--) {
      int curFurthestPos = Math.min(i + nums[i], nums.length - 1);
      for (int j = i + 1; j <= curFurthestPos; j++) {
        if (memo[j] == Flag10.GOOD) {
          memo[i] = Flag10.GOOD;
          break;
        }
      }
    }

    return memo[0] == Flag10.GOOD ? true : false;
  }
  //// -------------- end (Approach10)----------------------
}
// @lc code=end
