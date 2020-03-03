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
  public ListNode removeElements(ListNode head, int val) {
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
}
// @lc code=end
