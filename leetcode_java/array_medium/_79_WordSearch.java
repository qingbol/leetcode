/*
 * @lc app=leetcode id=79 lang=java
 *
 * [79] Word Search
 */

// @lc code=start
class Solution {
  /////////////////////// first round(20200309)////////////////////////////
  /////////////////////// first round(20200309)////////////////////////////
  //// -----------------start(Approach1)-------------------------------
  // 20200309
  // bfs: it's wrong use bfs, we should use backtrak. but why?
  // what's the difference? 
  //because "The same letter cell may not be used more than once."
  public boolean exist1(char[][] board, String word) {
    int nr = board.length;
    int nc = board[0].length;
    int[][] directions = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
    for (int i = 0; i < nr; i++) {
      for (int j = 0; j < nc; j++) {
        if (board[i][j] == word.charAt(0)) {
          if (dfs1(board, word, directions, i, j, 1)) {
            return true;
          }
        }
      }
    }
    return false;
  }

  private boolean dfs1(char[][] board, String word, int[][] directions, int r, int c, int p) {
    if (p == word.length() - 1) {
      return true;
    }
    for (int[] dir : directions) {
      int newR = r + dir[0];
      int newC = c + dir[1];
      if (newR < 0 || newR >= board.length || newC < 0 || newC >= board[0].length
          || board[newR][newC] != word.charAt(p)) {
        return false;
      }
      dfs1(board, word, directions, newR, newC, p + 1);
    }
    return false;
  }

  //// -------------- end (Approach1)---------------------
  //// --------------start(Approach2)---------------------
  // improvement of approach1
  // use backtrack instead
  public boolean exist2(char[][] board, String word) {
    int nr = board.length;
    int nc = board[0].length;
    int[][] directions = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
    for (int i = 0; i < nr; i++) {
      for (int j = 0; j < nc; j++) {
        // if (board[i][j] == word.charAt(0)) {
        if (backtrack2(board, word, directions, i, j, 0)) {
          return true;
        }
        // }
      }
    }
    return false;
  }

  private boolean backtrack2(char[][] board, String word, int[][] directions, int r, int c, int p) {
    // 1. check the bottom case
    if (p == word.length() - 1) {
      return true;
    }

    // check the boundaries
    if (r < 0 || r >= board.length || c < 0 || c >= board[0].length || board[r][c] != word.charAt(p)) {
      return false;
    }
    // explore the neighbors
    boolean ret = false;
    board[r][c] = '#';
    for (int[] dir : directions) {
      int newR = r + dir[0];
      int newC = c + dir[1];
      ret = backtrack2(board, word, directions, newR, newC, p + 1);
      if (ret) {
        break;
      }
    }

    // backtrack: clean up and return
    board[r][c] = word.charAt(p);
    return ret;
  }

  //// -------------- end (Approach2)---------------------
  //// --------------start(Approach3)---------------------
  // 20200309
  // backtracking. use visited[] to mark the state
  // better solution
  public boolean exist(char[][] board, String word) {
    boolean[][] visited = new boolean[board.length][board[0].length];
    int[][] directions = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board[0].length; j++) {
        if (board[i][j] == word.charAt(0)) {
          if (backtrack3(board, word, directions, visited, i, j, 0)) {
            return true;
          }
        }
      }
    }
    return false;
  }

  private boolean backtrack3(char[][] board, String word, int[][] directions, boolean[][] visited, int r, int c,
      int idx) {
    // 1 bottom case
    if (idx == word.length()) {
      return true;
    }
    // 2 check the boundaries
    if (r < 0 || r >= board.length || c < 0 || c >= board[0].length || visited[r][c]
        || board[r][c] != word.charAt(idx)) {
      return false;
    }

    // 3 mark the node befor next exploration
    visited[r][c] = true;
    boolean ret = false;
    // explore the neighbors in DFS
    for (int[] dir : directions) {
      int h = r + dir[0];
      int v = c + dir[1];
      ret = backtrack3(board, word, directions, visited, h, v, idx + 1);
      // return in this way, will assure the cleanup step be executed.
      if (ret) {
        break;
      }
    }

    // cleanup and backtrack
    visited[r][c] = false;
    return ret;
  }
  //// ---------------- end (Approach1)----------------------------------
  /////////////////////////// second round(20201129)///////////////////////
  /////////////////////////// second round(20201129)///////////////////////
  //// ----------------start(Approach2)----------------------------------
  // 20201129.
  //// ---------------- end (Approach2)----------------------------------
}
// @lc code=end
