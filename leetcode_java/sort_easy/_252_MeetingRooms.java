/*
 * @lc app=leetcode id=252 lang=java
 *
 * [252] Meeting Rooms
 */

// @lc code=start
class Solution {
  public boolean canAttendMeetings(int[][] intervals) {
    Arrays.sort(intervals, new Comparator<int[]>() {
      public int compare(int[] a, int[] b) {
        return a[0] - b[0];
      }
    });
    // System.out.println("intervals after sort: " +
    // Arrays.deepToString(intervals));

    for (int i = 0; i < intervals.length - 1; i++) {
      if (intervals[i][1] > intervals[i + 1][0]) {
        return false;
      }
    }
    return true;
  }
}
// @lc code=end
