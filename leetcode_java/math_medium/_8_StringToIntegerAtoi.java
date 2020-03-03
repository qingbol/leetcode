/*
 * @lc app=leetcode id=8 lang=java
 *
 * [8] String to Integer (atoi)
 */

// @lc code=start
class Solution {
  public int myAtoi2(String str) {
    long res = 0;
    int flag = 0;
    int sign = 0;
    for (int i = 0; i < str.length(); i++) {
      char c = str.charAt(i);
      if (Character.isWhitespace(c) && 0 == flag) {
        continue;
      } else if ('-' == c && 0 == flag) {
        sign = 1;
        flag = 1;
      } else if ('+' == c && 0 == flag) {
        flag = 1;
        continue;
      } else if (Character.isDigit(c)) {
        res = res * 10 + c - '0';
      } else if (Character.isWhitespace(c) && 1 == flag) {
        break;
      } else if (Character.isLetter(c)) {
        break;
      } else if (!Character.isDigit(c)) {
        break;
      }
    }
    if (1 == sign) {
      res *= -1;
    }
    if (res < Integer.MIN_VALUE) {
      return Integer.MIN_VALUE;
    }
    if (res > Integer.MAX_VALUE) {
      return Integer.MAX_VALUE;
    }
    return (int) res;
  }

  public int myAtoi(String str) {
    str = str.trim();
    if (null == str || 0 == str.length()) {
      return 0;
    }
    System.out.println("str after trim: " + str);
    char firstChar = str.charAt(0);
    System.out.println("firstChar: " + firstChar);
    int sign = 1;
    long res = 0;
    System.out.println("Long.MAX: " + Long.MAX_VALUE);
    int start = 0;
    if ('+' == firstChar) {
      start++;
    } else if ('-' == firstChar) {
      sign = -1;
      start++;
    }

    for (int i = start; i < str.length(); i++) {
      if (!Character.isDigit(str.charAt(i))) {
        break;
      }
      res = res * 10 + str.charAt(i) - '0';
      if (res > Integer.MAX_VALUE && 1 == sign) {
        return Integer.MAX_VALUE;
      }
      if (res > Integer.MAX_VALUE && -1 == sign) {
        return Integer.MIN_VALUE;
      }
      System.out.format("i: %d, res: %d \n", i, res);
    }

    // if (-1 == sign) {
    // res = sign * res;
    // }

    return (int) res * sign;
  }
}
// @lc code=end
