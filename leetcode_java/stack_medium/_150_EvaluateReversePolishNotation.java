/*
 * @lc app=leetcode id=150 lang=java
 *
 * [150] Evaluate Reverse Polish Notation
 */

// @lc code=start
class Solution {
  ////////////////// first round(20200206)///////////////////////////////////
  ////////////////// first round(20200206)///////////////////////////////////
  //// ----------------start(Approach1)-------------------------------------
  // 20200206
  // my implementation
  public int evalRPN1(String[] tokens) {
    Deque<Integer> rpnStack = new ArrayDeque<>();
    int res = 0;
    for (int i = 0; i < tokens.length; i++) {
      int len = tokens[i].length();
      if (Character.isDigit(tokens[i].charAt(0))
          || len > 1 && Character.isDigit(tokens[i].charAt(1))) {
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

  //// ---------------- end (Approach1)-------------------------------------
  //// ----------------start(Approach2)-------------------------------------
  //optimal

//   20/20 cases passed (4 ms)
// Your runtime beats 95.69 % of java submissions
// Your memory usage beats 53.97 % of java submissions (39.4 MB)

  public int evalRPN(String[] tokens) {
  // public int evalRPN2(String[] tokens) {
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

  //// ---------------- end (Approach2)-------------------------------------
  ////////////////// third round(20200920)///////////////////////////////////
  ////////////////// third round(20200920)///////////////////////////////////
  //// ----------------start(Approach3)-------------------------------------
  // 20200920

  // 20/20 cases passed (5 ms)
  // Your runtime beats 50.76 % of java submissions
  // Your memory usage beats 58.02 % of java submissions (39.3 MB)

  // public int evalRPN(String[] tokens) {
    public int evalRPN3(String[] tokens) {
    Deque<Integer> stack = new ArrayDeque<>();
    int operand = 0;
    for (String str : tokens) {
      if (str.equals("+") || str.equals("-") || str.equals("*") || str.equals("/")) {
        int part2 = stack.pop();
        int part1 = stack.pop();
        switch (str) {
          case "+":
            stack.push(part1 + part2);
            break;
          case "-":
            stack.push(part1 - part2);
            break;
          case "*":
            stack.push(part1 * part2);
            break;
          case "/":
            stack.push(part1 / part2);
            break;
        }
      } else {
        int sign = 1;
        for (char c : str.toCharArray()) {
          if (c == '-') {
            sign = -1;
          } else {
            operand = operand * 10 + (c - '0');
          }
        }
        stack.push(sign * operand);
        operand = 0;
      }
    }
    return stack.pop();
  }
  //// ---------------- end (Approach3)-------------------------------------
}
// @lc code=end
