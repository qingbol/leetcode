/*
 * @lc app=leetcode id=266 lang=java
 *
 * [266] Palindrome Permutation
 */

// @lc code=start
class Solution {
  ////////////////// first round(20200220)//////////////////////////////////////
  ////////////////// first round(20200220)//////////////////////////////////////
  //// -------------start(approach 1) -------------------------------------
  //20200220
  public boolean canPermutePalindrome(String s) {
    if (s.length() < 2) {
      return true;
    }
    int[] bucket = new int[256];
    for (char ch : s.toCharArray()) {
      bucket[ch - '\0']++;
    }
    int num = 0;
    for (int i = 0; i < 256; i++) {
      if (bucket[i] % 2 == 1) {
        num++;
        if (num > 1) {
          return false;
        }
      }
    }
    return true;
  }
  //// ------------------- end (approach1)--------------------------------------
  ////////////////// second round(20201027)////////////////////////////////////
  ////////////////// second round(20201027)////////////////////////////////////
  //// -------------------start(approach2)--------------------------------------
  // 20201027.
  //// ------------------- end (approach2)--------------------------------------
}
// @lc code=end
