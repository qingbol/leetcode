/*
 * @lc app=leetcode id=152 lang=java
 *
 * [152] Maximum Product Subarray
 */

// @lc code=start
class Solution {
  ////////////////// first round(20200404)///////////////////////////////////
  ////////////////// first round(20200404)///////////////////////////////////
  //// ---------------------start(Approach1)------------------------
  // 20200404, by myself.
  // Your runtime beats 10.33 % of java submissions
  public int maxProduct1(int[] nums) {
    int n = nums.length;
    if (n == 0) {
      return 0;
    }

    int[] product = new int[3];
    Arrays.fill(product, nums[0]);
    int gloabalProduct = nums[0];

    for (int i = 1; i < n; i++) {
      int min = product[0];
      int max = product[0];
      for (int j = 1; j < 3; j++) {
        min = Math.min(min, product[j]);
        max = Math.max(max, product[j]);
      }
      product[0] = nums[i] * max;
      product[1] = nums[i] * min;
      product[2] = nums[i];

      max = product[0];
      for (int j = 1; j < 3; j++) {
        max = Math.max(max, product[j]);
      }
      gloabalProduct = Math.max(gloabalProduct, max);
    }

    return gloabalProduct;
  }

  //// --------------------- end (Approach1)------------------------
  //// ---------------------start(Approach2)------------------------
  // 20200404, dp, improvement of approach1.
  // Your runtime beats 11.02 % of java submissions

  // public int maxProduct(int[] nums) {
  public int maxProduct2(int[] nums) {
    if (nums.length == 0) {
      return 0;
    }

    int imin = nums[0];
    int imax = nums[0];
    int res = nums[0];
    for (int i = 1; i < nums.length; i++) {
      if (nums[i] < 0) {
        int tmp = imin;
        imin = imax;
        imax = tmp;
      }

      imax = Math.max(nums[i], nums[i] * imax);
      imin = Math.min(nums[i], nums[i] * imin);
      res = Math.max(res, imax);
    }
    return res;
  }

  //// --------------------- end (Approach2)------------------------
  ////////////////// second round(20200910)///////////////////////////////////
  ////////////////// second round(20200910)///////////////////////////////////
  //// --------------start(Approach3)------------------------
  // 20200910.
  // cant come up with a correct solution by myself.
  // refer to Approach 2: Dynamic Programming

  // 187/187 cases passed (1 ms)
  // Your runtime beats 95.22 % of java submissions
  // Your memory usage beats 100 % of java submissions (38.7 MB)

  public int maxProduct(int[] nums) {
    // public int maxProduct3(int[] nums) {
    int n = nums.length;
    if (n == 0)
      return 0;

    int res = nums[0];
    int minSoFar = nums[0];
    int maxSoFar = nums[0];
    for (int i = 1; i < n; i++) {
      int maxTmp = Math.max(nums[i], Math.max(maxSoFar * nums[i], minSoFar * nums[i]));
      minSoFar = Math.min(nums[i], Math.min(maxSoFar * nums[i], minSoFar * nums[i]));
      maxSoFar = maxTmp;
      res = Math.max(res, maxSoFar);
    }
    return res;
  }
  //// --------------------- end (Approach3)------------------------
}
// @lc code=end
