/*
 * @lc app=leetcode id=277 lang=java
 *
 * [277] Find the Celebrity
 */

// @lc code=start
/*
 * The knows API is defined in the parent class Relation. boolean knows(int a, int b);
 */

public class Solution extends Relation {

  ////////////////// first round(20200111)///////////////////////////////////
  ////////////////// first round(20200111)///////////////////////////////////
  //// ----------------start(Approach1)-------------------------------------
  // 20200111
  public int findCelebrity1(int n) {
    boolean[] knowOther = new boolean[n];
    int[] beKnown = new int[n];
    for (int i = 0; i < n; i++) {
      // flag = 0;
      for (int j = 0; j < n; j++) {
        if (i != j && true == knows(i, j)) {
          knowOther[i] = true;
          beKnown[j]++;
          // break;
        }
      }
    }

    for (int i = 0; i < n; i++) {
      if (false == knowOther[i] && n - 1 == beKnown[i]) {
        return i;
      }
    }

    return -1;
  }

  //// ---------------- end (Approach1)-------------------------------------
  //// ----------------start(Approach2)-------------------------------------

  // public int findCelebrity(int n) {
  public int findCelebrity2(int n) {
    int candidate = 0;
    for (int i = 0; i < n; i++) {
      if (knows(candidate, i)) {
        candidate = i;
      }
    }

    for (int j = 0; j < n; j++) {
      if (candidate > j && knows(candidate, j) || !knows(j, candidate)) {
        return -1;
      } else if (candidate < j && !knows(j, candidate)) {
        return -1;
      }
    }

    return candidate;
  }
  //// ---------------- end (Approach2)-------------------------------------
  ////////////////// second round(20200911)///////////////////////////////////
  ////////////////// second round(20200911)///////////////////////////////////
  //// ----------------start(Approach3)-------------------------------------
  // 20200911, can only come up O(n^2) approach
  // refer to leetcode: Approach 2: Logical Deduction
  // with each call to knows(...), we can conclusively determine that exactly 1 of the people is not
  //// a celebrity!

  // 171/171 cases passed (38 ms)
  // Your runtime beats 23.4 % of java submissions
  // Your memory usage beats 13.39 % of java submissions (52.1 MB)

  public int findCelebrity(int n) {
    // public int findCelebrity3(int n) {
    // 1. initializastion
    int candidate = 0;
    for (int i = 1; i < n; i++) {
      if (knows(candidate, i))
        candidate = i;
    }
    // 2. check tehe candidate
    for (int i = 0; i < n; i++) {
      if (candidate == i)
        continue;
      if (knows(candidate, i) || !knows(i, candidate))
        return -1;
    }
    return candidate;
  }
  //// ---------------- end (Approach3)-------------------------------------
}
// @lc code=end
