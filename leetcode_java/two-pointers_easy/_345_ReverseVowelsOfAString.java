/*
 * @lc app=leetcode id=345 lang=java
 *
 * [345] Reverse Vowels of a String
 */

// @lc code=start
class Solution {
  //////////////////////// first round(20200215)//////////////////////////
  //////////////////////// first round(20200215)//////////////////////////
  //// ----------start(Approach1)------------------------------------
  // 20200215
  public String reverseVowels(String s) {
    Set<Character> set = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));
    int l = 0;
    int r = s.length() - 1;
    char[] str = s.toCharArray();
    while (l < r) {
      while (l < r && !set.contains(str[l])) {
        l++;
      }
      while (l < r && !set.contains(str[r])) {
        r--;
      }
      char tmp = str[l];
      str[l++] = str[r];
      str[r--] = tmp;
    }
    return new String(str);
  }
  //// ---------- end (Approach1)------------------------------------
  //////////////////////// second round(20201020)//////////////////////////
  //////////////////////// second round(20201020)//////////////////////////
  //// ----------start(Approach2)------------------------------------
  // 20201020
  //// ---------- end (Approach2)------------------------------------
}
// @lc code=end
