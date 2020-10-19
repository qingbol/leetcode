/*
 * @lc app=leetcode id=385 lang=java
 *
 * [385] Mini Parser
 */

// @lc code=start
/**
 * // This is the interface that allows for creating nested lists. // You should not implement it,
 * or speculate about its implementation public interface NestedInteger { // Constructor initializes
 * an empty nested list. public NestedInteger();
 *
 * // Constructor initializes a single integer. public NestedInteger(int value);
 *
 * // @return true if this NestedInteger holds a single integer, rather than a nested list. public
 * boolean isInteger();
 *
 * // @return the single integer that this NestedInteger holds, if it holds a single integer //
 * Return null if this NestedInteger holds a nested list public Integer getInteger();
 *
 * // Set this NestedInteger to hold a single integer. public void setInteger(int value);
 *
 * // Set this NestedInteger to hold a nested list and adds a nested integer to it. public void
 * add(NestedInteger ni);
 *
 * // @return the nested list that this NestedInteger holds, if it holds a nested list // Return
 * null if this NestedInteger holds a single integer public List<NestedInteger> getList(); }
 */

////////////////// first round(20200212)///////////////////////////////////
////////////////// first round(20200212)///////////////////////////////////
//// ----------------start(Approach1)-------------------------------------
// 20200212
// Approach1: by stack
class Solution {

  public NestedInteger deserialize1(String s) {
    // public NestedInteger deserialize(String s) {
    if (null == s || 0 == s.length()) {
      return null;
    }
    if (!s.startsWith("[")) {
      return new NestedInteger(Integer.parseInt(s));
    }

    NestedInteger res = new NestedInteger();
    Deque<NestedInteger> stack = new ArrayDeque<>();
    stack.push(res);
    int start = 1;
    for (int i = start; i < s.length(); i++) {
      if (s.charAt(i) == ',') {
        if (i > start) {
          int val = Integer.parseInt(s.substring(start, i));
          NestedInteger obj = new NestedInteger(val);
          stack.peek().add(obj);
        }
        start = i + 1;
      } else if (s.charAt(i) == '[') {
        NestedInteger subList = new NestedInteger();
        stack.peek().add(subList);
        stack.push(subList);
        start = i + 1;
      } else if (s.charAt(i) == ']') {
        if (i > start) {
          int val = Integer.parseInt(s.substring(start, i));
          NestedInteger obj = new NestedInteger(val);
          stack.peek().add(obj);
        }
        stack.pop();
        start = i + 1;
      }
    }

    return res;
  }

  //// --------------- end (Approach1)------------------------------
  //// ---------------start(Approach2)------------------------------
  // Approach2: by recursion

  // public NestedInteger deserialize(String s) {
  public NestedInteger deserialize2(String s) {
    if (s.length() == 0 || s.equals("[]"))
      return new NestedInteger();
    NestedInteger ni = new NestedInteger();
    char[] chars = s.toCharArray();
    if (chars[0] == '[') {
      int elementStart = 1;
      while (elementStart < chars.length) {
        int elementEnd = searchForElementEnd(chars, elementStart);
        String nextListElement = new String(chars, elementStart, elementEnd - elementStart);
        ni.add(deserialize(nextListElement));
        elementStart = elementEnd + 1;
      }
    } else
      ni.setInteger(Integer.parseInt(new String(chars)));
    // ni.setInteger(new Integer(new String(chars)));
    return ni;
  }

  private int searchForElementEnd(char[] chars, int elementStart) {
    int countBrackets = 0;
    int i = elementStart;
    // if (chars[i++] == '[')
    // countBrackets++;
    while (i < chars.length) {
      char nextChar = chars[i];
      if (nextChar == ']') {
        countBrackets--;
        if (countBrackets <= 0) {
          if (countBrackets == 0) {
            i++;
          }
          break;
        }
      } else if (nextChar == '[')
        countBrackets++;
      else if (nextChar == ',' && countBrackets == 0) {
        break;
      }
      i++;
    }
    return i;
  }
  //// ---------------- end (Approach2)-------------------------------------
  ////////////////// third round(20200921)///////////////////////////////////
  ////////////////// third round(20200921)///////////////////////////////////
  //// ----------------start(Approach3)-------------------------------------
  // 20200921.
  // refer to leetcode discuss: An Java Iterative Solution
  //// https://leetcode.com/problems/mini-parser/discuss/86066/An-Java-Iterative-Solution

  // 57/57 cases passed (6 ms)
  // Your runtime beats 65.23 % of java submissions
  // Your memory usage beats 60.51 % of java submissions (41.4 MB)

  public NestedInteger deserialize(String s) {
    // public NestedInteger deserialize3(String s) {
    if (s.charAt(0) != '[') {
      return new NestedInteger(Integer.valueOf(s));
    }

    Deque<NestedInteger> stack = new ArrayDeque<>();
    NestedInteger cur = null;
    StringBuilder sb = new StringBuilder();
    for (char c : s.toCharArray()) {
      if (Character.isDigit(c) || c == '-') {
        sb.append(c);
      } else if (c == '[') {
        if (cur != null) {
          stack.push(cur);
        }
        cur = new NestedInteger();
      } else if (c == ']' || c == ',') {
        if (sb.length() > 0) {
          cur.add(new NestedInteger(Integer.valueOf(sb.toString())));
          sb.setLength(0);
        }
        if (c == ']' && !stack.isEmpty()) {
          NestedInteger prev = stack.pop();
          prev.add(cur);
          cur = prev;
        }
      }
    }
    return cur;
  }
  //// ---------------- end (Approach3)-------------------------------------
}
// @lc code=end
