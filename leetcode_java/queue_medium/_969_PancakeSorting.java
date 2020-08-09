/*
 * @lc app=leetcode id=969 lang=java
 *
 * [969] Pancake Sorting
 */

// @lc code=start
class Solution {

//   215/215 cases passed (1 ms)
// Your runtime beats 100 % of java submissions
// Your memory usage beats 15.22 % of java submissions (39.6 MB)

  public List<Integer> pancakeSort(int[] A) {
    List<Integer> res = new ArrayList<>();
    helper1(A, A.length, res);
    // return Arrays.asList(A);
    // return Arrays.stream(A).boxed().collect(Collectors.toList());
    return res;
  }

  private void helper1(int[] A, int n, List<Integer> res) {
    if (n == 1)
      return;
    int idx = getMaxIdx(A, n);
    reverse1(A, idx + 1);
    // reverse1(A, idx);
    res.add(idx + 1);
    reverse1(A, n);
    res.add(n);
    helper1(A, n - 1, res);
  }

  private int getMaxIdx(int[] A, int n) {
    int max = A[0];
    int j = 0;
    for (int i = 1; i < n; i++) {
      if (A[i] > max) {
        max = A[i];
        j = i;
      }
    }
    return j;
  }

  private void reverse1(int[] A, int n) {
    int lo = 0, hi = n - 1;
    while (lo < hi) {
      int tmp = A[lo];
      A[lo] = A[hi];
      A[hi] = tmp;
      lo++;
      hi--;
    }
  }
}
// @lc code=end

