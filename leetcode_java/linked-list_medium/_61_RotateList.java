/*
 * @lc app=leetcode id=61 lang=java
 *
 * [61] Rotate List
 */

// @lc code=start
/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode(int x) { val = x; } }
 */
class Solution {
  public ListNode rotateRight1(ListNode head, int k) {
    if (null == head || null == head.next) {
      return head;
    }
    ListNode dummy = new ListNode(-1);
    dummy.next = head;
    ListNode it2 = head;
    int len = 1;
    while (it2.next != null) {
      it2 = it2.next;
      len++;
    }
    System.out.format("len: %d", len);
    for (int i = 0; i < k % len; i++) {
      ListNode it1 = head.next;
      it2 = head;
      // for (int i = 0; i < k; i++) {
      // it1 = it1.next;
      // }
      while (it1.next != null) {
        it1 = it1.next;
        it2 = it2.next;
      }
      dummy.next = it2.next;
      it2.next = it1.next;
      it1.next = head;
      head = dummy.next;
    }
    return dummy.next;
  }

  // better approach
  public ListNode rotateRight(ListNode head, int k) {
    if (null == head || null == head.next) {
      return head;
    }
    ListNode dummy = new ListNode(0);
    dummy.next = head;
    ListNode fast = dummy;
    ListNode slow = dummy;
    int len = 0;
    while (fast.next != null) {
      fast = fast.next;
      len++;
    }
    for (int i = 0; i < len - k % len; i++) {
      slow = slow.next;
    }
    // System.out.format("slow:%d", slow.val);

    // my own sequence is not right
    // if (slow != fast) {
    // dummy.next = slow.next;
    // slow.next = fast.next;
    // fast.next = head;
    // }
    fast.next = dummy.next;
    dummy.next = slow.next;
    slow.next = null;
    return dummy.next;
  }
}
// @lc code=end
