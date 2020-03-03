/*
 * @lc app=leetcode id=383 lang=java
 *
 * [383] Ransom Note
 */

// @lc code=start
class Solution {
  public boolean canConstruct1(String ransomNote, String magazine) {
    // int[] ransomArr =
    boolean[] flag = new boolean[magazine.length()];
    for (int i = 0; i < ransomNote.length(); i++) {
      boolean find = false;
      for (int j = 0; j < magazine.length(); j++) {
        // System.out.format("1:ransomNote.charAt(i): %c, magazine[j]: %c \n",
        // ransomNote.charAt(i), magazine.charAt(j));
        if (ransomNote.charAt(i) == magazine.charAt(j) && flag[j] == false) {
          // System.out.format("2:ransomNote.charAt(i): %c, magazine[j]: %c \n",
          // ransomNote.charAt(i), magazine.charAt(j));
          flag[j] = true;
          find = true;
          break;
        }
      }
      if (!find)
        return false;
    }
    return true;
  }

  //
  public boolean canConstruct(String ransomNote, String magazine) {
    int[] count = new int[26];
    for (char c : magazine.toCharArray()) {
      count[c - 'a']++;
    }
    for (char c : ransomNote.toCharArray()) {
      if (--count[c - 'a'] < 0) {
        return false;
      }
    }
    return true;
  }
}
// @lc code=end
