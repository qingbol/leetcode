/*
 * @lc app=leetcode id=8 lang=java
 *
 * [8] String to Integer (atoi)
 */

// @lc code=start
class Solution {
  ////////////////// first round(20200104)///////////////////////////////////
  ////////////////// first round(20200104)///////////////////////////////////
  //// ----------------start(Approach1)-------------------------------------
  // 20200104

  // public int myAtoi(String str) {
  public int myAtoi1(String str) {
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

  //// ---------------- end (Approach1)-------------------------------------
  //// ----------------start(Approach2)-------------------------------------
  // 20200104
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
  //// ---------------- end (Approach2)-------------------------------------
  ////////////////// second round(20200904)///////////////////////////////////
  ////////////////// second round(20200904)///////////////////////////////////
  //// ----------------start(Approach3)-------------------------------------
  // 20200904
  // refer to leetcode standard solution. && approach2

  public int myAtoi(String str) {
  // public int myAtoi3(String str) {
    int n = str.length();
    if (n == 0) return 0;
    long res = 0; 
    int sign = 1;
    int idx = 0;

    //1. skip space
    while(idx < n && str.charAt(idx) == ' ') {
      idx++;
    }

    //2. handle sign 
    if (idx < n && str.charAt(idx) == '+') {
      idx++;
    } else if (idx < n && str.charAt(idx) == '-') {
      sign = -1;
      idx++;
    }

    while (idx < n && str.charAt(idx) >= '0' && str.charAt(idx) <= '9') {
      res = res * 10 + (str.charAt(idx) - '0');
      idx++;
    }

    if (res > Integer.MAX_VALUE) {
      if (sign == 1) {
        return Integer.MAX_VALUE;
      } else {
        return Integer.MIN_VALUE;
      }
    }

    return (int) sign * res;
  }
  //// ---------------- end (Approach3)-------------------------------------
}
// @lc code=end
