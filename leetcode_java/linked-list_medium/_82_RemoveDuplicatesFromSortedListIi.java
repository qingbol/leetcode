/*
 * @lc app=leetcode id=82 lang=java
 *
 * [82] Remove Duplicates from Sorted List II
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
    ListNode dummy = new ListNode(-1);
    dummy.next = head;
    ListNode prev = head;
    ListNode cur = head;
    int flag = 0;
    // printList(head);
    while (cur != null && cur.next != null) {
      if (cur.val == cur.next.val) {
        // System.out.format("cur.val:%d, next:%d\n", cur.val, cur.next.val);
        flag = 1;
        cur = cur.next;
      } else if (cur.val != cur.next.val && flag == 1) {
        // System.out.format("cur-val:%d, next:%d\n", cur.val, cur.next.val);
        if (head.next.val == head.val) {
          // System.out.format("cur_val:%d, next:%d\n", cur.val, cur.next.val);
          head = cur.next;
          prev = cur.next;
        } else {
          prev.next = cur.next;
        }
        cur = cur.next;
        // prev = prev.next;
        flag = 0;
      } else if (cur.val != cur.next.val && flag == 0) {
        cur = cur.next;
        if (cur.val != prev.next.val) {
          prev = prev.next;
        }
      }
      // printList(head);
    }
    if (flag == 1) {
      if (head.val == cur.val) {
        head = cur.next;
      } else {
        prev.next = cur.next;
      }
    }
    return head;
  }

  private void printList(ListNode head) {
    while (head != null) {
      System.out.format("->%d", head.val);
      head = head.next;
    }
    System.out.println();
  }

  //
  public ListNode deleteDuplicates(ListNode head) {
    if (null == head || null == head.next) {
      return head;
    }
    ListNode dummy = new ListNode(0);
    dummy.next = head;
    ListNode prev = dummy;
    ListNode cur = head;

    // traverse every node
    while (cur != null) {
      while (cur.next != null && cur.val == cur.next.val) {
        cur = cur.next;
      }
      if (prev.next != cur) {
        prev.next = cur.next;
        cur = cur.next;
      } else {
        prev = prev.next;
        cur = cur.next;
      }
    }
    return dummy.next;
  }
}
// @lc code=end
