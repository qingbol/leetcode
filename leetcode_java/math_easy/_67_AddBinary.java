/*
 * @lc app=leetcode id=67 lang=java
 *
 * [67] Add Binary
 */

// @lc code=start
class Solution {
  ////////////////// first round(20200105)///////////////////////////////////
  ////////////////// first round(20200105)///////////////////////////////////
  //// ----------------start(Approach1)-------------------------------------
  // 20200105

  // public String addBinary(String a, String b) {
  public String addBinary1(String a, String b) {
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
  //// ---------------- end (Approach1)-------------------------------------
  ////////////////// second round(20200905)///////////////////////////////////
  //// ----------------start(Approach1)-------------------------------------
  // 20200905

  // 294/294 cases passed (1 ms)
  // Your runtime beats 100 % of java submissions
  // Your memory usage beats 72.24 % of java submissions (38.6 MB)

  public String addBinary(String a, String b) {
    // public String addBinary2(String a, String b) {
    StringBuilder res = new StringBuilder();
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

      res.append(sum % 2);
      carry = sum / 2;
    }

    if (carry != 0) {
      // if (carry == 1) {
      res.append(carry);
    }
    res.reverse();
    return res.toString();
  }
  //// ---------------- end (Approach2)-------------------------------------
}
// @lc code=end
