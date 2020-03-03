/*
 * @lc app=leetcode id=336 lang=java
 *
 * [336] Palindrome Pairs
 */

// @lc code=start
class Solution {
  //// ----------------------start(Approach 1)-----------------------------
  //// : by myself, brute force approach
  public List<List<Integer>> palindromePairs1(String[] words) {
    if (words == null || words.length == 0) {
      return new ArrayList<>();
    }
    List<List<Integer>> res = new ArrayList<>();
    for (int i = 0; i < words.length; i++) {
      for (int j = 0; j < words.length; j++) {
        if (i != j) {
          if (isPalindrome(words[i] + words[j])) {
            res.add(new ArrayList<>(Arrays.asList(i, j)));
            // } else if (isPalindrome(words[j] + words[i])) {
            // res.add(new ArrayList<>(Arrays.asList(j, i)));
          }
        }
      }
    }
    return res;
  }

  private boolean isPalindrome(String s) {
    if (s.length() < 2) {
      return true;
    }
    int l = 0;
    int r = s.length() - 1;
    for (; l < r; l++, r--) {
      if (s.charAt(l) != s.charAt(r)) {
        return false;
      }
    }
    return true;
  }

  //// ---------------------- end (Approach 1)-----------------------------
  //// ----------------------start(Approach 2)-----------------------------
  // hashmap
  public List<List<Integer>> palindromePairs(String[] words) {
    if (words == null || words.length == 0) {
      return new ArrayList<>();
    }
    Map<String, Integer> map = new HashMap<>();
    List<List<Integer>> res = new ArrayList<>();
    for (int i = 0; i < words.length; i++) {
      map.put(words[i], i);
    }

    for (int i = 0; i < words.length; i++) {
      // reverse
      String rev = new StringBuilder(words[i]).reverse().toString();
      if (map.containsKey(rev) && map.get(rev) != i) {
        res.add(new ArrayList<>(Arrays.asList(i, map.get(rev))));
      }

      // prefix
      List<String> prefixs = findPrefix(words[i]);
      // System.out.format("prefixs: %s\n", prefixs);
      for (String prefix : prefixs) {
        String prefixRev = new StringBuilder(prefix).reverse().toString();
        if (map.containsKey(prefixRev) && map.get(prefixRev) != i) {
          res.add(new ArrayList<>(Arrays.asList(map.get(prefixRev), i)));
        }
      }
      // suffix
      List<String> suffixs = findSuffix(words[i]);
      // System.out.format("suffixs: %s\n", suffixs);
      for (String suffix : suffixs) {
        String suffixRev = new StringBuilder(suffix).reverse().toString();
        if (map.containsKey(suffixRev) && map.get(suffixRev) != i) {
          res.add(new ArrayList<>(Arrays.asList(i, map.get(suffixRev))));
        }
      }
    }
    return res;
  }

  private List<String> findPrefix(String ss) {
    // if (ss.length() < 2) {
    // return new ArrayList<>(Arrays.asList(""));
    // }
    List<String> lst = new ArrayList<>();
    int upper = ss.length() - 1;
    for (; upper >= 0; upper--) {
      int l = 0;
      int r = upper;
      for (; l < r; l++, r--) {
        if (ss.charAt(l) != ss.charAt(r)) {
          break;
        }
      }
      if (l >= r) {
        lst.add(ss.substring(upper + 1));
      }
    }
    return lst;
  }

  private List<String> findSuffix(String ss) {
    // if (ss.length() < 2) {
    // return new ArrayList<>(Arrays.asList(""));
    // }
    List<String> lst = new ArrayList<>();
    int lower = 0;
    for (; lower < ss.length(); lower++) {
      int r = ss.length() - 1;
      int l = lower;
      for (; l < r; l++, r--) {
        if (ss.charAt(l) != ss.charAt(r)) {
          break;
        }
      }
      if (l >= r) {
        lst.add(ss.substring(0, lower));
      }
    }
    return lst;
  }
  //// ---------------------- end (Approach 2)-----------------------------
  //// ----------------------start(Approach 3)-----------------------------
  // standard hashing approach.

  //// ---------------------- end (Approach 3)-----------------------------
}
// @lc code=end
