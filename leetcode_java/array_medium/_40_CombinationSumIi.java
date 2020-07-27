/*
 * @lc app=leetcode id=40 lang=java
 *
 * [40] Combination Sum II
 */

// @lc code=start
class Solution {
  /////////////////////////// first round(20200228)//////////////////////////
  /////////////////////////// first round(20200228)//////////////////////////
  //// --------------------start(Approach1)-------------------------
  // 20200228

  public List<List<Integer>> combinationSum2_1(int[] candidates, int target) {
    // public List<List<Integer>> combinationSum2(int[] candidates, int target) {
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
  //// -------------------- end (Approach1)-------------------------
  /////////////////////////// second round(20200726)//////////////////////////
  /////////////////////////// second round(20200726)//////////////////////////
  //// --------------------start(Approach2)-------------------------
  // 20200726.
  // 172/172 cases passed (4 ms)
  // Your runtime beats 74.96 % of java submissions
  // Your memory usage beats 76.96 % of java submissions (39.5 MB)

  public List<List<Integer>> combinationSum2(int[] candidates, int target) {
    // public List<List<Integer>> combinationSum2_2(int[] candidates, int target) {
    List<List<Integer>> res = new ArrayList<>();
    Arrays.sort(candidates);

    helper2(candidates, target, new ArrayList<>(), res, 0);
    return res;
  }

  private void helper2(int[] nums, int target, List<Integer> track, List<List<Integer>> res, int start) {
    if (target <= 0) {
      if (target == 0)
        res.add(new ArrayList<>(track));
      return;
    }

    for (int i = start; i < nums.length; i++) {
      if (i != start && nums[i] == nums[i - 1])
        continue;
      track.add(nums[i]);
      helper2(nums, target - nums[i], track, res, i + 1);
      track.remove(track.size() - 1);
    }
  }
  //// -------------------- end (Approach2)-------------------------
}
// @lc code=end
