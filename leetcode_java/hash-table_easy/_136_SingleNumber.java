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
  ////////////////// first round(20200103)///////////////////////////////////
  ////////////////// first round(20200103)///////////////////////////////////
  //// ----------------start(Approach1)-------------------------------------
  // 20200103

  // public int singleNumber(int[] nums) {
  public int singleNumber1(int[] nums) {
    int target = 0;
    for (int num : nums) {
      target ^= num;
    }
    return target;
  }
  //// ---------------- end (Approach1)-------------------------------------
  ////////////////// second round(20200904)///////////////////////////////////
  ////////////////// second round(20200904)///////////////////////////////////
  //// ----------------start(Approach1)-------------------------------------
  // 20200904

  // 16/16 cases passed (0 ms)
  // Your runtime beats 100 % of java submissions
  // Your memory usage beats 65.1 % of java submissions (40.5 MB)

  public int singleNumber(int[] nums) {
    // public int singleNumber2(int[] nums) {
    int res = 0;
    for (int num : nums) {
      res ^= num;
    }
    return res;
  }
  //// ---------------- end (Approach2)-------------------------------------

}
// @lc code=end
