/*
 * @lc app=leetcode id=395 lang=java
 *
 * [395] Longest Substring with At Least K Repeating Characters
 */

// @lc code=start
class Solution {
  ////////////////// first round(20200218)///////////////////////////////////
  ////////////////// first round(20200218)///////////////////////////////////
  //// ---------------start(Approach1)----------------------------------
  // 20200218, brute force
  public int longestSubstring1(String s, int k) {
    if (null == s || 0 == s.length() || k > s.length()) {
      return 0;
    }
    if (k < 2) {
      return s.length();
    }

    int[] bucket = new int[26];
    boolean flag = true;
    int res = Integer.MIN_VALUE;
    for (int i = 0; i < s.length(); i++) {
      for (int j = i; j < s.length(); j++) {
        Arrays.fill(bucket, 0);
        flag = true;
        for (int p = i; p <= j; p++) {
          bucket[s.charAt(p) - 'a']++;
        }
        for (int p = i; p <= j; p++) {
          if (bucket[s.charAt(p) - 'a'] < k) {
            flag = false;
          }
        }
        if (flag) {
          res = Math.max(res, j - i + 1);
        }
      }
    }
    return res == Integer.MIN_VALUE ? 0 : res;
  }

  //// --------------- end (Approach1)----------------------------------
  //// ---------------start(Approach2)----------------------------------
  // recursion
  public int longestSubstring(String s, int k) {
    if (null == s || 0 == s.length() || k > s.length()) {
      return 0;
    }
    return helper(s, 0, s.length(), k);
  }

  private int helper(String s, int l, int r, int k) {
    // build freq map
    int[] bucket = new int[26];
    for (int i = l; i < r; i++) {
      bucket[s.charAt(i) - 'a']++;
    }

    // check validity
    boolean valid = true;
    for (int i = 0; i < bucket.length; i++) {
      if (bucket[i] > 0 && bucket[i] < k) {
        valid = false;
      }
    }
    if (valid == true) {
      return r - l;
    }

    // for each invalid char, start a new split search
    int start = 0;
    int res = 0;
    for (int i = l; i < r; i++) {
      if (bucket[s.charAt(i) - 'a'] < k) {
        res = Math.max(res, helper(s, start, i, k));
        start = i + 1;
      }
    }
    // if from start to r, there's no invalid element, we need to do this
    if (start < r) {
      res = Math.max(res, helper(s, start, r, k));
    }

    return res;
  }
  //// ----------------- end (Appraoch2)----------------------
  ////////////////// second round(20201023)/////////////////////////////////////
  ////////////////// second round(20201023)/////////////////////////////////////
  //// -----------------start(Appraoch3)----------------------
  //20201023
  //refer to leetcode: Approach 3: Sliding Window
  //// ----------------- end (Appraoch3)----------------------
}
// @lc code=end
