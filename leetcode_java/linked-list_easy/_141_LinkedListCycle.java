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
  ////////////////// first round(20200123)///////////////////////////////////
  ////////////////// first round(20200123)///////////////////////////////////
  //// ----------------start(Approach1)-------------------------------------
  // 20200123
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
  //// ---------------- end (Appraoch1)----------------------------------
  /////////////////////////// second round(20200918)///////////////////////
  /////////////////////////// second round(20200918)///////////////////////
  //// ----------------start(Appraoch2)----------------------------------
  // 20200918.
  //just like approach1.
  //// ---------------- end (Appraoch2)----------------------------------
}
// @lc code=end
