/*
 * @lc app=leetcode id=206 lang=java
 *
 * [206] Reverse Linked List
 */

// @lc code=start
/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode(int x) { val = x; } }
 */
class Solution {
  // bad practice
  public ListNode reverseList1(ListNode head) {
    if (null == head || null == head.next) {
      return head;
    }
    ListNode dummy = new ListNode(0);
    dummy.next = head;
    ListNode p = dummy;
    ListNode n = head.next;
    while (n != null) {
      // System.out.format("h:%d\n", head.val);
      n = head.next;
      head.next = p;
      p = head;
      head = n;
      // n = n.next;
    }
    dummy.next.next = null;
    dummy = null;
    return p;
  }

  // good practice
  public ListNode reverseList2(ListNode head) {
    if (null == head || null == head.next) {
      return head;
    }
    ListNode dummy = null;
    while (head != null) {
      ListNode next = head.next;
      head.next = dummy;
      dummy = head;
      head = next;
    }
    return dummy;
  }

  // recursion approach
  public ListNode reverseList(ListNode head) {
    return reverse(head, null);
  }

  public ListNode reverse(ListNode head, ListNode newHead) {
    if (head == null) {
      return newHead;
    }
    ListNode next = head.next;
    head.next = newHead;
    return reverse(next, head);
  }
}
// @lc code=end
