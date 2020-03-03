/*
 * @lc app=leetcode id=90 lang=java
 *
 * [90] Subsets II
 */

// @lc code=start
class Solution {
  public List<List<Integer>> subsetsWithDup(int[] nums) {
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
}
// @lc code=end
