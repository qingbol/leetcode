/*
 * @lc app=leetcode id=296 lang=java
 *
 * [296] Best Meeting Point
 */

// @lc code=start
class Solution {
  public int minTotalDistance(int[][] grid) {
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
}
// @lc code=end
