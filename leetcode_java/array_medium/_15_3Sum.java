/*
 * @lc app=leetcode id=15 lang=java
 *
 * [15] 3Sum
 */

// @lc code=start
class Solution {
  public List<List<Integer>> threeSum(int[] nums) {
    Arrays.sort(nums);
    List<List<Integer>> lst = new ArrayList<>();
    for (int i = 0; i < nums.length - 2; i++) {
      if (i > 0 && nums[i] == nums[i - 1])
        continue;
      if (nums[i] > 0)
        break;
      int low = i + 1;
      int high = nums.length - 1;
      while (low < high) {
        if (nums[low] + nums[high] == 0 - nums[i]) {
          lst.add(Arrays.asList(nums[i], nums[low], nums[high]));
          while (low < high && nums[low] == nums[low + 1])
            low++;
          while (low < high && nums[high] == nums[high - 1])
            high--;
          low++;
          high--;
        } else if (nums[low] + nums[high] > 0 - nums[i]) {
          high--;
        } else {
          low++;
        }
      }
    }
    return lst;
  }
}
// @lc code=end
