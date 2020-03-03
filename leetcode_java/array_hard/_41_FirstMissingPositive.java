/*
 * @lc app=leetcode id=41 lang=java
 *
 * [41] First Missing Positive
 */

// @lc code=start
class Solution {
  public int firstMissingPositive(int[] nums) {

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
}
// @lc code=end
