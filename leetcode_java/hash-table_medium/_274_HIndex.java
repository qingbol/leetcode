import java.util.Collections;

/*
 * @lc app=leetcode id=274 lang=java
 *
 * [274] H-Index
 */

// @lc code=start
class Solution {
  ////////////////// first round(20200115)///////////////////////////////////
  ////////////////// first round(20200115)///////////////////////////////////
  //// ----------------start(Approach1)-------------------------------------
  // 20200115
  // refer to leetcode: Approach #1 (Sorting) [Accepted]

  public int hIndex1(int[] citations) {
    Integer[] sorted = new Integer[citations.length];
    int cnt = 0;
    for (int val : citations) {
      // sorted[cnt++] = new Integer(val);
      sorted[cnt++] = Integer.valueOf(val);
    }
    // Arrays.sort(citations);
    // Arrays.sort(citations, (a, b) -> b.compareTo(a));
    // final Integer[] sorted = ArrayUtils.toObject(citations);
    Arrays.sort(sorted, Collections.reverseOrder());
    // System.out.println(Arrays.toString(sorted));
    int res = 0;
    for (int i = 0; i < citations.length; i++) {
      if (sorted[i] >= i + 1) {
        res = Math.max(res, i + 1);
      }
    }
    return res;
  }

  //// ---------------- end (Approach1)-------------------------------------
  //// ----------------start(Approach2)-------------------------------------
  //
  // refer to leetcode: Approach #1 (Sorting) [Accepted]
  public int hIndex2(int[] citations) {
    Arrays.sort(citations);
    int res = 0;
    for (int i = 0; i < citations.length; i++) {
      if (citations[citations.length - 1 - i] > i) {
        res = i + 1;
      } else {
        break;
      }
    }
    return res;
  }

  //// ---------------- end (Approach2)-------------------------------------
  //// ----------------start(Approach3)-------------------------------------
  //
  // public int hIndex(int[] citations) {
  public int hIndex3(int[] citations) {
    int[] helper = new int[citations.length + 1];
    for (int i = 0; i < citations.length; i++) {
      helper[citations[i] <= citations.length ? citations[i] : citations.length] += 1;
    }
    int sum = 0;
    for (int i = citations.length; i >= 0; i--) {
      sum += helper[i];
      if (sum >= i) {
        return i;
      }
    }
    return 0;
  }
  //// ---------------- end (Approach3)-------------------------------------
  ////////////////// second round(20200911)///////////////////////////////////
  ////////////////// second round(20200911)///////////////////////////////////
  //// ----------------start(Approach4)-------------------------------------
  // 20200911, can't solve it by myself.
  // refer to leetcode: Approach #1 (Sorting) [Accepted]

  // 82/82 cases passed (1 ms)
  // Your runtime beats 39.62 % of java submissions
  // Your memory usage beats 36.75 % of java submissions (37.5 MB)

  public int hIndex4(int[] citations) {
    // public int hIndex(int[] citations) {
    int n = citations.length;
    Arrays.sort(citations);

    int res = 0;
    for (int i = 0; i < n; i++) {
      if (citations[n - 1 - i] >= i + 1) {
        res = i + 1;
      } else {
        break;
      }
    }
    return res;
  }
  //// ---------------- end (Approach4)-------------------------------------
  //// ----------------start(Approach5)-------------------------------------
  // 20200911, can't solve it by myself.
  // refer to leetcode: Approach #2 (Counting) [Accepted]
  //optimal soluton

  // 82/82 cases passed (0 ms)
  // Your runtime beats 100 % of java submissions
  // Your memory usage beats 99.65 % of java submissions (36.9 MB)

  // public int hIndex5(int[] citations) {
  public int hIndex(int[] citations) {
    int n = citations.length;
    int[] count = new int[n + 1];

    // 1. distribute
    for (int citation : citations) {
      if (citation > n) {
        count[n]++;
      } else {
        count[citation]++;
      }
    }
    // 2.collect
    int needed = n;
    int sum = count[n];
    while (sum < needed) {
      needed--;
      sum += count[needed];
    }
    return needed;
  }
  //// ---------------- end (Approach5)-------------------------------------
}
// @lc code=end
