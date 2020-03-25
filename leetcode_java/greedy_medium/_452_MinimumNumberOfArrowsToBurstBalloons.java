/*
 * @lc app=leetcode id=452 lang=java
 *
 * [452] Minimum Number of Arrows to Burst Balloons
 */

// @lc code=start
class Solution {
  //// ------------------start(Approach1)-------------------------
  // 20200323, by myself
  // greedy. sort the input array by start.
  public int findMinArrowShots1(int[][] points) {
    if (points == null || points.length == 0) {
      return 0;
    }
    Arrays.sort(points, (a, b) -> a[0] - b[0]);
    // System.out.format("points:\n%s\n", Arrays.deepToString(points).replace("],",
    // "]\n"));

    // int[] curPoint = points[0];
    int numArrow = 1;
    // The leftmost end in current group
    int leftmostEnd = points[0][1];
    for (int[] point : points) {
      if (leftmostEnd < point[0]) {
        numArrow++;
        // curPoint = point;
        leftmostEnd = point[1];
      } else {
        leftmostEnd = Math.min(leftmostEnd, point[1]);
      }
    }
    // System.out.format("num:%d\n", numArrow);
    return numArrow;
  }

  //// ------------------ end (Approach1)-------------------------
  //// ------------------start(Approach1)-------------------------
  // 20200323, by myself
  // greedy. sort the input array by start.
  public int findMinArrowShots(int[][] points) {
    if (points == null || points.length == 0) {
      return 0;
    }
    Arrays.sort(points, (a, b) -> a[1] - b[1]);

    int leftmostEndInCurrentGroup = points[0][1];
    int res = 1;
    for (int[] point : points) {
      if (point[0] > leftmostEndInCurrentGroup) {
        res++;
        leftmostEndInCurrentGroup = point[1];
      }
    }
    return res;
  }
  //// ------------------ end (Approach1)-------------------------
}
// @lc code=end
