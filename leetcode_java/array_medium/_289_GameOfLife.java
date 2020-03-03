/*
 * @lc app=leetcode id=289 lang=java
 *
 * [289] Game of Life
 */

// @lc code=start
class Solution {
  public void gameOfLife(int[][] board) {
    int m = board.length;
    int n = board[0].length;

    // cal state
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        int cnt = calNeighbor(board, i, j);
        if (board[i][j] == 1) {
          if (cnt == 2 || cnt == 3) {
            board[i][j] += 2;
          }
        }
        if (board[i][j] == 0 && cnt == 3) {
          board[i][j] += 2;
        }
      }
    }

    // update
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        board[i][j] >>= 1;
      }
    }

  }

  private int calNeighbor(int[][] board, int row, int col) {
    int count = 0;
    int high = Math.max(0, row - 1);
    int low = Math.min(board.length - 1, row + 1);
    int left = Math.max(0, col - 1);
    int right = Math.min(board[0].length - 1, col + 1);
    for (int i = high; i <= low; i++) {
      for (int j = left; j <= right; j++) {
        if (i == row && j == col) {
          continue;
        }
        if ((board[i][j] & 1) == 1) {
          count++;
        }
      }
    }
    return count;
  }
}
// @lc code=end
