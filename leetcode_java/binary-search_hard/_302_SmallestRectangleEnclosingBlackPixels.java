/*
 * @lc app=leetcode id=302 lang=java
 *
 * [302] Smallest Rectangle Enclosing Black Pixels
 */

// @lc code=start
class Solution {
  ////////////////// first round(20200122)///////////////////////////////////
  ////////////////// first round(20200122)///////////////////////////////////
  //// ----------------start(Approach1)------------------------------------
  // 20200122.
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

  //// :------------------ end (Approach1)----------------------------------
  //// :------------------start(Approach2)----------------------------------
  // Approach2: binary searchd

  public int minArea2(char[][] image, int x, int y) {
    // public int minArea(char[][] image, int x, int y) {
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
  //// :------------------ end (Approach2)----------------------------------
  ////////////////// second round(20200917)///////////////////////////////////
  ////////////////// second round(20200917)///////////////////////////////////
  //// :------------------start(Approach3)----------------------------------
  // 20200917.
  // i can only figure out approach1, approach2 is too tricky. the only way to master this method is
  //// to remember it

  // 111/111 cases passed (0 ms)
  // Your runtime beats 100 % of java submissions
  // Your memory usage beats 56.73 % of java submissions (40.2 MB)

  // public int minArea3(char[][] image, int x, int y) {
  public int minArea(char[][] image, int x, int y) {
    int m = image.length, n = image[0].length;
    int left = findLeftBoundInRow(image, 0, y);
    int right = findRightBoundInRow(image, y + 1, n);
    int top = findLeftBoundInCol(image, 0, x);
    int bottom = findRightBoundInCol(image, x + 1, m);
    // System.out.format("left: %d, right: %d, top: %d, bot: %d\n", left, right, top, bottom);
    return (right + 1 - left) * (bottom + 1 - top);
    // return (right - left) * (bottom - top);
  }

  private int findLeftBoundInRow(char[][] image, int lo, int hi) {
    while (lo < hi) {
      int mid = lo + (hi - lo) / 2;
      // System.out.format("mid: %d, isBlack: %b\n", mid, isBlackInCol(image,mid));
      if (isBlackInCol(image, mid)) {
        hi = mid;
      } else {
        lo = mid + 1;
      }
    }
    return lo;
  }

  private int findRightBoundInRow(char[][] image, int lo, int hi) {
    while (lo < hi) {
      int mid = lo + (hi - lo) / 2;
      if (isBlackInCol(image, mid)) {
        lo = mid + 1;
      } else {
        hi = mid;
      }
    }
    return lo - 1;
  }

  private int findLeftBoundInCol(char[][] image, int lo, int hi) {
    while (lo < hi) {
      int mid = lo + (hi - lo) / 2;
      if (isBlackInRow(image, mid)) {
        hi = mid;
      } else {
        lo = mid + 1;
      }
    }
    return lo;
  }

  private int findRightBoundInCol(char[][] image, int lo, int hi) {
    while (lo < hi) {
      int mid = lo + (hi - lo) / 2;
      if (isBlackInRow(image, mid)) {
        lo = mid + 1;
      } else {
        hi = mid;
      }
    }
    return lo - 1;
  }

  private boolean isBlackInCol(char[][] image, int mid) {
    for (int i = 0; i < image.length; i++) {
      if (image[i][mid] == '1') {
        return true;
      }
    }
    return false;
  }

  private boolean isBlackInRow(char[][] image, int mid) {
    for (int j = 0; j < image[0].length; j++) {
      if (image[mid][j] == '1') {
        return true;
      }
    }
    return false;
  }

  //// :------------------ end (Approach3)----------------------------------
}
// @lc code=end
