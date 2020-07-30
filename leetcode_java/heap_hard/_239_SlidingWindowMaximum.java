/*
 * @lc app=leetcode id=239 lang=java
 *
 * [239] Sliding Window Maximum
 */

// @lc code=start
class Solution {
  ////////////////// first round(20200219)///////////////////////////////////
  ////////////////// first round(20200219)///////////////////////////////////
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

  // public int[] maxSlidingWindow(int[] nums, int k) {
  public int[] maxSlidingWindow2(int[] nums, int k) {
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
  ////////////////// second round(20200729)///////////////////////////////////
  ////////////////// second round(20200729)///////////////////////////////////
  //// ----------------start(Approach3)-----------------
  // 20200729
  //refer to labuladong <特殊数据结构：单调队列>

  // 18/18 cases passed (17 ms)
  // Your runtime beats 42.42 % of java submissions
  // Your memory usage beats 72.41 % of java submissions (51.6 MB)

  public int[] maxSlidingWindow(int[] nums, int k) {
    // public int[] maxSlidingWindow3(int[] nums, int k) {
    int n = nums.length;
    int[] res = new int[n - k + 1];
    MonotonicQueue<Integer> mq = new MonotonicQueue<>();

    for (int i = 0; i < n; i++) {
      if (i < k - 1) {
        mq.offer(nums[i]);
      } else {
        mq.offer(nums[i]);
        res[i - k + 1] = mq.getMax();
        mq.remove(nums[i - k + 1]);
      }
    }

    return res;
  }

  class MonotonicQueue<T extends Comparable<T>> {
    Deque<T> q;

    public MonotonicQueue() {
      q = new ArrayDeque<>();
    }

    public void offer(T elem) {
      while (!q.isEmpty() && q.peekLast().compareTo(elem) < 0) {
        q.pollLast();
      }
      q.offer(elem);
    }

    public T getMax() {
      return q.peek();
    }

    public void remove(T elem) {
      if (!q.isEmpty() && q.peek().equals(elem)) {
        q.poll();
      }
    }
  }
  //// ---------------- end (Approach3)-----------------

}
// @lc code=end
