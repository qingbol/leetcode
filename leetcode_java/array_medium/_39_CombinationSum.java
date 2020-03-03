/*
 * @lc app=leetcode id=39 lang=java
 *
 * [39] Combination Sum
 */

// @lc code=start
class Solution {
  //// --------------------start(Approach1)-------------------------
  // by myself, wrong
  public List<List<Integer>> combinationSum1(int[] candidates, int target) {
    List<List<Integer>> res = new ArrayList<>();
    if (candidates == null || candidates.length == 0) {
      return res;
    }
    // int sum = 0;
    helper1(res, new ArrayList<>(), candidates, target, 0);
    // helper1(res, new ArrayList<>(), candidates, target, 0);
    return res;
  }

  private void helper1(List<List<Integer>> res, List<Integer> lst, int[] c, int t, int sum) {
    if (sum >= t) {
      if (sum == t) {
        res.add(new ArrayList<>(lst));
      }
      return;
    }

    for (int i = 0; i < c.length; i++) {
      sum += c[i];
      lst.add(c[i]);
      helper1(res, lst, c, t, sum);
      sum -= lst.get(lst.size() - 1);
      lst.remove(lst.size() - 1);
    }
  }

  //// -------------------- end (Approach1)-------------------------
  //// --------------------start(Approach2)-------------------------
  // backtracking, combinations's variation
  public List<List<Integer>> combinationSum(int[] candidates, int target) {
    List<List<Integer>> res = new ArrayList<>();
    if (candidates == null || candidates.length == 0) {
      return res;
    }

    helper2(res, new ArrayList<>(), candidates, target, 0);
    return res;
  }

  private void helper2(List<List<Integer>> res, List<Integer> lst, int[] c, int t, int start) {
    if (t <= 0) {
      if (t == 0) {
        res.add(new ArrayList(lst));
      }
      return;
    }

    for (int i = start; i < c.length; i++) {
      t -= c[i];
      lst.add(c[i]);
      helper2(res, lst, c, t, i);
      t += lst.get(lst.size() - 1);
      lst.remove(lst.size() - 1);
    }
  }
  //// -------------------- end (Approach2)-------------------------
  //// --------------------start(Approach3)-------------------------
  //// -------------------- end (Approach3)-------------------------
}
// @lc code=end
