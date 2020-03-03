package easy;

/*
 * @lc app=leetcode id=136 lang=java
 *
 * [136] Single Number
 */
public class _136_SingleNumber {
  Solution soluton = new Solution();
}

// @lc code=start
class Solution {
  public int singleNumber(int[] nums) {
    int target = 0;
    for (int num : nums) {
      target ^= num;
    }
    return target;
  }
}
// @lc code=end
