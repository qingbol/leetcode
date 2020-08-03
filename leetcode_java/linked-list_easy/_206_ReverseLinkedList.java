/*
 * @lc app=leetcode id=206 lang=java
 *
 * [206] Reverse Linked List
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

  //// ---------------- end (Approach1)-------------------------------------
  //// ----------------start(Approach2)-------------------------------------
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

  //// ---------------- end (Approach2)-------------------------------------
  //// ----------------start(Approach3)-------------------------------------
  // recursion approach
  // public ListNode reverseList(ListNode head) {
  public ListNode reverseList3(ListNode head) {
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
  //// ---------------- end (Approach3)-------------------------------------
  ////////////////// second round(20200730)///////////////////////////////////
  ////////////////// second round(20200730)///////////////////////////////////
  //// ----------------start(Approach4)-------------------------------------
  // 20200730, by myself. iterative version

  // 27/27 cases passed (0 ms)
  // Your runtime beats 100 % of java submissions
  // Your memory usage beats 86.37 % of java submissions (39 MB)

  // public ListNode reverseList(ListNode head) {
  public ListNode reverseList4(ListNode head) {
    ListNode prev = null, nxt = null;
    while (head != null) {
      nxt = head.next;
      head.next = prev;
      prev = head;
      head = nxt;
    }
    return prev;
  }
  //// ---------------- end (Approach4)-------------------------------------
  //// ----------------start(Approach5)-------------------------------------
  // 20200730, recursion version
  // can't come up with myself

  // 27/27 cases passed (0 ms)
  // Your runtime beats 100 % of java submissions
  // Your memory usage beats 5.01 % of java submissions (40.9 MB)

  // public ListNode reverseList(ListNode head) {
  public ListNode reverseList5(ListNode head) {
    return helper5(head, null);
  }

  private ListNode helper5(ListNode head, ListNode prev) {
    if (head == null) {
      return prev;
    }

    ListNode nxt = head.next;
    head.next = prev;
    return helper5(nxt, head);
  }
  //// ---------------- end (Approach5)-------------------------------------
  //// ----------------start(Approach6)-------------------------------------
  // 20200730, recursion version
  // can't come up with myself
  // refer to labuladong<递归反转链表的一部分>

  // 27/27 cases passed (1 ms)
  // Your runtime beats 9.43 % of java submissions
  // Your memory usage beats 5.01 % of java submissions (40.4 MB)

  public ListNode reverseList(ListNode head) {
    // public ListNode reverseList6(ListNode head) {
    if (head == null)
      return head;

    if (head.next == null)
      return head;
    ListNode last = reverseList(head.next);
    head.next.next = head;
    head.next = null;
    return last;
  }
  //// ---------------- end (Approach6)-------------------------------------
}
// @lc code=end
