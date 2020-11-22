/*
 * @lc app=leetcode id=140 lang=java
 *
 * [140] Word Break II
 */

// @lc code=start
class Solution {
  /////////////////////////// first round(20200229)//////////////////////////
  /////////////////////////// first round(20200229)//////////////////////////
  //// ----------------------start(Approach1)-------------------------
  // 20200229
  // By myself. BackTracking. Time Limite Exceeded error for case:
  // "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaabaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"
  // '["a","aa","aaa","aaaa","aaaaa","aaaaaa","aaaaaaa","aaaaaaaa","aaaaaaaaa","aaaaaaaaaa"]
  public List<String> wordBreak1(String s, List<String> wordDict) {
    List<String> res = new ArrayList<>();
    if (s == null || s.length() == 0) {
      return res;
    }
    helper1(res, s, wordDict, new StringBuilder(), 0);
    return res;
  }

  private void helper1(List<String> res, String s, List<String> wordDict, StringBuilder sb, int start) {
    if (start == s.length()) {
      // if (sb.toString().replaceAll("\\s", "").length() == s.length()) {
      res.add(new String(sb).trim());
      // }
      return;
    }

    StringBuilder word = new StringBuilder();
    for (int i = start; i < s.length(); i++) {
      word.append(s.charAt(i));
      int len = sb.length();
      if (wordDict.contains(word.toString())) {
        sb.append(word).append(" ");
        helper1(res, s, wordDict, sb, i + 1);
        sb.setLength(len);
      }
    }
  }

  //// ---------------------- end (Approach1)----------------------
  //// ----------------------start(Approach2)----------------------
  // recursion
  // same TLE error with Approach1
  public List<String> wordBreak2(String s, List<String> wordDict) {
    return recursion2(s, wordDict, 0);
  }

  private List<String> recursion2(String s, List<String> wordDict, int start) {
    List<String> ret = new ArrayList<>();
    if (start == s.length()) {
      ret.add("");
      return ret;
    }

    for (int end = start + 1; end <= s.length(); end++) {
      if (wordDict.contains(s.substring(start, end))) {
        // System.out.format("s: %s\n", s.substring(start, end));
        List<String> lst = recursion2(s, wordDict, end);
        for (String str : lst) {
          ret.add(s.substring(start, end) + (str.equals("") ? "" : " ") + str);
        }
      }
    }
    return ret;
  }

  //// ---------------------- end (Approach2)----------------------
  //// ----------------------start(Approach3)----------------------
  // recursion with memorization
  // optimal
  public List<String> wordBreak(String s, List<String> wordDict) {
    Map<Integer, List<String>> map = new HashMap<>();
    return recursion3(map, s, wordDict, 0);
  }

  private List<String> recursion3(Map<Integer, List<String>> map, String s, List<String> wordDict, int start) {
    if (map.containsKey(start)) {
      return map.get(start);
    }
    List<String> ret = new ArrayList<>();
    if (start == s.length()) {
      ret.add("");
      return ret;
    }

    for (int end = start + 1; end <= s.length(); end++) {
      if (wordDict.contains(s.substring(start, end))) {
        List<String> lst = recursion3(map, s, wordDict, end);
        for (String str : lst) {
          ret.add(s.substring(start, end) + (str.equals("") ? "" : " ") + str);
        }
      }
    }
    map.put(start, ret);
    return ret;
  }

  //// ---------------------- end (Approach3)----------------------
  //// ----------------------start(Approach4)----------------------
  // dp
  // Time Limit Exceeded error
  public List<String> wordBreak4(String s, List<String> wordDict) {
    List<String>[] dp = new ArrayList[s.length() + 1];
    dp[0] = new ArrayList<>(Arrays.asList(""));
    // System.out.format("size:%d\n", dp[0].size());

    // for loop
    for (int i = 1; i <= s.length(); i++) {
      List<String> lst = new ArrayList<>();
      for (int j = 0; j < i; j++) {
        if (dp[j].size() > 0 && wordDict.contains(s.substring(j, i))) {
          for (String l : dp[j]) {
            lst.add(l + (l.equals("") ? "" : " ") + s.substring(j, i));
          }
        }
      }
      dp[i] = lst;
    }
    return dp[s.length()];
  }
  //// --------------- end (Approach3)--------------------------------
  /////////////////////////// second round(20201122)///////////////////////
  /////////////////////////// second round(20201122)///////////////////////
  //// ----------------start(Approach4)----------------------------------
  // 20201122.
  //// ---------------- end (Approach4)----------------------------------
}
// @lc code=end
