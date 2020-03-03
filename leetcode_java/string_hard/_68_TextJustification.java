/*
 * @lc app=leetcode id=68 lang=java
 *
 * [68] Text Justification
 */

// @lc code=start
class Solution {
  public List<String> fullJustify(String[] words, int maxWidth) {
    List<String> res = new ArrayList<>();
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < words.length; i++) {
      if (sb.length() == 0 && words[i].length() <= maxWidth || sb.length() + words[i].length() + 1 <= maxWidth) {
        if (sb.length() != 0) {
          sb.append(" ");
        }
        sb.append(words[i]);
      } else {
        res.add(sb.toString());
        sb.setLength(0);
        i--;
      }
    }
    if (sb.length() != 0) {
      res.add(sb.toString());
    }
    // System.out.format("res: %s\n", res);
    for (int i = 0; i < res.size(); i++) {
      sb.setLength(0);
      sb.append(res.get(i));
      int extraSpace = maxWidth - sb.length();
      if (i == res.size() - 1 || !res.get(i).contains(" ")) {
        while (extraSpace > 0) {
          sb.insert(sb.length(), " ");
          extraSpace--;
        }
      } else {
        int idx = -1;
        while (extraSpace > 0) {
          idx = sb.indexOf(" ", idx + 1);
          if (idx != -1) {
            sb.insert(idx, " ");
            // idx++;
            extraSpace--;
            while (sb.charAt(idx) == sb.charAt(idx + 1)) {
              idx++;
            }
            // System.out.format("idx: %d\n", idx);
          }
        }
      }
      res.set(i, sb.toString());
    }
    // System.out.format("res: %s\n", res);
    return res;
  }
}
// @lc code=end
