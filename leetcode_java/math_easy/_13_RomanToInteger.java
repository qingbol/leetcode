/*
 * @lc app=leetcode id=13 lang=java
 *
 * [13] Roman to Integer
 */

// @lc code=start
class Solution {
  // by myself, brute force
  public int romanToInt1(String s) {
    // System.out.format("s: %s\n", s);
    int res = 0;
    int i = 0;
    while (i < s.length()) {
      // System.out.format("res: %d \n", res);
      if (s.charAt(i) == 'M') {
        res += 1000;
      } else if (s.charAt(i) == 'D') {
        res += 500;
      } else if (s.charAt(i) == 'L') {
        res += 50;
      } else if (s.charAt(i) == 'V') {
        res += 5;
      } else if (s.charAt(i) == 'I') {
        if (i < s.length() - 1 && s.charAt(i + 1) == 'V') {
          res += 4;
          i++;
        } else if (i < s.length() - 1 && s.charAt(i + 1) == 'X') {
          res += 9;
          i++;
        } else {
          res += 1;
        }
      } else if (s.charAt(i) == 'X') {
        if (i < s.length() - 1 && s.charAt(i + 1) == 'L') {
          res += 40;
          i++;
        } else if (i < s.length() - 1 && s.charAt(i + 1) == 'C') {
          res += 90;
          i++;
        } else {
          res += 10;
        }
      } else if (s.charAt(i) == 'C') {
        if (i < s.length() - 1 && s.charAt(i + 1) == 'D') {
          res += 400;
          i++;
        } else if (i < s.length() - 1 && s.charAt(i + 1) == 'M') {
          res += 900;
          i++;
        } else {
          res += 100;
        }
      }
      i++;
    }
    return res;
  }

  // optimal
  public int romanToInt(String s) {
    int[] bucket = new int[26];
    bucket['I' - 'A'] = 1;
    bucket['V' - 'A'] = 5;
    bucket['X' - 'A'] = 10;
    bucket['L' - 'A'] = 50;
    bucket['C' - 'A'] = 100;
    bucket['D' - 'A'] = 500;
    bucket['M' - 'A'] = 1000;

    int res = 0;
    char prev = 'A';
    for (int i = 0; i < s.length(); i++) {
      if (bucket[s.charAt(i) - 'A'] > bucket[prev - 'A']) {
        res -= 2 * bucket[prev - 'A'];
      }
      res += bucket[s.charAt(i) - 'A'];
      prev = s.charAt(i);
    }
    return res;
  }
}
// @lc code=end
