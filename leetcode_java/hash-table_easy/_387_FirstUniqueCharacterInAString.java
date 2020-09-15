/*
 * @lc app=leetcode id=387 lang=java
 *
 * [387] First Unique Character in a String
 */

// @lc code=start
class Solution {
  ////////////////// first round(20200109)///////////////////////////////////
  ////////////////// first round(20200109)///////////////////////////////////
  //// ----------------start(Approach1)-------------------------------------
  // 20200109

  // public int firstUniqChar(String s) {
  public int firstUniqChar1(String s) {
    if (null == s || 0 == s.length()) {
      return -1;
    }
    int max = Integer.MIN_VALUE;
    for (int i = 0; i < s.length(); i++) {
      max = Math.max(max, s.charAt(i) - 'a');
    }

    int[] count = new int[max + 1];
    for (int i = 0; i < s.length(); i++) {
      count[s.charAt(i) - 'a'] += 1;
    }

    for (int i = 0; i < s.length(); i++) {
      if (1 == count[s.charAt(i) - 'a']) {
        return i;
      }
    }
    return -1;
  }
  //// ---------------- end (Approach1)-------------------------------------
  ////////////////// second round(20200907)///////////////////////////////////
  ////////////////// second round(20200907)///////////////////////////////////
  //// ----------------start(Approach2)-------------------------------------
  // 20200907. two pass method
  //refer to leetcode standard solution

//   104/104 cases passed (30 ms)
// Your runtime beats 33.76 % of java submissions
// Your memory usage beats 71.65 % of java submissions (40 MB)

  public int firstUniqChar(String s) {
  // public int firstUniqChar2(String s) {
    Map<Character, Integer> map = new HashMap<>();

    //1. count the frequency
    for (char c : s.toCharArray()) {
      map.putIfAbsent(c, 0);
      map.put(c, map.get(c) + 1);
    }

    //2.check the frequency
    for (int i = 0; i < s.length(); i++) {
      if (map.get(s.charAt(i)) == 1) return i;
    }
  
    return -1;
  }
  //// ---------------- end (Approach1)-------------------------------------
}
// @lc code=end
