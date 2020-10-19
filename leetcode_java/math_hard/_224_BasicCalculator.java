/*
 * @lc app=leetcode id=224 lang=java
 *
 * [224] Basic Calculator
 */

// @lc code=start
class Solution {
  ////////////////// first round(20200206)///////////////////////////////////
  ////////////////// first round(20200206)///////////////////////////////////
  //// ----------------start(Approach1)-------------------------------------
  // 20200206

  // 37/37 cases passed (9 ms)
  // Your runtime beats 61.7 % of java submissions
  // Your memory usage beats 30.07 % of java submissions (40.2 MB)

  // public int calculate(String s) {
  public int calculate1(String s) {
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

  //// ---------------- end (Approach1)-------------------------------------
  ////////////////// second round(20200804)///////////////////////////////////
  ////////////////// second round(20200804)///////////////////////////////////
  //// ----------------start(Approach2)-------------------------------------
  // 20200804, most part by myself.

  // 37/37 cases passed (42 ms)
  // Your runtime beats 15.19 % of java submissions
  // Your memory usage beats 21.05 % of java submissions (41.3 MB)

  // if i use res += operand * sign;
  // instead of
  // if (operator == '+') {
  // res += operand;
  // } else if (operator == '-') {
  // res -= operand;
  // }

  // 37/37 cases passed (9 ms)
  // Your runtime beats 61.7 % of java submissions
  // Your memory usage beats 30.07 % of java submissions (40.1 MB)

  // public int calculate(String s) {
  public int calculate2(String s) {
    // public int calculate2(String s) {
    Deque<Integer> stack = new ArrayDeque<>();

    int idx = 0;
    int operand = 0;
    int res = 0;
    // char operator = '+';
    int sign = 1;
    while (idx < s.length()) {
      Character ch = s.charAt(idx);
      if (Character.isDigit(ch)) {
        operand = operand * 10 + (ch - '0');
        idx++;
      } else if (Character.isSpace(ch)) {
        idx++;
      }
      // } else {
      if (ch.equals('+') || ch.equals('-') || ch.equals(')') || idx == s.length()) {
        // if (ch.equals('+') || ch.equals('-') || ch.equals('(') || ch.equals(')')
        // || idx == s.length()) {
        res += operand * sign;
        // if (operator == '+') {
        // res += operand;
        // } else if (operator == '-') {
        // res -= operand;
        // }
        operand = 0;
      }
      // System.out.format("res: %d\n", res);
      // System.out.format("stack: %s\n", stack);

      if (ch.equals('+')) {
        // operator = '+';
        sign = 1;
        idx++;
      } else if (ch.equals('-')) {
        // operator = '-';
        sign = -1;
        idx++;
      } else if (ch.equals('(')) {
        stack.push(res);
        stack.push(sign);
        res = 0;
        sign = 1;
        // operator = '+';
        idx++;
      } else if (ch.equals(')')) {
        res = res * stack.pop() + stack.pop();
        idx++;
      }
      // }
      // if (ch.equals(' '))
      // idx++;
    }
    return res;
  }
  //// ---------------- end (Approach2)-------------------------------------
  //// ----------------start(Approach3)-------------------------------------
  // 20200920
  // refer to labuladong<拆解复杂问题：实现计算器>

//37/37 cases passed (163 ms)
// Your runtime beats 8.07 % of java submissions
// Your memory usage beats 5.01 % of java submissions (122.4 MB)

  public int calculate(String s) {
    // public int calculate3(String s) {
    int n = s.length();
    if (n == 0)
      return 0;
    // 1. define necessary variable
    Deque<Integer> stack = new ArrayDeque<>();
    int operand = 0;
    char operator = '+';

    // 2. iteratively check every char
    for (int i = 0; i < n; i++) {
      char c = s.charAt(i);
      if (Character.isDigit(c)) {
        operand = operand * 10 + (c - '0');
      }
      // next, we need to handle "(";
      if (c == '(') {
        String subString = s.substring(i + 1);
        operand = calculate(subString);
        i += getRightBound(subString);
      }
      if (!Character.isDigit(c) && !Character.isSpaceChar(c) || i == n - 1) {
        switch (operator) {
          case '+':
            stack.push(operand);
            break;
          case '-':
            stack.push(-operand);
            break;
        }
        operator = c;
        operand = 0;
      }
      if (c == ')')
        break;

    }
    // sum the stack
    int sum = 0;
    while (!stack.isEmpty()) {
      sum += stack.pop();
    }
    return sum;
  }


  private int getRightBound(String s) {
    int count = 1;
    for (int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);
      if (c == '(') {
        count++;
      } else if (c == ')') {
        count--;
        if (count == 0) {
          return i + 1;
        }
      }
    }
    return -1;
  }
  //// ---------------- end (Approach3)-------------------------------------
}
// @lc code=end
