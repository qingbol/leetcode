/*
 * @lc app=leetcode id=46 lang=java
 *
 * [46] Permutations
 */

// @lc code=start
class Solution {
  //// --------------------start(Approach1)----------------------------
  // 20200227.
  public List<List<Integer>> permute1(int[] nums) {
    List<List<Integer>> res = new ArrayList<>();
    if (nums == null || nums.length == 0) {
      return res;
    }
    helper(res, new ArrayList<>(), nums);
    return res;
  }

  private void helper(List<List<Integer>> res, List<Integer> lst, int[] nums) {
    if (lst.size() == nums.length) {
      res.add(new ArrayList<>(lst));
      return;
    }

    for (int i = 0; i < nums.length; i++) {
      if (lst.contains(nums[i])) {
        continue;
      }
      lst.add(nums[i]);
      // System.out.format("nums[%d] befor %d\n", i, nums[i]);
      helper(res, lst, nums);
      // System.out.format("nums[%d] after %d\n", i, nums[i]);
      lst.remove(lst.size() - 1);
      // lst.remove(nums[i]);
    }
  }

  //// -------------------- end (Approach1)----------------------------
  //// --------------------start(Approach2)----------------------------
  // 20200227.
  // optimal, no need to check lst.contains()
  public List<List<Integer>> permute(int[] nums) {
    List<List<Integer>> res = new ArrayList<>();
    if (nums == null || nums.length == 0) {
      return res;
    }
    int end = nums.length;
    List<Integer> lst = new ArrayList<>(nums.length);
    for (int num : nums) {
      lst.add(num);
    }
    // System.out.format("lst: %s\n", lst);
    backtracking(res, lst, end, 0);
    return res;
  }

  private void backtracking(List<List<Integer>> res, List<Integer> lst, int end, int first) {
    if (first == end) {
      res.add(new ArrayList(lst));
    }

    for (int i = first; i < end; i++) {
      Collections.swap(lst, first, i);
      backtracking(res, lst, end, first + 1);
      Collections.swap(lst, first, i);
    }
  }
  //// -------------------- end (Approach2)----------------------------
}
// @lc code=end
