/*
 * @lc app=leetcode id=78 lang=java
 *
 * [78] Subsets
 *
 * https://leetcode.com/problems/subsets/description/
 *
 * algorithms Medium (56.94%) Likes: 2709 Dislikes: 63 Total Accepted: 460.8K Total Submissions:
 * 808.9K Testcase Example: '[1,2,3]'
 *
 * Given a set of distinct integers, nums, return all possible subsets (the power set).
 * 
 * Note: The solution set must not contain duplicate subsets.
 * 
 * Example: Input: nums = [1,2,3] Output: [ ⁠ [3], [1], [2], [1,2,3], [1,3], [2,3], [1,2], [] ]
 * 
 */

// @lc code=start
class Solution {
  ////////////////////// first round(20200227)/////////////////////
  ////////////////////// first round(20200227)/////////////////////
  //// ---------------start(Approach1)----------------------------
  // 20200227.
  // Approach 1: Cascading

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
  // Approach 3: Lexicographic (Binary Sorted) Subsets

  // public List<List<Integer>> subsets(int[] nums) {
  public List<List<Integer>> subsets4(int[] nums) {
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
  ////////////////////// second round(20200726)/////////////////////
  ////////////////////// second round(20200726)/////////////////////
  //// ---------------start(Approach5)----------------------------
  // 20200726. by myself, backtrack + use start to mark the used element
  // refer to labuladong < 回溯算法团灭子集、排列、组合问题>

  // 10/10 cases passed (0 ms)
  // Your runtime beats 100 % of java submissions
  // Your memory usage beats 11.28 % of java submissions (40 MB)

  public List<List<Integer>> subsets5(int[] nums) {
    // public List<List<Integer>> subsets(int[] nums) {
    List<List<Integer>> res = new ArrayList<>();
    helper5(nums, new ArrayList<>(), 0, res);
    return res;
  }

  private void helper5(int[] nums, List<Integer> track, int start, List<List<Integer>> res) {
    res.add(new ArrayList<>(track));

    for (int i = start; i < nums.length; i++) {
      track.add(nums[i]);
      helper5(nums, track, i + 1, res);
      // helper5(nums, track, start + 1, res);
      track.remove(track.size() - 1);
    }
  }
  //// --------------- end (Approach5)----------------------------
  //// ---------------start(Approach6)----------------------------
  // 20200726. bit manipulation
  // refer to leetcode standard soluton

  // 10/10 cases passed (1 ms)
  // Your runtime beats 77.07 % of java submissions
  // Your memory usage beats 18.59 % of java submissions (39.9 MB)

  public List<List<Integer>> subsets6(int[] nums) {
    // public List<List<Integer>> subsets(int[] nums) {
    int n = nums.length;
    List<List<Integer>> res = new ArrayList<>();

    for (int i = (int) Math.pow(2, n); i < (int) Math.pow(2, n + 1); i++) {
      String bitMask = Integer.toBinaryString(i).substring(1);

      List<Integer> cur = new ArrayList<>();
      for (int j = 0; j < n; j++) {
        if (bitMask.charAt(j) == '1') {
          cur.add(nums[j]);
        }
      }
      res.add(cur);
    }
    return res;
  }
  //// --------------- end (Approach6)----------------------------
  //// ---------------start(Approach7)----------------------------
  // 20200726. bit manipulation
  // optimal
  // refer to leetcode discussion
  // https://leetcode.com/problems/subsets/discuss/27278/C%2B%2B-RecursiveIterativeBit-Manipulation

  // 10/10 cases passed (0 ms)
  // Your runtime beats 100 % of java submissions
  // Your memory usage beats 81.75 % of java submissions (39.4 MB)

  public List<List<Integer>> subsets7(int[] nums) {
    // public List<List<Integer>> subsets(int[] nums) {
    int n = nums.length;
    int p = 1 << n;
    List<List<Integer>> res = new ArrayList<>();

    for (int i = 0; i < p; i++) {
      List<Integer> cur = new ArrayList<>();
      for (int j = 0; j < n; j++) {
        if ((i >> j & 1) == 1) {
          cur.add(nums[j]);
        }
      }
      res.add(cur);
    }
    return res;
  }
  //// --------------- end (Approach7)----------------------------
  //// ---------------start(Approach8)----------------------------
  //20201121. another backtracking implementation
  //similar to _320_			Generalized Abbreviation

//with track.remove(track.size() - 1);
//   10/10 cases passed (1 ms)
// Your runtime beats 55.61 % of java submissions
// Your memory usage beats 71.24 % of java submissions (39.1 MB)

//without track.remove(track.size() - 1);
// 10/10 cases passed (0 ms)
// Your runtime beats 100 % of java submissions
// Your memory usage beats 84.92 % of java submissions (39.1 MB)

  // public List<List<Integer>> subsets5(int[] nums) {
  public List<List<Integer>> subsets(int[] nums) {
    List<List<Integer>> res = new ArrayList<>();
    helper8(nums, new ArrayList<>(), 0, res);
    return res;
  }

  private void helper8(int[] nums, List<Integer> track, int start, List<List<Integer>> res) {
    if (start == nums.length) {
      res.add(new ArrayList<>(track));
    }

    helper5(nums, track, start + 1, res);
    track.add(nums[start]);
    helper5(nums, track, start + 1, res);
    // helper5(nums, track, start + 1, res);
    // track.remove(track.size() - 1);
  }
  //// --------------- end (Approach5)----------------------------
}
// @lc code=end
