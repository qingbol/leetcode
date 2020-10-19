/*
 * @lc app=leetcode id=84 lang=java
 *
 * [84] Largest Rectangle in Histogram
 */

// @lc code=start
class Solution {
  /////////////////////////// first round(20200206)///////////////////////
  /////////////////////////// first round(20200206)///////////////////////
  //// ----------------start(Approach1)----------------------------------
  // 20200206
  public int largestRectangleArea(int[] heights) {
    if (null == heights || 0 == heights.length) {
      return 0;
    }
    Deque<Integer> stack = new ArrayDeque<>();
    int res = 0;
    stack.push(-1);
    for (int i = 0; i <= heights.length; i++) {
      int hi = i == heights.length ? 0 : heights[i];
      // System.out.format("stack: %s\n", stack);
      while (stack.peek() != -1 && heights[stack.peek()] >= hi) {
        res = Math.max(res, heights[stack.pop()] * (i - stack.peek() - 1));
        // System.out.format("i: %d, j: %d, res: %d\n", i, stack.peek(), res);
      }
      stack.push(i);
    }
    return res;
  }
  //// ---------------- end (Appraoch1)----------------------------------
  /////////////////////////// second round(20200928)///////////////////////
  /////////////////////////// second round(20200928)///////////////////////
  //// ----------------start(Appraoch2)----------------------------------
  //20201019
  //same as approach1
  //// ---------------- end (Appraoch2)----------------------------------
}
// @lc code=end
