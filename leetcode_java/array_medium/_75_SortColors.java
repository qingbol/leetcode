/*
 * @lc app=leetcode id=75 lang=java
 *
 * [75] Sort Colors
 */

// @lc code=start
class Solution {
  ////////////////// first round(20200109)///////////////////////////////////
  ////////////////// first round(20200109)///////////////////////////////////
  //// ----------------start(Approach1)-------------------------------------
  // 20200109

  // public void sortColors(int[] nums) {
  public void sortColors1(int[] nums) {
    int max = Integer.MIN_VALUE;
    for (int num : nums) {
      max = Math.max(max, num);
    }
    int[] count = new int[max + 1];

    // scatter
    for (int i = 0; i < nums.length; i++) {
      count[nums[i]] += 1;
    }

    // gather
    int index = 0;
    for (int i = 0; i < count.length; i++) {
      for (int j = 0; j < count[i]; j++) {
        nums[index++] = i;
      }
    }

  }
  //// ---------------- end (Approach1)-------------------------------------
  ////////////////// second round(20200906)///////////////////////////////////
  ////////////////// second round(20200906)///////////////////////////////////
  //// ----------------start(Approach2)-------------------------------------
  // 20200906
  // refer to leetcode standard solution

  // 87/87 cases passed (0 ms)
  // Your runtime beats 100 % of java submissions
  // Your memory usage beats 68.69 % of java submissions (38 MB)

  public void sortColors(int[] nums) {
    // public void sortColors2(int[] nums) {
    int n = nums.length;
    int pos0 = 0, pos2 = n - 1, cur = 0;
    while (cur <= pos2) {
      // for (;cur <= pos2; cur++) {
      if (nums[cur] == 0) {
        swap(nums, pos0, cur);
        pos0++;
        cur++;
      } else if (nums[cur] == 2) {
        swap(nums, pos2, cur);
        pos2--;
      } else if (nums[cur] == 1) {
        cur++;
      }
    }
  }

  private void swap(int[] nums, int x, int y) {
    int tmp = nums[x];
    nums[x] = nums[y];
    nums[y] = tmp;
  }
  //// ---------------- end (Approach2)-------------------------------------
}
// @lc code=end
