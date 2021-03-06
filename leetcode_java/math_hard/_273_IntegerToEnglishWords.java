/*
 * @lc app=leetcode id=273 lang=java
 *
 * [273] Integer to English Words
 */

// @lc code=start
class Solution {
  //////////////////////// first round(20200216)//////////////////////////
  //////////////////////// first round(20200216)//////////////////////////
  //// ----------start(Approach1)------------------------------------
  // 20200216
  private final String[] belowTen = { "", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine" };
  private final String[] belowTwenty = new String[] { "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen",
      "Sixteen", "Seventeen", "Eighteen", "Nineteen" };
  private final String[] belowHundred = new String[] { "", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty",
      "Seventy", "Eighty", "Ninety" };

  public String numberToWords(int num) {
    if (num == 0) {
      return "Zero";
    }
    return helper(num);
  }

  private String helper(int num) {
    StringBuilder sb = new StringBuilder();
    if (num < 10) {
      sb.append(belowTen[num]);
    } else if (num < 20) {
      sb.append(belowTwenty[num % 10]);
    } else if (num < 100) {
      sb.append(belowHundred[num / 10]).append(" ").append(helper(num % 10));
    } else if (num < 1000) {
      sb.append(helper(num / 100)).append(" Hundred ").append(helper(num % 100));
    } else if (num < 1000000) {
      sb.append(helper(num / 1000)).append(" Thousand ").append(helper(num % 1000));
    } else if (num < 1000000000) {
      sb.append(helper(num / 1000000)).append(" Million ").append(helper(num % 1000000));
    } else {
      sb.append(helper(num / 1000000000)).append(" Billion ").append(helper(num % 1000000000));
    }
    return sb.toString().trim();
  }
  //// ---------- end (Approach1)------------------------------------
  //////////////////////// second round(20201021)//////////////////////////
  //////////////////////// second round(20201021)//////////////////////////
  //// ----------start(Approach2)------------------------------------
  // 20201021. 
  //// ---------- end (Approach2)------------------------------------
}
// @lc code=end
