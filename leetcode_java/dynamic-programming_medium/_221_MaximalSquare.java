/*
 * @lc app=leetcode id=221 lang=java
 *
 * [221] Maximal Square
 */

// @lc code=start
class Solution {
  //// ---------------start(Approach1)---------------------------
  // 20200405, dp + space:O(mn)
  // Your runtime beats 7.7 % of java submissions
  public int maximalSquare1(char[][] matrix) {
    if (matrix == null || matrix.length == 0) {
      return 0;
    }
    int nr = matrix.length;
    int nc = matrix[0].length;
    int[][] dp = new int[nr + 1][nc + 1];
    int maxLen = 0;

    for (int i = 1; i < nr + 1; i++) {
      for (int j = 1; j < nc + 1; j++) {
        if (matrix[i - 1][j - 1] == '1') {
          dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;
        } else {
          dp[i][j] = 0;
        }
        maxLen = Math.max(maxLen, dp[i][j]);
      }
    }

    return maxLen * maxLen;
  }

  //// --------------- end (Approach1)---------------------------
  //// ---------------start(Approach2)---------------------------
  // 20200405, improvement of approach1. space: O(mn) -> O(n);
  // Your runtime beats 9.47 % of java submissions
  public int maximalSquare2(char[][] matrix) {
    if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
      return 0;
    }
    int nr = matrix.length;
    int nc = matrix[0].length;

    int[] dp = new int[nc + 1];
    int prev = 0;
    int maxLen = 0;

    for (int i = 1; i < nr + 1; i++) {
      for (int j = 1; j < nc + 1; j++) {
        int tmp = dp[j];
        if (matrix[i - 1][j - 1] == '1') {
          dp[j] = Math.min(Math.min(dp[j], dp[j - 1]), prev) + 1;
        } else {
          dp[j] = 0;
        }
        prev = tmp;
        maxLen = Math.max(maxLen, dp[j]);
      }
    }
    return maxLen * maxLen;
  }

  //// --------------- end (Approach2)---------------------------
  //// ---------------start(Approach3)---------------------------
  // sliding window from
  // https://leetcode.com/problems/maximal-square/discuss/539617/Sliding-window.-99.89.-Very-intuitive-solution-with-explanation
  // Your runtime beats 24.48 % of java submissions
  public int maximalSquare(char[][] matrix) {
    int size = 0;
    for (int i = 0; i < matrix.length; i++) {
      for (int j = 0; j < matrix[0].length; j++) {
        while (isSquare(matrix, i, j, size)) {
          size++;
        }
      }
    }
    return size * size;
  }

  private boolean isSquare(char[][] matrix, int startI, int startJ, int size) {
    int endI = startI + size;
    int endJ = startJ + size;
    if (endI > matrix.length - 1 || endJ > matrix[0].length - 1) {
      return false;
    }
    for (int i = startI; i <= endI; i++) {
      for (int j = startJ; j <= endJ; j++) {
        if (matrix[i][j] != '1') {
          return false;
        }
      }
    }
    return true;
  }
  //// --------------- end (Approach3)---------------------------
}
// @lc code=end
