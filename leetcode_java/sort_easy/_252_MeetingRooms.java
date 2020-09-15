/*
 * @lc app=leetcode id=252 lang=java
 *
 * [252] Meeting Rooms
 */

// @lc code=start
class Solution {
  ////////////////// first round(20200110)///////////////////////////////////
  ////////////////// first round(20200110)///////////////////////////////////
  // ------------start(Approach 1)------------------------------------------
  // 20200110

  // public boolean canAttendMeetings(int[][] intervals) {
  public boolean canAttendMeetings1(int[][] intervals) {
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
  // ------------ end (Approach 1)------------------------------------------
  ////////////////// second round(20200909)///////////////////////////////////
  ////////////////// second round(20200909)///////////////////////////////////
  // ------------start(Approach 2)------------------------------------------
  // 20200909

  // 77/77 cases passed (4 ms)
  // Your runtime beats 95.93 % of java submissions
  // Your memory usage beats 74.17 % of java submissions (39.3 MB)

  public boolean canAttendMeetings(int[][] intervals) {
    // public boolean canAttendMeetings2(int[][] intervals) {
    int n = intervals.length;
    if (n == 0)
      return true;
    Arrays.sort(intervals, (a, b) -> a[1] - b[1]);
    int end = intervals[0][1];
    for (int i = 1; i < n; i++) {
      if (end > intervals[i][0]) {
        // end = Math.max(end, intervals[i][1]);
        return false;
      } else {
        end = intervals[i][1];
      }
    }
    return true;
  }
  // ------------ end (Approach 2)------------------------------------------
}
// @lc code=end
