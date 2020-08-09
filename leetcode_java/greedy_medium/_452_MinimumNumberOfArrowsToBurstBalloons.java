/*
 * @lc app=leetcode id=452 lang=java
 *
 * 
 */

// @lc code=start
class Solution {
  ////////////////// first round(20200323)///////////////////////////////////
  ////////////////// first round(20200323)///////////////////////////////////
  //// ------------------start(Approach1)-------------------------
  // 20200323, by myself
  // greedy. sort the input array by start.
  // Your runtime beats 41.04 % of java submissions
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
  //// ------------------start(Approach2)-------------------------
  // 20200323, by myself
  // greedy. sort the input array by start.
  //refer to labuladong <贪心算法之区间调度问题>

  // Your runtime beats 98.04 % of java submissions
  // public int findMinArrowShots(int[][] points) {
  public int findMinArrowShots2(int[][] points) {
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

  //// ------------------ end (Approach2)-------------------------
  ////////////////// second round(20200806)///////////////////////////////////
  ////////////////// second round(20200806)///////////////////////////////////
  //// ------------------start(Approach3)-------------------------
  // 20200323, by myself
  // greedy. sort the input array by start.
  //refer to labuladong <贪心算法之区间调度问题>

//   43/43 cases passed (21 ms)
// Your runtime beats 53.36 % of java submissions
// Your memory usage beats 31.52 % of java submissions (47.2 MB)

  public int findMinArrowShots(int[][] points) {
    if (points == null || points.length == 0)
      return 0;
    Arrays.sort(points, (a, b) -> a[1] - b[1]);

    int earliestEnd = points[0][1];
    int res = 1;
    for (int[] point : points) {
      if (point[0] > earliestEnd) {
        res++;
        earliestEnd = point[1];
      }
    }
    return res;
  }
  //// ------------------ end (Approach3)-------------------------
}
// @lc code=end
