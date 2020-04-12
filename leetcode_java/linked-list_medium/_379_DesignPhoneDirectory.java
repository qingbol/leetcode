/*
 * @lc app=leetcode id=379 lang=java
 *
 * [379] Design Phone Directory
 */

// @lc code=start
class PhoneDirectory {
  //// --------------------start(Approach1)-------------------
  // 20200409, linkedlist
  // Your runtime beats 14.92 % of java submissions
  LinkedList<Integer> lst;

  /**
   * Initialize your data structure here
   * 
   * @param maxNumbers - The maximum numbers that can be stored in the phone
   *                   directory.
   */
  // public PhoneDirectory(int maxNumbers) {
  // lst = new LinkedList<>()
  // for (int i = 0; i < maxNumbers; i++) {
  // lst.add(i);
  // }
  // }

  /**
   * Provide a number which is not assigned to anyone.
   * 
   * @return - Return an available number. Return -1 if none is available.
   */
  public int get1() {
    if (lst.size() == 0) {
      return -1;
    }
    return lst.remove();
  }

  /** Check if a number is available or not. */
  public boolean check1(int number) {
    return lst.contains(number);
  }

  /** Recycle or release a number. */
  public void release1(int number) {
    if (!lst.contains(number)) {
      lst.add(number);
    }
  }

  //// -------------------- end (Approach1)-------------------

  //// --------------------start(Approach2)-------------------
  // 20200409, better approach. queue + hashset
  // only queue: Your runtime beats 11.35 % of java submissions
  // queue + hashset: Your runtime beats 65.41 % of java submissions
  Queue<Integer> queue;
  Set<Integer> set;
  int maxNum;

  public PhoneDirectory(int maxNumbers) {
    queue = new ArrayDeque<>();
    maxNum = maxNumbers;
    set = new HashSet<>();
    for (int i = 0; i < maxNumbers; i++) {
      queue.offer(i);
    }
  }

  public int get() {
    Integer ret = queue.poll();
    if (ret == null) {
      return -1;
    }
    set.add(ret);
    return ret;
  }

  public boolean check(int number) {
    if (number >= maxNum || number < 0 || set.contains(number)) {
      return false;
    }
    return true;
  }

  public void release(int number) {
    if (set.remove(number)) {
      queue.offer(number);
    }
  }
}
//// -------------------- end (Approach2)-------------------
/**
 * Your PhoneDirectory object will be instantiated and called as such:
 * PhoneDirectory obj = new PhoneDirectory(maxNumbers); int param_1 = obj.get();
 * boolean param_2 = obj.check(number); obj.release(number);
 */
// @lc code=end
