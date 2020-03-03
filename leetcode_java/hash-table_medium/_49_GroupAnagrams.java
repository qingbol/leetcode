/*
 * @lc app=leetcode id=49 lang=java
 *
 * [49] Group Anagrams
 */

// @lc code=start
class Solution {
  // by myself, it' a little verbose, should use the optimal approach.
  public List<List<String>> groupAnagrams1(String[] strs) {
    Map<String, List<String>> map = new HashMap<>();
    for (int i = 0; i < strs.length; i++) {
      String tmp = strs[i];
      char[] charArr = tmp.toCharArray();
      // tmp = String.valueOf(Arrays.sort(tmp));
      Arrays.sort(charArr);
      tmp = String.valueOf(charArr);
      // System.out.format("tmp: %s\n", tmp);
      if (map.containsKey(tmp)) {
        map.get(tmp).add(strs[i]);
      } else {
        List<String> s = new ArrayList<>(Arrays.asList(strs[i]));
        map.put(tmp, s);
      }
    }

    List<List<String>> res = new ArrayList<>();
    for (List<String> lst : map.values()) {
      res.add(lst);
    }
    return res;
  }

  // optimal
  public class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
      if (strs == null || strs.length == 0)
        return new ArrayList<List<String>>();
      Map<String, List<String>> map = new HashMap<String, List<String>>();
      for (String s : strs) {
        char[] ca = s.toCharArray();
        Arrays.sort(ca);
        String keyStr = String.valueOf(ca);
        if (!map.containsKey(keyStr))
          map.put(keyStr, new ArrayList<String>());
        map.get(keyStr).add(s);
      }
      return new ArrayList<List<String>>(map.values());
    }
  }
}
// @lc code=end
