/*
 * @lc app=leetcode id=242 lang=java
 *
 * [242] Valid Anagram
 */

// @lc code=start
class Solution {

  //////////////////////// first round(20200213)//////////////////////////
  //////////////////////// first round(20200213)//////////////////////////
  //// ----------start(Approach1)------------------------------------
  // 20200213
  // by java8 sort
  public boolean isAnagram1(String s, String t) {
    String sortedT = Stream.of(t.split("")).sorted().collect(Collectors.joining());
    // System.out.format("t: %s\n", sortedT);
    String sortedS = s.chars().sorted()
        .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append).toString();
    // System.out.format("s: %s\n", sortedS);
    return sortedS.equals(sortedT) ? true : false;
  }

  //// ---------------- end (Appraoch1)----------------------------------
  //// ----------------start(Appraoch2)----------------------------------
  //
  public boolean isAnagram2(String s, String t) {
    if (s.length() != t.length()) {
      return false;
    }
    Map<Character, Integer> map = new HashMap<>();
    for (int i = 0; i < s.length(); i++) {
      map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
      map.put(t.charAt(i), map.getOrDefault(t.charAt(i), 0) - 1);
    }
    for (Integer val : map.values()) {
      if (val != 0) {
        return false;
      }
    }
    return true;
  }

  //// ---------------- end (Appraoch2)----------------------------------
  //// ----------------start(Appraoch3)----------------------------------
  // by counting sort
  public boolean isAnagram(String s, String t) {
    int[] bucket = new int[26];
    for (int i = 0; i < s.length(); i++) {
      bucket[s.charAt(i) - 'a']++;
    }
    for (int i = 0; i < t.length(); i++) {
      bucket[t.charAt(i) - 'a']--;
    }
    for (int i = 0; i < bucket.length; i++) {
      if (bucket[i] != 0) {
        return false;
      }
    }
    return true;
  }
  //// ---------- end (Approach3)------------------------------------
  //////////////////////// second round(20201023)//////////////////////////
  //////////////////////// second round(20201023)//////////////////////////
  //// ----------start(Approach4)------------------------------------
  // 20201023. 
  //// ---------- end (Approach4)------------------------------------
}
// @lc code=end
