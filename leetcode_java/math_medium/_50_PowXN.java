/*
 * @lc app=leetcode id=50 lang=java
 *
 * [50] Pow(x, n)
 */

// @lc code=start
class Solution {
  // public double myPow1(double x, int n) {
  // int dim = Math.abs(n);
  // double[] resArr = new double[dim];
  // Map<Integer, Double> map = new HashMap<Integer, Double>();
  // double res = myPowHelper(x, n, map);
  // double res = myPowHelper(x, n, resArr);
  // return res;
  // }

  private double myPowHelper1(double x, int n, Map<Integer, Double> myMap) {
    if (0 == x) {
      return 0;
    }
    if (0 == n) {
      return 1;
    }
    if (1 == n) {
      return x;
    }
    if (-1 == n) {
      return 1 / x;
    }
    int nAbs = Math.abs(n);
    if (!myMap.containsKey(nAbs)) {
      if (1 == n % 2) {
        myMap.put(nAbs, myPowHelper1(x, (n - 1) / 2, myMap) * myPowHelper1(x, (n - 1) / 2, myMap) * x);
      } else if (0 == n % 2) {
        myMap.put(nAbs, myPowHelper1(x, n / 2, myMap) * myPowHelper1(x, n / 2, myMap));
      } else if (-1 == n % 2) {
        myMap.put(nAbs, myPowHelper1(x, (n + 1) / 2, myMap) * myPowHelper1(x, (n + 1) / 2, myMap) * 1 / x);
      }
    }
    return myMap.get(nAbs);
  }

  // optimal solution
  public double myPow(double x, int n) {
    if (n >= 0) {
      return myPowHelper(x, n);
    } else {
      return 1.0 / myPowHelper(x, n);
    }
  }

  private double myPowHelper(double x, int n) {
    if (0 == n) {
      return 1;
    }

    double y = myPowHelper(x, n / 2);
    if (0 == n % 2) {
      return y * y;
    } else {
      return y * y * x;
    }
  }
}
// @lc code=end
