/*
 * @lc app=leetcode id=41 lang=java
 *
 * [41] First Missing Positive
 */

// @lc code=start
class Solution {
  ////////////////// first round(20200113)///////////////////////////////////
  ////////////////// first round(20200113)///////////////////////////////////
  //// ----------------start(Approach1)-------------------------------------
  // 20200113

  // public int firstMissingPositive(int[] nums) {
  public int firstMissingPositive1(int[] nums) {
    // int res = nums[0];
    int i = 0;
    while (i < nums.length) {
      if (nums[i] == i + 1 || nums[i] < 1 || nums[i] > nums.length) {
        i++;
        continue;
      }
      // System.out.format("i: %d, nums[i]: %s\n", i, nums[i]);
      if (nums[i] != nums[nums[i] - 1]) {
        swap(nums, i, nums[i] - 1);
      } else {
        i++;
      }
      // System.out.format("i: %d, nums: %s\n", i, Arrays.toString(nums));
    }

    for (i = 0; i < nums.length; i++) {
      if (nums[i] != i + 1) {
        break;
      }
    }
    return i + 1;
  }

  private void swap(int[] arr, int a, int b) {
    int tmp = arr[a];
    arr[a] = arr[b];
    arr[b] = tmp;
  }
  //// ---------------- end (Approach1)-------------------------------------
  ////////////////// second round(20200910)///////////////////////////////////
  ////////////////// second round(20200910)///////////////////////////////////
  //// ----------------start(Approach2)-------------------------------------
  // 20200910, can't solve by myself.
  // the preceding approach 1 is awesome , but that idea is hard to come up with.
  // refer to leetcode standard solution: Approach 1: Index as a hash key.

  // 165/165 cases passed (0 ms)
  // Your runtime beats 100 % of java submissions
  // Your memory usage beats 66.59 % of java submissions (37.4 MB)

  public int firstMissingPositive(int[] nums) {
    // public int firstMissingPositive2(int[] nums) {
    int n = nums.length;
    // 1. check if 1 is exist.
    boolean hasOne = false;
    for (int i = 0; i < n; i++) {
      if (nums[i] == 1)
        hasOne = true;
    }
    if (hasOne == false)
      return 1;

    // 2. replace negative, 0, >n
    for (int i = 0; i < n; i++) {
      if (nums[i] <= 0 || nums[i] > n)
        nums[i] = 1;
    }
    // 3. use index as hash key, and sign as presence detector.
    for (int i = 0; i < n; i++) {
      int key = Math.abs(nums[i]);
      if (key == n) {
        nums[0] = -Math.abs(nums[0]);
        // nums[0] = -nums[0];
      } else {
        nums[key] = -Math.abs(nums[key]);
      }
    }
    // 4. check result
    for (int i = 1; i < n; i++) {
      if (nums[i] > 0) {
        return i;
      }
    }
    if (nums[0] > 0)
      return n;
    return n + 1;
  }
  //// ---------------- end (Approach1)-------------------------------------
}
// @lc code=end
