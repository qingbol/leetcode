/*
 * @lc app=leetcode id=67 lang=java
 *
 * [67] Add Binary
 */

// @lc code=start
class Solution {
  public String addBinary(String a, String b) {
    StringBuilder strRes = new StringBuilder();
    int i = a.length() - 1;
    int j = b.length() - 1;

    int carry = 0;
    while (i >= 0 || j >= 0) {
      int sum = carry;
      if (i >= 0) {
        sum += a.charAt(i) - '0';
        i--;
      }
      if (j >= 0) {
        sum += b.charAt(j) - '0';
        j--;
      }
      strRes.append(sum % 2);
      carry = sum / 2;
    }
    if (carry != 0) {
      strRes.append(carry);
    }
    strRes.reverse();
    return strRes.toString();
  }
}
// @lc code=end
