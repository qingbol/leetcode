/*
 * @lc app=leetcode id=56 lang=java
 *
 * [56] Merge Intervals
 */

// @lc code=start
class Solution {
  // ------------start(Approach 1)------------------------------------------
  public int[][] merge1(int[][] intervals) {
    if (null == intervals || 0 == intervals.length) {
      return null;
    }
    int idx = 0;
    int len = intervals.length;
    List<int[]> lst = new ArrayList<>();
    int[] tmp = intervals[idx].clone();
    while (idx < len) {
      while (idx < len && intervals[idx][1] < intervals[idx + 1][0]) {
        lst.add(intervals[idx++]);
      }
      tmp = intervals[idx].clone();
      while (idx < len && tmp[1] >= intervals[idx + 1][0]) {
        tmp[0] = Math.min(tmp[0], intervals[idx][0]);
        tmp[1] = Math.min(tmp[1], intervals[idx][1]);
      }
      lst.add(tmp);
      idx++;
    }
    return lst.toArray(new int[lst.size()][]);
  }

  // ------------ end (Approach 1)------------------------------------------
  // ------------start(Approach 2)------------------------------------------
  //
  public int[][] merge2(int[][] intervals) {
    if (null == intervals || intervals.length < 2) {
      return intervals;
    }
    int len = intervals.length;
    Arrays.sort(intervals, new Comparator<int[]>() {
      public int compare(int[] a, int[] b) {
        return a[0] - b[0];
      }
    });
    // System.out.println("Array after sort: " + Arrays.deepToString(intervals));
    List<int[]> lst = new ArrayList<>();
    int[] tmp = intervals[0].clone();
    for (int i = 1; i < len; i++) {
      if (tmp[1] >= intervals[i][0]) {
        tmp[1] = Math.max(tmp[1], intervals[i][1]);
      } else {
        lst.add(tmp.clone());
        tmp[0] = intervals[i][0];
        tmp[1] = intervals[i][1];
      }
    }
    lst.add(tmp.clone());
    return lst.toArray(new int[lst.size()][2]);
  }

  // ------------ end (Approach 2)------------------------------------------
  // ------------start(Approach 3)------------------------------------------
  // optimal
  public int[][] merge(int[][] intervals) {
    if (null == intervals || 0 == intervals.length) {
      return new int[][] {};
    }
    // sort intervals first
    Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
    // create a list to collect the result
    List<int[]> res = new ArrayList<>();
    // initial value
    int start = intervals[0][0];
    int end = intervals[0][1];

    // traverse the interval to merge
    for (int[] interval : intervals) {
      if (interval[0] <= end) {
        end = Math.max(end, interval[1]);
      } else {
        res.add(new int[] { start, end });
        start = interval[0];
        end = interval[1];
      }
    }
    res.add(new int[] { start, end });

    return res.toArray(new int[][] {});
  }

  // ------------ end (Approach 3)------------------------------------------
}
// @lc code=end
