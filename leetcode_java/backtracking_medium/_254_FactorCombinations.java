/*
 * @lc app=leetcode id=254 lang=java
 *
 * [254] Factor Combinations
 */

// @lc code=start
class Solution {
  //// ----------------------start(Approach1)-------------------------
  // By myself. acceptable
  public List<List<Integer>> getFactors1(int n) {
    List<List<Integer>> res = new ArrayList<>();
    if (n <= 1) {
      return res;
    }

    helper1(res, new ArrayList<>(), n, 2);
    return res;
  }

  private void helper1(List<List<Integer>> res, List<Integer> lst, int n, int start) {
    if (n == 1) {
      if (lst.size() > 0) {
        res.add(new ArrayList<>(lst));
      }
      return;
    }

    for (int i = start; i <= n; i++) {
      if (n % i != 0) {
        continue;
      }
      if (n / i != 1 || n / i == 1 && lst.size() > 0) {
        lst.add(i);
        helper1(res, lst, n / i, i);
        lst.remove(lst.size() - 1);
      }
    }
  }

  //// ---------------------- end (Approach1)-------------------------
  //// ----------------------start(Approach2)-------------------------
  // better
  public List<List<Integer>> getFactors(int n) {
    List<List<Integer>> res = new ArrayList<>();
    if (n <= 1) {
      return res;
    }

    helper2(res, new ArrayList<>(), n, 2);
    return res;
  }

  private void helper2(List<List<Integer>> res, List<Integer> lst, int n, int start) {
    if (n == 1) {
      if (lst.size() > 1) {
        res.add(new ArrayList<>(lst));
      }
      return;
    }

    for (int i = start; i <= n; i++) {
      if (n % i != 0) {
        continue;
      }
      lst.add(i);
      helper2(res, lst, n / i, i);
      lst.remove(lst.size() - 1);
    }
  }
  //// ---------------------- end (Approach2)-------------------------
}
// @lc code=end
