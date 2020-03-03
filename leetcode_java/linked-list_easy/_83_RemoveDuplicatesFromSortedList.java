/*
 * @lc app=leetcode id=83 lang=java
 *
 * [83] Remove Duplicates from Sorted List
 */

// @lc code=start
/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode(int x) { val = x; } }
 */
class Solution {
  public ListNode deleteDuplicates1(ListNode head) {
    if (null == head || null == head.next) {
      return head;
    }
    ListNode p = head;
    ListNode q = head.next;
    while (p != null && p.next != null) {
      if (p.val == q.val) {
        p.next = q.next;
      } else {
        p = p.next;
      }
      q = q.next;
    }
    return head;
  }

  //
  public ListNode deleteDuplicates(ListNode head) {
    if (null == head || null == head.next) {
      return head;
    }
    ListNode cur = head;
    while (cur != null && cur.next != null) {
      if (cur.val == cur.next.val) {
        cur.next = cur.next.next;
      } else {
        cur = cur.next;
      }
    }
    return head;
  }
}
// @lc code=end
