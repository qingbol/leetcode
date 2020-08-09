import jdk.javadoc.internal.doclets.toolkit.resources.doclets;

/*
 * @lc app=leetcode id=227 lang=java
 *
 * [227] Basic Calculator II
 */

// @lc code=start
class Solution {
  ////////////////// first round(20200207)///////////////////////////////////
  ////////////////// first round(20200207)///////////////////////////////////
  //// --------------start(Approach1)------------------
  // 20200207
  // stack. based on my own idea
  public int calculate1(String s) {
    Deque<Integer> numStack = new ArrayDeque<>();
    Deque<Character> charStack = new ArrayDeque<>();
    int idx = 0;
    int res = 0;
    while (idx < s.length()) {
      Character ch = s.charAt(idx);
      if (Character.isDigit(ch)) {
        int val = 0;
        while (idx < s.length() && Character.isDigit(s.charAt(idx))) {
          val = val * 10 + s.charAt(idx) - '0';
          idx++;
        }
        if (!charStack.isEmpty()) {
          if (charStack.peek().equals('*')) {
            charStack.pop();
            val = val * numStack.pop();
          } else if (charStack.peek().equals('/')) {
            charStack.pop();
            val = numStack.pop() / val;
          } else if (charStack.peek().equals('-')) {
            charStack.pop();
            val = -val;
          }
        }
        numStack.push(val);
      } else if (ch.equals('+') || ch.equals('-') || ch.equals('*') || ch.equals('/')) {
        charStack.push(ch);
        idx++;
      } else if (ch.equals(' ')) {
        idx++;
      }
    }
    // while (!charStack.isEmpty()) {
    // if (charStack.peek().equals('+')) {
    // charStack.pop();
    // tmp = numStack.pop() + numStack.pop();
    // // res += tmp;
    // numStack.push(tmp);
    // } else if (charStack.peek().equals('-')) {
    // charStack.pop();
    // tmp = numStack.pop() * -1 + numStack.pop();
    // // res += tmp;
    // numStack.push(tmp);
    // }
    // System.out.println("charStack: " + charStack);
    // System.out.println("res: " + res);
    // }
    while (!numStack.isEmpty()) {
      res += numStack.pop();
    }
    return res;
  }

  //// -------------- end (Approach1)------------------
  //// --------------start(Approach2)------------------
  // 20200207
  // stack. based on my own idea. improve
  // public int calculate(String s) {
  public int calculate2(String s) {
    Deque<Integer> numStack = new ArrayDeque<>();
    Character sign = '+';
    int idx = 0;
    int res = 0;
    while (idx < s.length()) {
      Character ch = s.charAt(idx);
      if (Character.isDigit(ch)) {
        int val = 0;
        while (idx < s.length() && Character.isDigit(s.charAt(idx))) {
          val = val * 10 + s.charAt(idx) - '0';
          idx++;
        }
        if (sign.equals('*')) {
          val = val * numStack.pop();
        } else if (sign.equals('/')) {
          val = numStack.pop() / val;
        } else if (sign.equals('-')) {
          val = -val;
        }
        numStack.push(val);
      } else if (ch.equals('+') || ch.equals('-') || ch.equals('*') || ch.equals('/')) {
        sign = ch;
        idx++;
      } else if (ch.equals(' ')) {
        idx++;
      }
    }

    // cal res from stack
    while (!numStack.isEmpty()) {
      res += numStack.pop();
    }
    return res;
  }

  //// -------------- end (Approach2)------------------
  //// --------------start(Approach3)------------------
  // 20200207. optimal
  // stack
  public int calculate3(String s) {
    // public int calculate(String s) {
    Deque<Integer> stack = new ArrayDeque<>();
    int res = 0;
    Character sign = '+';
    int idx = 0;
    int val = 0;
    while (idx < s.length()) {
      Character ch = s.charAt(idx);
      if (Character.isDigit(ch)) {
        while (idx < s.length() && Character.isDigit(s.charAt(idx))) {
          val = val * 10 + s.charAt(idx) - '0';
          idx++;
          // System.out.format("val: %d\n", val);
        }
        // ch = s.charAt(idx);
      } else if (ch.equals(' ')) {
        idx++;
      }
      // } else if (ch.equals('+') || ch.equals('-') || ch.equals('*') ||
      // ch.equals('/') || idx == s.length()) {

      if (ch.equals('+') || ch.equals('-') || ch.equals('*') || ch.equals('/')
          || idx == s.length()) {
        if (sign.equals('+')) {
          stack.push(val);
        } else if (sign.equals('-')) {
          stack.push(-val);
        } else if (sign.equals('*')) {
          stack.push(val * stack.pop());
        } else if (sign.equals('/')) {
          stack.push(stack.pop() / val);
        }
        // System.out.format("sign: %c\n", sign);
        sign = ch;
        val = 0;
        idx++;
      }
      // System.out.format("stack: %s\n", stack);
    }

    for (int num : stack) {
      res += num;
    }
    return res;
  }
  //// -------------- end (Approach3)------------------
  ////////////////// first round(20200207)///////////////////////////////////
  //// --------------start(Approach1)------------------
  // 20200804, totally by myself.

  // 109/109 cases passed (17 ms)
  // Your runtime beats 41.02 % of java submissions
  // Your memory usage beats 20.72 % of java submissions (41.9 MB)

  // public int calculate4(String s) {
  public int calculate(String s) {
    // System.out.format("s:%s\n", s);
    Deque<Integer> stack = new ArrayDeque<>();
    int sign = 1;
    char operator = '+';
    int operand = 0;
    for (int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);
      if (Character.isDigit(c)) {
        operand = operand * 10 + (int) (c - '0');
        // } else if (c == ' ') {
        // continue;
      }
      // } else {
      // cal the former operand.
      if (c == '+' || c == '*' || c == '/' || c == '-' || i == s.length() - 1) {
        operand *= sign;
        if (operator == '+') {
          stack.push(operand);
        } else if (operator == '*') {
          int part1 = stack.pop();
          stack.push(part1 * operand);
        } else if (operator == '/') {
          int part1 = stack.pop();
          stack.push(part1 / operand);
        }

        // System.out.format("i: %d, operator: %c\n", i, operator);
        // System.out.format("stack: %s\n", stack);

        // update the sign and operator
        if (c == '+' || c == '*' || c == '/') {
          // dont forget to change sign
          sign = 1;
          operator = c;
        } else if (c == '-') {
          sign = -1;
          // dont forget to change the operator
          operator = '+';
        }
        // reset the operand
        operand = 0;
      }
      // skip the space sign
      if (c == ' ')
        continue;
    }
    // cal the former operand.
    // operand *= sign;
    // if (operator == '+') {
    // stack.push(operand);
    // } else if (operator == '*') {
    // int part1 = stack.pop();
    // stack.push(part1 * operand);
    // } else if (operator == '/') {
    // int part1 = stack.pop();
    // stack.push(part1 / operand);
    // }

    // add the nums in stack
    int res = 0;
    while (!stack.isEmpty()) {
      res += stack.pop();
    }

    return res;
  }
  //// -------------- end (Approach3)------------------

}
// @lc code=end
