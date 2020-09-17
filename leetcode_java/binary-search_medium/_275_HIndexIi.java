/*
 * @lc app=leetcode id=275 lang=java
 *
 * [275] H-Index II
 */

// @lc code=start
class Solution {
  ////////////////// first round(20200120)///////////////////////////////////
  ////////////////// first round(20200120)///////////////////////////////////
  //// ----------------start(Approach1)-------------------------------------
  // 20200120

  // public int hIndex(int[] citations) {
  public int hIndex1(int[] citations) {
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
  //// ---------------- end (Approach1)-------------------------------------
  ////////////////// second round(20200915)///////////////////////////////////
  ////////////////// second round(20200915)///////////////////////////////////
  //// ----------------start(Approach2)-------------------------------------
  // 20200915.
  //just like approach1.

  // public int hIndex(int[] citations) {
  // public int hIndex2(int[] citations) {

  // }
  //// ---------------- end (Approach2)-------------------------------------
}
// @lc code=end
