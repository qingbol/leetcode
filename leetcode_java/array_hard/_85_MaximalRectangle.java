/*
 * @lc app=leetcode id=85 lang=java
 *
 * [85] Maximal Rectangle
 */

// @lc code=start
class Solution {
  /////////////////////////// first round(20200212)///////////////////////
  /////////////////////////// first round(20200212)///////////////////////
  //// ----------------start(Approach1)----------------------------------
  // 20200212
  public int maximalRectangle(char[][] matrix) {
  // public int maximalRectangle1(char[][] matrix) {
    if (null == matrix || 0 == matrix.length) {
      return 0;
    }
    int m = matrix.length;
    int n = matrix[0].length;
    int res = 0;
    int[] height = new int[n + 1];
    Deque<Integer> stack = new ArrayDeque<>();
    for (int i = 0; i < m; i++) {
      stack.clear();
      for (int j = 0; j < n + 1; j++) {
        if (j < n) {
          if (matrix[i][j] == '1') {
            height[j] += 1;
          } else {
            height[j] = 0;
          }
        }

        // cal the area
        if (stack.isEmpty() || height[stack.peek()] <= height[j]) {
          stack.push(j);
        } else {
          while (!stack.isEmpty() && height[stack.peek()] > height[j]) {
            // System.out.format("res: %d, h: %d, j: %d, i: %d\n", height[stack.peek()], j,
            // stack.peek());
            int cur = height[stack.pop()] * (stack.isEmpty() ? j : (j - stack.peek() - 1));
            // int cur = height[stack.peek()] * (j - stack.pop());
            System.out.format("i: %d, res: %d\n", i, cur);
            res = Math.max(res, cur);
          }
          stack.push(j);
        }
      }

    }
    return res;
  }
  //// ---------------- end (Appraoch1)----------------------------------
  /////////////////////////// second round(20201019)///////////////////////
  /////////////////////////// second round(20201019)///////////////////////
  //// ----------------start(Appraoch2)----------------------------------
  //20201019
  //same as approach1

  public int maximalRectangle2(char[][] matrix) {
    return 0;
  }
  //// ---------------- end (Appraoch2)----------------------------------
}
// @lc code=end
