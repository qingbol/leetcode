/*
 * @lc app=leetcode id=54 lang=java
 *
 * [54] Spiral Matrix
 */

// @lc code=start
class Solution {
  ////////////////// first round(20200111)///////////////////////////////////
  ////////////////// first round(20200111)///////////////////////////////////
  //// ----------------start(Approach1)-------------------------------------
  // 20200111
  // refer to leetcode: Approach 2: Layer-by-Layer

  // public List<Integer> spiralOrder(int[][] matrix) {
  public List<Integer> spiralOrder1(int[][] matrix) {
    List<Integer> list = new ArrayList<>();
    if (0 == matrix.length) {
      return list;
    }
    int rowBegin = 0;
    int rowEnd = matrix.length;
    // System.out.println("rowEnd: " + rowEnd);
    int colBegin = 0;
    int colEnd = matrix[0].length;
    // System.out.println("colEnd: " + colEnd);

    while (rowBegin < rowEnd && colBegin < colEnd) {
      // System.out.println("--------------------");
      for (int j = colBegin; j < colEnd; j++) {
        list.add(matrix[rowBegin][j]);
        // System.out.println("matrix: " + matrix[rowBegin][j]);
      }
      rowBegin++;
      // System.out.println("rowBegin: " + rowBegin);
      for (int i = rowBegin; i < rowEnd; i++) {
        list.add(matrix[i][colEnd - 1]);
        // System.out.println("matrix: " + matrix[i][colEnd - 1]);
      }
      colEnd--;
      // System.out.println("colEnd: " + colEnd);
      if (rowBegin < rowEnd) {
        for (int j = colEnd - 1; j >= colBegin; j--) {
          // System.out.println("matrix: " + matrix[rowEnd - 1][j]);
          list.add(matrix[rowEnd - 1][j]);
        }
      }
      rowEnd--;
      // System.out.println("rowEnd: " + rowEnd);
      if (colBegin < colEnd) {
        for (int i = rowEnd - 1; i >= rowBegin; i--) {
          list.add(matrix[i][colBegin]);
          // System.out.println("matrix: " + matrix[i][colBegin]);
        }
      }
      colBegin++;
      // System.out.println("colBegin: " + colBegin);
    }

    return list;
  }
  //// ---------------- end (Approach1)-------------------------------------
  ////////////////// second round(20200913)///////////////////////////////////
  ////////////////// second round(20200913)///////////////////////////////////
  //// ----------------start(Approach2)-------------------------------------
  // 20200914
  // approach1 is better.
  // refer to leetcode: Approach 1: Simulation

  // 22/22 cases passed (0 ms)
  // Your runtime beats 100 % of java submissions
  // Your memory usage beats 97.82 % of java submissions (37 MB)

  public List<Integer> spiralOrder(int[][] matrix) {
    // public List<Integer> spiralOrder2(int[][] matrix) {
    List<Integer> res = new ArrayList<>();
    if (matrix.length == 0)
      return res;
    int R = matrix.length, C = matrix[0].length;
    int[][] dir = new int[][] {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    boolean[][] visited = new boolean[R][C];

    int r = 0, c = 0;
    int candidateR = 0, candidateC = 0;
    int di = 0;
    while (res.size() < R * C) {
      // System.out.format("ele: %d\n", matrix[r][c]);
      res.add(matrix[r][c]);
      // System.out.format("res: %s\n", res);
      visited[r][c] = true;
      candidateR = r + dir[di][0];
      candidateC = c + dir[di][1];

      if (candidateR >= R || candidateR < 0 || candidateC >= C || candidateC < 0
          || visited[candidateR][candidateC]) {
        di = (di + 1) % 4;
        r += dir[di][0];
        c += dir[di][1];
      } else {
        r = candidateR;
        c = candidateC;
      }
    }
    return res;
  }
  //// ---------------- end (Approach2)-------------------------------------
}
// @lc code=end
