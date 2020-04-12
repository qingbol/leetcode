import java.util.Map;

/*
 * @lc app=leetcode id=288 lang=java
 *
 * [288] Unique Word Abbreviation
 */

// @lc code=start
////-------------------start(Approach1)-----------------------------
//20200411, by myself. hashmap + hashmap
//Your runtime beats 11.2 % of java submissions
// public class ValidWordAbbr {
class ValidWordAbbr1 {

  // Set<String> dict;
  Map<String, Integer> dict;
  Map<String, Integer> map;

  public ValidWordAbbr1(String[] dictionary) {
    // public ValidWordAbbr(String[] dictionary) {
    dict = new HashMap<>();
    map = new HashMap<>();
    if (dictionary == null || dictionary.length == 0) {
      return;
    }

    for (String s : dictionary) {
      if (s.length() == 0) {
        continue;
      }

      dict.putIfAbsent(s, 0);
      dict.put(s, dict.get(s) + 1);

      String abb = s.charAt(0) + String.valueOf(s.length() - 2) + s.charAt(s.length() - 1);
      map.putIfAbsent(abb, 0);
      map.put(abb, map.get(abb) + 1);
    }
  }

  public boolean isUnique(String word) {
    if (word == null || word.length() == 0) {
      return true;
    }
    String abb = word.charAt(0) + String.valueOf(word.length() - 2) + word.charAt(word.length() - 1);
    int same = dict.getOrDefault(word, 0);
    if (map.containsKey(abb) && map.get(abb) > same) {
      return false;
    }
    return true;
  }
}

//// ------------------- end (Approach1)-----------------------------
//// -------------------start(Approach2)-----------------------------
// 20200411, Approach #3 (Hash Table) [Accepted]
// Your runtime beats 14.15 % of java submissions
// class ValidWordAbbr2 {
public class ValidWordAbbr {

  Set<String> dict;
  Map<String, Boolean> map;

  public ValidWordAbbr(String[] dictionary) {
    // public ValidWordAbbr1(String[] dictionary) {
    map = new HashMap<>();
    dict = new HashSet(Arrays.asList(dictionary));
    for (String s : dict) {

      String abbr = s.length() <= 2 ? s : s.charAt(0) + String.valueOf(s.length() - 2) + s.charAt(s.length() - 1);
      // map.putIfAbsent(abbr, true);
      map.put(abbr, !map.containsKey(abbr));
    }
  }

  public boolean isUnique(String word) {
    int n = word.length();
    String abbr = n <= 2 ? word : word.charAt(0) + String.valueOf(n - 2) + word.charAt(n - 1);

    Boolean hasAbbr = map.get(abbr);
    return hasAbbr == null || (hasAbbr && dict.contains(word));
  }
}
//// ------------------- end (Approach2)-----------------------------

/**
 * Your ValidWordAbbr object will be instantiated and called as such:
 * ValidWordAbbr obj = new ValidWordAbbr(dictionary); boolean param_1 =
 * obj.isUnique(word);
 */
// @lc code=end
