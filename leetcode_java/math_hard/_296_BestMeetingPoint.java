/*
 * @lc app=leetcode id=296 lang=java
 *
 * [296] Best Meeting Point
 */

// @lc code=start
class Solution {
  ////////////////// first round(20200116)///////////////////////////////////
  ////////////////// first round(20200116)///////////////////////////////////
  //// ----------------start(Approach1)-------------------------------------
  // 20200116

  // You can calculate the distance without knowing the median using a two pointer approach. This
  // neat approach is inspired by [@larrywang2014's
  // solution](https://leetcode.com/discuss/65336/14ms-java-solution).

  // public int minTotalDistance(int[][] grid) {
  public int minTotalDistance1(int[][] grid) {
    List<Integer> listX = new ArrayList<>();
    List<Integer> listY = new ArrayList<>();

    int m = grid.length;
    int n = grid[0].length;
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (1 == grid[i][j]) {
          listY.add(i);
        }
      }
    }
    for (int j = 0; j < n; j++) {
      for (int i = 0; i < m; i++) {
        if (1 == grid[i][j]) {
          listX.add(j);
        }
      }
    }

    int sum = 0;
    sum = sumAll(listX, sum);
    sum = sumAll(listY, sum);
    return sum;
  }

  private int sumAll(List<Integer> list, int sum) {
    int start = 0;
    int end = list.size() - 1;
    while (start < end) {
      sum += (list.get(end--) - list.get(start++));
    }
    return sum;
  }
  //// ---------------- end (Approach1)-------------------------------------
  ////////////////// second round(20200911)///////////////////////////////////
  ////////////////// second round(20200911)///////////////////////////////////
  //// ----------------start(Approach2)-------------------------------------
  // 20200911
  // refer to Approach #3 (Sorting) [Accepted]
  // Approach #4 (Collect Coordinates in Sorted Order) [Accepted]

  // 57/57 cases passed (5 ms)
  // Your runtime beats 66.3 % of java submissions
  // Your memory usage beats 94.02 % of java submissions (38.8 MB)

  public int minTotalDistance(int[][] grid) {
    // public int minTotalDistance2(int[][] grid) {
    int m = grid.length;
    int n = grid[0].length;
    List<Integer> rows = new ArrayList<>();
    List<Integer> cols = new ArrayList<>();
    // 1. collect valid home in sorted order
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (grid[i][j] == 1) {
          rows.add(i);
          cols.add(j);
        }
      }
    }
    Collections.sort(cols);

    // 2. cal the shortest distance
    return calDistance(rows) + calDistance(cols);
  }

  private int calDistance(List<Integer> lst) {
    int lo = 0, hi = lst.size() - 1;
    int sum = 0;
    while (lo < hi) {
      sum += lst.get(hi--) - lst.get(lo++);
    }
    return sum;
  }
  //// ---------------- end (Approach2)-------------------------------------
}
// @lc code=end
