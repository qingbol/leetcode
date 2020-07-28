/*
 * @lc app=leetcode id=22 lang=java
 *
 * [22] Generate Parentheses
 */

// @lc code=start
class Solution {
  ////////////////// first round(20200219)//////////////////////////////////////
  ////////////////// first round(20200219)//////////////////////////////////////
  //// ---------------start(Approach1)--------------------
  // 20200219.
  // leetcode standard solution: Approach 2: Backtracking
  // backtracking, optimal solution

  // 8/8 cases passed (1 ms)
  // Your runtime beats 88.78 % of java submissions
  // Your memory usage beats 77.28 % of java submissions (39.3 MB)

  public List<String> generateParenthesis1(int n) {
    // public List<String> generateParenthesis(int n) {
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
  //// --------------- end (Approach1)--------------------
  //// ---------------start(Approach2)--------------------
  // 20200219.
  // brute force, recursion

  // public List<String> generateParenthesis(int n) {
  public List<String> generateParenthesis2(int n) {
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

  //// --------------- end (Approach2)--------------------
  ////////////////// second round(20200727)////////////////////////////////////
  ////////////////// second round(20200727)////////////////////////////////////
  //// ---------------start(Approach3)--------------------
  // 20200727. backtracking , by myself.

  // 8/8 cases passed (6 ms)
  // Your runtime beats 14.65 % of java submissions
  // Your memory usage beats 26.87 % of java submissions (39.8 MB)

  public List<String> generateParenthesis3(int n) {
    // public List<String> generateParenthesis(int n) {
    List<String> res = new ArrayList<>();
    helper3(2 * n, new StringBuilder(), res);
    return res;
  }

  private void helper3(int len, StringBuilder sb, List<String> res) {
    if (len == 0) {
      if (isValid3(sb, '_') == 0) {
        res.add(sb.toString());
      }
      return;
    }

    for (char ch : "()".toCharArray()) {
      if (isValid3(sb, ch) < 0)
        continue;
      sb.append(ch);
      helper3(len - 1, sb, res);
      sb.deleteCharAt(sb.length() - 1);
    }
  }

  private int isValid3(StringBuilder sb, char ch) {
    int sum = ch == '(' ? 1 : (ch == ')' ? -1 : 0);
    for (int i = 0; i < sb.length(); i++) {
      if (sb.charAt(i) == '(') {
        sum++;
      } else {
        sum--;
      }
    }
    return sum;
  }
  //// --------------- end (Approach3)--------------------
  //// ---------------start(Approach4)--------------------
  // 20200727. backtracking ,
  // refer to labuladong <回溯算法最佳实践：括号生成>

  // 8/8 cases passed (1 ms)
  // Your runtime beats 88.78 % of java submissions
  // Your memory usage beats 26.78 % of java submissions (39.8 MB)

  public List<String> generateParenthesis(int n) {
    // public List<String> generateParenthesis4(int n) {
    List<String> res = new ArrayList<>();

    helper4(n, 0, 0, new StringBuilder(), res);
    return res;
  }

  private void helper4(int pair, int left, int right, StringBuilder sb, List<String> res) {
    if (left < right)
      return;
    if (left > pair || right > pair)
      return;
    if (left == pair && right == pair) {
      res.add(sb.toString());
    }

    sb.append('(');
    helper4(pair, left + 1, right, sb, res);
    sb.deleteCharAt(sb.length() - 1);

    sb.append(')');
    helper4(pair, left, right + 1, sb, res);
    sb.deleteCharAt(sb.length() - 1);
  }
  //// --------------- end (Approach4)--------------------
}
// @lc code=end
