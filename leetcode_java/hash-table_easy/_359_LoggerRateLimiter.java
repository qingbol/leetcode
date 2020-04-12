/*
 * @lc app=leetcode id=359 lang=java
 *
 * [359] Logger Rate Limiter
 */

// @lc code=start
class Logger {
  //// ---------------------start(Approach1)----------------------
  // 20200409, by myself.
  // Your runtime beats 98.93 % of java submissions
  Map<String, Integer> map;

  /** Initialize your data structure here. */
  public Logger() {
    map = new HashMap<>();
  }

  /**
   * Returns true if the message should be printed in the given timestamp,
   * otherwise returns false. If this method returns false, the message will not
   * be printed. The timestamp is in seconds granularity.
   */
  public boolean shouldPrintMessage(int timestamp, String message) {
    if (map.containsKey(message) && timestamp - map.get(message) < 10) {
      // map.put(message, timestamp);
      return false;
    }
    map.put(message, timestamp);
    return true;
  }
}
//// --------------------- end (Approach1)----------------------

/**
 * Your Logger object will be instantiated and called as such: Logger obj = new
 * Logger(); boolean param_1 = obj.shouldPrintMessage(timestamp,message);
 */
// @lc code=end
