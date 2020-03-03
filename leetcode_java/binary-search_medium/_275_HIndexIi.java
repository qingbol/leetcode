/*
 * @lc app=leetcode id=275 lang=java
 *
 * [275] H-Index II
 */

// @lc code=start
class Solution {
  public int hIndex(int[] citations) {
    int lo = 0;
    int hi = citations.length - 1;
    int res = 0;
    while (lo <= hi) {
      int mid = lo + (hi - lo) / 2;
      if (citations[mid] >= citations.length - mid) {
        res = Math.max(res, citations.length - mid);
        hi = mid - 1;
      } else {
        lo = mid + 1;
      }
    }
    return res;
  }
}
// @lc code=end
