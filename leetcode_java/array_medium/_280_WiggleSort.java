/*
 * @lc app=leetcode id=280 lang=java
 *
 * [280] Wiggle Sort
 */

// @lc code=start
class Solution {
  ////////////////// first round(20200116)///////////////////////////////////
  ////////////////// first round(20200116)///////////////////////////////////
  //// ----------------start(Approach1)-------------------------------------
  // 20200116

  public void wiggleSort1(int[] nums) {
    Arrays.sort(nums);
    int start = 0;
    int end = nums.length - 1;

    while (start < end) {
      start++;
      end--;
      swap(nums, start, end);
      start++;
      end--;
    }
  }

  private void swap(int[] arr, int start, int end) {
    int tmp = arr[start];
    arr[start] = arr[end];
    arr[end] = tmp;
  }

  //// ---------------- end (Approach1)-------------------------------------
  //// ----------------start(Approach2)-------------------------------------
  public void wiggleSort2(int[] nums) {
    // public void wiggleSort(int[] nums) {
    Arrays.sort(nums);
    for (int i = 1; i < nums.length - 1; i += 2) {
      swap(nums, i, i + 1);
    }
  }
  //// ---------------- end (Approach2)-------------------------------------
  //// ----------------start(Approach3)-------------------------------------

  // public void wiggleSort(int[] nums) {
  public void wiggleSort3(int[] nums) {
    for (int i = 1; i < nums.length; i++) {
      if ((1 == i % 2) != (nums[i] > nums[i - 1])) {
        swap(nums, i, i - 1);
      }
    }
  }
  //// ---------------- end (Approach3)-------------------------------------
  ////////////////// second round(20200911)///////////////////////////////////
  ////////////////// second round(20200911)///////////////////////////////////
  //// ----------------start(Approach4)-------------------------------------
  // 20200911
  // cant' solve it by myself. just remember the rule.
  // refer to Approach #2 (One-pass Swap) [Accepted]

  // 126/126 cases passed (1 ms)
  // Your runtime beats 60.77 % of java submissions
  // Your memory usage beats 88 % of java submissions (40.2 MB)

  // public void wiggleSort4(int[] nums) {
  public void wiggleSort(int[] nums) {
    int n = nums.length;
    for (int i = 0; i < n - 1; i++) {
      if (i % 2 == 0 && nums[i] > nums[i + 1])
        swap(nums, i, i + 1);
      if (i % 2 == 1 && nums[i] < nums[i + 1])
        swap(nums, i, i + 1);
    }
  }
  //// ---------------- end (Approach4)-------------------------------------
}
// @lc code=end
