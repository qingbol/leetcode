/*
 * @lc app=leetcode id=253 lang=java
 *
 * [253] Meeting Rooms II
 */

// @lc code=start
class Solution {
  ////////////////// first round(20200110)///////////////////////////////////
  ////////////////// first round(20200110)///////////////////////////////////
  // ------------start(Approach 1)------------------------------------------
  // 20200110
  // refer to leetcode:Approach 2: Chronological Ordering

  // public int minMeetingRooms(int[][] intervals) {
  public int minMeetingRooms1(int[][] intervals) {
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
  // ------------ end (Approach 1)------------------------------------------
  ////////////////// second round(20200909)///////////////////////////////////
  ////////////////// second round(20200909)///////////////////////////////////
  // ------------start(Approach 2)------------------------------------------
  // 20200909, by myself.
  // wrong

  // public int minMeetingRooms(int[][] intervals) {
  public int minMeetingRooms2(int[][] intervals) {
    int n = intervals.length;
    if (n == 0)
      return 0;
    // Arrays.sort(intervals, (a, b) -> a[1] - b[1]);
    // Arrays.sort(intervals, (a, b) -> a[1] == b[1] ? a[0] - b[0] : a[1] - b[1]);
    Arrays.sort(intervals, (a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
    int end = intervals[0][1];
    int res = 1;
    int room = 1;

    for (int i = 1; i < n; i++) {
      if (end > intervals[i][0]) {
        // end = Math.max(end, intervals[i][1]);
        room++;
      } else {
        end = intervals[i][1];
        res = Math.max(res, room);
        room = 1;
      }
    }
    res = Math.max(res, room);

    return res;
  }
  // ------------ end (Approach 2)------------------------------------------
  // ------------start(Approach 3)------------------------------------------
  // 20200909,
  // refer to leetcode:Approach 1: Priority Queues

  // 78/78 cases passed (6 ms)
  // Your runtime beats 76.45 % of java submissions
  // Your memory usage beats 54.91 % of java submissions (39.6 MB)

  public int minMeetingRooms(int[][] intervals) {
    // public int minMeetingRooms3(int[][] intervals) {
    int n = intervals.length;
    if (n == 0)
      return 0;
    Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
    PriorityQueue<Integer> pq = new PriorityQueue<>();
    // 1. initialize the pq.
    pq.offer(intervals[0][1]);
    int room = 1;
    // 2. iterate
    for (int i = 1; i < n; i++) {
      if (pq.peek() <= intervals[i][0]) {
        pq.poll();
      } else {
        room++;
      }
      pq.offer(intervals[i][1]);
    }
    return room;
  }
  // ------------ end (Approach 3)------------------------------------------
}
// @lc code=end
