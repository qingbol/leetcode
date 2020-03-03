/*
 * @lc app=leetcode id=71 lang=java
 *
 * [71] Simplify Path
 */

// @lc code=start
class Solution {
  public String simplifyPath(String path) {
    if (null == path || 0 == path.length()) {
      return null;
    }
    Deque<String> stack = new ArrayDeque<>();
    String[] str = path.split("/+");
    for (String s : str) {
      // System.out.format("%s |", s);
      // if (s.matches("\\w+")) {
      if (s.equals("..")) {
        // System.out.format("%s |", s);
        if (!stack.isEmpty()) {
          stack.pop();
        }
      } else if (!s.equals(".") && !s.equals("")) {
        stack.push(s);
      }
    }
    System.out.println();

    StringBuilder res = new StringBuilder();
    while (!stack.isEmpty()) {
      // System.out.println("s1: " + stack.peek());
      res.insert(0, '/' + stack.pop());
    }
    // System.out.println("s: " + res);
    // System.out.println();

    return res.toString().length() == 0 ? "/" : res.toString();
  }
}
// @lc code=end
