/*
 * @lc app=leetcode id=125 lang=java
 *
 * [125] Valid Palindrome
 */

// @lc code=start
class Solution {
  ////////////////// first round(20200215)//////////////////////////////////////
  ////////////////// first round(20200215)//////////////////////////////////////
  //// -------------start(approach 1) -------------------------------------
  // 20200215

  // public boolean isPalindrome(String s) {
  public boolean isPalindrome1(String s) {
    if (null == s || s.length() < 2) {
      return true;
    }
    int l = 0;
    int r = s.length() - 1;
    while (l < r) {
      while (l < r && !Character.isLetterOrDigit(s.charAt(l))) {
        l++;
      }
      while (l < r && !Character.isLetterOrDigit(s.charAt(r))) {
        r--;
      }
      char left = s.charAt(l);
      if (Character.isUpperCase(s.charAt(l))) {
        left = Character.toLowerCase(left);
      }
      char right = s.charAt(r);
      if (Character.isUpperCase(s.charAt(r))) {
        right = Character.toLowerCase(right);
      }
      if (left != right) {
        return false;
      }
      l++;
      r--;
    }
    return true;
  }
  //// ------------------- end (approach1)--------------------------------------
  ////////////////// second round(20201027)////////////////////////////////////
  ////////////////// second round(20201027)////////////////////////////////////
  //// -------------------start(approach2)--------------------------------------
  // 20201027.
  // refer to leetcode : <Approach 1: Compare with Reverse>

  /** An alternate solution using Java 8 Streams */
  // public boolean isPalindromeUsingStreams(String s) {
  public boolean isPalindrome(String s) {
    StringBuilder builder = new StringBuilder();

    s.chars().filter(c -> Character.isLetterOrDigit(c))
    .mapToObj(c -> Character.toLowerCase((char) c)).forEach(builder::append);

    // s.chars().filter(c -> Character.isLetterOrDigit(c)).map(c -> Character.toLowerCase((char) c))
    //     .forEach(builder::append);

    System.out.format("builder:%s\n", builder.toString());
    System.out.format("reverse:%s\n", builder.reverse().toString());
    return builder.toString().equals(builder.reverse().toString());
  }
  //// ------------------- end (approach2)--------------------------------------
}
// @lc code=end
