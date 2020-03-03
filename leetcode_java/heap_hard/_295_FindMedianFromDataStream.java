/*
 * @lc app=leetcode id=295 lang=java
 *
 * [295] Find Median from Data Stream
 */

// @lc code=start
//// -------------start(approach1)------------------------------
// brute force
class MedianFinder1 {
  List<Integer> data;
  // PriorityQueue<Integer> pq;

  /** initialize your data structure here. */
  public MedianFinder1() {
    data = new ArrayList<>();
    // pq = new PriorityQueue<>();
  }

  public void addNum(int num) {
    data.add(num);
    // pq.offer(num);
  }

  public double findMedian() {
    double res = 0.0;
    int len = data.size();
    Collections.sort(data);
    if ((len & 1) == 1) {
      res = data.get(len / 2);
    } else {
      res = (data.get(len / 2) + data.get(len / 2 - 1)) * 0.5;
    }
    return res;
  }
}

//// ------------- end (approach1)------------------------------
//// -------------start(approach2)------------------------------
// optimal
public class MedianFinder {
  PriorityQueue<Integer> lo;
  PriorityQueue<Integer> hi;

  public MedianFinder() {
    lo = new PriorityQueue<>();
    hi = new PriorityQueue<>(Collections.reverseOrder());
  }

  public void addNum(int num) {
    lo.offer(num);
    hi.offer(lo.poll());
    if (hi.size() > lo.size()) {
      lo.offer(hi.poll());
    }
  }

  public double findMedian() {
    // return 0;
    return lo.size() > hi.size() ? lo.peek() : (lo.peek() + hi.peek()) * 0.5;
  }
}

//// ------------- end (approach2)------------------------------
//// -------------start(approach3)------------------------------
// Approach 4: Multiset and Two Pointers
// need to be done
//// ------------- end (approach3)------------------------------

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder(); obj.addNum(num); double param_2 =
 * obj.findMedian();
 */
// @lc code=end
