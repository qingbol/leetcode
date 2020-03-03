/*
 * @lc app=leetcode id=280 lang=java
 *
 * [280] Wiggle Sort
 */

// @lc code=start
class Solution {
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

  public void wiggleSort2(int[] nums) {
    Arrays.sort(nums);
    for (int i = 1; i < nums.length - 1; i += 2) {
      swap(nums, i, i + 1);
    }
  }

  public void wiggleSort(int[] nums) {
    for (int i = 1; i < nums.length; i++) {
      if ((1 == i % 2) != (nums[i] > nums[i - 1])) {
        swap(nums, i, i - 1);
      }
    }
  }
}
// @lc code=end
