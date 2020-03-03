/*
 * @lc app=leetcode id=225 lang=java
 *
 * [225] Implement Stack using Queues
 */

// @lc code=start
class MyStack {
  Deque<Integer> que;
  Deque<Integer> queHelper;

  /** Initialize your data structure here. */
  public MyStack() {
    que = new ArrayDeque<>();
    queHelper = new ArrayDeque<>();
  }

  /** Push element x onto stack. */
  public void push(int x) {
    que.offer(x);
    // System.out.format("after push: %s\n", que);
  }

  /** Removes the element on top of the stack and returns that element. */
  public int pop() {
    int res = 0;
    int len = 0;
    if (!que.isEmpty()) {
      len = que.size();
      for (int i = 0; i < len - 1; i++) {
        queHelper.offer(que.poll());
      }
      res = que.poll();
    } else if (!queHelper.isEmpty()) {
      len = queHelper.size();
      for (int i = 0; i < len - 1; i++) {
        que.offer(queHelper.poll());
      }
      res = queHelper.poll();

    }
    // System.out.format("after pop: %s\n", que);
    return res;

  }

  /** Get the top element. */
  public int top() {
    int tmp = 0;
    if (!que.isEmpty()) {
      while (!que.isEmpty()) {
        tmp = que.poll();
        queHelper.offer(tmp);
      }
    } else if (!queHelper.isEmpty()) {
      while (!queHelper.isEmpty()) {
        tmp = queHelper.poll();
        que.offer(tmp);
      }
    }
    // System.out.format("after top: %s\n", que);
    return tmp;

  }

  /** Returns whether the stack is empty. */
  public boolean empty() {
    return que.isEmpty() && queHelper.isEmpty();
  }
}

/**
 * Your MyStack object will be instantiated and called as such: MyStack obj =
 * new MyStack(); obj.push(x); int param_2 = obj.pop(); int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */
// @lc code=end
