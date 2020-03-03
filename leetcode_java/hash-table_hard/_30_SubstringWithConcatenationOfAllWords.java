import java.util.Map;

/*
 * @lc app=leetcode id=30 lang=java
 *
 * [30] Substring with Concatenation of All Words
 */

// @lc code=start
class Solution {
  // wrong, misunderstand the requirement
  public List<Integer> findSubstring1(String s, String[] words) {
    List<Integer> lst = new ArrayList<>();
    for (int i = 0; i < words.length; i++) {
      for (int j = 0; j < words.length; j++) {
        if (i != j) {
          String tmp = words[i] + words[j];
          int idx = s.indexOf(tmp);
          if (idx != -1) {
            lst.add(idx);
          }
        }
      }
    }
    return lst;
  }

  // wrong. one loop can't work.
  public List<Integer> findSubstring2(String s, String[] words) {
    Map<String, Integer> map = new HashMap<>();
    Map<String, Integer> mapBackup = new HashMap<>();
    List<Integer> res = new ArrayList<>();
    for (String word : words) {
      map.put(word, map.getOrDefault(word, 0) + 1);
    }
    mapBackup.putAll(map);

    int l = words[0].length();
    int len = words.length * l;

    // int start = 0;
    // int idx = 0;
    for (int i = 0; i < s.length() - l; i++) {
      String subs = s.substring(i, i + l);
      if (map.containsKey(subs)) {
        map.put(subs, map.getOrDefault(subs, 0) - 1);
        if (map.get(subs) == 0) {
          map.remove(subs);
        }
        // start = i;
        i += l - 1;
        System.out.format("i in for: %d\n", i);
        if (map.isEmpty()) {
          System.out.format("i in empty: %d\n", i);
          res.add(i - len + 1);
          // idx = i;
          map.putAll(mapBackup);
          i = i - len + 1;
          // System.out.format("map: %s\n", map);
        }
      } else {
        map.putAll(mapBackup);
      }
    }

    // System.out.format("res: %s\n", res);
    return res;
  }

  // After reading the answer,
  public List<Integer> findSubstring(String s, String[] words) {
    if (null == s || s.length() == 0 || words == null || words.length == 0) {
      return new ArrayList<>();
    }
    Map<String, Integer> map = new HashMap<>();
    Map<String, Integer> mapHelper = new HashMap<>();
    List<Integer> res = new ArrayList<>();

    for (String word : words) {
      mapHelper.put(word, mapHelper.getOrDefault(word, 0) + 1);
    }
    // System.out.format("map: %s\n", mapHelper);

    int n = s.length();
    int wCount = words.length;
    int wLen = words[0].length();
    int len = wLen * wCount;

    for (int i = 0; i < n - len + 1; i++) {
      map.putAll(mapHelper);
      // System.out.format("map:%s\n", map);
      for (int j = i; !map.isEmpty(); j += wLen) {
        // System.out.format("j: %d\n", j);
        String subs = s.substring(j, j + wLen);
        if (map.containsKey(subs)) {
          map.put(subs, map.get(subs) - 1);
          if (map.get(subs) == 0) {
            map.remove(subs);
          }
        } else {
          break;
        }
      }
      if (map.isEmpty()) {
        res.add(i);
      }
    }
    return res;
  }
}
// @lc code=end
