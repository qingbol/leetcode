/*
 * @lc app=leetcode id=278 lang=java
 *
 * [278] First Bad Version
 */

// @lc code=start
/*
 * The isBadVersion API is defined in the parent class VersionControl. boolean isBadVersion(int
 * version);
 */

public class Solution extends VersionControl {
  ////////////////// first round(20200119)///////////////////////////////////
  ////////////////// first round(20200119)///////////////////////////////////
  //// ----------------start(Approach1)-------------------------------------
  // 20200119
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

  //// ---------------- end (Approach1)-------------------------------------
  //// ----------------start(Approach2)-------------------------------------
  // left < right
  // public int firstBadVersion(int n) {
  public int firstBadVersion2(int n) {
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

  //// ---------------- end (Approach2)-------------------------------------
  //// ----------------start(Approach3)-------------------------------------
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
  //// ---------------- end (Approach3)-------------------------------------
  ////////////////// second round(20200915)///////////////////////////////////
  ////////////////// second round(20200915)///////////////////////////////////
  //// ----------------start(Approach4)-------------------------------------
  // 20200915. by myself
  // search the left bound. [lo, hi]

  // over flow
  // 21/22 cases passed (N/A)
  // Testcase
  // 2147483647
  // 2147483647

  // public int firstBadVersion(int n) {
  public int firstBadVersion4(int n) {
    int lo = 1, hi = n + 1;
    while (lo < hi) {
      int mid = lo + (hi - lo) / 2;
      if (isBadVersion(mid)) {
        hi = mid;
      } else {
        lo = mid + 1;
      }
    }

    return lo;
  }
  //// ---------------- end (Approach4)-------------------------------------
  //// ----------------start(Approach5)-------------------------------------
  // 20200915. by myself
  // search the left bound. [lo, hi)

  // 22/22 cases passed (12 ms)
  // Your runtime beats 99.36 % of java submissions
  // Your memory usage beats 54.25 % of java submissions (36.3 MB)

  public int firstBadVersion(int n) {
    // public int firstBadVersion5(int n) {
    int lo = 1, hi = n;
    while (lo <= hi) {
      int mid = lo + (hi - lo) / 2;
      if (isBadVersion(mid)) {
        hi = mid - 1;
      } else {
        lo = mid + 1;
      }
    }

    return lo;
    // if (isBadVersion(hi)) {
    // return hi;
    // } else {
    // return lo;
    // // return hi + 1;
    // }
  }
  //// ---------------- end (Approach5)-------------------------------------
}
// @lc code=end
