/*
 * @lc app=leetcode id=352 lang=java
 *
 * [352] Data Stream as Disjoint Intervals
 */

// @lc code=start
////////////////// first round(20200909)///////////////////////////////////
////////////////// first round(20200909)///////////////////////////////////
// ------------start(Approach 1)------------------------------------------
// 20200909, by myself.

// Time Limit Exceeded
// 7/9 cases passed (N/A)

class SummaryRanges1 {
  // public class SummaryRanges {
  List<Integer> nums;

  /** Initialize your data structure here. */
  // public SummaryRanges() {
  public SummaryRanges1() {
    nums = new ArrayList<>();
  }

  public void addNum(int val) {
    nums.add(val);
  }

  public int[][] getIntervals() {
    int n = nums.size();
    List<int[]> intervals = new ArrayList<>();
    Collections.sort(nums);
    int l = 0, r = 0;
    while (r < n) {
      while (r < n - 1 && (nums.get(r) + 1 == nums.get(r + 1) || nums.get(r) == nums.get(r + 1)))
        r++;
      intervals.add(new int[] {nums.get(l), nums.get(r)});
      r++;
      l = r;
    }
    return intervals.toArray(new int[][] {});
  }

}
// ------------ end (Approach 1)------------------------------------------
// ------------start(Approach 2)------------------------------------------
// 20200909, awesome approach.
// refer to
// https://leetcode.com/problems/data-stream-as-disjoint-intervals/discuss/82553/Java-solution-using-TreeMap-real-O(logN)-per-adding.
// https://leetcode.com/problems/data-stream-as-disjoint-intervals/discuss/82553/Java-solution-using-TreeMap-real-O(logN)-per-adding./282387

// 9/9 cases passed (66 ms)
// Your runtime beats 75.32 % of java submissions
// Your memory usage beats 83.05 % of java submissions (44.7 MB)


// class SummaryRanges2 {
public class SummaryRanges {
  TreeMap<Integer, int[]> map;

  /** Initialize your data structure here. */
  public SummaryRanges() {
    // public SummaryRanges2() {
    map = new TreeMap<>();
  }

  public void addNum(int val) {
    if (map.containsKey(val))
      return;
    Integer l = map.lowerKey(val);
    Integer h = map.higherKey(val);

    if (l != null && h != null && map.get(l)[1] + 1 == val && h == val + 1) {
      map.get(l)[1] = map.get(h)[1];
      map.remove(h);
    } else if (l != null && map.get(l)[1] + 1 >= val) {
      map.get(l)[1] = Math.max(map.get(l)[1], val);
    } else if (h != null && val + 1 == h) {
      map.put(val, new int[] {val, map.get(h)[1]});
      map.remove(h);
    } else {
      map.put(val, new int[] {val, val});
    }
  }

  public int[][] getIntervals() {
    return map.values().toArray(new int[][] {});
  }

}

// ------------ end (Approach 2)------------------------------------------

/**
 * Your SummaryRanges object will be instantiated and called as such: SummaryRanges obj = new
 * SummaryRanges(); obj.addNum(val); int[][] param_2 = obj.getIntervals();
 */
// @lc code=end

