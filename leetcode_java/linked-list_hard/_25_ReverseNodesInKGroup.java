/*
 * @lc app=leetcode id=25 lang=java
 *
 * [25] Reverse Nodes in k-Group
 */

// @lc code=start
/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode(int x) { val = x; } }
 */
class Solution {

  // by myselft (wrong)
  public ListNode reverseKGroup1(ListNode head, int k) {
    ListNode dummy = new ListNode(0);
    dummy.next = head;
    ListNode prevHead = dummy;
    ListNode prev = null;
    ListNode cur = head;
    ListNode next = null;
    int i = 0;
    ListNode local = new ListNode(0);
    ListNode localHead = local;
    while (cur != null) {
      localHead.next = cur;
      localHead = cur;
      for (i = 0; i < k && cur.next != null; i++) {
        next = cur.next;
        cur.next = prev;
        prev = cur;
        cur = next;
      }
      System.out.format("cur:%d\n", cur.val);
      prevHead.next = prev;
      prevHead = localHead;
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

  // recursion
  public ListNode reverseKGroup(ListNode head, int k) {
    if (null == head || null == head.next) {
      return head;
    }
    int count = 0;
    ListNode curr = head;
    while (count < k && curr != null) {
      curr = curr.next;
      count++;
    }

    // recursively reverse the list if count == k.
    if (count == k) {
      curr = reverseKGroup(curr, k);

      while (count-- > 0) {
        ListNode next = head.next;
        head.next = curr;
        curr = head;
        head = next;
      }
      return curr;
    }

    // if count < k,, dont reverse the
    return head;
  }
}
// @lc code=end
