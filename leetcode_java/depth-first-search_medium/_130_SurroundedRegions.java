/*
 * @lc app=leetcode id=130 lang=java
 *
 * [130] Surrounded Regions
 */

// @lc code=start
class Solution {
  //// -----------------start(Approach1)-----------------
  // 20200309
  public void solve(char[][] board) {
    // System.out.format("board: %s\n", Arrays.deepToString(board));
    if (board.length < 3 || board[0].length < 3) {
      return;
    }
    int nr = board.length;
    int nc = board[0].length;

    // traverse the top and bottome border
    for (int j = 0; j < nc; j++) {
      if (board[0][j] == 'O') {
        bfs1(board, 0, j);
      }
      if (board[nr - 1][j] == 'O') {
        bfs1(board, nr - 1, j);
      }
    }

    for (int i = 0; i < nr; i++) {
      if (board[i][0] == 'O') {
        bfs1(board, i, 0);
      }
      if (board[i][nc - 1] == 'O') {
        bfs1(board, i, nc - 1);
      }
    }

    // Post processing, turn 'E' to 'X', turn
    for (int i = 0; i < nr; i++) {
      for (int j = 0; j < nc; j++) {
        if (board[i][j] == 'E') {
          board[i][j] = 'O';
        } else if (board[i][j] == 'O') {
          board[i][j] = 'X';
        }
      }
    }
  }

  private void bfs1(char[][] board, int r, int c) {
    if (r < 0 || r >= board.length || c < 0 || c >= board[0].length || board[r][c] != 'O') {
      return;
    }
    board[r][c] = 'E';
    bfs1(board, r - 1, c);
    bfs1(board, r + 1, c);
    bfs1(board, r, c - 1);
    bfs1(board, r, c + 1);
  }
}
// @lc code=end
