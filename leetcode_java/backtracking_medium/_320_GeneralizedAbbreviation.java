/*
 * @lc app=leetcode id=320 lang=java
 *
 * [320] Generalized Abbreviation
 */

// @lc code=start
class Solution {
  //// ----------------start(Approach1)----------------------------
  // by myself, wrong
  public List<String> generateAbbreviations1(String word) {
    List<String> res = new ArrayList<>();
    if (word == null || word.length() == 0) {
      return res;
    }

    helper1(res, word, word, 0);
    return res;
  }

  private void helper1(List<String> res, String s, String word, int start) {
    res.add(s);
    for (int i = start; i < word.length(); i++) {
      if (s.charAt(i) == '1') {
        continue;
      }
      helper1(res, s.substring(0, i) + "1" + s.substring(i + 1), word, start + 1);
    }
  }

  //// ---------------- end (Approach1)----------------------------
  //// ----------------start(Approach2)----------------------------
  // binary backtracking
  public List<String> generateAbbreviations2(String word) {
    List<String> res = new ArrayList<>();
    // if (word == null || word.length() == 0) {
    // return res;
    // }
    helper2(res, word, "", 0, 0);
    return res;
  }

  private void helper2(List<String> res, String word, String str, int pos, int count) {
    if (pos == word.length()) {
      if (count > 0) {
        str = str + count;
      }
      res.add(str);
      return;
    }
    // } else {
    helper2(res, word, str, pos + 1, count + 1);
    // String tmp = str;
    if (count > 0) {
      str = str + count;
    }
    str = str + word.charAt(pos);
    helper2(res, word, str, pos + 1, 0);
    // }
  }

  //// ---------------- end (Approach2)----------------------------
  //// ----------------start(Approach3)----------------------------
  public List<String> generateAbbreviations(String word) {
    List<String> res = new ArrayList<>();
    for (int i = 0; i < 1 << word.length(); i++) {
      res.add(helper3(word, i));
    }
    return res;
  }

  private String helper3(String word, int bitmap) {
    StringBuilder sb = new StringBuilder();
    int n = word.length();
    int count = 0;
    for (int i = 0; i < n; i++, bitmap >>= 1) {
      if ((bitmap & 1) == 0) {
        if (count > 0) {
          sb.append(count);
          count = 0;
        }
        sb.append(word.charAt(i));
      } else {
        count++;
      }
    }
    if (count > 0) {
      sb.append(count);
    }
    return sb.toString();
  }
  //// ---------------- end (Approach3)----------------------------
}
// @lc code=end
