/*
 * @lc app=leetcode id=216 lang=java
 *
 * [216] Combination Sum III
 */

// @lc code=start
class Solution {
  public List<List<Integer>> combinationSum3(int k, int n) {
    List<List<Integer>> res = new ArrayList<>();
    if (k == 0) {
      return res;
    }

    helper1(res, new ArrayList<>(), k, n, 1);
    return res;
  }

  private void helper1(List<List<Integer>> res, List<Integer> lst, int k, int n, int start) {
    if (lst.size() == k || n <= 0) {
      if (n == 0 && lst.size() == k) {
        res.add(new ArrayList<>(lst));
      }
      return;
    }

    for (int i = start; i <= 9; i++) {
      lst.add(i);
      helper1(res, lst, k, n - i, i + 1);
      lst.remove(lst.size() - 1);
    }
  }
}
// @lc code=end
