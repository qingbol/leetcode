/*
 * @lc app=leetcode id=138 lang=java
 *
 * [138] Copy List with Random Pointer
 */

// @lc code=start
// /*
// // Definition for a Node.
// class Node {
// int val;
// Node next;
// Node random;

// public Node(int val) {
// this.val = val;
// this.next = null;
// this.random = null;
// }
// }
// */

class Solution {
  //////////////////////// second round(20200919)////////////////////////
  //////////////////////// second round(20200919)////////////////////////
  ///// -------------------start(Approach2)-----------------------------
  // 20200919, cant figure it out
  // refer to leetcode: Approach 1: Recursive

  // Memory Limit Exceeded
  // Your Input
  // [[7,null],[13,0],[11,4],[10,2],[1,0]]

  // public Node copyRandomList(Node head) {
  public Node copyRandomList2(Node head) {
    Map<Node, Node> map = new HashMap<>();
    return helper2(head, map);
  }

  private Node helper2(Node head, Map<Node, Node> map) {
    if (head == null)
      return null;
    if (map.containsKey(head))
      return map.get(head);
    Node newHead = new Node(head.val);
    newHead.next = helper2(head.next, map);
    newHead.random = helper2(head.random, map);
    return newHead;
  }
  ///// ------------------- end (Approach2)-----------------------------
  ///// -------------------start(Approach3)-----------------------------
  // refer to leetcode: Approach 3: Iterative with O(1)O(1) Space

  // 18/18 cases passed (0 ms)
  // Your runtime beats 100 % of java submissions
  // Your memory usage beats 31.96 % of java submissions (39.6 MB)

  public Node copyRandomList(Node head) {
    // public Node copyRandomList3(Node head) {
    if (head == null)
      return null;
    Node newHead = null;
    Node ptr = head;
    // 1. clone the node according to next. And link it to the next
    while (ptr != null) {
      Node newNode = new Node(ptr.val);
      // if (newHead == null)
      // newHead = newNode;
      newNode.next = ptr.next;
      ptr.next = newNode;
      ptr = newNode.next;
    }
    // 2. link the random
    newHead = head.next;
    Node newPtr = newHead;
    ptr = head;
    while (ptr != null) {
      newPtr.random = ptr.random == null ? null : ptr.random.next;
      ptr = newPtr.next;
      if (ptr != null)
        newPtr = ptr.next;
    }
    // 3. seperate the old and new
    ptr = head;
    newPtr = newHead;
    while (ptr != null) {
      ptr.next = newPtr.next;
      ptr = ptr.next;
      if (ptr != null) {
        newPtr.next = ptr.next;
        newPtr = newPtr.next;
      }
    }
    return newHead;
  }
  ///// ------------------- end (Approach3)-----------------------------
}
// @lc code=end

