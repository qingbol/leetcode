import java.beans.FeatureDescriptor;

/*
 * @lc app=leetcode id=204 lang=java
 *
 * [204] Count Primes
 */

// @lc code=start
class Solution {
  ////////////////// first round(20200106)///////////////////////////////////
  ////////////////// first round(20200106)///////////////////////////////////
  //// ----------------start(Approach1)-------------------------------------
  // 20200106
  public int countPrimes1(int n) {
    if (n < 2) {
      return 0;
    }
    int res = 0;
    while (n > 1) {
      if (isPrime(n)) {
        res++;
      }
    }

    return res;
  }

  private boolean isPrime(int x) {
    int divisor = x - 1;
    while (divisor > 1) {
      if (0 == x % divisor) {
        return false;
      }
    }
    return true;
  }

  // optimal solution
  public int countPrimes2(int n) {
    boolean[] isPrime = new boolean[n];
    int res = 0;
    for (int i = 2; i < n; i++) {
      if (false == isPrime[i]) {
        res++;
        for (int j = 2; j * i < n; j++) {
          isPrime[i * j] = true;
        }
      }
    }
    return res;
  }

  //// ---------------- end (Approach2)-------------------------------------
  ////////////////// second round(20200806)///////////////////////////////////
  ////////////////// second round(20200806)///////////////////////////////////
  //// ----------------start(Approach3)-------------------------------------
  // 20200806
  //refer to labuladong<如何高效寻找素数>

//   20/20 cases passed (13 ms)
// Your runtime beats 86.03 % of java submissions
// Your memory usage beats 13.17 % of java submissions (38.2 MB)

  // public int countPrimes3(int n) {
  public int countPrimes(int n) {
    boolean[] isPrime = new boolean[n];
    Arrays.fill(isPrime, true);

    // for (int i = 2; i < Math.sqrt(n); i++) {
    for (int i = 2; i * i < n; i++) {
      if (isPrime[i]) {
        for (int j = i * i; j < n; j += i) {
          isPrime[j] = false;
        }
      }
    }

    int res = 0;
    for (int i = 2; i < n; i++) {
      if (isPrime[i])
        res++;
    }
    return res;
  }
  //// ---------------- end (Approach3)-------------------------------------
}
// @lc code=end
