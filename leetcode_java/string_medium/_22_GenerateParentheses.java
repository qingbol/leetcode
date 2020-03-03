/*
 * @lc app=leetcode id=22 lang=java
 *
 * [22] Generate Parentheses
 */

// @lc code=start
class Solution {
  // backtracking, optimal solution
  public List<String> generateParenthesis1(int n) {
    List<String> res = new ArrayList<>();
    helper(res, new String(), 0, 0, n);
    return res;
  }

  private void helper(List<String> lst, String s, int l, int r, int pairs) {
    if (s.length() == 2 * pairs) {
      lst.add(s);
    }
    if (l < pairs) {
      helper(lst, s + "(", l + 1, r, pairs);
    }
    if (l > r) {
      helper(lst, s + ")", l, r + 1, pairs);
    }
  }

  // brute force, recursion
  public List<String> generateParenthesis(int n) {
    if (n == 0) {
      return new ArrayList<>();
    }
    List<String> res = new ArrayList<>();
    generateAll(res, new String(), 2 * n);
    return res;
  }

  private void generateAll(List<String> lst, String s, int len) {
    if (len == 0) {
      if (isValid(s)) {
        // System.out.format("s: %s\n", s);
        lst.add(s);
      }
      return;
    }
    generateAll(lst, s + "(", len - 1);
    generateAll(lst, s + ")", len - 1);
  }

  private boolean isValid(String ss) {
    int num = 0;
    for (char ch : ss.toCharArray()) {
      if (ch == '(') {
        num++;
      } else if (ch == ')') {
        num--;
        if (num < 0) {
          return false;
        }
      }
    }
    return num == 0 ? true : false;
  }
}
// @lc code=end
