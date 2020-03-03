/*
 * @lc app=leetcode id=388 lang=java
 *
 * [388] Longest Absolute File Path
 */

// @lc code=start
class Solution {
  public int lengthLongestPath(String input) {
    Deque<Integer> stack = new ArrayDeque<>();
    int level = 0;
    int length = 0;
    stack.push(0);
    // stack.push(-1);
    int res = 0;
    for (String str : input.split("\n")) {
      level = str.lastIndexOf("\t") + 1;
      // stack.size = level + 1;
      while (level + 1 < stack.size()) {
        stack.pop();
      }
      length = stack.peek() + str.length() - level + 1;
      stack.push(length);
      if (str.contains(".")) {
        res = Math.max(res, length - 1);
      }
    }
    return res;
  }
}
// @lc code=end
