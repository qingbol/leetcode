/*
 * @lc app=leetcode id=302 lang=java
 *
 * [302] Smallest Rectangle Enclosing Black Pixels
 */

// @lc code=start
class Solution {
  public int minArea1(char[][] image, int x, int y) {
    int[] corner = new int[4];
    corner[0] = x;
    corner[1] = y;
    corner[2] = x + 1;
    corner[3] = y + 1;
    dfs(image, x, y, corner);
    int res = (corner[2] - corner[0]) * (corner[3] - corner[1]);
    // System.out.format("corner: %s\n", Arrays.toString(corner));
    return res;
  }

  private void dfs(char[][] image, int x, int y, int[] vertex) {
    if (x < 0 || x >= image.length || y < 0 || y >= image[0].length || image[x][y] == '0') {
      return;
    }
    // System.out.format("x:%d, y:%d\n", x, y);
    image[x][y] = '0';
    vertex[0] = Math.min(vertex[0], x);
    vertex[1] = Math.min(vertex[1], y);
    vertex[2] = Math.max(vertex[2], x + 1);
    vertex[3] = Math.max(vertex[3], y + 1);
    dfs(image, x + 1, y, vertex);
    dfs(image, x - 1, y, vertex);
    dfs(image, x, y + 1, vertex);
    dfs(image, x, y - 1, vertex);
  }

  // Approach2: binary searchd
  public int minArea(char[][] image, int x, int y) {
    int m = image.length;
    int n = image[0].length;
    int left = searchHorizontal(image, 0, y, true);
    int right = searchHorizontal(image, y + 1, n, false);
    int top = searchVertical(image, 0, x, true);
    int bottom = searchVertical(image, x + 1, m, false);
    // System.out.format("l: %d, r: %d, t: %d, b: %d\n", left, right, top, bottom);
    return (right - left) * (bottom - top);
  }

  private int searchHorizontal(char[][] image, int l, int r, boolean w2b) {
    // System.out.println("------------");
    int bottom = image.length;
    while (l < r) {
      int top = 0;
      int mid = l + (r - l) / 2;
      while (top < bottom && image[top][mid] == '0') {
        // System.out.format("top:%d, val:%c\n", top, image[top][mid]);
        top++;
      }
      // System.out.format("l: %d, r: %d, m: %d\n", l, r, mid);
      if (top < bottom == w2b) {
        r = mid;
      } else {
        l = mid + 1;
      }
    }
    return l;
  }

  private int searchVertical(char[][] image, int t, int b, boolean w2b) {
    int right = image[0].length;
    while (t < b) {
      int left = 0;
      int mid = t + (b - t) / 2;
      while (left < right && image[mid][left] == '0') {
        left++;
      }
      if (left < right == w2b) {
        b = mid;
      } else {
        t = mid + 1;
      }
    }
    return t;
  }
}
// @lc code=end
