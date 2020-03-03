/*
 * @lc app=leetcode id=143 lang=java
 *
 * [143] Reorder List
 */

// @lc code=start
/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode(int x) { val = x; } }
 */
class Solution {
  // recursion method by myself
  ListNode front = null;

  public void reorderList1(ListNode head) {
    if (null == head || head.next == null) {
      return;
    }
    front = head;
    reorderHelper(head);
  }

  private ListNode reorderHelper(ListNode curHead) {
    if (null == curHead.next || curHead == null) {
      return curHead;
    }
    ListNode tailHead = reorderHelper(curHead.next);
    // ListNode frontNext = front.next;
    if (front.next != tailHead && tailHead != null && front != tailHead) {
      // System.out.format("front:%d, tail: %d\n", front.val, tailHead.val);
      tailHead.next = front.next;
      // ListNode tmp = front.next;
      front.next = tailHead;
      front = tailHead.next;
      // printList(curHead);
      return curHead;
    } else if (front.next == tailHead && tailHead != null || front == tailHead) {
      // System.out.print("==");
      // System.out.format("front:%d, tail:%d\n", front.val, tailHead.val);
      tailHead.next = null;
    }
    return null;
  }

  private void printList(ListNode h) {
    while (h != null) {
      System.out.format("->%d", h.val);
      h = h.next;
    }
    System.out.println();
  }

  // iteration method
  public void reorderList(ListNode head) {
    if (null == head || null == head.next) {
      return;
    }
    ListNode median = findMedian(head);
    // printList(median);
    ListNode tail = reverse(median);
    // printList(tail);
    linkThem(head, tail);
    // printList(head);
  }

  private ListNode findMedian(ListNode curHead) {
    ListNode fast = curHead;
    ListNode slow = curHead;
    while (fast.next != null && fast.next.next != null) {
      fast = fast.next.next;
      slow = slow.next;
    }
    fast = slow.next;
    slow.next = null;
    return fast;
  }

  private ListNode reverse(ListNode h) {
    ListNode prev = null;
    ListNode cur = h;
    ListNode next = null;
    while (cur != null) {
      next = cur.next;
      cur.next = prev;
      prev = cur;
      cur = next;
    }
    return prev;
  }

  private void linkThem(ListNode l1, ListNode l2) {
    ListNode p = l1;
    ListNode q = l2;
    ListNode dummy = new ListNode(0);
    ListNode cur = dummy;
    while (p != null && q != null) {
      cur.next = p;
      p = p.next;
      cur = cur.next;
      cur.next = q;
      q = q.next;
      cur = cur.next;
    }
    cur.next = p;
    l1 = dummy.next;
  }
}
// @lc code=end
