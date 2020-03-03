/*
 * @lc app=leetcode id=20 lang=java
 *
 * [20] Valid Parentheses
 */

// @lc code=start
class Solution {
  public boolean isValid1(String s) {
    if (null == s || s.length() == 0) {
      return true;
    }

    Map<Character, Character> map = new HashMap(3);
    map.put('(', ')');
    map.put('[', ']');
    map.put('{', '}');
    Deque<Character> stack = new ArrayDeque();
    for (char c : s.toCharArray()) {
      if (stack.isEmpty()) {
        stack.push(c);
      } else {
        if (c == map.get(stack.peek()).charValue()) {
          stack.pop();
        } else {
          stack.push(c);
        }
      }
    }
    return stack.isEmpty() ? true : false;
  }

  public boolean isValid(String s) {
    if (null == s || 0 == s.length()) {
      return true;
    }
    Deque<Character> stack = new ArrayDeque<>();
    for (Character ch : s.toCharArray()) {
      // System.out.println(ch);
      if (ch == '(') {
        stack.push(')');
      } else if (ch == '[') {
        stack.push(']');
      } else if (ch == '{') {
        stack.push('}');
      } else {
        if (stack.isEmpty() || ch != stack.pop()) {
          return false;
        }
      }
    }
    return stack.isEmpty();
  }
  // private boolean isPair(char c, Deque stack) {
  // if (c == )
  // }
}
// @lc code=end
