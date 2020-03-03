/*
 * @lc app=leetcode id=134 lang=java
 *
 * [134] Gas Station
 */

// @lc code=start
class Solution {
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

  //
  public int canCompleteCircuit(int[] gas, int[] cost) {
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
}
// @lc code=end
