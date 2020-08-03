/*
 * @lc app=leetcode id=92 lang=java
 *
 * [92] Reverse Linked List II
 */

// @lc code=start
/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode next; ListNode(int
 * x) { val = x; } }
 */
class Solution {
  ////////////////// first round(20200123)///////////////////////////////////
  ////////////////// first round(20200123)///////////////////////////////////
  //// ----------------start(Approach1)-------------------------------------
  // 20200123
  public ListNode reverseBetween1(ListNode head, int m, int n) {
    if (null == head || null == head.next || m == n) {
      return head;
    }
    ListNode dummy = new ListNode(-1);
    dummy.next = head;
    ListNode start = dummy;
    ListNode end = head;
    for (int i = 0; i < m - 1; i++) {
      start = start.next;
    }
    ListNode p = start.next;
    for (int i = 1; i < n; i++) {
      end = end.next;
    }
    // System.out.format("start: %d, end: %d\n", start.val, end.val);
    ListNode prev = end.next;
    // printList(head);

    while (p != end) {
      ListNode next = p.next;
      p.next = prev;
      prev = p;
      p = next;
      // printList(head);
    }
    p.next = prev;
    start.next = p;
    // printList(dummy.next);
    return dummy.next;
  }

  private void printList(ListNode head) {
    while (head != null) {
      System.out.format("-> %d", head.val);
      head = head.next;
    }
    System.out.println();
  }

  //// ---------------- end (Approach1)-------------------------------------
  //// ----------------start(Approach2)-------------------------------------
  // iterative
  // public ListNode reverseBetween(ListNode head, int m, int n) {
  public ListNode reverseBetween2(ListNode head, int m, int n) {
    if (null == head || null == head.next) {
      return head;
    }
    ListNode pre = null;
    ListNode cur = head;

    // move the two pointers untill they reach the proper starting point
    while (m > 1) {
      pre = cur;
      cur = cur.next;
      m--;
      n--;
    }

    // the two pointers that will fix the final connections
    ListNode con = pre;
    ListNode tail = cur;

    // iterativelly reverse the nodes untill n becom 0
    ListNode next = null;
    while (n > 0) {
      next = cur.next;
      cur.next = pre;
      pre = cur;
      cur = next;
      n--;
    }

    if (con == null) {
      head = pre;
    } else {
      con.next = pre;
    }
    tail.next = cur;
    return head;
  }

  //// ---------------- end (Approach2)-------------------------------------
  ////////////////// second round(20200730)///////////////////////////////////
  ////////////////// second round(20200730)///////////////////////////////////
  //// ----------------start(Approach3)-------------------------------------
  // 20200730, by myself.
  // refer to labuladong <递归反转链表的一部分>

  // 44/44 cases passed (0 ms)
  // Your runtime beats 100 % of java submissions
  // Your memory usage beats 59.6 % of java submissions (37 MB)

  ListNode successor3 = null;

  public ListNode reverseBetween3(ListNode head, int m, int n) {
    // public ListNode reverseBetween(ListNode head, int m, int n) {
    if (m == 1) {
      return helper3(head, n);
    }
    ListNode cur = head;
    for (int i = 0; i < m - 2; i++) {
      cur = cur.next;
    }
    if (cur.next != null)
      cur.next = helper3(cur.next, n - m + 1);
    return head;
  }

  private ListNode helper3(ListNode node, int n) {
    if (n == 1) {
      successor3 = node.next;
      return node;
    }
    ListNode last = helper3(node.next, n - 1);
    node.next.next = node;
    node.next = successor3;
    return last;
  }
  //// ---------------- end (Approach3)-------------------------------------
  //// ----------------start(Approach3)-------------------------------------
  // 20200730,
  // refer to labuladong <递归反转链表的一部分>

//   44/44 cases passed (0 ms)
// Your runtime beats 100 % of java submissions
// Your memory usage beats 5.2 % of java submissions (39.1 MB)

  ListNode successor4 = null;

  // public ListNode reverseBetween4(ListNode head, int m, int n) {
  public ListNode reverseBetween(ListNode head, int m, int n) {
    if (m == 1)
      return helper4(head, n);
    head.next = reverseBetween(head.next, m - 1, n - 1);
    return head;
  }

  private ListNode helper4(ListNode node, int n) {
    if (n == 1) {
      successor4 = node.next;
      return node;
    }
    ListNode last = helper4(node.next, n - 1);
    node.next.next = node;
    node.next = successor4;
    return last;
  }
  //// ---------------- end (Approach4)-------------------------------------
}
// @lc code=end
