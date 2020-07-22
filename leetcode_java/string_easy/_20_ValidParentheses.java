/*
 * @lc app=leetcode id=20 lang=java
 *
 * [20] Valid Parentheses
 */

// @lc code=start
class Solution {
  ///////////////////////// first round(20200205)////////////////////
  ///////////////////////// first round(20200205)////////////////////
  //// ---------------start(Approach1)------------------------------
  // 20200205.
  public boolean isValid1(String s) {
    // public boolean isValid(String s) {
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
  //// --------------- end (Approach1)------------------------------
  //// ---------------start(Approach2)------------------------------

  // public boolean isValid(String s) {
  public boolean isValid2(String s) {
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
  //// --------------- end (Approach2)------------------------------

  ///////////////////////// second round(20200720)////////////////////
  ///////////////////////// second round(20200720)////////////////////
  //// ---------------start(Approach3)------------------------------
  // 20200720.
  // public boolean isValid3(String s) {
  public boolean isValid(String s) {
    if (s.length() == 0)
      return true;

    Deque<Character> stack = new ArrayDeque<>();
    for (char ch : s.toCharArray()) {
      // System.out.format("%c", ch);
      if (ch == '(') {
        stack.push(')');
      } else if (ch == '[') {
        stack.push(']');
      } else if (ch == '{') {
        stack.push('}');
      } else if (ch == ')' || ch == ']' || ch == '}') {
        if (stack.isEmpty() || stack.pop() != ch) {
          return false;
        }
      }
    }
    return stack.isEmpty();
  }
  //// --------------- end (Approach3)------------------------------
}
// @lc code=end
