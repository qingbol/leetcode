/*
 * @lc app=leetcode id=228 lang=java
 *
 * [228] Summary Ranges
 */

// @lc code=start
class Solution {
  ////////////////// first round(20200217)///////////////////////////////////
  ////////////////// first round(20200217)///////////////////////////////////
  // ------------start(Approach 1)------------------------------------------
  // 20200217

  // public List<String> summaryRanges(int[] nums) {
  public List<String> summaryRanges1(int[] nums) {
    List<String> lst = new ArrayList<>();
    int l = 0;
    int r = 0;
    while (r < nums.length) {
      while (r < nums.length - 1 && nums[r] + 1 == nums[r + 1]) {
        r++;
      }
      String tmp = new String();
      if (r > l) {
        tmp = nums[l] + "->" + nums[r];
      } else {
        tmp = String.valueOf(nums[l]);
      }
      lst.add(tmp);
      r++;
      l = r;
    }
    return lst;
  }
  // ------------ end (Approach 1)------------------------------------------
  ////////////////// second round(20200909)///////////////////////////////////
  ////////////////// second round(20200909)///////////////////////////////////
  // ------------start(Approach 2)------------------------------------------
  // 20200909, by myself

  // 28/28 cases passed (7 ms)
  // Your runtime beats 51.37 % of java submissions
  // Your memory usage beats 90.91 % of java submissions (37.6 MB)

  public List<String> summaryRanges(int[] nums) {
    // public List<String> summaryRanges2(int[] nums) {
    int n = nums.length;
    List<String> res = new ArrayList<>();
    if (n == 0)
      return res;

    int start = nums[0];
    int end = nums[0];
    for (int i = 1; i < n; i++) {
      if (nums[i] == end + 1) {
        end = nums[i];
      } else {
        if (start == end) {
          res.add(String.valueOf(start));
          // res.add(start + "");
        } else {
          res.add(start + "->" + end);
        }
        start = end = nums[i];
      }
    }

    if (start == end) {
      res.add(start + "");
    } else {
      res.add(start + "->" + end);
    }
    return res;
  }
  // ------------ end (Approach 1)------------------------------------------
}
// @lc code=end
