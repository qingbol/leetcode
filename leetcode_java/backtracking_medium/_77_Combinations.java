/*
 * @lc app=leetcode id=77 lang=java
 *
 * [77] Combinations
 */

// @lc code=start
class Solution {
  ////////////////////////// first round(20200227)////////////////////
  ////////////////////////// first round(20200227)////////////////////
  //// --------------------start(Approach1)-------------------------
  // 20200227. // backtracking
  //optimal

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
  public List<List<Integer>> combine2(int n, int k) {
    // public List<List<Integer>> combine(int n, int k) {
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
  ////////////////////////// first round(20200726)////////////////////
  ////////////////////////// first round(20200726)////////////////////
  //// --------------------start(Approach3)-------------------------
  // 20200227. by myself
  // backtracking

  // 27/27 cases passed (20 ms)
  // Your runtime beats 59.87 % of java submissions
  // Your memory usage beats 67.81 % of java submissions (40.7 MB)

  public List<List<Integer>> combine3(int n, int k) {
    // public List<List<Integer>> combine(int n, int k) {
    int[] nums = new int[n];
    for (int i = 0; i < n; i++) {
      nums[i] = i + 1;
    }
    List<List<Integer>> res = new ArrayList<>();
    helper3(nums, k, 0, new ArrayList<>(), res);
    return res;
  }

  private void helper3(int[] nums, int k, int start, List<Integer> track, List<List<Integer>> res) {
    if (track.size() == k) {
      res.add(new ArrayList<>(track));
      return;
    }

    for (int i = start; i < nums.length; i++) {
      track.add(nums[i]);
      helper3(nums, k, i + 1, track, res);
      track.remove(track.size() - 1);
    }
  }

  //// -------------------- end (Approach3)-------------------------
  //// -------------------- start(Approach4)-------------------------
  //refer to Approach 2: Lexicographic (binary sorted) combinations
  //dont understand.
  
  public List<List<Integer>> combine(int n, int k) {
  // public List<List<Integer>> combine4(int n, int k) {
    // init first combination
    LinkedList<Integer> nums = new LinkedList<Integer>();
    for (int i = 1; i < k + 1; ++i)
      nums.add(i);
    nums.add(n + 1);

    List<List<Integer>> output = new ArrayList<List<Integer>>();
    int j = 0;
    while (j < k) {
      // add current combination
      output.add(new LinkedList(nums.subList(0, k)));
      // increase first nums[j] by one
      // if nums[j] + 1 != nums[j + 1]
      j = 0;
      System.out.format("nums befor: %s\n", nums);
      while ((j < k) && (nums.get(j + 1) == nums.get(j) + 1))
        nums.set(j, j++ + 1);
      nums.set(j, nums.get(j) + 1);
      System.out.format("nums after: %s\n", nums);
    }
    return output;
  }
  //// -------------------- end (Approach4)-------------------------
}
// @lc code=end
