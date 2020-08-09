/*
 * @lc app=leetcode id=435 lang=java
 *
 * [435] Non-overlapping Intervals
 */

// @lc code=start
class Solution {
  ////////////////// first round(20200402)///////////////////////////////////
  ////////////////// first round(20200402)///////////////////////////////////
  //// ----------------start(Approach1)-------------------------------------
  // 20200402, optimal
  //refer to labuladong <贪心算法之区间调度问题>

  // public int eraseOverlapIntervals(int[][] intervals) {
  public int eraseOverlapIntervals1(int[][] intervals) {
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

  //// ---------------- end (Approach1)-------------------------------------
  //// ----------------start(Approach1)-------------------------------------
  // 20200806, part by myself
  //refer to labuladong <贪心算法之区间调度问题>

  // 18/18 cases passed (3 ms)
  // Your runtime beats 69.73 % of java submissions
  // Your memory usage beats 14.78 % of java submissions (39.8 MB)

  public int eraseOverlapIntervals(int[][] intervals) {
    // public int eraseOverlapIntervals2(int[][] intervals) {
    int n = intervals.length;
    if (n == 0)
      return 0;
    Arrays.sort(intervals, (a, b) -> a[1] - b[1]);
    int[] cur = new int[] {intervals[0][0], intervals[0][1]};
    int res = 1;
    for (int i = 1; i < n; i++) {
      if (intervals[i][0] >= cur[1]) {
        res++;
        cur[0] = intervals[i][0];
        cur[1] = intervals[i][1];
        // } else {
        // cur[1] = Math.max(cur[1], intervals[i][1]);
      }
    }
    return n - res;
  }
  //// ---------------- end (Approach1)-------------------------------------
}
// @lc code=end
