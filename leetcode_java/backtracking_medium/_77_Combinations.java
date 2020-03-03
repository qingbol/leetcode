/*
 * @lc app=leetcode id=77 lang=java
 *
 * [77] Combinations
 */

// @lc code=start
class Solution {
  //// --------------------start(Approach1)-------------------------
  // backtracking
  public List<List<Integer>> combine1(int n, int k) {
    List<List<Integer>> res = new ArrayList<>();
    // int[] nums = new int[n];
    // for (int i = 1; i <= n; i++) {
    // nums[i - 1] = i;
    // }
    // System.out.format("nums:%s\n", Arrays.toString(nums));

    helper1(res, new ArrayList<>(), n, k, 1);
    return res;
  }

  private void helper1(List<List<Integer>> res, List<Integer> lst, int n, int k, int start) {
    if (lst.size() == k) {
      res.add(new ArrayList<>(lst));
      return;
    }

    for (int i = start; i <= n; i++) {
      lst.add(i);
      helper1(res, lst, n, k, i + 1);
      lst.remove(lst.size() - 1);
    }
  }

  //// -------------------- end (Approach1)-------------------------
  //// --------------------start(Approach2)-------------------------
  // iteration
  public List<List<Integer>> combine(int n, int k) {
    // init first combination
    LinkedList<Integer> nums = new LinkedList<Integer>();
    for (int i = 1; i < k + 1; ++i)
      nums.add(i);
    nums.add(n + 1);
    // System.out.format("nums: %s\n", nums);

    List<List<Integer>> output = new ArrayList<List<Integer>>();
    int j = 0;
    while (j < k) {
      // add current combination
      output.add(new LinkedList(nums.subList(0, k)));
      // increase first nums[j] by one
      // if nums[j] + 1 != nums[j + 1]
      j = 0;
      while ((j < k) && (nums.get(j + 1) == nums.get(j) + 1)) {
        System.out.println("----------------------------------");
        System.out.format("nums in j: %d step :%s\n", j, nums);
        nums.set(j, j++ + 1);
        System.out.format("nums in j: %d step :%s\n", j, nums);
        System.out.println("----------------------------------");
      }
      nums.set(j, nums.get(j) + 1);
      System.out.format("out:nums in j: %d step :%s\n", j, nums);
    }
    return output;
  }
  //// -------------------- end (Approach2)-------------------------
}
// @lc code=end
