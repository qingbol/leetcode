/*
 * @lc app=leetcode id=264 lang=java
 *
 * [264] Ugly Number II
 */

// @lc code=start
class Solution {
  ////////////////// first round(20200107)///////////////////////////////////
  ////////////////// first round(20200107)///////////////////////////////////
  //// ----------------start(Approach1)-------------------------------------
  // 20200107
  public int nthUglyNumber1(int n) {
    if (1 == n) {
      return 1;
    }
    int sequence = 1;
    int upTo = 2;
    while (n != sequence) {
      if (true == isUgly(upTo)) {
        sequence++;
      }
      upTo++;
    }
    return --upTo;
  }

  private boolean isUgly(int x) {
    while (0 == x % 2) {
      x /= 2;
    }
    while (0 == x % 3) {
      x /= 3;
    }
    while (0 == x % 5) {
      x /= 5;
    }
    return 1 == x;
  }

  //// ---------------- end (Approach1)-------------------------------------
  //// ----------------start(Approach2)-------------------------------------
  // optimal solution

  // public int nthUglyNumber(int n) {
  public int nthUglyNumber2(int n) {
    int[] uglyArray = new int[n];
    uglyArray[0] = 1;
    int index2 = 0;
    int index3 = 0;
    int index5 = 0;
    for (int i = 1; i < n; i++) {
      uglyArray[i] =
          Math.min(uglyArray[index2] * 2, Math.min(uglyArray[index3] * 3, uglyArray[index5] * 5));
      if (uglyArray[i] == uglyArray[index2] * 2) {
        index2++;
      }
      if (uglyArray[i] == uglyArray[index3] * 3) {
        index3++;
      }
      if (uglyArray[i] == uglyArray[index5] * 5) {
        index5++;
      }
    }
    return uglyArray[n - 1];
  }
  //// ---------------- end (Approach2)-------------------------------------
  ////////////////// second round(20200906)///////////////////////////////////
  ////////////////// second round(20200906)///////////////////////////////////
  //// ----------------start(Approach3)-------------------------------------
  // 20200906
  // refer to leetcode standard solution

  // 596/596 cases passed (2 ms)
  // Your runtime beats 98.03 % of java submissions
  // Your memory usage beats 86.09 % of java submissions (37.4 MB)

  public int nthUglyNumber(int n) {
    // public int nthUglyNumber3(int n) {
    int[] nums = new int[n];
    nums[0] = 1;
    int idx2 = 0, idx3 = 0, idx5 = 0;
    for (int i = 1; i < n; i++) {
      nums[i] = Math.min(nums[idx2] * 2, Math.min(nums[idx3] * 3, nums[idx5] * 5));
      if (nums[i] == nums[idx2] * 2)
        idx2++;
      if (nums[i] == nums[idx3] * 3)
        idx3++;
      if (nums[i] == nums[idx5] * 5)
        idx5++;
    }
    return nums[n - 1];
  }
  //// ---------------- end (Approach3)-------------------------------------
}
// @lc code=end
