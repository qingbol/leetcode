/*
 * @lc app=leetcode id=287 lang=java
 *
 * [287] Find the Duplicate Number
 */

// @lc code=start
class Solution {
  ////////////////// first round(20200111)///////////////////////////////////
  ////////////////// first round(20200111)///////////////////////////////////
  //// ----------------start(Approach1)-------------------------------------
  // 20200111, find the start of circle
  //refrer to leetcode standard solution: 
  // Approach 3: Floyd's Tortoise and Hare (Cycle Detection)
  
  public int findDuplicate1(int[] nums) {
  // public int findDuplicate(int[] nums) {
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

  //// ---------------- end (Approach1)-------------------------------------
  //// ----------------start(Approach2)-------------------------------------
  //
  // public int findDuplicate(int[] nums) {
  public int findDuplicate2(int[] nums) {
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
  //// ---------------- end (Approach2)-------------------------------------
  ////////////////// second round(20200907)///////////////////////////////////
  ////////////////// second round(20200907)///////////////////////////////////
  //// ----------------start(Approach3)-------------------------------------
  // 20200907, by myself.

//   53/53 cases passed (1 ms)
// Your runtime beats 68.62 % of java submissions
// Your memory usage beats 83.49 % of java submissions (39.4 MB)
  
  // public int findDuplicate3(int[] nums) {
  public int findDuplicate(int[] nums) {
    int m = nums.length;
    for (int i = 0; i < m; i++) {
      int idx = Math.abs(nums[i]);
      if (nums[idx] > 0) {
        nums[idx] = -nums[idx];
      } else {
        return idx;
      }
    }
    return -1;
  }
  //// ---------------- end (Approach3)-------------------------------------
}
// @lc code=end
