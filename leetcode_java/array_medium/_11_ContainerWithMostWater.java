/*
 * @lc app=leetcode id=11 lang=java
 *
 * [11] Container With Most Water
 */

// @lc code=start
class Solution {
  ////////////////// first round(20200110)///////////////////////////////////
  ////////////////// first round(20200110)///////////////////////////////////
  //// --------------start(Approach1)------------------------
  // 20200110.

  // public int maxArea(int[] height) {
  public int maxArea1(int[] height) {
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
  //// --------------------- end (Approach1)------------------------
  ////////////////// second round(20200910)///////////////////////////////////
  ////////////////// second round(20200910)///////////////////////////////////
  //// --------------start(Approach3)------------------------
  // 20200910. by myself.

  // 50/50 cases passed (2 ms)
  // Your runtime beats 96.58 % of java submissions
  // Your memory usage beats 78.57 % of java submissions (39.7 MB)

  public int maxArea(int[] height) {
    // public int maxArea2(int[] height) {
    int n = height.length;
    if (n < 2)
      return 0;
    int left = 0, right = n - 1;
    int res = 0;
    while (left < right) {
      res = Math.max(res, Math.min(height[left], height[right]) * (right - left));
      if (height[left] < height[right]) {
        left++;
      } else {
        right--;
      }
    }
    return res;
  }
  //// --------------------- end (Approach1)------------------------
}
// @lc code=end
