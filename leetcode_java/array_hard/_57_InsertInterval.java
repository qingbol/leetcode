/*
 * @lc app=leetcode id=57 lang=java
 *
 * [57] Insert Interval
 */

// @lc code=start
class Solution {
  ////////////////// first round(20200112)///////////////////////////////////
  ////////////////// first round(20200112)///////////////////////////////////
  //// ---------------------------start(Approach1)-----------------------
  // 20200112

  public int[][] insert1(int[][] intervals, int[] newInterval) {
    // public int[][] insert(int[][] intervals, int[] newInterval) {
    // if (null == intervals || 0 == intervals.length) {
    // return newInterval;
    // }
    int size = intervals.length;
    int left = binarySearch(intervals, 0, size, newInterval[0]);
    int right = binarySearch(intervals, 0, size, newInterval[1]);
    System.out.println(left + " " + right);

    int len = left + 1;
    intervals[left++][1] = Math.max(intervals[right][1], newInterval[1]);
    int idx = right + 1;
    // System.out.println(idx);
    for (int i = left; i <= right; i++) {
      if (idx < size) {
        // System.out.println(idx);
        // System.out.println(left);
        intervals[i][0] = intervals[idx][0];
        intervals[i][1] = intervals[idx][1];
        len++;
        idx++;
      } else {
        intervals[i] = null;
      }
    }

    while (idx < size) {
      len++;
      idx++;
    }
    // System.out.println(len);
    int[][] tmp = new int[len][2];
    for (int i = 0; i < len; i++) {
      for (int j = 0; j < 2; j++) {
        tmp[i][j] = intervals[i][j];
      }
    }

    return tmp;
  }

  private int binarySearch(int[][] arrs, int start, int end, int val) {
    int low = start;
    int high = end;
    int mid = 0;
    int index = -1;
    // System.out.println("-----binary serach---------");
    while (low < high) {
      // System.out.println("-----binary serach---------");
      mid = (high - low) / 2 + low;
      if (arrs[mid][0] == val) {
        return mid;
      } else if (arrs[mid][0] > val) {
        high = mid - 1;
        binarySearch(arrs, low, high, val);
      } else if (arrs[mid][0] < val) {
        low = mid + 1;
        binarySearch(arrs, low, high, val);
      }
    }
    return low;
  }

  //// --------------------------- end (Approach1)-----------------------
  //// ---------------------------start(Approach2)-----------------------
  //optimal

  // public int[][] insert(int[][] intervals, int[] newInterval) {
  public int[][] insert2(int[][] intervals, int[] newInterval) {
    List<int[]> lst = new ArrayList<>();

    int idx = 0;
    int len = intervals.length;
    // int[] tmp = new int[2];
    int[] tmp = newInterval.clone();
    while (idx < len && intervals[idx][1] < newInterval[0]) {
      lst.add(intervals[idx++]);
    }
    // System.out.println(Arrays.deepToString(lst.toArray()));
    // System.out.format(intervals[idx][0] + " " + newInterval[1]);
    while (idx < len && intervals[idx][0] <= newInterval[1]) {
      tmp[0] = Math.min(intervals[idx][0], tmp[0]);
      tmp[1] = Math.max(intervals[idx][1], tmp[1]);
      idx++;
      // System.out.println(Arrays.toString(tmp));
    }
    // System.out.println(Arrays.toString(tmp));
    lst.add(tmp);
    while (idx < len) {
      lst.add(intervals[idx++]);
    }
    // System.out.println(Arrays.deepToString(lst.toArray()));
    return lst.toArray(new int[lst.size()][2]);
  }
  //// --------------------------- end (Approach2)-----------------------
  ////////////////// second round(20200908)///////////////////////////////////
  ////////////////// second round(20200908)///////////////////////////////////
  //// ---------------------------start(Approach3)-----------------------
  // 20200908

  // Wrong Answer
  // 102/154 cases passed (N/A)
  // Testcase
  // [[1,3],[6,9]]
  // [2,5]
  // Answer
  // [[6,9],[1,5]]
  // Expected Answer
  // [[1,5],[6,9]]

  //Analysis: the order in the result matters, so I have to split the process to 3 parts. like approach2.

  // public int[][] insert3(int[][] intervals, int[] newInterval) {
  public int[][] insert(int[][] intervals, int[] newInterval) {
    List<List<Integer>> res = new ArrayList<>();
    for (int[] interval : intervals) {
      if (isOverlap3(interval, newInterval)) {
        newInterval[0] = Math.min(interval[0], newInterval[0]);
        newInterval[1] = Math.max(interval[1], newInterval[1]);
      } else {
        List<Integer> cur = new ArrayList<>();
        cur.add(interval[0]);
        cur.add(interval[1]);
        res.add(cur);
      }
    }

    List<Integer> cur = new ArrayList<>();
    cur.add(newInterval[0]);
    cur.add(newInterval[1]);
    res.add(cur);

    // System.out.format("res: %s\n", res);
    int[][] ret = new int[res.size()][2];
    for (int i = 0; i < res.size(); i++) {
      for (int j = 0; j < 2; j++) {
        ret[i][j] = res.get(i).get(j);
      }
    }

    return ret;
    // return res.toArray(new int[res.size()][2]);
  }

  private boolean isOverlap3(int[] a, int[] b) {
    if (a[1] >= b[0] && b[1] >= a[0]) {
      // if (a[1] >= b[0] || b[1] >= a[0]) {
      return true;
    }
    return false;
  }

  //// --------------------------- end (Approach3)-----------------------
}
// @lc code=end
