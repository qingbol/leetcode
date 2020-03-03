/*
 * @lc app=leetcode id=141 lang=java
 *
 * [141] Linked List Cycle
 */

// @lc code=start
/**
 * Definition for singly-linked list. class ListNode { int val; ListNode next;
 * ListNode(int x) { val = x; next = null; } }
 */
public class Solution {
  public boolean hasCycle(ListNode head) {
    if (null == head || null == head.next) {
      return false;
    }
    ListNode fast = head.next;
    ListNode slow = head;
    // System.out.format("fast:%d, slow: %d\n", fast.val, slow.val);
    while (fast != null && fast.next != null) {
      slow = slow.next;
      fast = fast.next.next;
      if (slow == fast) {
        return true;
      }
    }
    return false;
  }
}
// @lc code=end
