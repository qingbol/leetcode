import java.util.Iterator;

/*
 * @lc app=leetcode id=281 lang=java
 *
 * [281] Zigzag Iterator
 */

// @lc code=start
////------------------start(Appraoch1)-----------------------
//20200411, by myself. flag
//Your runtime beats 100 % of java submissions
// public class ZigzagIterator {
class ZigzagIterator1 {
  boolean isSecond;
  Iterator<Integer> it1;
  Iterator<Integer> it2;

  // public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
  public ZigzagIterator1(List<Integer> v1, List<Integer> v2) {
    it1 = v1.iterator();
    it2 = v2.iterator();
    isSecond = false;
    // System.out.format("check point 01\n");
  }

  public int next() {
    // System.out.format("check point 02\n");
    if (isSecond) {
      isSecond = false;
      return it2.next();
    }
    isSecond = true;
    return it1.next();
  }

  public boolean hasNext() {
    // System.out.format("check point 03\n");
    boolean ret1 = it1.hasNext();
    boolean ret2 = it2.hasNext();
    if (!ret1) {
      isSecond = true;
    }
    if (!ret2) {
      isSecond = false;
    }
    return ret1 || ret2;
  }
}

//// ------------------ end (Appraoch1)-----------------------
//// ------------------start(Appraoch2)-----------------------
// 20200411, by myself. Queue.
// Your runtime beats 58.52 % of java submissions
public class ZigzagIterator {
  // class ZigzagIterator2 {
  Queue<Iterator<Integer>> queue;

  // public ZigzagIterator2(List<Integer> v1, List<Integer> v2) {
  public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
    queue = new ArrayDeque<>();
    if (!v1.isEmpty()) {
      queue.offer(v1.iterator());
    }
    if (!v2.isEmpty()) {
      queue.offer(v2.iterator());
    }
    // Iterator<Integer> it1 = v1.iterator();
    // Iterator<Integer> it2 = v2.iterator();
    // if (it1.hasNext()) {
    // queue.offer(it1);
    // }
    // if (it2.hasNext()) {
    // queue.offer(it2);
    // }
  }

  public int next() {
    Iterator<Integer> curr = queue.poll();
    int ret = curr.next();
    if (curr.hasNext()) {
      queue.offer(curr);
    }
    return ret;
  }

  public boolean hasNext() {
    return !queue.isEmpty();
  }
}
//// ------------------ end (Appraoch2)-----------------------

/**
 * Your ZigzagIterator object will be instantiated and called as such:
 * ZigzagIterator i = new ZigzagIterator(v1, v2); while (i.hasNext()) v[f()] =
 * i.next();
 */
// @lc code=end
