/*
 * @lc app=leetcode id=277 lang=java
 *
 * [277] Find the Celebrity
 */

// @lc code=start
/* The knows API is defined in the parent class Relation.
      boolean knows(int a, int b); */

public class Solution extends Relation {
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

  public int findCelebrity(int n) {
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
}
// @lc code=end
