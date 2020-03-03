/*
 * @lc app=leetcode id=344 lang=java
 *
 * [344] Reverse String
 */

// @lc code=start
class Solution {
  public void reverseString(char[] s) {
    char tmp = '\0';
    int l = 0;
    int r = s.length - 1;
    while (l < r) {
      tmp = s[l];
      s[l++] = s[r];
      s[r--] = tmp;
      // l++;
      // r--;
    }
  }

  // Stringbuilder
  // wrong ,why?
  public void reverseString2(char[] s) {
    String s1 = new String(s);
    StringBuilder s2 = new StringBuilder(s1);
    StringBuilder s3 = s2.reverse();
    System.out.format("s3: %s\n", s3);
    System.out.format("s3: %s\n", s3.toString());
    char[] t = new char[s.length];
    t = s3.toString().toCharArray();
    System.out.format("s3: %s\n", Arrays.toString(t));
    s = t;
  }
}
// @lc code=end
