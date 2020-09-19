/*
 * @lc app=leetcode id=369 lang=java
 *
 * [369] Plus One Linked List
 */

// @lc code=start
/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode next; ListNode(int
 * x) { val = x; } }
 */
class Solution {
  /////////////////////////// first round(20200125)///////////////////////
  /////////////////////////// first round(20200125)///////////////////////
  //// ----------------start(Appraoch1)----------------------------------
  // 20200125
  // int carry = 0;

  // public ListNode plusOne(ListNode head) {
  public ListNode plusOne1(ListNode head) {
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

  //// ---------------- end (Appraoch1)----------------------------------
  /////////////////////////// second round(20200918)///////////////////////
  /////////////////////////// second round(20200918)///////////////////////
  //// ----------------start(Appraoch2)----------------------------------
  // 20200918.
  // refer to leetcode: Approach 1: Sentinel Head + Textbook Addition.

  // 108/108 cases passed (0 ms)
  // Your runtime beats 100 % of java submissions
  // Your memory usage beats 97.16 % of java submissions (36.8 MB)

  public ListNode plusOne(ListNode head) {
    // public ListNode plusOne2(ListNode head) {
    ListNode dummy = new ListNode(0);
    dummy.next = head;
    ListNode rightMostNotNine = dummy;
    // 1.find the rightMostNotNine node
    while (head != null) {
      if (head.val != 9) {
        rightMostNotNine = head;
      }
      head = head.next;
    }
    // 2. set the value
    rightMostNotNine.val += 1;
    rightMostNotNine = rightMostNotNine.next;
    while (rightMostNotNine != null) {
      rightMostNotNine.val = 0;
      rightMostNotNine = rightMostNotNine.next;
    }

    if (dummy.val == 0) {
      return dummy.next;
    } else {
      return dummy;
    }
  }
  //// ---------------- end (Appraoch2)----------------------------------
}
// @lc code=end
