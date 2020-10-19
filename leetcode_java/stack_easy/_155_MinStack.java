/*
 * @lc app=leetcode id=155 lang=java
 *
 * [155] Min Stack
 */

// @lc code=start
  /////////////////////////// first round(20200205)///////////////////////
  /////////////////////////// first round(20200205)///////////////////////
  //// ----------------start(Appraoch1)----------------------------------
  // 20200205
class MinStack {
  /** initialize your data structure here. */
  private Deque<Integer> stack;
  private Deque<Integer> stackMin;

  public MinStack() {
    stack = new ArrayDeque();
    stackMin = new ArrayDeque();
  }

  public void push(int x) {
    stack.push(x);
    if (stackMin.isEmpty() || x <= stackMin.peek()) {
      stackMin.push(x);
    }
    // System.out.println(stackMin);
  }

  public void pop() {
    // System.out.format("stack: %d, stackMin: %d\n", stack.pop(), stackMin.pop());
    // int x = stack.pop();
    // if (x == stackMin.peek()) {
    Integer x = stack.pop();
    if (x.equals(stackMin.peek())) {
      stackMin.pop();
    }
    System.out.println(stackMin);
  }

  public int top() {
    return stack.peek();
  }

  public int getMin() {
    return stackMin.peek();
  }
}

  //// ---------------- end (Appraoch1)----------------------------------
  /////////////////////////// second round(20200919)///////////////////////
  /////////////////////////// second round(20200919)///////////////////////
  //// ----------------start(Appraoch2)----------------------------------
  // 20200919. can't figure it out by myself
  //just like approach1.
  //// ---------------- end (Appraoch2)----------------------------------
/**
 * Your MinStack object will be instantiated and called as such: MinStack obj =
 * new MinStack(); obj.push(x); obj.pop(); int param_3 = obj.top(); int param_4
 * = obj.getMin();
 */
// @lc code=end
