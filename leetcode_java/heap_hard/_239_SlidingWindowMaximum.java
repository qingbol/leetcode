/*
 * @lc app=leetcode id=239 lang=java
 *
 * [239] Sliding Window Maximum
 */

// @lc code=start
class Solution {
  //// ----------------start(Approach1)-----------------
  // 20200219. // by myself. brute force method
  // Your runtime beats 94.17 % of java submissions
  public int[] maxSlidingWindow1(int[] nums, int k) {
    if (null == nums || nums.length == 0) {
      return new int[0];
    }
    int[] res = new int[nums.length - k + 1];
    int max = Integer.MIN_VALUE;
    // int nextMax = Integer.MIN_VALUE;
    int idx = 0;

    // System.out.format("res:%s\n", Arrays.toString(res));
    for (int i = k - 1; i < nums.length; i++) {
      if (i == k - 1 || max == nums[i - k]) {
        max = findMax(nums, i - k + 1, i);
      } else if (max != nums[i - k]) {
        max = Math.max(max, nums[i]);
      }
      // System.out.format("i: %d, idx:%d\n", i, idx);
      res[idx++] = max;
    }
    return res;
  }

  private int findMax(int[] arr, int l, int r) {
    int max = arr[l];
    for (int i = l + 1; i <= r; i++) {
      max = Math.max(max, arr[i]);
    }
    return max;
  }

  //// ---------------- end (Approach1)-----------------
  //// ----------------start(Approach2)-----------------
  // 20200219, use deque
  // Your runtime beats 69.42 % of java submissions
  public int[] maxSlidingWindow(int[] nums, int k) {
    if (null == nums || 0 == nums.length) {
      return new int[0];
    }
    if (k == 1) {
      return nums;
    }

    Deque<Integer> deque = new ArrayDeque<>();
    int[] res = new int[nums.length - k + 1];
    int idx = 0;

    for (int i = 0; i < nums.length; i++) {
      // remove the less value elements before Add current element
      while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
        deque.pollLast();
      }
      // add the current element
      deque.offer(i);
      // remove the element out of range
      if (!deque.isEmpty() && deque.peek() == i - k) {
        deque.poll();
      }

      // add max to res
      if (i >= k - 1) {
        res[idx++] = nums[deque.peek()];
      }
    }
    return res;
  }
  //// ---------------- end (Approach2)-----------------

}
// @lc code=end
