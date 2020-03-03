/*
 * @lc app=leetcode id=224 lang=java
 *
 * [224] Basic Calculator
 */

// @lc code=start
class Solution {
  public int calculate(String s) {
    if (null == s || 0 == s.length()) {
      return 0;
    }
    int idx = 0;
    Deque<Integer> numStack = new ArrayDeque<>();
    Character ch = s.charAt(idx);
    int sign = 1;
    int res = 0;
    while (idx < s.length()) {
      ch = s.charAt(idx);
      if (Character.isDigit(ch)) {
        int factor = 0;
        while (idx < s.length() && Character.isDigit(s.charAt(idx))) {
          // System.out.println("ch: " + ch);
          factor = factor * 10 + s.charAt(idx) - '0';
          idx++;
        }
        // System.out.println("factor: " + factor);
        res = res + factor * sign;
        // System.out.println("local res: " + res);
        // numStack.push(factor * sign);
      } else if (ch == '+') {
        sign = 1;
        idx++;
      } else if (ch == '-') {
        sign = -1;
        idx++;
      } else if (ch == '(') {
        numStack.push(res);
        numStack.push(sign);
        res = 0;
        sign = 1;
        idx++;
      } else if (ch == ')') {
        res = res * numStack.pop() + numStack.pop();
        idx++;
      } else if (ch == ' ') {
        idx++;
      }
    }
    // while (!numStack.isEmpty()) {
    // res += numStack.pop();
    // }
    return res;
  }
};
// @lc code=end
