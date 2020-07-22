/*
 * @lc app=leetcode id=80 lang=java
 *
 * [80] Remove Duplicates from Sorted Array II
 */

// @lc code=start
class Solution {
  //////////////////first round(202000111)////////////////////////
  //////////////////first round(202000111)////////////////////////
  //// --------------------start(Approach1)----------------------
  // 20200111.
  public int removeDuplicates1(int[] nums) {
    if (1 == nums.length) {
      return 1;
    }
    int left = 0;
    int right = 1;
    int res = 1;
    int flag = 0;
    while (left <= right && right < nums.length) {
      // System.out.println("res1: " + res);
      flag = 0;
      while (left <= right && right < nums.length && nums[left] == nums[right]) {
        // System.out.println("res2: " + res);
        flag++;
        if (flag < 2) {
          // System.out.println("res3: " + res);
          // right++;
          left++;
          // System.out.println("res4: " + res);
          if (left < nums.length) {
            // System.out.println("res7: " + res);
            nums[left] = nums[right++];
            res++;
          }
        } else {
          right++;
        }
      }

      // System.out.println("res5: " + res);
      left++;
      if (left <= right && right < nums.length) {
        nums[left] = nums[right++];
        res++;
      }
    }
    // System.out.println("res6: " + res);
    return res;
  }

  //// -------------------- end (Approach1)----------------------
  //// --------------------start(Approach2)----------------------
  // 20200111.
  // optimal
  public int removeDuplicates2(int[] nums) {
    if (nums.length < 3) {
      return nums.length;
    }
    int res = 2;
    for (int i = 2; i < nums.length; i++) {
      if (nums[i - 2] != nums[i]) {
        nums[res++] = nums[i];
      }
    }
    return res;
  }
  //// -------------------- end (Approach2)----------------------
  //////////////////second round(20200718)////////////////////////
  //////////////////second round(20200718)////////////////////////
  //// --------------------start(Approach3)----------------------
  // 20200718
  // 166/166 cases passed (1 ms)
  // Your runtime beats 46.46 % of java submissions
  // Your memory usage beats 8.83 % of java submissions (41.9 MB)

  public int removeDuplicates(int[] nums) {
    // public int removeDuplicates3(int[] nums) {
    int idx = 2;
    for (int i = 2; i < nums.length; i++) {
      if (nums[i] != nums[idx - 2]) {
        nums[idx++] = nums[i];
      }
    }
    return idx;
  }
  //// -------------------- end (Approach3)----------------------
}
// @lc code=end
