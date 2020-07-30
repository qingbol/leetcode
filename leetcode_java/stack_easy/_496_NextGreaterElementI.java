/*
 * @lc app=leetcode id=496 lang=java
 *
 * [496] Next Greater Element I
 */

// @lc code=start
class Solution {
  ////////////////// first round(20200729)///////////////////////////////////
  ////////////////// first round(20200729)///////////////////////////////////
  //// ----------------start(Approach1)-------------------------------------
  ////20200729.
  //refer to labuladong<特殊数据结构：单调栈> & leetcode standard solution.
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Deque<Integer> stack = new ArrayDeque<>();
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = nums2.length - 1; i >= 0; i--) {
          while (!stack.isEmpty() && stack.peek() <= nums2[i]) {
            stack.pop();
          }
          map.put(nums2[i], stack.isEmpty() ? -1 : stack.peek());
          stack.push(nums2[i]);
        }

        int[] res = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
          res[i] = map.get(nums1[i]);
        }
        return res;
    }
  //// ---------------- end (Approach1)-------------------------------------
}
// @lc code=end

