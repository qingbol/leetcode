/*
 * @lc app=leetcode id=435 lang=java
 *
 * [435] Non-overlapping Intervals
 */

// @lc code=start
class Solution {
  public int eraseOverlapIntervals(int[][] intervals) {
    if (intervals == null || intervals.length == 0) {
      return 0;
    }
    int n = intervals.length;
    Arrays.sort(intervals, (a, b) -> a[1] - b[1]);

    int earliestEnd = intervals[0][1];
    int cnt = 1;
    for (int[] interval : intervals) {
      if (interval[0] >= earliestEnd) {
        cnt++;
        earliestEnd = interval[1];
      }
    }

    return n - cnt;
  }
}
// @lc code=end
