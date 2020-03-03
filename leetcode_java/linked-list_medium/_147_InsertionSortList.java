/*
 * @lc app=leetcode id=147 lang=java
 *
 * [147] Insertion Sort List
 */

// @lc code=start
/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode(int x) { val = x; } }
 */
class Solution {
  public ListNode insertionSortList1(ListNode head) {
    if (null == head || null == head.next) {
      return head;
    }
    ListNode dummy = new ListNode(0);
    dummy.next = head;
    ListNode curr = dummy;
    // startOfUnordered
    ListNode tail = head;
    while (tail.next != null) {
      curr = dummy;
      while (curr.next != tail.next && curr.next.val <= tail.next.val) {
        curr = curr.next;
      }
      if (curr.next == tail.next) {
        tail = tail.next;
        continue;
      }
      ListNode p = curr.next;
      ListNode q = tail.next;
      tail.next = q.next;
      curr.next = q;
      q.next = p;
    }
    return dummy.next;
  }

  // better
  public ListNode insertionSortList(ListNode head) {
    if (head == null) {
      return head;
    }

    ListNode helper = new ListNode(0); // new starter of the sorted list
    ListNode cur = head; // the node will be inserted
    ListNode pre = helper; // insert node between pre and pre.next
    ListNode next = null; // the next node will be inserted
    // not the end of input list
    while (cur != null) {
      next = cur.next;
      // find the right place to insert
      // System.out.format("pre.next: %d, cur: %d\n", pre.next.val, cur.val);
      while (pre.next != null && pre.next.val < cur.val) {
        // printList(helper.next);
        pre = pre.next;
      }
      // insert between pre and pre.next
      cur.next = pre.next;
      // System.out.format("cur: %d, next: %d\n", cur.val, pre.next.val);
      pre.next = cur;
      pre = helper;
      cur = next;
      // printList(helper.next);
    }
    return helper.next;
  }

  private void printList(ListNode h) {
    while (h != null) {
      System.out.format("->%d", h.val);
      h = h.next;
    }
    System.out.println();
  }
}
// @lc code=end
