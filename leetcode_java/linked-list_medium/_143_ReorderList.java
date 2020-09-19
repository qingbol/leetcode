/*
 * @lc app=leetcode id=143 lang=java
 *
 * [143] Reorder List
 */

// @lc code=start
/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode next; ListNode(int
 * x) { val = x; } }
 */
class Solution {
  /////////////////////////// first round(20200126)///////////////////////
  /////////////////////////// first round(20200126)///////////////////////
  //// ----------------start(Appraoch1)----------------------------------
  // 20200126
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

  //// -------------------- end (Approach1)------------------------------
  //// --------------------start(Approach2)------------------------------
  // iteration method

  // public void reorderList(ListNode head) {
  public void reorderList2(ListNode head) {
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
  //// -------------------- end (Approach2)------------------------------
  /////////////////////////// second round(20200920)///////////////////////
  /////////////////////////// second round(20200920)///////////////////////
  //// ----------------start(Appraoch3)----------------------------------
  // 20200920.
  // Or refer to leetcode: Approach 1: Reverse the Second Part of the List and Merge Two Sorted
  //// Lists
  // detail is important: how to define the median of even number?

  // 13/13 cases passed (1 ms)
  // Your runtime beats 99.94 % of java submissions
  // Your memory usage beats 34.28 % of java submissions (42.9 MB)

  public void reorderList(ListNode head) {
    // public void reorderList3(ListNode head) {
    if (head == null || head.next == null)
      return;
    // 1. find the median
    ListNode slow = head, fast = head;
    while (fast != null && fast.next != null) {
      slow = slow.next;
      fast = fast.next.next;
    }
    // 2. rever the second half.
    ListNode pre = null;
    ListNode cur = slow;
    ListNode nxt = null;
    // While (cur != null) {
    while (cur != null) {
      nxt = cur.next;
      cur.next = pre;
      pre = cur;
      cur = nxt;
    }
    // 3. link them
    // ListNode dummy = new ListNode();
    // dummy.next = head;
    ListNode first = head, second = pre;
    while (second.next != null) {
      nxt = first.next;
      first.next = second;
      first = nxt;

      nxt = second.next;
      second.next = first;
      second = nxt;
    }
  }

  //// ---------------- end (Appraoch3)----------------------------------
}
// @lc code=end
