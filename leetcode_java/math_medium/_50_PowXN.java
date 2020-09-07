/*
 * @lc app=leetcode id=50 lang=java
 *
 * [50] Pow(x, n)
 */

// @lc code=start
class Solution {
  ////////////////// first round(20200106)///////////////////////////////////
  ////////////////// first round(20200106)///////////////////////////////////
  //// ----------------start(Approach1)-------------------------
  // 20200106

  public double myPow1(double x, int n) {
    int dim = Math.abs(n);
    double[] resArr = new double[dim];
    Map<Integer, Double> map = new HashMap<Integer, Double>();
    double res = myPowHelper1(x, n, map);
    // double res = myPowHelper1(x, n, resArr);
    return res;
  }

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
        myMap.put(nAbs,
            myPowHelper1(x, (n - 1) / 2, myMap) * myPowHelper1(x, (n - 1) / 2, myMap) * x);
      } else if (0 == n % 2) {
        myMap.put(nAbs, myPowHelper1(x, n / 2, myMap) * myPowHelper1(x, n / 2, myMap));
      } else if (-1 == n % 2) {
        myMap.put(nAbs,
            myPowHelper1(x, (n + 1) / 2, myMap) * myPowHelper1(x, (n + 1) / 2, myMap) * 1 / x);
      }
    }
    return myMap.get(nAbs);
  }

  //// ---------------- end (Approach1)-------------------------
  //// ----------------start(Approach2)-------------------------
  // optimal solution
  // public double myPow(double x, int n) {
  public double myPow2(double x, int n) {
    if (n >= 0) {
      return myPowHelper2(x, n);
    } else {
      return 1.0 / myPowHelper2(x, n);
    }
  }

  private double myPowHelper2(double x, int n) {
    if (0 == n) {
      return 1;
    }

    double y = myPowHelper2(x, n / 2);
    if (0 == n % 2) {
      return y * y;
    } else {
      return y * y * x;
    }
  }
  //// ---------------- end (Approach2)-------------------------
  ////////////////// second round(20200906)///////////////////////////////////
  ////////////////// second round(20200906)///////////////////////////////////
  //// ----------------start(Approach1)-------------------------
  // 20200906. recuisive fast power algorightm
  // refer to leetcode standard solution

  public double myPow(double x, int n) {
    // public double myPow3(double x, int n) {
    if (n < 0) {
      x = 1 / x;
      n = -n;
    }
    return helper3(x, n);
  }

  private double helper3(double x, int n) {
    if (n == 0)
      return 1;
    double half = helper3(x, n / 2);
    if (n % 2 == 0) {
      return half * half;
    } else {
      return half * half * x;
    }
  }
  //// ---------------- end (Approach3)-------------------------
}
// @lc code=end
