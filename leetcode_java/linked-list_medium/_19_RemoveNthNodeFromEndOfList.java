/*
 * @lc app=leetcode id=19 lang=java
 *
 * [19] Remove Nth Node From End of List
 */

// @lc code=start
/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode(int x) { val = x; } }
 */
class Solution {
  /////////////////////////// first round(20200125)///////////////////////
  /////////////////////////// first round(20200125)///////////////////////
  //// ----------------start(Appraoch1)----------------------------------
  // 20200125
  // by myself
  public ListNode removeNthFromEnd1(ListNode head, int n) {
    if (null == head || n == 0) {
      return head;
    }
    ListNode dummy = new ListNode(0);
    dummy.next = head;
    ListNode fast = dummy;
    ListNode slow = dummy;
    // ListNode prev = dummy;
    int k = 0;
    while (fast != null) {
      fast = fast.next;
      k++;
      if (k >= n + 2) {
        slow = slow.next;
        // prev = prev.next;
      }
    }
    slow.next = slow.next.next;
    return dummy.next;
  }

  //// ---------------- end (Appraoch1)----------------------------------
  //// ----------------start(Appraoch2)----------------------------------
  // better

  // public ListNode removeNthFromEnd(ListNode head, int n) {
  public ListNode removeNthFromEnd2(ListNode head, int n) {
    if (null == head) {
      return head;
    }
    ListNode dummy = new ListNode(0);
    dummy.next = head;
    ListNode fast = dummy;
    ListNode slow = dummy;

    for (int i = 0; i < n + 1; i++) {
      fast = fast.next;
    }

    while (null != fast) {
      fast = fast.next;
      slow = slow.next;
    }
    slow.next = slow.next.next;
    return dummy.next;
  }
  //// ---------------- end (Appraoch2)----------------------------------
  /////////////////////////// second round(20200918)///////////////////////
  /////////////////////////// second round(20200918)///////////////////////
  //// ----------------start(Appraoch3)----------------------------------
  // 20200918.

  public ListNode removeNthFromEnd(ListNode head, int n) {
  // public ListNode removeNthFromEnd2(ListNode head, int n) {
    if (head == null) return head;
    ListNode dummy = new ListNode(0);
    dummy.next = head;
    ListNode slow = dummy;
    // ListNode slow = head;
    ListNode fast = dummy;
    // ListNode fast = head;
    //1. move fast to the right postion
    while (n >= 0 && fast != null) {
      fast = fast.next;
      n--;
    }

    //2. move slow to the node preceding target
    while (fast != null) {
      fast = fast.next;
      slow = slow.next;
    }
    slow.next = slow.next.next;
    return dummy.next;
  }
  //// ---------------- end (Appraoch3)----------------------------------
}
// @lc code=end
