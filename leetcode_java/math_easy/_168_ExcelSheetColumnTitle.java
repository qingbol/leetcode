/*
 * @lc app=leetcode id=168 lang=java
 *
 * [168] Excel Sheet Column Title
 */

// @lc code=start
class Solution {
  public String convertToTitle(int n) {
    // n = n - 1;
    StringBuilder sb = new StringBuilder();
    // char ch = '\0';
    while (n > 0) {
      // while ((n - 1) / 26 > 0) {
      n--;
      char ch = (char) (n % 26 + 'A');
      // if (sb.length() == 0) {
      // ch = (char) (n % 26 + 'A');
      // } else {
      // ch = (char) ((n - 1) % 26 + 'A');
      // }
      sb.insert(0, ch);
      n = n / 26;
    }
    // if (sb.length() == 0) {
    // ch = (char) (n % 26 + 'A');
    // } else {
    // ch = (char) ((n - 1) % 26 + 'A');
    // }
    // sb.insert(0, ch);
    // char first = (n - 1) / 26 == 0 ? '\0' : (char) ((n - 1) / 26 - 1 + 'A');
    // char second = (char) ((n - 1) % 26 + 'A');
    // // System.out.format("first: %c, second: %c \n", first, second);
    // String res = "";
    // if (first != '\0') {
    // res += first;
    // }
    // res += second;
    return sb.toString();
  }
}
// @lc code=end
