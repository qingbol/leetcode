/*
 * @lc app=leetcode id=241 lang=java
 *
 * [241] Different Ways to Add Parentheses
 */

// @lc code=start
class Solution {
  // divide and conquer
  public List<Integer> diffWaysToCompute1(String input) {
    List<Integer> res = helper(input);
    // System.out.format("res: %s\n", res);
    return res;
  }

  private List<Integer> helper1(String s) {
    List<Integer> ret = new ArrayList<>();
    if (!s.contains("+") && !s.contains("-") && !s.contains("*")) {
      ret.add(Integer.valueOf(s));
    }
    for (int i = 0; i < s.length(); i++) {
      char ch = s.charAt(i);
      if (ch == '+' || ch == '-' || ch == '*') {
        // divide
        List<Integer> left = helper(s.substring(0, i));
        List<Integer> right = helper(s.substring(i + 1));

        // conquer
        for (Integer l : left) {
          for (Integer r : right) {
            int sum = 0;
            switch (ch) {
              case '+':
                sum = l + r;
                break;
              case '-':
                sum = l - r;
                break;
              case '*':
                sum = l * r;
                break;
            }
            ret.add(sum);
          }
        } // : end of for
      } // endof if

    }
    return ret;
  }

  // divide and conquer with memo
  private Map<String, List<Integer>> map = new HashMap<>();

  public List<Integer> diffWaysToCompute(String input) {
    List<Integer> res = helper(input);
    // System.out.format("res: %s\n", res);
    return res;
  }

  private List<Integer> helper(String s) {
    if (map.containsKey(s)) {
      return map.get(s);
    }
    List<Integer> ret = new ArrayList<>();
    if (!s.contains("+") && !s.contains("-") && !s.contains("*")) {
      ret.add(Integer.valueOf(s));
    }
    for (int i = 0; i < s.length(); i++) {
      char ch = s.charAt(i);
      if (ch == '+' || ch == '-' || ch == '*') {
        // divide
        List<Integer> left = helper(s.substring(0, i));
        List<Integer> right = helper(s.substring(i + 1));

        // conquer
        for (Integer l : left) {
          for (Integer r : right) {
            int sum = 0;
            switch (ch) {
              case '+':
                sum = l + r;
                break;
              case '-':
                sum = l - r;
                break;
              case '*':
                sum = l * r;
                break;
            }
            ret.add(sum);
          }
        } // : end of for
      } // endof if

    }
    map.put(s, ret);
    return ret;
  }
}
// @lc code=end
