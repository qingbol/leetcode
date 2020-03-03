/*
 * @lc app=leetcode id=248 lang=java
 *
 * [248] Strobogrammatic Number III
 */

// @lc code=start
class Solution {
  private static final char[][] PAIRS = { { '0', '0' }, { '1', '1' }, { '8', '8' }, { '6', '9' }, { '9', '6' } };

  public int strobogrammaticInRange1(String low, String high) {
    int res = 0;
    for (int len = low.length(); len <= high.length(); len++) {
      res += dfs(low, high, 0, len - 1, new char[len]);
    }
    return res;
  }

  private int dfs(String low, String high, int left, int right, char[] str) {
    if (left > right) {
      String s = String.valueOf(str);
      if (low.length() == str.length && s.compareTo(low) < 0 || high.length() == str.length && s.compareTo(high) > 0) {
        return 0;
      } else {
        return 1;
      }
    }
    int count = 0;
    for (char[] pair : PAIRS) {
      str[left] = pair[0];
      str[right] = pair[1];
      if (str.length != 1 && str[0] == 0) {
        continue;
      }
      if (left == right && (pair[0] == '6' || pair[0] == '9')) {
        continue;
      }
      count += dfs(low, high, left + 1, right - 1, str);
    }
    return count;
  }

  // A more understandable solution
  public int strobogrammaticInRange(String low, String high) {
    List<String> list = new ArrayList<>();
    for (int len = low.length(); len <= high.length(); len++) {
      list.addAll(findValid(len, len));
    }
    int res = 0;
    for (String s : list) {
      if (!(s.length() == low.length() && s.compareTo(low) < 0
          || s.length() == high.length() && s.compareTo(high) > 0)) {
        res++;
      }
    }
    return res;
  }

  private List<String> findValid(int n, int m) {
    if (n == 0) {
      return new ArrayList<>(Arrays.asList(""));
    }
    if (n == 1) {
      return new ArrayList<>(Arrays.asList("0", "1", "8"));
    }
    List<String> lst = findValid((n - 2), m);
    List<String> ret = new ArrayList<>();
    for (String str : lst) {
      if (n != m) {
        ret.add("0" + str + "0");
      }
      ret.add("1" + str + "1");
      ret.add("8" + str + "8");
      ret.add("6" + str + "9");
      ret.add("9" + str + "6");
    }
    return ret;
  }
}
// @lc code=end
