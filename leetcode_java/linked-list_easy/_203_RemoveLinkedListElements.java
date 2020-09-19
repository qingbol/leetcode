/*
 * @lc app=leetcode id=203 lang=java
 *
 * [203] Remove Linked List Elements
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

  // public ListNode removeElements(ListNode head, int val) {
  public ListNode removeElements1(ListNode head, int val) {
    if (null == head) {
      return head;
    }
    ListNode dummy = new ListNode(0);
    dummy.next = head;
    ListNode curr = dummy;
    while (curr.next != null) {
      if (curr.next.val == val) {
        curr.next = curr.next.next;
      } else {
        curr = curr.next;
      }
      // printList(dummy.next);
    }
    return dummy.next;
  }

  private void printList(ListNode curHead) {
    while (curHead != null) {
      System.out.format("->%d", curHead.val);
      curHead = curHead.next;
    }
    System.out.println();
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
