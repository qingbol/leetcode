/*
 * @lc app=leetcode id=36 lang=java
 *
 * [36] Valid Sudoku
 */

// @lc code=start
class Solution {
  public boolean isValidSudoku1(char[][] board) {
    Map<Character, Integer>[] rows = new Map[9];
    Map<Character, Integer>[] cols = new Map[9];
    Map<Character, Integer>[] boxes = new Map[9];

    for (int i = 0; i < 9; i++) {
      rows[i] = new HashMap<>();
      cols[i] = new HashMap<>();
      boxes[i] = new HashMap<>();
    }

    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board[0].length; j++) {
        if (board[i][j] == '.')
          continue;
        int idx = i / 3 * 3 + j / 3;
        char c = board[i][j];
        // System.out.format("c: %c\n", c);
        int row = rows[i].getOrDefault(c, 0);
        int col = cols[j].getOrDefault(c, 0);
        int box = boxes[idx].getOrDefault(c, 0);
        rows[i].put(c, row + 1);
        cols[j].put(c, col + 1);
        boxes[idx].put(c, box + 1);
        // System.out.format("rows[i]: %s\n", rows[i]);
        // System.out.format("cols[%d]: %s\n", j, cols[j]);

        if (rows[i].get(c) > 1 || cols[j].get(c) > 1 || boxes[idx].get(c) > 1) {
          return false;
        }
      }
    }
    return true;
  }

  //
  public boolean isValidSudoku(char[][] board) {
    HashSet<String> set = new HashSet<>();
    for (int i = 0; i < 9; i++) {
      for (int j = 0; j < 9; j++) {
        char c = board[i][j];
        if (c == '.')
          continue;
        if (!set.add(c + " in row: " + i) || !set.add(c + " in col: " + j)
            || !set.add(c + " in box: " + i / 3 * 3 + j / 3)) {
          return false;
        }
      }
    }
    return true;
  }
}
// @lc code=end
