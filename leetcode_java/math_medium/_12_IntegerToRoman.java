/*
 * @lc app=leetcode id=12 lang=java
 *
 * [12] Integer to Roman
 */

// @lc code=start
class Solution {
  public String intToRoman1(int num) {
    StringBuilder sb = new StringBuilder();
    while (num > 0) {

      if (num / 1000 > 0) {
        sb.append(new String(new char[num / 1000]).replaceAll("\0", "M"));
        // System.out.format("sb: %s\n", sb.toString());
        num -= num / 1000 * 1000;
      } else if (num / 100 == 9) {
        sb.append("CM");
        num -= 900;
      } else if (num / 100 > 4 && num / 100 < 9) {
        sb.append("D");
        num -= 500;
      } else if (num / 100 == 4) {
        sb.append("CD");
        num -= 400;
      } else if (num / 100 > 0 && num / 100 < 4) {
        sb.append("C");
        num -= 100;
      } else if (num / 10 == 9) {
        sb.append("XC");
        num -= 90;
      } else if (num / 10 > 4 && num / 10 < 9) {
        sb.append("L");
        num -= 50;
      } else if (num / 10 == 4) {
        sb.append("XL");
        num -= 40;
      } else if (num / 10 > 0 && num / 10 < 4) {
        sb.append("X");
        num -= 10;
      } else if (num == 9) {
        sb.append("IX");
        num -= 9;
      } else if (num > 4 && num < 9) {
        sb.append("V");
        num -= 5;
      } else if (num == 4) {
        sb.append("IV");
        num -= 9;
      } else if (num > 0 & num < 4) {
        sb.append("I");
        num -= 1;
      }
    }
    return sb.toString();
  }

  // optimum
  public String intToRoman2(int num) {
    String M[] = { "", "M", "MM", "MMM" };
    String C[] = { "", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM" };
    String X[] = { "", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC" };
    String I[] = { "", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX" };
    return M[num / 1000] + C[(num % 1000) / 100] + X[(num % 100) / 10] + I[(num % 10)];
  }

  public String intToRoman(int num) {
    int[] values = { 1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1 };
    String[] tokens = { "M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I" };
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < values.length; i++) {
      while (num >= values[i]) {
        num -= values[i];
        sb.append(tokens[i]);
      }
    }
    return sb.toString();
  }
}
// @lc code=end
