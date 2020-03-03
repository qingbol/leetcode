/*
 * @lc app=leetcode id=278 lang=java
 *
 * [278] First Bad Version
 */

// @lc code=start
/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
  // left <= right
  public int firstBadVersion1(int n) {
    int lo = 1;
    int hi = n;
    while (lo <= hi) {
      int mid = lo + (hi - lo) / 2;
      boolean isBad = isBadVersion(mid);
      if (isBad) {
        hi = mid - 1;
      } else if (!isBad) {
        lo = mid + 1;
      }
    }
    return lo;
  }

  // left < right
  public int firstBadVersion(int n) {
    int lo = 1;
    int hi = n;
    while (lo < hi) {
      int mid = lo + (hi - lo) / 2;
      boolean isBad = isBadVersion(mid);
      if (isBad) {
        hi = mid;
      } else {
        lo = mid + 1;
      }
    }
    return lo;
  }

  // left + 1 < right
  public int firstBadVersion3(int n) {
    int lo = 1;
    int hi = n;
    while (lo + 1 < hi) {
      int mid = lo + (hi - lo) / 2;
      if (isBadVersion(mid)) {
        hi = mid;
      } else {
        lo = mid;
      }
    }
    if (isBadVersion(lo)) {
      return lo;
    } else {
      return hi;
    }
  }
}
// @lc code=end
