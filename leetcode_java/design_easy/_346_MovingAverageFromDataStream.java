/*
 * @lc app=leetcode id=346 lang=java
 *
 * [346] Moving Average from Data Stream
 */

// @lc code=start
////--------------------start(Approach1)-----------------------------
// queue. by myselft.
//Your runtime beats 93.01 % of java submissions
class MovingAverage {
  private Queue<Integer> queue;

  private static double sum;
  private static int size;

  /** Initialize your data structure here. */
  public MovingAverage(int size) {
    queue = new ArrayDeque<>(size);
    this.size = size;
    sum = 0.0;
  }

  public double next(int val) {
    double ave = 0.0;
    sum += val;
    queue.offer(val);
    if (queue.size() > size) {
      sum -= queue.poll();
      ave = sum / size;
    } else {
      ave = sum / queue.size();
    }
    return ave;
  }
}

//// -------------------- end (Approach1)-----------------------------
//// --------------------start(Approach1)-----------------------------
// Your runtime beats 93.01 % of java submissions
class MovingAverage2 {
}
//// -------------------- end (Approach2)-----------------------------

/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size); double param_1 = obj.next(val);
 */
// @lc code=end
