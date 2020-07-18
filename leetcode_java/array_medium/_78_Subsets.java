/*
 * @lc app=leetcode id=78 lang=java
 *
 * [78] Subsets
 *
 * https://leetcode.com/problems/subsets/description/
 *
 * algorithms
 * Medium (56.94%)
 * Likes:    2709
 * Dislikes: 63
 * Total Accepted:    460.8K
 * Total Submissions: 808.9K
 * Testcase Example:  '[1,2,3]'
 *
 * Given a set of distinct integers, nums, return all possible subsets (the
 * power set).
 * 
 * Note: The solution set must not contain duplicate subsets.
 * 
 * Example:
 * 
 * 
 * Input: nums = [1,2,3]
 * Output:
 * [
 * ⁠ [3],
 * [1],
 * [2],
 * [1,2,3],
 * [1,3],
 * [2,3],
 * [1,2],
 * []
 * ]
 * 
 */

// @lc code=start
class Solution {
  //// ---------------start(Approach1)----------------------------
  // 20200227.
  // recursion
  public List<List<Integer>> subsets1(int[] nums) {
    // create res and initializing
    List<List<Integer>> res = new ArrayList<>();
    // List<Integer> lst = new ArrayList<>();
    res.add(new ArrayList<>());

    for (int i = 0; i < nums.length; i++) {
      // generate new list from the old list
      List<List<Integer>> extra = new ArrayList<>();
      for (List<Integer> elem : res) {
        List<Integer> newElem = new ArrayList<>(elem);
        newElem.add(nums[i]);
        extra.add(newElem);
      }
      // add the new generated list into res.
      res.addAll(extra);
    }
    return res;
  }

  //// --------------- end (Approach1)----------------------------
  //// ---------------start(Approach2)----------------------------
  // 20200227
  // Backtracking
  public List<List<Integer>> subsets2(int[] nums) {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> list = new ArrayList<>();

    subsetsHelper(nums, 0, res, list);
    return res;
  }

  public void subsetsHelper(int[] nums, int start, List<List<Integer>> res, List<Integer> list) {
    res.add(new ArrayList(list));
    for (int i = start; i < nums.length; i++) {
      list.add(nums[i]);
      // System.out.println("Befor enter, i: " + i + " list: " + list);
      subsetsHelper(nums, i + 1, res, list);
      list.remove(list.size() - 1);
      // System.out.println("After leave, i: " + i + " list: " + list);
    }
    // return;
  }

  //// --------------- end (Approach2)----------------------------
  //// ---------------start(Approach3)----------------------------
  // 20200227
  // Backtracking
  public List<List<Integer>> subsets3(int[] nums) {
    List<List<Integer>> res = new ArrayList<>();
    if (nums == null || nums.length == 0) {
      return res;
    }
    for (int k = 0; k <= nums.length; k++) {
      backtrack(res, new ArrayList<>(), nums, 0, k);
    }
    return res;
  }

  private void backtrack(List<List<Integer>> res, List<Integer> lst, int[] nums, int start, int k) {
    if (lst.size() == k) {
      res.add(new ArrayList<>(lst));
      return;
    }

    for (int i = start; i < nums.length; i++) {
      lst.add(nums[i]);
      backtrack(res, lst, nums, i + 1, k);
      lst.remove(lst.size() - 1);
    }
  }

  //// --------------- end (Approach3)----------------------------
  //// ---------------start(Approach4)----------------------------
  // 20200227
  public List<List<Integer>> subsets(int[] nums) {
    List<List<Integer>> res = new ArrayList<>();
    int n = nums.length;

    // generate bitmask, from 00...00 to 11...11
    int nthBit = 1 << n;
    for (int i = 0; i < (int) Math.pow(2, n); i++) {
      String bitmask = Integer.toBinaryString(i | nthBit).substring(1);
      List<Integer> lst = new ArrayList<>();
      for (int j = 0; j < n; j++) {
        if (bitmask.charAt(j) == '1') {
          lst.add(nums[j]);
        }
      }
      res.add(lst);
    }
    return res;
  }
  //// --------------- end (Approach4)----------------------------
}
// @lc code=end
