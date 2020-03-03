/*
 * @lc app=leetcode id=148 lang=java
 *
 * [148] Sort List
 */

// @lc code=start
/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode(int x) { val = x; } }
 */
class Solution {
  public ListNode sortList(ListNode head) {
    return mergeSort(head);
  }

  private ListNode mergeSort(ListNode curHead) {
    if (null == curHead || null == curHead.next) {
      return curHead;
    }
    ListNode median = findMedian(curHead);
    // printList("median: ", median);
    ListNode left = mergeSort(curHead);
    // printList("left: ", left);
    ListNode right = mergeSort(median);
    // printList("right: ", right);
    ListNode res = mergeFunc(left, right);
    // printList("res: ", res);
    return res;
  }

  private ListNode findMedian(ListNode curPtr) {
    ListNode fast = curPtr;
    ListNode slow = curPtr;
    while (fast.next != null && null != fast.next.next) {
      fast = fast.next.next;
      slow = slow.next;
    }
    ListNode secondHalfStart = slow.next;
    slow.next = null;
    return secondHalfStart;
  }

  private ListNode mergeFunc(ListNode l, ListNode r) {
    // printList("l: ", l);
    // printList("r: ", r);
    ListNode dummy = new ListNode(0);
    // dummy.next = l;
    ListNode prev = dummy;
    while (l != null && r != null) {
      if (l.val <= r.val) {
        prev.next = l;
        prev = l;
        l = l.next;
      } else {
        prev.next = r;
        prev = r;
        r = r.next;
      }
    }
    prev.next = l != null ? l : r;
    // printList("dummy.next: ", dummy.next);
    return dummy.next;
  }

  private void printList(String str, ListNode tmp) {
    System.out.print(str);
    while (tmp != null) {
      System.out.format("->%d", tmp.val);
      tmp = tmp.next;
    }
    System.out.println();
  }
}
// @lc code=end
