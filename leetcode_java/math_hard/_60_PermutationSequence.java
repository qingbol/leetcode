/*
 * @lc app=leetcode id=60 lang=java
 *
 * [60] Permutation Sequence
 */

// @lc code=start
class Solution {
  ////////////////// first round(20200227)///////////////////////
  ////////////////// first round(20200227)///////////////////////
  //// -------------------start(Approach1)----------------------
  // 20200227.
  // public String getPermutation(int n, int k) {
  public String getPermutation1(int n, int k) {
    int[] factorialBase = new int[n];
    List<Integer> nums = new ArrayList<>();
    // generate base nums
    for (int i = 1; i <= n; i++) {
      nums.add(i);
    }
    // generate factorial base
    factorialBase[0] = 1;
    for (int i = 1; i < n; i++) {
      factorialBase[i] = factorialBase[i - 1] * i;
    }

    // permutation number - 1
    k--;

    // Generate factorial number system representation
    StringBuilder sb = new StringBuilder();
    for (int i = n - 1; i >= 0; i--) {
      int idx = k / factorialBase[i];
      k -= idx * factorialBase[i];
      sb.append(nums.get(idx));
      nums.remove(idx);
    }
    return sb.toString();
  }

  //// ------------------- end (Approach1)----------------------
  ////////////////// first round(20200725)///////////////////////
  ////////////////// first round(20200725)///////////////////////
  //// -------------------start(Approach2)----------------------
  // 20200725. by myself. by swap.

  // Wrong Answer
  // 33/200 cases passed (N/A)
  // Testcase
  // 3
  // 5

  // public String getPermutation(int n, int k) {
  public String getPermutation2(int n, int k) {
    int[] count = new int[1];
    int[] nums = new int[n];
    for (int i = 0; i < n; i++) {
      nums[i] = i + 1;
    }
    // System.out.println(Arrays.toString(nums));
    StringBuilder sb = new StringBuilder();
    helper2(nums, k, count, 0, sb);
    return sb.toString();
  }

  private void helper2(int[] nums, int k, int[] count, int start, StringBuilder sb) {
    if (start == nums.length) {
      count[0] += 1;
      // count[0]++;
      // System.out.format("start:%d, count[0]:%d\n", start, count[0]);
      if (count[0] == k) {
        for (int num : nums) {
          sb.append(num);
        }
      }
      return;
    }

    for (int i = start; i < nums.length; i++) {
      // System.out.format("start: %d,i: %d\n", start, i);
      swap2(nums, start, i);
      helper2(nums, k, count, start + 1, sb);
      swap2(nums, start, i);
    }

  }

  private void swap2(int[] nums, int i, int j) {
    // System.out.format("i: %d, j: %d\n", i, j);
    int tmp = nums[i];
    nums[i] = nums[j];
    nums[j] = tmp;
  }
  //// ------------------- end (Approach2)----------------------
  //// -------------------start(Approach3)----------------------
  // 20200725. by myselft. use extra array to mark used status.

  // 200/200 cases passed (2243 ms)
  // Your runtime beats 5.01 % of java submissions
  // Your memory usage beats 12.92 % of java submissions (39.2 MB)

  // public String getPermutation(int n, int k) {
    public String getPermutation3(int n, int k) {
    // List<List<Integer>> res = new ArrayList<>();
    StringBuilder sb = new StringBuilder();
    int[] nums = new int[n];
    boolean[] used = new boolean[n];
    for (int i = 0; i < n; i++) {
      nums[i] = i + 1;
    }

    helper3(nums, new int[] { k }, new ArrayList(), sb, used);
    return sb.toString();
  }

  private void helper3(int[] nums, int[] k, List<Integer> track, StringBuilder sb, boolean[] used) {
    if (track.size() == nums.length) {
      k[0]--;
      if (k[0] == 0) {
        for (int num : track) {
          sb.append(num);
        }
      }
      return;
    }

    for (int i = 0; i < nums.length; i++) {
      if (used[i])
        continue;
      track.add(nums[i]);
      used[i] = true;
      helper3(nums, k, track, sb, used);
      track.remove(track.size() - 1);
      used[i] = false;
    }
  }
  //// ------------------- end (Approach3)----------------------
  //// -------------------start(Approach4)----------------------
  // 20200726. refer to leetcode standard solution: factorial Number system

  public String getPermutation(int n, int k) {
    // public String getPermutation3(int n, int k) {
      int[] factorialBase = new int[n];
      List<Integer> nums = new ArrayList<>(n);
      factorialBase[0] = 1;
      nums.add(1);
      for (int i = 1; i < n; i++) {
        factorialBase[i] = factorialBase[i - 1] * i;
        nums.add(i + 1);
      }

      k--;
      StringBuilder sb = new StringBuilder();
      for (int i = n - 1; i >= 0; i--) {
        int idx = k / factorialBase[i];
        k = k % factorialBase[i];
        sb.append(nums.get(idx));
        nums.remove(idx);
      }

      return sb.toString();
  }
  //// ------------------- end (Approach4)----------------------
}
// @lc code=end
