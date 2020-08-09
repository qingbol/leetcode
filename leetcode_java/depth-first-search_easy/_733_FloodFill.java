/*
 * @lc app=leetcode id=733 lang=java
 *
 * [733] Flood Fill
 */

// @lc code=start
class Solution {

  ////////////////// first round(20200805)///////////////////////////////////
  ////////////////// first round(20200805)///////////////////////////////////
  //// ----------------start(Approach1)-------------------------
  // 20200805, by myself

  // 277/277 cases passed (2 ms)
  // Your runtime beats 22.66 % of java submissions
  // Your memory usage beats 5.2 % of java submissions (45.6 MB)

  public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
    int oldColor = image[sr][sc];
    int[][] d = new int[][] {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    boolean[][] visited = new boolean[image.length][image[0].length];
    helper1(image, sr, sc, newColor, oldColor, d, visited);
    return image;
  }

  private void helper1(int[][] image, int r, int c, int newColor, int oldColor, int[][] d,
      boolean[][] visited) {
    if (r >= image.length || r < 0 || c >= image[0].length || c < 0)
      return;
    if (image[r][c] != oldColor || visited[r][c])
      return;

    image[r][c] = newColor;
    visited[r][c] = true;

    for (int i = 0; i < d.length; i++) {
      helper1(image, r + d[i][0], c + d[i][1], newColor, oldColor, d, visited);
    }
  }
  //// ---------------- end (Approach2)-------------------------
}
// @lc code=end

