/*
 * @lc app=leetcode id=174 lang=java
 *
 * [174] Dungeon Game
 */

// @lc code=start
class Solution {
  //// -------------------start(Approach1)------------------------------
  // 20200405, by myself.
  // Your runtime beats 43.93 % of java submissions
  public int calculateMinimumHP(int[][] dungeon) {
    if (dungeon == null || dungeon.length == 0 || dungeon[0].length == 0) {
      return 0;
    }
    int nr = dungeon.length;
    int nc = dungeon[0].length;

    dungeon[nr - 1][nc - 1] = Math.max(1, 1 - dungeon[nr - 1][nc - 1]);
    for (int j = nc - 2; j >= 0; j--) {
      dungeon[nr - 1][j] = Math.max(1, dungeon[nr - 1][j + 1] - dungeon[nr - 1][j]);
    }
    for (int i = nr - 2; i >= 0; i--) {
      dungeon[i][nc - 1] = Math.max(1, dungeon[i + 1][nc - 1] - dungeon[i][nc - 1]);
    }

    for (int i = nr - 2; i >= 0; i--) {
      for (int j = nc - 2; j >= 0; j--) {
        dungeon[i][j] = Math.max(1, Math.min(dungeon[i + 1][j], dungeon[i][j + 1]) - dungeon[i][j]);
      }
    }

    return dungeon[0][0];
  }
  //// ------------------- end (Approach1)------------------------------
}
// @lc code=end
