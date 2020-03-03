/*
 * @lc app=leetcode id=228 lang=java
 *
 * [228] Summary Ranges
 */

// @lc code=start
class Solution {
  public List<String> summaryRanges(int[] nums) {
    List<String> lst = new ArrayList<>();
    int l = 0;
    int r = 0;
    while (r < nums.length) {
      while (r < nums.length - 1 && nums[r] + 1 == nums[r + 1]) {
        r++;
      }
      String tmp = new String();
      if (r > l) {
        tmp = nums[l] + "->" + nums[r];
      } else {
        tmp = String.valueOf(nums[l]);
      }
      lst.add(tmp);
      r++;
      l = r;
    }
    return lst;
  }
}
// @lc code=end
