/*
 * @lc app=leetcode id=167 lang=java
 *
 * [167] Two Sum II - Input array is sorted
 */

// @lc code=start
class Solution {
  ////////////////// first round(20200120)///////////////////////////////////
  ////////////////// first round(20200120)///////////////////////////////////
  //// ----------------start(Approach1)-------------------------------------
  // 20200120,

  public int[] twoSum1(int[] numbers, int target) {
    for (int i = 0; i < numbers.length; i++) {
      if (numbers[i] > target) {
        break;
      }
      int idx = findTarget(numbers, i, target - numbers[i]);
      if (idx != -1) {
        return new int[] {i + 1, idx + 1};
      }
    }
    return new int[] {-1, -1};
  }

  private int findTarget(int[] arr, int start, int aim) {
    int lo = start + 1;
    int hi = arr.length - 1;
    while (lo <= hi) {
      int mid = lo + (hi - lo) / 2;
      if (arr[mid] == aim) {
        return mid;
      } else if (arr[mid] > aim) {
        hi = mid - 1;
      } else {
        lo = mid + 1;
      }
    }
    return -1;
  }

  //// ---------------- end (Approach1)-------------------------------------
  //// ----------------start(Approach2)-------------------------------------
  //
  // public int[] twoSum(int[] numbers, int target) {
  public int[] twoSum2(int[] numbers, int target) {
    int lo = 0;
    int hi = numbers.length - 1;
    while (lo < hi) {
      int sum = numbers[lo] + numbers[hi];
      if (sum == target) {
        return new int[] {lo + 1, hi + 1};
      } else if (sum > target) {
        hi--;
      } else {
        lo++;
      }
    }
    return new int[] {-1, -1};
  }
  //// ---------------- end (Approach2)-------------------------------------
  ////////////////// second round(20200907)///////////////////////////////////
  ////////////////// second round(20200907)///////////////////////////////////
  //// ----------------start(Approach3)-------------------------------------
  // 20200907, by myself

  // 17/17 cases passed (0 ms)
  // Your runtime beats 100 % of java submissions
  // Your memory usage beats 48.94 % of java submissions (39.8 MB)

  public int[] twoSum(int[] numbers, int target) {
    // public int[] twoSum2(int[] numbers, int target) {
    int n = numbers.length;
    int lo = 0, hi = n - 1;
    while (lo < hi) {
      int sum = numbers[lo] + numbers[hi];
      if (sum > target) {
        hi--;
      } else if (sum < target) {
        lo++;
      } else {
        return new int[] {lo + 1, hi + 1};
      }
    }
    return new int[] {-1, -1};
  }
  //// ---------------- end (Approach3)-------------------------------------
}
// @lc code=end
