/*
 * @lc app=leetcode id=295 lang=java
 *
 * [295] Find Median from Data Stream
 */

// @lc code=start
  ////////////////// first round(20200226)///////////////////////////////////
  ////////////////// first round(20200226)///////////////////////////////////
  //// ----------------start(Approach1)-------------------------------------
//20200226, by myself. brute force^
//Your runtime beats 7.38 % of java submissions
class MedianFinder1 {
  // public class MedianFinder {
  List<Integer> data;
  // PriorityQueue<Integer> pq;

  /** initialize your data structure here. */
  // public MedianFinder() {
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
// 20200226, optimal
// Your runtime beats 49.14 % of java submissions
// class MedianFinder2 {
public class MedianFinder {
  PriorityQueue<Integer> minHeap;
  PriorityQueue<Integer> maxHeap;

  // public MedianFinder2() {
  public MedianFinder() {
    minHeap = new PriorityQueue<>();
    maxHeap = new PriorityQueue<>(Collections.reverseOrder());
  }

  public void addNum(int num) {
    minHeap.offer(num);
    maxHeap.offer(minHeap.poll());
    if (maxHeap.size() > minHeap.size()) {
      minHeap.offer(maxHeap.poll());
    }
    // System.out.format("minHeap:%s\n", minHeap);
    // System.out.format("maxHeap:%s\n", maxHeap);
  }

  public double findMedian() {
    // return 0;
    return minHeap.size() > maxHeap.size() ? minHeap.peek() : (minHeap.peek() + maxHeap.peek()) * 0.5;
  }
}

//// ------------- end (approach2)------------------------------
  ////////////////// second round(20201112)///////////////////////////////////
  ////////////////// second round(20201112)///////////////////////////////////
//// -------------start(approach3)------------------------------
// 20201112, try to solve it again
// public class MedianFinder {
class MedianFinder3 {

  // public MedianFinder() {
  public MedianFinder3() {
  }

  public void addNum(int num) {
  }

  public double findMedian() {
    return 0.0;
  }
}
//// ------------- end (approach3)------------------------------
// Approach 4: Multiset and Two Pointers
// need to be done

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder(); obj.addNum(num); double param_2 =
 * obj.findMedian();
 */
// @lc code=end
