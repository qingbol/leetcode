/*
 * @lc app=leetcode id=227 lang=java
 *
 * [227] Basic Calculator II
 */

// @lc code=start
class Solution {
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
  public int calculate(String s) {
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
  // 20200207
  // stack
  public int calculate2(String s) {
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

      if (ch.equals('+') || ch.equals('-') || ch.equals('*') || ch.equals('/') || idx == s.length()) {
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

}
// @lc code=end
