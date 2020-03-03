/*
 * @lc app=leetcode id=43 lang=java
 *
 * [43] Multiply Strings
 */

// @lc code=start
class Solution {
  public String multiply2(String num1, String num2) {
    // StringBuilder strRes = new StringBuilder();
    int i = 0;
    // int i = num1.length() - 1;
    // int j = num2.length() - 1;
    long sum = 0;
    System.out.format("Long.max: %d\n", Long.MAX_VALUE);
    long sumIn = 0;
    int carry = 0;
    while (i < num1.length()) {
      sumIn = 0;
      sum *= 10;
      carry = 0;
      int j = num2.length() - 1;
      int factor = 0;
      while (j >= 0) {
        int sumIn1 = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
        sumIn = sumIn + (sumIn1 % 10 + carry) % 10 * (long) Math.pow(10, factor);
        System.out.format("j: %d | sumIn: %d\n", j, sumIn);
        carry = sumIn1 / 10;
        j--;
        factor++;
      }
      if (carry != 0) {
        sumIn += Math.pow(10, factor) * carry;
      }
      System.out.format("i: %d || sumIn: %d\n", i, sumIn);
      sum += sumIn;
      System.out.format("i: %d || sum: %d\n", i, sum);
      i++;
    }

    return Long.toString(sum);
  }

  // optimal method
  public String multiply(String num1, String num2) {
    if (null == num1 || null == num2) {
      return null;
    }
    StringBuilder strRes = new StringBuilder();
    int num1Len = num1.length();
    int num2Len = num2.length();
    int product = 0;
    int[] res = new int[num1Len + num2Len];

    for (int i = num1Len - 1; i >= 0; i--) {
      for (int j = num2Len - 1; j >= 0; j--) {
        product = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
        int sum = product + res[i + j + 1];
        res[i + j] += sum / 10;
        res[i + j + 1] = sum % 10;
      }
      // System.out.format("i: %d, j: || res: %s\n", i, Arrays.toString(res));
    }

    for (int i = 0; i < res.length; i++) {
      if (0 == res[i] && 0 == strRes.length()) {
        continue;
      }
      strRes.append(res[i]);
    }
    // System.out.println("strRes: " + strRes);
    return 0 == strRes.length() ? "0" : strRes.toString();
  }
}
// @lc code=end
