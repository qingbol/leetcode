/*
 * @lc app=leetcode id=57 lang=java
 *
 * [57] Insert Interval
 */

// @lc code=start
class Solution {
  public int[][] insert1(int[][] intervals, int[] newInterval) {
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

  public int[][] insert(int[][] intervals, int[] newInterval) {
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
}
// @lc code=end
