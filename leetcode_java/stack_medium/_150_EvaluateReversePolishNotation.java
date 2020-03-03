/*
 * @lc app=leetcode id=150 lang=java
 *
 * [150] Evaluate Reverse Polish Notation
 */

// @lc code=start
class Solution {
  // my implementation
  public int evalRPN1(String[] tokens) {
    Deque<Integer> rpnStack = new ArrayDeque<>();
    int res = 0;
    for (int i = 0; i < tokens.length; i++) {
      int len = tokens[i].length();
      if (Character.isDigit(tokens[i].charAt(0)) || len > 1 && Character.isDigit(tokens[i].charAt(1))) {
        int val = 0;
        int sign = 1;
        for (Character ch : tokens[i].toCharArray()) {
          if (ch == '-') {
            sign = -1;
          } else {
            val = val * 10 + ch - '0';
          }
        }
        // System.out.format("val: %d\n", val * sign);
        rpnStack.push(val * sign);
      } else if (tokens[i].charAt(0) == '+') {
        res = rpnStack.pop() + rpnStack.pop();
        rpnStack.push(res);
        // System.out.format("res +: %d\n", res);
        // res = 0;
      } else if (len == 1 && tokens[i].charAt(0) == '-') {
        res = rpnStack.pop() * -1 + rpnStack.pop();
        rpnStack.push(res);
        // System.out.format("res -: %d\n", res);
        res = 0;
      } else if (tokens[i].charAt(0) == '*') {
        res = rpnStack.pop() * rpnStack.pop();
        rpnStack.push(res);
        // System.out.format("res *: %d\n", res);
        // res = 0;
      } else if (tokens[i].charAt(0) == '/') {
        int denominator = rpnStack.pop();
        res = rpnStack.pop() / denominator;
        // System.out.format("res /: %d\n", res);
        rpnStack.push(res);
        // res = 0;
      }
    }
    return rpnStack.pop();
  }

  // better approch.
  public int evalRPN(String[] tokens) {
    Deque<Integer> stack = new ArrayDeque<>();
    for (String str : tokens) {
      if (str.equals("+")) {
        stack.push(stack.pop() + stack.pop());
      } else if (str.equals("-")) {
        stack.push(stack.pop() * -1 + stack.pop());
      } else if (str.equals("*")) {
        stack.push(stack.pop() * stack.pop());
      } else if (str.equals("/")) {
        int denominator = stack.pop();
        stack.push(stack.pop() / denominator);
      } else {
        stack.push(Integer.parseInt(str));
      }
    }
    return stack.pop();
  }

}
// @lc code=end
