/*
 * @lc app=leetcode id=9 lang=java
 *
 * [9] Palindrome Number
 */

// @lc code=start
class Solution {
  ////////////////// first round(20200220)//////////////////////////////////////
  ////////////////// first round(20200220)//////////////////////////////////////
  //// -------------start(approach 1) -------------------------------------
  //20200220
  public boolean isPalindrome1(int x) {
    String s = String.valueOf(x);
    if (s.length() < 2) {
      return true;
    }

    for (int l = 0, r = s.length() - 1; l < r; l++, r--) {
      if (s.charAt(l) != (s.charAt(r))) {
        return false;
      }
    }
    return true;
  }

  //// ------------------- end (approach1)--------------------------------------
  //// -------------------start(approach2)--------------------------------------
  // math
  public boolean isPalindrome(int x) {
    if (x < 0 || x % 10 == 0 && x != 0) {
      return false;
    }
    int secondHalf = 0;
    while (x > secondHalf) {
      secondHalf = secondHalf * 10 + x % 10;
      x = x / 10;
    }
    return x == secondHalf || x == secondHalf / 10;
  }
  //// ------------------- end (approach3)--------------------------------------
  ////////////////// second round(20201027)////////////////////////////////////
  ////////////////// second round(20201027)////////////////////////////////////
  //// -------------------start(approach4)--------------------------------------
  //20201027.
  //// ------------------- end (approach4)--------------------------------------
}
// @lc code=end
