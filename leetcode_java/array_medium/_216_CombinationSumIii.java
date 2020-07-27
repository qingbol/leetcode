/*
 * @lc app=leetcode id=216 lang=java
 *
 * [216] Combination Sum III
 */

// @lc code=start
class Solution {
  /////////////////////////// first round(20200228)//////////////////////////
  //// --------------------start(Approach1)-------------------------
  // 20200228

  // public List<List<Integer>> combinationSum3(int k, int n) {
  public List<List<Integer>> combinationSum3_1(int k, int n) {
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

  //// -------------------- end (Approach1)-------------------------
  /////////////////////////// first round(20200228)//////////////////////////
  //// --------------------start(Approach2)-------------------------
  // 20200228, by myslef. backtracking

  // 18/18 cases passed (0 ms)
  // Your runtime beats 100 % of java submissions
  // Your memory usage beats 46.2 % of java submissions (36.9 MB)

  public List<List<Integer>> combinationSum3(int k, int n) {
    // public List<List<Integer>> combinationSum3_2(int k, int n) {
    List<List<Integer>> res = new ArrayList<>();
    helper2(k, n, new ArrayList<>(), res, 1);
    return res;
  }

  private void helper2(int k, int n, List<Integer> track, List<List<Integer>> res, int start) {
    if (n <= 0 || track.size() >= k) {
      if (track.size() == k && n == 0)
        res.add(new ArrayList<>(track));
      return;
    }

    for (int i = start; i <= 9; i++) {
      track.add(i);
      helper2(k, n - i, track, res, i + 1);
      track.remove(track.size() - 1);
    }
  }
  //// -------------------- end (Approach2)-------------------------
}
// @lc code=end
