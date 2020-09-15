/*
 * @lc app=leetcode id=134 lang=java
 *
 * [134] Gas Station
 */

// @lc code=start
class Solution {
  ////////////////// first round(20200116)///////////////////////////////////
  ////////////////// first round(20200116)///////////////////////////////////
  //// ----------------start(Approach1)-------------------------------------
  // 20200116

  public int canCompleteCircuit1(int[] gas, int[] cost) {
    int sum = 0;
    int res = -1;
    for (int i = 0; i < gas.length; i++) {
      if (gas[i] >= cost[i]) {
        sum = gas[i] - cost[i];
        // System.out.format("i: %d, sum: %d\n", i, sum);
        int j = i;
        // int j = (i + 1) % gas.length;
        do {
          j = (j + 1) % gas.length;
          sum += gas[j] - cost[j];
          // System.out.format("gas[j]: %d, cost[j]: %d, sum: %d\n", gas[j], cost[j],
          // sum);
        } while (j != i && sum >= 0);
        // while (j != i && sum >= 0) {
        // sum += gas[j] - cost[j];
        // j = (j + 1) % gas.length;
        // }
        if (j == i) {
          res = i;
        }
      }
    }
    return res;
  }

  //// ---------------- end (Approach1)-------------------------------------
  //// ----------------start(Approach2)-------------------------------------
  //
  // public int canCompleteCircuit(int[] gas, int[] cost) {
  public int canCompleteCircuit2(int[] gas, int[] cost) {
    int total_tank = 0;
    int cur_tank = 0;
    int start = 0;
    for (int i = 0; i < gas.length; i++) {
      total_tank += gas[i] - cost[i];
      cur_tank += gas[i] - cost[i];

      if (cur_tank < 0) {
        start = i + 1;
        cur_tank = 0;
      }
    }
    return total_tank >= 0 ? start : -1;
  }
  //// ---------------- end (Approach2)-------------------------------------
  ////////////////// second round(20200913)///////////////////////////////////
  ////////////////// second round(20200913)///////////////////////////////////
  //// ----------------start(Approach3)-------------------------------------
  // 20200913, cant solve it in O(1) by myself
  // refer to leetcode: Approach 1: One pass.

  // 31/31 cases passed (0 ms)
  // Your runtime beats 100 % of java submissions
  // Your memory usage beats 58.3 % of java submissions (39.9 MB)

  public int canCompleteCircuit(int[] gas, int[] cost) {
    // public int canCompleteCircuit3(int[] gas, int[] cost) {
    int n = gas.length;

    // 1. 1st pass to check if that station exist
    int totalGas = 0;
    for (int i = 0; i < n; i++) {
      totalGas += gas[i] - cost[i];
    }
    if (totalGas < 0)
      return -1;
    // 2. 2nd pass to find the station
    int curGas = 0;
    int candidate = 0;
    for (int i = 0; i < n; i++) {
      curGas += gas[i] - cost[i];
      if (curGas < 0) {
        candidate = i + 1;
        curGas = 0;
      }
    }
    return candidate;
  }
  //// ---------------- end (Approach2)-------------------------------------
}
// @lc code=end
