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

  // better
  public ListNode removeNthFromEnd(ListNode head, int n) {
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
}
// @lc code=end
