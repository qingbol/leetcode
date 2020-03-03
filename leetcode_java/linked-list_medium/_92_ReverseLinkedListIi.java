/*
 * @lc app=leetcode id=92 lang=java
 *
 * [92] Reverse Linked List II
 */

// @lc code=start
/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode(int x) { val = x; } }
 */
class Solution {
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

  // iterative
  public ListNode reverseBetween(ListNode head, int m, int n) {
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
}
// @lc code=end
