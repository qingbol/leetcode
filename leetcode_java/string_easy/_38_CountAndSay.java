import java.util.regex.Pattern;
import java.util.regex.Matcher;
/*
 * @lc app=leetcode id=38 lang=java
 *
 * [38] Count and Say
 */

// @lc code=start
class Solution {
  //////////////////////// first round(20200215)//////////////////////////
  //////////////////////// first round(20200215)//////////////////////////
  //// ----------start(Approach1)------------------------------------
  // 20200215
  public String countAndSay(int n) {
  // public String countAndSay1(int n) {
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

  //// ---------------- end (Appraoch1)----------------------------------
  //// ----------------start(Appraoch2)----------------------------------
  // Regex
  // public String countAndSay(int n) {
  public String countAndSay2(int n) {
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
  //// ---------- end (Approach2)------------------------------------
  //////////////////////// second round(20201020)//////////////////////////
  //////////////////////// second round(20201020)//////////////////////////
  //// ----------start(Approach3)------------------------------------
  // 20201020. ant figure it out by myself.
  //// ---------- end (Approach3)------------------------------------
}
// @lc code=end
