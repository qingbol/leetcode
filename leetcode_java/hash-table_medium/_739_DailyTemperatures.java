/*
 * @lc app=leetcode id=739 lang=java
 *
 * [739] Daily Temperatures
 */

// @lc code=start
class Solution {
  ////////////////// first round(20200729)///////////////////////////////////
  ////////////////// first round(20200729)///////////////////////////////////
  //// ----------------start(Approach1)-------------------------------------
  ////20200729.
// [73,74,75,71,69,72,76,73]
// Output (0 ms)
// [1,1,3,2,1,1,0,0]
// Expected Answer
// [1,1,4,2,1,1,0,0]

  // public int[] dailyTemperatures(int[] T) {
  public int[] dailyTemperatures1(int[] T) {
    int[] res = new int[T.length];
    Deque<Integer> stack = new ArrayDeque<>();
    Map<Integer, Integer> map = new HashMap<>();
    // for (int i = 0; i < T.length; i++) {
    //   map.put(T[i], i);
    // }

    for (int i = T.length - 1; i >=0; i--) {
      int days = 1;
      while (!stack.isEmpty() && T[i] >= stack.peek()) {
        stack.pop();
        days++;
      }
      res[i] = stack.isEmpty() ? 0 : days;
      // res[i] = stack.isEmpty() ? 0 : map.get(stack.peek()) - i;
      stack.push(T[i]);
    }

    return res;
  }
  //// ---------------- end (Approach1)-------------------------------------
  //// ----------------start(Approach1)-------------------------------------
  ////20200729.
  //refer to labuladong <特殊数据结构：单调栈>

//   37/37 cases passed (18 ms)
// Your runtime beats 55.98 % of java submissions
// Your memory usage beats 5.04 % of java submissions (72.6 MB)

  public int[] dailyTemperatures(int[] T) {
  // public int[] dailyTemperatures2(int[] T) {
    Deque<Integer> stack = new ArrayDeque<>();
    int[] res = new int[T.length];

    for (int i = T.length - 1; i >= 0; i--) {
      while (!stack.isEmpty() && T[i] >= T[stack.peek()]) {
        stack.pop();
      }

      res[i] = stack.isEmpty() ? 0 : stack.peek() - i;
      stack.push(i);
    }
    return res;
  }
  //// ---------------- end (Approach1)-------------------------------------
}
// @lc code=end

