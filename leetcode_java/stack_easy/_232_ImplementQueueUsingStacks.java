/*
 * @lc app=leetcode id=232 lang=java
 *
 * [232] Implement Queue using Stacks
 */

// @lc code=start
//by myself. worse approach.
class MyQueue {
  Deque<Integer> stack;
  Deque<Integer> revStack;
  int size;

  /** Initialize your data structure here. */
  public MyQueue() {
    stack = new ArrayDeque<>();
    revStack = new ArrayDeque<>();
    size = 0;
  }

  /** Push element x to the back of queue. */
  public void push(int x) {
    while (!revStack.isEmpty()) {
      stack.push(revStack.pop());
    }
    revStack.push(x);
    while (!stack.isEmpty()) {
      revStack.push(stack.pop());
    }
    size++;
  }

  /** Removes the element from in front of queue and returns that element. */
  public int pop() {
    if (!revStack.isEmpty()) {
      size--;
      return revStack.pop();
    }
    return -1;
  }

  /** Get the front element. */
  public int peek() {
    if (!revStack.isEmpty()) {
      return revStack.peek();
    }
    return -1;
  }

  /** Returns whether the queue is empty. */
  public boolean empty() {
    return size == 0 ? true : false;
  }
}

/**
 * Your MyQueue object will be instantiated and called as such: MyQueue obj =
 * new MyQueue(); obj.push(x); int param_2 = obj.pop(); int param_3 =
 * obj.peek(); boolean param_4 = obj.empty();
 */
// @lc code=end
