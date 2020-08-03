import java.util.Deque;

/*
 * @lc app=leetcode id=232 lang=java
 *
 * [232] Implement Queue using Stacks
 */

// @lc code=start
// by myself. worse approach.
////////////////// first round(20200207)///////////////////////////////////
////////////////// first round(20200207)///////////////////////////////////
//// ----------------start(Approach1)-------------------------------------
// 20200207
// public class MyQueue {
class MyQueue1 {
  Deque<Integer> stack;
  Deque<Integer> revStack;
  int size;

  /** Initialize your data structure here. */
  // public MyQueue() {
  public MyQueue1() {
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


//// ---------------- end (Approach1)-------------------------------------
////////////////// second round(20200802)///////////////////////////////////
////////////////// second round(20200802)///////////////////////////////////
//// ----------------start(Approach2)-------------------------------------
public class MyQueue {
  // class MyQueue2 {
  Deque<Integer> offerStack;
  Deque<Integer> pollStack;

  /** Initialize your data structure here. */
  public MyQueue() {
    // public MyQueue2() {
    offerStack = new ArrayDeque<>();
    pollStack = new ArrayDeque<>();
  }

  /** Push element x to the back of queue. */
  public void push(int x) {
    offerStack.push(x);
  }

  /** Removes the element from in front of queue and returns that element. */
  public int pop() {
    if (pollStack.isEmpty()) {
      while (!offerStack.isEmpty())
        pollStack.push(offerStack.pop());
    }
    return pollStack.pop();
  }

  /** Get the front element. */
  public int peek() {
    if (pollStack.isEmpty()) {
      while (!offerStack.isEmpty())
        pollStack.push(offerStack.pop());
    }
    return pollStack.peek();
  }

  /** Returns whether the queue is empty. */
  public boolean empty() {
    return offerStack.isEmpty() & pollStack.isEmpty();
  }
}


//// ---------------- end (Approach2)-------------------------------------
//// ----------------start(Approach3)-------------------------------------
// public class MyQueue {
class MyQueue3 {

  /** Initialize your data structure here. */
  // public MyQueue() {
  public MyQueue3() {

  }

  /** Push element x to the back of queue. */
  public void push(int x) {

  }

  /** Removes the element from in front of queue and returns that element. */
  public int pop() {
    return -1;
  }

  /** Get the front element. */
  public int peek() {
    return -1;
  }

  /** Returns whether the queue is empty. */
  public boolean empty() {
    return false;
  }
}
//// ---------------- end (Approach3)-------------------------------------
// /**
// * Your MyQueue object will be instantiated and called as such: MyQueue obj =
// * new MyQueue(); obj.push(x); int param_2 = obj.pop(); int param_3 =
// * obj.peek(); boolean param_4 = obj.empty();
// */
// @lc code=end
