/*
 * @lc app=leetcode id=17 lang=java
 *
 * [17] Letter Combinations of a Phone Number
 */

// @lc code=start
class Solution {
  //// ---------------start(Approach1)--------------------------------
  // by myself, wrong
  public List<String> letterCombinations1(String digits) {
    Map<Character, String> map = new HashMap<>();
    map.put('2', "abc");
    map.put('3', "def");
    map.put('4', "ghi");
    map.put('5', "jkl");
    map.put('6', "mno");
    map.put('7', "pqrs");
    map.put('8', "tuv");
    map.put('9', "wxyz");
    StringBuilder sb = new StringBuilder();
    for (char ch : digits.toCharArray()) {
      sb.append(map.get(ch));
    }
    List<String> res = new ArrayList<>();
    // System.out.format("sb: %s\n", sb);
    helper1(res, new StringBuilder(), sb.toString(), 2, 0);

    return res;
  }

  private void helper1(List<String> res, StringBuilder str, String s, int k, int start) {
    if (str.length() == k) {
      res.add(str.toString());
    }
    for (int i = start; i < s.length(); i++) {
      str.append(s.charAt(i));
      helper1(res, str, s, k, i + 1);
      str.deleteCharAt(str.length() - 1);
    }
  }

  //// --------------- end (Approach1)--------------------------------
  //// ---------------start(Approach2)--------------------------------
  public List<String> letterCombinations2(String digits) {
    List<String> res = new ArrayList<>();
    if (digits.length() == 0) {
      return res;
    }
    Map<Character, String> map = new HashMap<>();
    map.put('2', "abc");
    map.put('3', "def");
    map.put('4', "ghi");
    map.put('5', "jkl");
    map.put('6', "mno");
    map.put('7', "pqrs");
    map.put('8', "tuv");
    map.put('9', "wxyz");

    helper2(map, res, "", digits, 0, digits.length());
    return res;
  }

  private void helper2(Map<Character, String> map, List<String> res, String combine, String digits, int start, int k) {
    if (combine.length() == k) {
      res.add(combine);
      return;
    }

    String curr = map.get(digits.charAt(start));
    for (char ch : curr.toCharArray()) {
      combine = combine + ch;
      helper2(map, res, combine, digits, start + 1, k);
      combine = combine.substring(0, combine.length() - 1);
    }
  }

  //// --------------- end (Approach2)--------------------------------
  //// ---------------start(Approach3)--------------------------------
  // iteration version
  public List<String> letterCombinations(String digits) {
    List<String> res = new ArrayList<>();
    if (digits == null || digits.length() == 0) {
      return res;
    }
    String[] mapping = { "0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };

    res.add("");
    for (int i = 0; i < digits.length(); i++) {
      res = combine(res, mapping[digits.charAt(i) - '0']);
    }
    return res;
  }

  private List<String> combine(List<String> res, String s) {
    List<String> ret = new ArrayList<>();
    for (String prev : res) {
      for (char ch : s.toCharArray()) {
        ret.add(prev + ch);
      }
    }
    return ret;
  }
  //// --------------- end (Approach3)--------------------------------

}
// @lc code=end
