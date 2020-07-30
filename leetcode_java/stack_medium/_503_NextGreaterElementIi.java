/*
 * @lc app=leetcode id=503 lang=java
 *
 * [503] Next Greater Element II
 */

// @lc code=start
class Solution {
  ////////////////// first round(20200729)///////////////////////////////////
  ////////////////// first round(20200729)///////////////////////////////////
  //// ----------------start(Approach1)-------------------------------------
  // 20200729
  // refer to labuladong <特殊数据结构：单调栈>
  // 224/224 cases passed (10 ms)
  // Your runtime beats 66.95 % of java submissions
  // Your memory usage beats 5.26 % of java submissions (52.7 MB)

  public int[] nextGreaterElements(int[] nums) {
    int n = nums.length;
    Deque<Integer> stack = new ArrayDeque<>();
    int[] res = new int[n];

    for (int i = 2 * n - 1; i >= 0; i--) {
      // System.out.format("stack: %s\n", stack);
      while (!stack.isEmpty() && nums[i % n] >= nums[stack.peek()]) {
        stack.pop();
      }
      // System.out.format("i%n : %d, empty: %b\n", i % n, stack.isEmpty());

      res[i % n] = stack.isEmpty() ? -1 : nums[stack.peek()];
      stack.push(i % n);
    }
    return res;
  }
  //// ---------------- end (Approach1)-------------------------------------
}
// @lc code=end

