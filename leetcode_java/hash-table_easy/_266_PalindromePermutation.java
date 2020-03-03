/*
 * @lc app=leetcode id=266 lang=java
 *
 * [266] Palindrome Permutation
 */

// @lc code=start
class Solution {
  public boolean canPermutePalindrome(String s) {
    if (s.length() < 2) {
      return true;
    }
    int[] bucket = new int[256];
    for (char ch : s.toCharArray()) {
      bucket[ch - '\0']++;
    }
    int num = 0;
    for (int i = 0; i < 256; i++) {
      if (bucket[i] % 2 == 1) {
        num++;
        if (num > 1) {
          return false;
        }
      }
    }
    return true;
  }
}
// @lc code=end
