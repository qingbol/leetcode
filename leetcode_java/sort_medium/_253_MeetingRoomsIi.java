/*
 * @lc app=leetcode id=253 lang=java
 *
 * [253] Meeting Rooms II
 */

// @lc code=start
class Solution {
  public int minMeetingRooms(int[][] intervals) {
    int[] starts = new int[intervals.length];
    int[] ends = new int[intervals.length];
    for (int i = 0; i < intervals.length; i++) {
      starts[i] = intervals[i][0];
      ends[i] = intervals[i][1];
    }

    Arrays.sort(starts);
    Arrays.sort(ends);

    int room = 0;
    int firstEnd = 0;
    for (int i = 0; i < intervals.length; i++) {
      if (starts[i] < ends[firstEnd]) {
        room++;
      } else {
        firstEnd++;
      }
    }

    return room;
  }
}
// @lc code=end
