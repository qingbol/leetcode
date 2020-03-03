/*
 * @lc app=leetcode id=229 lang=java
 *
 * [229] Majority Element II
 */

// @lc code=start
class Solution {
  public List<Integer> majorityElement(int[] nums) {
    List<Integer> res = new ArrayList<>();
    if (null == nums) {
      return res;
    }
    int num1 = 0;
    int num2 = 0;
    int cnt1 = 0;
    int cnt2 = 0;
    for (int i = 0; i < nums.length; i++) {
      if (num1 == nums[i]) {
        cnt1++;
      } else if (num2 == nums[i]) {
        cnt2++;
      } else if (cnt1 == 0) {
        num1 = nums[i];
        cnt1 = 1;
      } else if (cnt2 == 0) {
        num2 = nums[i];
        cnt2 = 1;
      } else {
        cnt1--;
        cnt2--;
      }
    }

    cnt1 = 0;
    cnt2 = 0;
    for (int num : nums) {
      if (num1 == num) {
        cnt1++;
      } else if (num2 == num) {
        cnt2++;
      }
    }
    if (cnt1 > nums.length / 3) {
      res.add(num1);
    }
    if (cnt2 > nums.length / 3) {
      res.add(num2);
    }
    return res;
  }
}
// @lc code=end
