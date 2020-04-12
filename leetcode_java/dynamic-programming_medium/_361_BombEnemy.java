/*
 * @lc app=leetcode id=361 lang=java
 *
 * [361] Bomb Enemy
 */

// @lc code=start
class Solution {
  //// ---------------start(Approach1)----------------------------
  // 20200409, by myselft. brute force.
  // Your runtime beats 59.26 % of java submissions
  public int maxKilledEnemies1(char[][] grid) {
    if (grid == null || grid.length == 0) {
      return 0;
    }
    int nr = grid.length;
    int nc = grid[0].length;

    int res = 0;
    for (int i = 0; i < nr; i++) {
      for (int j = 0; j < nc; j++) {
        int kill = 0;
        if (grid[i][j] == '0') {
          int up = i - 1;
          int dn = i + 1;
          int lf = j - 1;
          int rt = j + 1;
          while (up >= 0 && grid[up][j] != 'W') {
            if (grid[up][j] == 'E') {
              kill++;
            }
            up--;
          }
          while (dn <= nr - 1 && grid[dn][j] != 'W') {
            if (grid[dn][j] == 'E') {
              kill++;
            }
            dn++;
          }
          while (lf >= 0 && grid[i][lf] != 'W') {
            if (grid[i][lf] == 'E') {
              kill++;
            }
            lf--;
          }
          while (rt <= nc - 1 && grid[i][rt] != 'W') {
            if (grid[i][rt] == 'E') {
              kill++;
            }
            rt++;
          }
        }
        res = Math.max(res, kill);
      }
    }
    return res;
  }

  //// --------------- end (Approach1)----------------------------
  //// ---------------start(Approach2)----------------------------
  // 20200409, pseud dp.
  // Your runtime beats 98.93 % of java submissions
  public int maxKilledEnemies(char[][] grid) {
    if (grid == null || grid.length == 0 || grid[0].length == 0) {
      return 0;
    }
    int nr = grid.length;
    int nc = grid[0].length;

    // define some variable
    int rowCnt = 0;
    int[] colCnt = new int[nc];
    int res = 0;

    for (int i = 0; i < nr; i++) {
      for (int j = 0; j < nc; j++) {
        if (grid[i][j] == 'W') {
          continue;
        }
        // calculate the death toll of this row. for current epicenter
        if (j == 0 || grid[i][j - 1] == 'W') {
          rowCnt = 0;
          for (int k = j; k < nc && grid[i][k] != 'W'; k++) {
            rowCnt += grid[i][k] == 'E' ? 1 : 0;
          }
        }
        // calculate the death toll of this col for current epicenter.
        if (i == 0 || grid[i - 1][j] == 'W') {
          colCnt[j] = 0;
          for (int k = i; k < nr && grid[k][j] != 'W'; k++) {
            colCnt[j] += grid[k][j] == 'E' ? 1 : 0;
          }
        }

        // if this point can put bomb.
        if (grid[i][j] == '0') {
          res = Math.max(res, rowCnt + colCnt[j]);
        }
      }
    }

    return res;
  }
  //// --------------- end (Approach2)----------------------------
}
// @lc code=end
