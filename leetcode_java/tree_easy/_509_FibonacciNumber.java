/*
 * @lc app=leetcode id=509 lang=java
 *
 * [509] Fibonacci Number
 */

// @lc code=start
class Solution {
  //// --------------start(Approach1)------------------
  // 20200324, by myself. recursion.
  // Your runtime beats 32.77 % of java submissions
  public int fib1(int N) {
    if (N <= 1) {
      return N;
    }
    return fib(N - 1) + fib(N - 2);
  }

  //// -------------- end (Approach1)------------------
  //// --------------start(Approach2)------------------
  // 20200324, by myself. iteration.
  // Approach 2: Bottom-Up Approach using Memoization
  // Your runtime beats 100 % of java submissions
  public int fib2(int N) {
    if (N <= 1) {
      return N;
    }
    int[] seq = new int[N + 1];
    seq[0] = 0;
    seq[1] = 1;
    for (int i = 2; i <= N; i++) {
      seq[i] = seq[i - 1] + seq[i - 2];
    }
    return seq[N];
  }

  //// -------------- end (Approach2)------------------
  //// --------------start(Approach3)------------------
  // Approach 3: Top-Down Approach using Memoization
  // Your runtime beats 100 % of java submissions
  public int fib(int N) {
    if (N <= 1) {
      return N;
    }
    int[] memo = new int[N + 1];
    Arrays.fill(memo, -1);
    memo[0] = 0;
    memo[1] = 1;

    return helper3(memo, N);
  }

  private int helper3(int[] memo, int N) {
    if (memo[N] != -1) {
      return memo[N];
    }

    int ret = helper3(memo, N - 1) + helper3(memo, N - 2);
    memo[N] = ret;
    return ret;
  }
  //// -------------- end (Approach3)------------------
}
// @lc code=end
