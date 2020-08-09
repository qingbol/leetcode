/*
 * @lc app=leetcode id=43 lang=java
 *
 * [43] Multiply Strings
 */

// @lc code=start
class Solution {
  ////////////////// first round(20200127)///////////////////////////////////
  ////////////////// first round(20200127)///////////////////////////////////
  //// ----------------start(Approach1)-------------------------
  // 20200127

  public String multiply1(String num1, String num2) {
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

  //// ---------------- end (Approach1)-------------------------
  //// ----------------start(Approach2)-------------------------
  // 20200127
  // optimal method
  public String multiply2(String num1, String num2) {
    // public String multiply(String num1, String num2) {
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
  //// ---------------- end (Approach2)-------------------------
  ////////////////// second round(20200805)///////////////////////////////////
  ////////////////// second round(20200805)///////////////////////////////////
  //// ----------------start(Approach3)-------------------------
  // 20200805. can't come up by myself.
  // refer to labuladong <字符串乘法>

//   311/311 cases passed (3 ms)
// Your runtime beats 94.66 % of java submissions
// Your memory usage beats 19.39 % of java submissions (39.8 MB)

  // public String multiply3(String num1, String num2) {
  public String multiply(String num1, String num2) {
    int n1 = num1.length();
    int n2 = num2.length();
    if (n1 == 0 || n1 == 0)
      return "";
    int[] res = new int[n1 + n2];

    for (int i = n1 - 1; i >= 0; i--) {
      for (int j = n2 - 1; j >= 0; j--) {
        int mul = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
        int sum = mul + res[i + j + 1];
        res[i + j + 1] = sum % 10;
        res[i + j] += sum / 10;
      }
    }

    int i = 0;
    while (i < n1 + n2 && res[i] == 0)
      i++;

    StringBuilder sb = new StringBuilder();
    for (; i < n1 + n2; i++)
      sb.append(res[i]);
    return sb.length() == 0 ? "0" : sb.toString();
  }
  //// ---------------- end (Approach3)-------------------------
}
// @lc code=end
