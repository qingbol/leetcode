import java.util.Collections;

/*
 * @lc app=leetcode id=274 lang=java
 *
 * [274] H-Index
 */

// @lc code=start
class Solution {
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

  //
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

  //
  public int hIndex(int[] citations) {
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
}
// @lc code=end
