/*
 * @lc app=leetcode id=189 lang=java
 *
 * [189] Rotate Array
 */

// @lc code=start
class Solution {
  ////////////////// first round(20200115)///////////////////////////////////
  ////////////////// first round(20200115)///////////////////////////////////
  //// ----------------start(Approach1)-------------------------------------
  // 20200115
  public void rotate1(int[] nums, int k) {
    int len = nums.length;
    int i = 1;
    int tmp = nums[len - 1];
    int prePos = len - 1;
    while (i < len) {
      int idx = len - 1 - k * i;
      while (idx < 0) {
        idx += len;
      }
      nums[prePos] = nums[idx];
      // System.out.format("prePos: %d, idx: %d,nums[idx]: %d\n", prePos, idx,
      // nums[idx]);
      prePos = idx;
      i++;
    }
    nums[prePos] = tmp;

  }
  //// ---------------- end (Approach1)-------------------------------------
  //// ----------------start(Approach2)-------------------------------------

  //
  public void rotate2(int[] nums, int k) {
    int len = nums.length;
    int count = 0;
    for (int start = 0; count < len; start++) {
      int cur = (start + k) % len;
      int pre = nums[start];
      while (cur != start) {
        int next = nums[cur];
        nums[cur] = pre;
        pre = next;
        cur = (cur + k) % len;
        count++;
        System.out.format("nums: %s\n", Arrays.toString(nums));
      }
      nums[cur] = pre;
      count++;
      System.out.format("nums: %s\n", Arrays.toString(nums));
    }
  }
  //// ---------------- end (Approach2)-------------------------------------
  //// ----------------start(Approach3)-------------------------------------

  // Using cyclic replacement
  public void rotate3(int[] nums, int k) {
    int len = nums.length;
    int count = 0;
    for (int start = 0; count < len; start++) {
      int cur = start;
      int curVal = nums[cur];
      do {
        int next = (cur + k) % len;
        int tmp = nums[next];
        nums[next] = curVal;
        curVal = tmp;
        cur = next;
        count++;
      } while (cur != start);
    }
  }
  //// ---------------- end (Approach3)-------------------------------------
  //// ----------------start(Approach4)-------------------------------------

  // using reverse
  // public void rotate(int[] nums, int k) {
  public void rotate4(int[] nums, int k) {
    int len = nums.length;
    k %= len;
    reverse(nums, 0, len - 1);
    reverse(nums, 0, k - 1);
    reverse(nums, k, len - 1);
  }

  private void reverse(int[] arr, int start, int end) {
    while (start < end) {
      int tmp = arr[start];
      arr[start++] = arr[end];
      arr[end--] = tmp;
    }
  }
  //// ---------------- end (Approach4)-------------------------------------
  ////////////////// second round(20200911)///////////////////////////////////
  ////////////////// second round(20200911)///////////////////////////////////
  //// ----------------start(Approach5)-------------------------------------
  // 20200911
  // reverse is a great way to solve this problem. just memorize it

  // 35/35 cases passed (0 ms)
  // Your runtime beats 100 % of java submissions
  // Your memory usage beats 75.25 % of java submissions (40 MB)

  public void rotate(int[] nums, int k) {
    // public void rotate5(int[] nums, int k) {
    int n = nums.length;
    k %= n;
    reverse(nums, 0, n - 1);
    reverse(nums, 0, k - 1);
    reverse(nums, k, n - 1);
  }
  //// ---------------- end (Approach5)-------------------------------------
}
// @lc code=end
