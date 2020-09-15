/*
 * @lc app=leetcode id=383 lang=java
 *
 * [383] Ransom Note
 */

// @lc code=start
class Solution {
  ////////////////// first round(20200113)///////////////////////////////////
  ////////////////// first round(20200113)///////////////////////////////////
  //// ---------------------------start(Approach1)-----------------------
  // 20200113

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

  //// --------------------------- end (Approach1)-----------------------
  //// ---------------------------start(Approach2)-----------------------
  //

  // public boolean canConstruct(String ransomNote, String magazine) {
  public boolean canConstruct2(String ransomNote, String magazine) {
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
  //// --------------------------- end (Approach2)-----------------------
  ////////////////// second round(20200908)///////////////////////////////////
  ////////////////// second round(20200908)///////////////////////////////////
  //// ---------------------------start(Approach3)-----------------------
  // 20200113, by myself

  //129/129 cases passed (17 ms)
// Your runtime beats 22.88 % of java submissions
// Your memory usage beats 54.28 % of java submissions (40.2 MB)

  // public boolean canConstruct(String ransomNote, String magazine) {
  public boolean canConstruct3(String ransomNote, String magazine) {
    Map<Character, Integer> map = new HashMap<>();
    for (char c : ransomNote.toCharArray()) {
      map.putIfAbsent(c, 0);
      map.put(c, map.get(c) + 1);
    }
    for (char c : magazine.toCharArray()) {
      map.putIfAbsent(c, 0);
      map.put(c, map.get(c) - 1);
    }

    for (char c: ransomNote.toCharArray()) {
      if (map.get(c) > 0) {
        return false;
      }
    }
    return true;
  }
  //// --------------------------- end (Approach3)-----------------------
  //// ---------------------------start(Approach4)-----------------------
  // 20200113, by myself
  //improvement of approach2.

  // 129/129 cases passed (14 ms)
  // Your runtime beats 27.34 % of java submissions
  // Your memory usage beats 65.96 % of java submissions (40 MB)

  public boolean canConstruct(String ransomNote, String magazine) {
  // public boolean canConstruct3(String ransomNote, String magazine) {
    Map<Character, Integer> map = new HashMap<>();
    for (char c : magazine.toCharArray()) {
      map.putIfAbsent(c, 0);
      map.put(c, map.get(c) - 1);
    }

    for (char c : ransomNote.toCharArray()) {
      map.putIfAbsent(c, 0);
      map.put(c, map.get(c) + 1);
      if (map.get(c) > 0)  {
        return false;
      }
    }

    // for (char c: ransomNote.toCharArray()) {
    //   if (map.get(c) > 0) {
    //     return false;
    //   }
    // }
    return true;
  }
  //// --------------------------- end (Approach3)-----------------------
}
// @lc code=end
