/*
 * @lc app=leetcode id=388 lang=java
 *
 * [388] Longest Absolute File Path
 */

// @lc code=start
class Solution {
  ////////////////// first round(20200211)///////////////////////////////////
  ////////////////// first round(20200211)///////////////////////////////////
  //// ----------------start(Approach1)-------------------------------------
  // 20200211

  // public int lengthLongestPath(String input) {
  public int lengthLongestPath1(String input) {
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
  //// ---------------- end (Approach2)-------------------------------------
  ////////////////// third round(20200920)///////////////////////////////////
  ////////////////// third round(20200920)///////////////////////////////////
  //// ----------------start(Approach3)-------------------------------------
  // 20200920. can't solve it by myselft.
  // refer to leetcode discuss:
  //// https://leetcode.com/problems/longest-absolute-file-path/discuss/86615/9-lines-4ms-Java-solution/91528

  // 25/25 cases passed (1 ms)
  // Your runtime beats 82.08 % of java submissions
  // Your memory usage beats 80.14 % of java submissions (37.2 MB)

  public int lengthLongestPath(String input) {
    // public int lengthLongestPath2(String input) {
    Deque<Integer> stack = new ArrayDeque<>();
    // use size of stack to indicate the depth of directory
    stack.push(0); // dummy element to fill level0.
    int res = 0;
    // 1. split the input by \n
    String[] paths = input.split("\n");
    for (String path : paths) {
      int numOfTab = path.lastIndexOf("\t") + 1;
      int level = numOfTab + 1;
      while (level < stack.size())
        stack.pop();
      int curLen = stack.peek() + path.length() - numOfTab + 1;
      stack.push(curLen);
      if (path.contains("."))
        res = Math.max(res, curLen - 1);
    }
    return res;
  }
  //// ---------------- end (Approach2)-------------------------------------
}
// @lc code=end
