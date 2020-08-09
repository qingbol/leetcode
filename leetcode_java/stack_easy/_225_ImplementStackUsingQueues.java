/*
 * @lc app=leetcode id=225 lang=java
 *
 * [225] Implement Stack using Queues
 */

// @lc code=start
////////////////// first round(20200211)///////////////////////////////////
////////////////// first round(20200211)///////////////////////////////////
//// ----------------start(Approach1)-------------------------------------
// 20200207, bad practice

class MyStack1 {
  // public class MyStack {
  Deque<Integer> que;
  Deque<Integer> queHelper;

  /** Initialize your data structure here. */
  // public MyStack() {
  public MyStack1() {
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
//// ----------------end (Approach1)-------------------------------------
////////////////// second round(20200802)///////////////////////////////////
////////////////// second round(20200802)///////////////////////////////////
//// ----------------start(Approach2)-------------------------------------
// 20200802
// refer to labuladong <队列实现栈|栈实现队列>

// 16/16 cases passed (0 ms)
// Your runtime beats 100 % of java submissions
// Your memory usage beats 41.97 % of java submissions (37.1 MB)


// class MyStack2 {
public class MyStack {
  Queue<Integer> q;
  int fakeTop;

  /** Initialize your data structure here. */
  public MyStack() {
    // public MyStack2() {
    q = new ArrayDeque<>();
    fakeTop = -1;
  }

  /** Push element x onto stack. */
  public void push(int x) {
    q.offer(x);
    fakeTop = x;
  }

  /** Removes the element on top of the stack and returns that element. */
  public int pop() {
    int sz = q.size();
    while (sz > 2) {
      q.offer(q.poll());
      sz--;
    }
    fakeTop = q.peek();
    q.offer(q.poll());
    return q.poll();
  }

  /** Get the top element. */
  public int top() {
    return fakeTop;
  }

  /** Returns whether the stack is empty. */
  public boolean empty() {
    return q.isEmpty();
  }
}
//// ----------------end (Approach2)-------------------------------------

/**
 * Your MyStack object will be instantiated and called as such: MyStack obj = new MyStack();
 * obj.push(x); int param_2 = obj.pop(); int param_3 = obj.top(); boolean param_4 = obj.empty();
 */
// @lc code=end
