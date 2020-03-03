/*
 * @lc app=leetcode id=80 lang=java
 *
 * [80] Remove Duplicates from Sorted Array II
 */

// @lc code=start
class Solution {
  public int removeDuplicates1(int[] nums) {
    if (1 == nums.length) {
      return 1;
    }
    int left = 0;
    int right = 1;
    int res = 1;
    int flag = 0;
    while (left <= right && right < nums.length) {
      // System.out.println("res1: " + res);
      flag = 0;
      while (left <= right && right < nums.length && nums[left] == nums[right]) {
        // System.out.println("res2: " + res);
        flag++;
        if (flag < 2) {
          // System.out.println("res3: " + res);
          // right++;
          left++;
          // System.out.println("res4: " + res);
          if (left < nums.length) {
            // System.out.println("res7: " + res);
            nums[left] = nums[right++];
            res++;
          }
        } else {
          right++;
        }
      }

      // System.out.println("res5: " + res);
      left++;
      if (left <= right && right < nums.length) {
        nums[left] = nums[right++];
        res++;
      }
    }
    // System.out.println("res6: " + res);
    return res;
  }

  // optimal
  public int removeDuplicates1(int[] nums) {
    if (nums.length < 3) {
      return nums.length;
    }
    int res = 2;
    for (int i = 2; i < nums.length; i++) {
      if (nums[i - 2] != nums[i]) {
        nums[res++] = nums[i];
      }
    }

  }
}
// @lc code=end
