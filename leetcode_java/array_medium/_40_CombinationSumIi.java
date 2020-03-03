/*
 * @lc app=leetcode id=40 lang=java
 *
 * [40] Combination Sum II
 */

// @lc code=start
class Solution {
  public List<List<Integer>> combinationSum2(int[] candidates, int target) {
    List<List<Integer>> res = new ArrayList<>();
    if (candidates == null || candidates.length == 0) {
      return res;
    }
    Arrays.sort(candidates);
    helper1(res, new ArrayList<>(), candidates, target, 0);
    return res;
  }

  private void helper1(List<List<Integer>> res, List<Integer> lst, int[] c, int t, int start) {
    if (t <= 0) {
      if (t == 0) {
        res.add(new ArrayList<>(lst));
      }
      return;
    }

    for (int i = start; i < c.length; i++) {
      if (i != start && c[i] == c[i - 1]) {
        continue;
      }
      lst.add(c[i]);
      helper1(res, lst, c, t - c[i], i + 1);
      lst.remove(lst.size() - 1);
    }
  }
}
// @lc code=end
