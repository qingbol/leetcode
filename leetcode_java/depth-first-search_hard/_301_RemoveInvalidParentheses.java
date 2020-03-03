/*
 * @lc app=leetcode id=301 lang=java
 *
 * [301] Remove Invalid Parentheses
 */

// @lc code=start
class Solution {
  //// -------------start(approach 1) -------------------------------------
  // solution1: by myself. without pruning
  // problem: some case can't pass
  // 122/126 cases passed (N/A)
  // "(h(d()(((c)())()))()"
  private Map<String, List<String>> map = new HashMap<>();

  public List<String> removeInvalidParentheses1(String s) {
    if (null == s || s.length() == 0) {
      return new ArrayList<>(Arrays.asList(""));
    }
    List<String> res = helper(s);
    int max = 0;
    for (String sss : res) {
      max = Math.max(max, sss.length());
    }
    // java8 method to remove objects in a loop
    final int limit = max;
    res.removeIf(a -> a.length() < limit);

    // iterate method to remove objects in a loop
    // for (Iterator<String> it = res.iterator(); it.hasNext();) {
    // String tmp = it.next();
    // if (tmp.length() < max) {
    // it.remove();
    // }
    // }
    return res;
    // return res.size() == 0 ? new ArrayList<>(Arrays.asList("")) : res;
  }

  private List<String> helper(String ss) {
    if (map.containsKey(ss)) {
      return map.get(ss);
    }
    List<String> ret = new ArrayList<>();
    if (ss.length() > 0 && isValid(ss)) {
      ret.add(ss);
    } else if (ss.length() == 0 || ss == null) {
      ret.add("");
    } else if (!ss.contains("(") && !ss.contains(")")) {
      ret.add(ss);
    } else {
      for (int i = 0; i < ss.length(); i++) {
        if (ss.charAt(i) != '(' && ss.charAt(i) != ')') {
          continue;
        }
        List<String> lst = helper(ss.substring(0, i) + ss.substring(i + 1));
        // System.out.format("lst: %s\n", lst);
        for (String subs : lst) {
          if (!ret.contains(subs)) {
            ret.add(subs);
          }
        }
      }
    }
    map.put(ss, ret);
    return ret;
  }

  private boolean isValid(String str) {
    int balance = 0;
    for (char ch : str.toCharArray()) {
      if (ch == '(') {
        balance++;
      } else if (ch == ')') {
        balance--;
      }
      if (balance < 0) {
        return false;
      }
    }
    return balance == 0 ? true : false;
  }

  //// ------------- end (approach 1) --------------------------------------
  //// -------------start(approach 2) --------------------------------------
  // backtracking
  private Set<String> validExpressions = new HashSet<String>();
  private int minimumRemoved;

  private void reset() {
    this.validExpressions.clear();
    this.minimumRemoved = Integer.MAX_VALUE;
  }

  private void recurse(String s, int index, int leftCount, int rightCount, StringBuilder expression, int removedCount) {
    System.out.format("i: %d, l: %d, r: %d, str: %s: remove: %d\n", index, leftCount, rightCount, expression,
        removedCount);
    // If we have reached the end of string.
    if (index == s.length()) {

      // If the current expression is valid.
      if (leftCount == rightCount) {

        // If the current count of removed parentheses is <= the current minimum count
        if (removedCount <= this.minimumRemoved) {

          // Convert StringBuilder to a String. This is an expensive operation.
          // So we only perform this when needed.
          String possibleAnswer = expression.toString();

          // If the current count beats the overall minimum we have till now
          if (removedCount < this.minimumRemoved) {
            this.validExpressions.clear();
            this.minimumRemoved = removedCount;
          }
          // System.out.format("possible: %s\n", possibleAnswer);
          this.validExpressions.add(possibleAnswer);
          // System.out.format("set: %s\n", this.validExpressions);
        }
      }
    } else {

      char currentCharacter = s.charAt(index);
      int length = expression.length();

      // If the current character is neither an opening bracket nor a closing one,
      // simply recurse further by adding it to the expression StringBuilder
      if (currentCharacter != '(' && currentCharacter != ')') {
        expression.append(currentCharacter);
        this.recurse(s, index + 1, leftCount, rightCount, expression, removedCount);
        expression.deleteCharAt(length);
      } else {

        // Recursion where we delete the current character and move forward
        this.recurse(s, index + 1, leftCount, rightCount, expression, removedCount + 1);
        expression.append(currentCharacter);

        // If it's an opening parenthesis, consider it and recurse
        if (currentCharacter == '(') {
          this.recurse(s, index + 1, leftCount + 1, rightCount, expression, removedCount);
        } else if (rightCount < leftCount) {
          // For a closing parenthesis, only recurse if right < left
          this.recurse(s, index + 1, leftCount, rightCount + 1, expression, removedCount);
        }

        // Undoing the append operation for other recursions.
        expression.deleteCharAt(length);
      }
    }
  }

  public List<String> removeInvalidParentheses2(String s) {

    this.reset();
    this.recurse(s, 0, 0, 0, new StringBuilder(), 0);
    return new ArrayList(this.validExpressions);
  }

  //// ------------- end (approach 2) --------------------------------------
  //// -------------start(approach 3) --------------------------------------
  // DFS optimal solution
  public List<String> removeInvalidParentheses3(String s) {
    List<String> ans = new ArrayList<>();
    remove(s, ans, 0, 0, new char[] { '(', ')' });
    return ans;
  }

  public void remove(String s, List<String> ans, int last_i, int last_j, char[] par) {
    // System.out.format("s1: %s\n", s);
    for (int stack = 0, i = last_i; i < s.length(); ++i) {
      // System.out.format("i: %d\n", i);
      // System.out.format("s1: %s\n", s);
      if (s.charAt(i) == par[0])
        stack++;
      if (s.charAt(i) == par[1])
        stack--;
      if (stack >= 0)
        continue;
      for (int j = last_j; j <= i; ++j) {
        if (s.charAt(j) == par[1] && (j == last_j || s.charAt(j - 1) != par[1]))
          remove(s.substring(0, j) + s.substring(j + 1), ans, i, j, par); // continue to check the rest of
      }
      return;
    }
    // System.out.format("s2: %s\n", s);
    String reversed = new StringBuilder(s).reverse().toString();
    if (par[0] == '(') {
      remove(reversed, ans, 0, 0, new char[] { ')', '(' });
    } // finished left to right
    else {// finished right to left
      ans.add(reversed);
      // System.out.format("ans: %s\n", ans);
    }
  }

  //// ------------- end (approach 3) --------------------------------------
  //// -------------start(approach 4) --------------------------------------
  // reproduce DFS optimal solution
  public List<String> removeInvalidParentheses(String s) {
    char[] pair = new char[] { '(', ')' };
    List<String> res = new ArrayList<>();
    dfs(s, 0, 0, pair, res);
    return res;
  }

  private void dfs(String ss, int searchStart, int removeStart, char[] pair, List<String> lst) {
    int balance = 0;
    for (int i = searchStart; i < ss.length(); i++) {
      if (ss.charAt(i) == pair[0]) {
        balance++;
      } else if (ss.charAt(i) == pair[1]) {
        balance--;
      }
      // if balance <0, we need to delete the invalid char
      if (balance < 0) {
        for (int j = removeStart; j <= i; j++) {
          if (ss.charAt(j) == pair[1] && (j == removeStart || ss.charAt(j - 1) != pair[1]))
            dfs(ss.substring(0, j) + ss.substring(j + 1), i, j, pair, lst);
        }
        return;
      }
    }

    // check reverse string
    String str = new StringBuilder(ss).reverse().toString();
    if (pair[0] == '(') {
      dfs(str, 0, 0, new char[] { ')', '(' }, lst);
    } else {
      lst.add(str);
    }
  }
  //// ------------- end (approach 4) --------------------------------------
}
// @lc code=end
