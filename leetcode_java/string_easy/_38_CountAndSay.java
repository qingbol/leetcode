import java.util.regex.Pattern;
import java.util.regex.Matcher;

/*
 * @lc app=leetcode id=38 lang=java
 *
 * [38] Count and Say
 */

// @lc code=start
class Solution {
  public String countAndSay1(int n) {
    return say("1", n);
  }

  private String say(String s, int n) {
    // System.out.format("s: %s, n: %d\n", s, n);
    if (n == 1) {
      return s;
    }
    StringBuilder sb = new StringBuilder();
    int l = 0;
    int r = 0;
    while (r < s.length()) {
      while (r < s.length() && s.charAt(r) == s.charAt(l)) {
        r++;
      }
      sb.append(r - l).append(s.charAt(l));
      l = r;
    }
    return say(sb.toString(), --n);
  }

  // Regex
  public String countAndSay(int n) {
    String regex = "(.)\\1*";
    Pattern pattern = Pattern.compile(regex);
    String curSeq = "1";

    for (int i = 1; i < n; ++i) {
      Matcher m = pattern.matcher(curSeq);
      StringBuilder nextSeq = new StringBuilder();
      if (m.find()) {
        nextSeq.append(m.group().length()).append(m.group().charAt(0));
      }
      curSeq = nextSeq.toString();
    }
    return curSeq;
  }
}
// @lc code=end
