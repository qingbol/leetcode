/*
 * @lc app=leetcode id=142 lang=java
 *
 * [142] Linked List Cycle II
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
  public ListNode detectCycle(ListNode head) {
    if (null == head || null == head.next) {
      return null;
    }
    ListNode fast = head;
    ListNode slow = head;
    while (fast != null && fast.next != null) {
      fast = fast.next.next;
      slow = slow.next;
      // System.out.format("slow:%d, fast:%d\n", slow.val, fast.val);
      if (slow == fast) {
        fast = head;
        while (fast != slow) {
          // System.out.format("slow:%d, fast:%d\n", slow.val, fast.val);
          fast = fast.next;
          slow = slow.next;
        }
        return slow;
      }
    }
    return null;
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
