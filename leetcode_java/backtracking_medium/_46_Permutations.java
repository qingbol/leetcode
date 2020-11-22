/*
 * @lc app=leetcode id=46 lang=java
 *
 * [46] Permutations
 */

// @lc code=start
class Solution {
  /////////////////////// first round(20200227)//////////////////////////
  /////////////////////// first round(20200227)//////////////////////////
  //// --------------------start(Approach1)----------------------------
  // 20200227. backtrak + contains.
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
  // public List<List<Integer>> permute2(int[] nums) {
    List<List<Integer>> res = new ArrayList<>();
    if (nums == null || nums.length == 0) {
      return res;
    }
    int end = nums.length;
    //here nums is int[] not Integer[]. so we cant use the below method
    // List<Integer> lst = new ArrayList<Integer>(Arrays.asList(nums));
    List<Integer> lst = new ArrayList<>(nums.length);
    for (int num : nums) {
      lst.add(num);
    }
    // System.out.format("lst: %s\n", lst);
    helper2(res, lst, end, 0);
    return res;
  }

  private void helper2(List<List<Integer>> res, List<Integer> lst, int end, int first) {
    if (first == end) {
      res.add(new ArrayList(lst));
    }

    for (int i = first; i < end; i++) {
      Collections.swap(lst, first, i);
      helper2(res, lst, end, first + 1);
      Collections.swap(lst, first, i);
    }
  }

  //// -------------------- end (Approach2)----------------------------
  /////////////////////// second round(20200725)//////////////////////////
  /////////////////////// second round(20200725)//////////////////////////
  //// --------------------start(Approach3)----------------------------
  // 20200227. backtrak + contains.

  // 25/25 cases passed (1 ms)
  // Your runtime beats 94.39 % of java submissions
  // Your memory usage beats 45 % of java submissions (39.7 MB)

  // public List<List<Integer>> permute(int[] nums) {
  public List<List<Integer>> permute3(int[] nums) {
    List<List<Integer>> res = new ArrayList<>();
    if (nums.length == 0)
      return res;
    helper3(nums, new ArrayList<>(), res);
    return res;
  }

  private void helper3(int[] nums, List<Integer> track, List<List<Integer>> res) {
    if (track.size() == nums.length) {
      res.add(new ArrayList<>(track));
      return;
    }

    for (int num : nums) {
      if (track.contains(num)) {
        continue;
      }
      track.add(num);
      helper3(nums, track, res);
      track.remove(track.size() - 1);
      // track.removeLast();
    }
  }
  //// -------------------- end (Approach3)----------------------------
  //// --------------------start(Approach4)----------------------------
  // 20200227. backtrak + swap.

  // 25/25 cases passed (1 ms)
  // Your runtime beats 94.39 % of java submissions
  // Your memory usage beats 21.7 % of java submissions (39.9 MB)

  // public List<List<Integer>> permute(int[] nums) {
    public List<List<Integer>> permute4(int[] nums) {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> lst = new ArrayList<>();
    for (int num : nums) {
      lst.add(num);
    }

    helper4(lst, 0, nums.length, res);
    return res;
  }

  private void helper4(List<Integer> lst, int first, int end, List<List<Integer>> res) {
    if (first == end) {
      res.add(new ArrayList<>(lst));
      return;
    }

    for (int i = first; i < end; i++) {
      Collections.swap(lst, first, i);
      helper4(lst, first + 1, end, res);
      Collections.swap(lst, first, i);
    }
  }
  //// -------------------- end (Approach4)----------------------------
}
// @lc code=end
