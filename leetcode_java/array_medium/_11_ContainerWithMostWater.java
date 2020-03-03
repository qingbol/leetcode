/*
 * @lc app=leetcode id=11 lang=java
 *
 * [11] Container With Most Water
 */

// @lc code=start
class Solution {
  public int maxArea(int[] height) {
    int vol = 0;
    int left = 0;
    int right = height.length - 1;
    int leftMax = 0;
    int rightMax = 0;
    while (left < right) {
      leftMax = height[left];
      rightMax = height[right];
      if (height[left] < height[right]) {
        vol = Math.max(vol, (right - left) * height[left]);
        while (left < right && height[left] <= leftMax)
          ++left;
      } else {
        vol = Math.max(vol, (right - left) * height[right]);
        while (left < right && height[right] <= rightMax)
          --right;
      }
    }

    return vol;
  }
}
// @lc code=end
