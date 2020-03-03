/*
 * @lc app=leetcode id=287 lang=java
 *
 * [287] Find the Duplicate Number
 */

// @lc code=start
class Solution {
  public int findDuplicate1(int[] nums) {
    int slow = nums[0];
    int fast = nums[nums[0]];

    while (slow != fast) {
      slow = nums[slow];
      fast = nums[nums[fast]];
    }
    fast = 0;
    while (slow != fast) {
      slow = nums[slow];
      fast = nums[fast];
    }

    return slow;
  }

  //
  public int findDuplicate(int[] nums) {
    int low = 0;
    int high = nums.length - 1;
    int count = 0;
    int mid = 0;
    while (low <= high) {
      mid = (high - low) / 2 + low;
      count = 0;
      for (int num : nums) {
        if (num <= mid) {
          count++;
        }
      }
      if (count <= mid) {
        low = mid + 1;
      } else {
        high = mid - 1;
      }
    }
    return low;

  }
}
// @lc code=end
