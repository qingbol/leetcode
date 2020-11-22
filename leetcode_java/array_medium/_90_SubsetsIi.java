/*
 * @lc app=leetcode id=90 lang=java
 *
 * [90] Subsets II
 */

// @lc code=start
class Solution {
  ////////////////////////// first round(20200227)///////////////////
  ////////////////////////// first round(20200227)///////////////////
  //// ----------------start(Approach1)----------------------------
  // 20200227.
  // public List<List<Integer>> subsetsWithDup(int[] nums) {
  public List<List<Integer>> subsetsWithDup1(int[] nums) {
    List<List<Integer>> res = new ArrayList<>();
    Arrays.sort(nums);
    backtrack(res, new ArrayList<>(), nums, 0);
    return res;
  }

  private void backtrack(List<List<Integer>> res, List<Integer> lst, int[] nums, int start) {
    // System.out.format("lst: %s\n", lst);
    res.add(new ArrayList(lst));

    for (int i = start; i < nums.length; i++) {
      if (i != start && nums[i] == nums[i - 1]) {
        continue;
      }
      lst.add(nums[i]);
      backtrack(res, lst, nums, i + 1);
      lst.remove(lst.size() - 1);
    }
  }

  //// ---------------- end (Approach1)----------------------------
  ////////////////////////// second round(20200726)///////////////////
  ////////////////////////// second round(20200726)///////////////////
  //// ----------------start(Approach2)----------------------------
  // 20200726. backtrack.
  //refer to leetcode discussion
  //https://leetcode.com/problems/subsets-ii/discuss/30150/Very-simple-and-fast-java-solution

  // 19/19 cases passed (1 ms)
  // Your runtime beats 99.89 % of java submissions
  // Your memory usage beats 89.65 % of java submissions (39.4 MB)

  public List<List<Integer>> subsetsWithDup(int[] nums) {
    // public List<List<Integer>> subsetsWithDup2(int[] nums) {
    List<List<Integer>> res = new ArrayList<>();
    Arrays.sort(nums);
    helper2(nums, 0, new ArrayList<>(), res);
    return res;
  }

  private void helper2(int[] nums, int start, List<Integer> track, List<List<Integer>> res) {
    res.add(new ArrayList<>(track));

    for (int i = start; i < nums.length; i++) {
      // if (i != start && nums[i] == nums[i - 1]) {
        if (i > 0 && nums[i] == nums[i - 1]) {
        continue;
      }
      track.add(nums[i]);
      helper2(nums, i + 1, track, res);
      track.remove(track.size() - 1);
    }
  }
  //// ---------------- end (Approach2)----------------------------
}
// @lc code=end
