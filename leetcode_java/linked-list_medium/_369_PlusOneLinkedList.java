/*
 * @lc app=leetcode id=369 lang=java
 *
 * [369] Plus One Linked List
 */

// @lc code=start
/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode(int x) { val = x; } }
 */
class Solution {
  // int carry = 0;
  public ListNode plusOne(ListNode head) {
    int val = plusOneHelper(head);
    if (val > 0) {
      ListNode dummy = new ListNode(val);
      dummy.next = head;
      return dummy;
    }
    return head;
  }

  private int plusOneHelper(ListNode curHead) {
    if (curHead.next == null) {
      int carry = (curHead.val + 1) / 10;
      curHead.val = (curHead.val + 1) % 10;
      return carry;
    }

    int prevCarry = plusOneHelper(curHead.next);
    int carry = (curHead.val + prevCarry) / 10;
    curHead.val = (curHead.val + prevCarry) % 10;
    return carry;
  }

}
// @lc code=end
