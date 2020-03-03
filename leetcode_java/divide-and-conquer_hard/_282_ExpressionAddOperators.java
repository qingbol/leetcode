/*
 * @lc app=leetcode id=282 lang=java
 *
 * [282] Expression Add Operators
 */

// @lc code=start
class Solution {
  //// ---------------start(Approach1)--------------------------
  // optimal
  // use for loop to get all possible operands
  public List<String> addOperators1(String num, int target) {
    List<String> res = new ArrayList<>();
    helper1(res, num, target, new StringBuilder(), 0, 0, 0);
    return res;
  }

  private void helper1(List<String> res, String num, int target, StringBuilder sb, long val, long prev, int idx) {
    if (idx == num.length()) {
      if (val == target) {
        res.add(sb.toString());
      }
      return;
    }

    for (int i = idx; i < num.length(); i++) {
      // e.g. 105, idx = 1, i =2, "05" is invalid number, so break.
      if (i != idx && num.charAt(idx) == '0') {
        break;
      }
      long cur = Long.parseLong(num.substring(idx, i + 1));
      int len = sb.length();
      // handle the first operand
      if (idx == 0) {
        helper1(res, num, target, sb.append(cur), cur, cur, i + 1);
        sb.setLength(len);
      } else {
        // addition
        helper1(res, num, target, sb.append("+").append(cur), val + cur, cur, i + 1);
        sb.setLength(len);
        // substraction
        helper1(res, num, target, sb.append("-").append(cur), val - cur, -cur, i + 1);
        sb.setLength(len);
        // multiplication
        helper1(res, num, target, sb.append("*").append(cur), val - prev + (prev * cur), prev * cur, i + 1);
        sb.setLength(len);
      }

    }
  }

  //// --------------- end (Approach1)--------------------------
  //// ---------------start(Approach2)--------------------------
  // use backtrack to get all possible operands
  // optimal
  public List<String> addOperators(String num, int target) {
    List<String> res = new ArrayList<>();
    if (num.length() == 0) {
      return res;
    }
    helper2(res, num, target, new StringBuilder(), 0, 0, 0, 0);
    return res;
  }

  private void helper2(List<String> res, String num, int target, StringBuilder sb, long val, long cur, long prev,
      int idx) {
    if (idx == num.length()) {
      if (val == target && cur == 0) {
        // if (val == target) {
        res.add(sb.substring(1).toString());
      }
      // System.out.format("sb: %s\n", sb);
      return;
    }

    // extend the current operand by one digit.
    cur = cur * 10 + Character.getNumericValue(num.charAt(idx));
    String curStr = Long.toString(cur);
    // System.out.format("curr: %s\n", curStr);
    // int length = num.length();
    int len = sb.length();

    // To avoid cases where we have 1 + 05
    if (cur > 0) {
      // System.out.format("branch1: ");
      helper2(res, num, target, sb, val, cur, prev, idx + 1);
    }

    sb.append("+").append(curStr);
    // System.out.format("branch+: ");
    helper2(res, num, target, sb, val + cur, 0, cur, idx + 1);
    sb.setLength(len);
    if (sb.length() > 0) {
      sb.append("-").append(curStr);
      // System.out.format("branch-: ");
      helper2(res, num, target, sb, val - cur, 0, -cur, idx + 1);
      sb.setLength(len);
      sb.append("*").append(curStr);
      // System.out.format("branch*: ");
      helper2(res, num, target, sb, val - prev + (prev * cur), 0, prev * cur, idx + 1);
      sb.setLength(len);
    }
  }

  //// --------------- end (Approach2)--------------------------
  //// ---------------start(Approach3)--------------------------
  // use backtrack to find all operands
  // similar with approach2, just a little modification
  // Wrong for case: //"3456237490" \n9191
  // "123456789"\n 45
  public List<String> addOperators3(String num, int target) {
    List<String> res = new ArrayList<>();
    if (num == null || num.length() == 0) {
      return res;
    }
    helper3(res, num, target, new StringBuilder(), 0, 0, 0, 1);
    return res;
  }

  private void helper3(List<String> res, String num, int target, StringBuilder sb, long val, long prev, int start,
      int end) {
    if (end == num.length() + 1) {
      // if (end == num.length() + 1) {
      if (val == target) {
        // if (val == target && sb.charAt(sb.length() - 1) == '9') {
        // System.out.format("sb:%c", sb.charAt(sb.length() - 1));
        res.add(sb.toString());
      }
      // System.out.format("sb: %s\n", sb);
      // System.out.format("res: %s\n", res);
      return;
    }

    long curr = Long.parseLong(num.substring(start, end));
    // System.out.format("curr: %d\n", curr);
    int len = sb.length();

    // NO OP
    // (val, prev,) remain unchanged.
    // just move the end pointer one step further
    // To avoid cases where we have 1 + 05 or 1 * 05 since 05 won't be a
    // valid operand. Hence this check curr > 0
    if (curr > 0) {
      // System.out.format("branch1: ");
      helper3(res, num, target, sb, val, prev, start, end + 1);
      //// very important, because use this method, the start reamins 0. we need to
      //// use end pointer
      start = end - 1;
    }

    // For the first operand, we need to handle it separately,
    // we add the curr operand to val, but don't add "+" in sb.
    if (sb.length() == 0) {
      sb.append(curr);
      // System.out.format("branch2: curr:%d", curr);
      helper3(res, num, target, sb, curr, curr, start + 1, end + 1);
      sb.setLength(len);
    } else {
      // addition
      sb.append("+").append(curr);
      // System.out.format("branch+: ");
      helper3(res, num, target, sb, val + curr, curr, start + 1, end + 1);
      sb.setLength(len);

      // substraction
      sb.append("-").append(curr);
      // System.out.format("branch-: ");
      helper3(res, num, target, sb, val - curr, -curr, start + 1, end + 1);
      sb.setLength(len);

      // multiplication
      sb.append("*").append(curr);
      // System.out.format("branch*: ");
      helper3(res, num, target, sb, val - prev + (prev * curr), prev * curr, start + 1, end + 1);
      sb.setLength(len);
    }

  }

  //// --------------- end (Approach3)--------------------------
}
// @lc code=end
