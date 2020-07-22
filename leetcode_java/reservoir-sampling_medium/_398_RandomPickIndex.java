/*
 * @lc app=leetcode id=398 lang=java
 *
 * [398] Random Pick Index
 */

// @lc code=start
////////////////////////first round(20200127)////////////////////////
////////////////////////first round(20200127)////////////////////////
/////-------------------start(Approach1)-----------------------------
//20200127

class Solution1 {
// public class Solution {
  int[] nums;
  Random rand;

  // public Solution(int[] nums) {
  public Solution1(int[] nums) {
    this.nums = nums;
    this.rand = new Random();
  }

  public int pick(int target) {
    int idx = -1;
    int cnt = 1;
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] == target && rand.nextInt(cnt++) == 0) {
        idx = i;
      }
    }
    return idx;
  }
}
/////------------------- end (Approach1)-----------------------------

////////////////////////second round(20200720)////////////////////////
////////////////////////second round(20200720)////////////////////////
/////-------------------start(Approach2)-----------------------------
//20200720. refer to labuladong <如何在无限序列中随机抽取元素>

// 13/13 cases passed (94 ms)
// Your runtime beats 25.57 % of java submissions
// Your memory usage beats 7.4 % of java submissions (72.1 MB)

// class Solution2 {
public class Solution {
  private int[] nums;
  private Random rand;

  public Solution(int[] nums) {
  // public Solution2(int[] nums) {
    this.nums = nums;
    rand = new Random(47);
  }

  public int pick(int target) {
    int k = 0; 
    int res = -1;
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] == target) {
        if (rand.nextInt(++k) == 0) {
          res = i;
        }
      }
    }
    return res;
  }
}
/////------------------- end (Approach2)-----------------------------

// /**
// * Your Solution object will be instantiated and called as such: Solution obj
// =
// * new Solution(nums); int param_1 = obj.pick(target);
// */
// @lc code=end
