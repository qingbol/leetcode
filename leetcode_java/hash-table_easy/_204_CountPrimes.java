import java.beans.FeatureDescriptor;

/*
 * @lc app=leetcode id=204 lang=java
 *
 * [204] Count Primes
 */

// @lc code=start
class Solution {
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
  public int countPrimes(int n) {
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
}
// @lc code=end
