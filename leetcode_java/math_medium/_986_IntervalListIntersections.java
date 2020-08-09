/*
 * @lc app=leetcode id=986 lang=java
 *
 * [986] Interval List Intersections
 */

// @lc code=start
class Solution {
  ////////////////// first round(20200705)///////////////////////////////////
  ////////////////// first round(20200705)///////////////////////////////////
  //// ----------------start(Approach1)-------------------------------
  // by myself. 20200705
  public int[][] intervalIntersection1(int[][] A, int[][] B) {
    // public int[][] intervalIntersection(int[][] A, int[][] B) {
    List<int[]> res = new ArrayList<>();
    // if (A[0][0] > B[0][0]) {
    // int start = B[0][0];
    // int end = B[0][1];
    // } else {
    // int start = A[0][0];
    // int end = A[0][1];
    // }

    int len = Math.min(A.length, B.length);
    int preEnd = -1;
    for (int i = 0; i < len; i++) {
      int startMax = Math.max(A[i][0], B[i][0]);
      int startMin = Math.min(A[i][0], B[i][0]);
      int endMin = Math.min(A[i][1], B[i][1]);
      if (preEnd >= startMin) {
        res.add(new int[] {startMin, preEnd});
      }
      preEnd = Math.max(A[i][1], B[i][1]);
      res.add(new int[] {startMax, endMin});
    }

    return res.toArray(new int[][] {});
  }

  //// ---------------- end (Approach1)-------------------------------
  //// ----------------start(Approach2)-------------------------------
  // by myself. 20200705
  // 86/86 cases passed (2 ms)
  // Your runtime beats 99.73 % of java submissions

  // public int[][] intervalIntersection(int[][] A, int[][] B) {
  public int[][] intervalIntersection2(int[][] A, int[][] B) {
    // checking boundary condition
    if (A == null || A.length == 0 || B == null || B.length == 0) {
      return new int[][] {};
    }

    int i = 0, j = 0;
    List<int[]> res = new ArrayList<>();
    while (i < A.length && j < B.length) {
      if (isOverlap(A[i], B[j])) {
        int start = Math.max(A[i][0], B[j][0]);
        int end = Math.min(A[i][1], B[j][1]);
        res.add(new int[] {start, end});
        // if (A[i][1] >= B[j][1]) {
        // j++;
        // } else {
        // i++;
        // }
        // } else {
      }
      if (A[i][1] >= B[j][1]) {
        j++;
      } else {
        i++;
      }
    }
    return res.toArray(new int[][] {});
  }

  private boolean isOverlap(int[] arr1, int[] arr2) {
    // int start = Math.max(arr1[0], arr2[0]);
    // int end = Math.min(arr1[1], arr2[1]);
    if (arr1[0] > arr2[1] || arr2[0] > arr1[1]) {
      return false;
    } else {
      return true;
    }
  }

  //// ---------------- end (Approach2)-------------------------------
  ////////////////// second round(20200806)///////////////////////////////////
  ////////////////// second round(20200806)///////////////////////////////////
  //// ----------------start(Approach3)-------------------------------
  // 20200806, by myself.

  // 86/86 cases passed (2 ms)
  // Your runtime beats 99.87 % of java submissions
  // Your memory usage beats 25.91 % of java submissions (40.4 MB)

  public int[][] intervalIntersection(int[][] A, int[][] B) {
    // public int[][] intervalIntersection3(int[][] A, int[][] B) {
    int n1 = A.length;
    int n2 = B.length;
    int i = 0, j = 0;
    List<int[]> res = new ArrayList<>();
    while (i < n1 && j < n2) {
      if (isOverlap3(A[i], B[j])) {
        res.add(new int[] {Math.max(A[i][0], B[j][0]), Math.min(A[i][1], B[j][1])});
      }

      if (A[i][1] >= B[j][1]) {
        j++;
      } else {
        i++;
      }
    }
    return res.toArray(new int[][] {});
    // return res.size() == 0 ? new int[][]{} : res.toArray(new int[][]{});
  }

  private boolean isOverlap3(int[] x, int[] y) {
    return x[0] <= y[1] && x[1] >= y[0];
  }
  //// ---------------- end (Approach3)-------------------------------
}
// @lc code=end
