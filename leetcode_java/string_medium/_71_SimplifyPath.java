/*
 * @lc app=leetcode id=71 lang=java
 *
 * [71] Simplify Path
 */

// @lc code=start
class Solution {
  ////////////////// first round(20200205)///////////////////////////////////
  ////////////////// first round(20200205)///////////////////////////////////
  //// ----------------start(Approach1)-------------------------------------
  // 20200205

  // public String simplifyPath(String path) {
  public String simplifyPath1(String path) {
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
  //// ---------------- end (Approach2)-------------------------------------
  ////////////////// third round(20200920)///////////////////////////////////
  ////////////////// third round(20200920)///////////////////////////////////
  //// ----------------start(Approach3)-------------------------------------
  // 20200920. cant figure out the split() method. just remeber it.
  //refer to leetcode: Approach: Using Stacks

  // 254/254 cases passed (10 ms)
  // Your runtime beats 23.28 % of java submissions
  // Your memory usage beats 48.55 % of java submissions (39.7 MB)

  public String simplifyPath(String path) {
    // public String simplifyPath2(String path) {
    Deque<String> stack = new ArrayDeque<>();
    // 1. split & put it into stack.
    String[] strs = path.split("/+");
    for (String str : strs) {
      if (str.equals("..")) {
        if (!stack.isEmpty())
          stack.pop();
      } else if (str.equals(".") || str.equals("")) {
        // } else if (str.equals(".")) {
        continue;
      } else {
        stack.push(str);
      }
    }
    // 2. combine
    StringBuilder sb = new StringBuilder();
    for (String str : stack) {
      sb.insert(0, "/" + str);
      // sb.append("/" + str);
    }

    return sb.length() > 0 ? sb.toString() : "/";
  }
  //// ---------------- end (Approach2)-------------------------------------
}
// @lc code=end
