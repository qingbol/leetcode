/*
 * @lc app=leetcode id=86 lang=java
 *
 * [86] Partition List
 */

// @lc code=start
/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode(int x) { val = x; } }
 */
class Solution {
  ////////////////// first round(20200123)///////////////////////////////////
  ////////////////// first round(20200123)///////////////////////////////////
  //// ----------------start(Approach1)-------------------------------------
  // 20200123
  // designed by myself
  public ListNode partition1(ListNode head, int x) {
    if (null == head || null == head.next) {
      return head;
    }
    ListNode dummy = new ListNode(0);
    dummy.next = head;
    ListNode less = dummy;
    ListNode big = dummy;
    int i = 0;
    int j = 0;
    ListNode headOfBig = big.next;
    // printList(dummy.next);
    while (less != null && less.next != null) {
      while (less.next != null && less.next.val >= x) {
        less = less.next;
        j++;
      }
      // System.out.print("less: ");
      // printList(less);
      while (big.next != null && big.next.val < x) {
        big = big.next;
        i++;
      }
      // System.out.print("big: ");
      // printList(big);
      // System.out.format("bigPos: %d, lessPos: %d\n", i, j);
      if (less != null && j < i) {
        less = less.next;
        j++;
        continue;
      }
      // System.out.print("less: ");
      // printList(less);
      if (less.next != null) {
        headOfBig = big.next;
        big.next = less.next;
        less.next = less.next.next;
        big.next.next = headOfBig;
        i--;
      }
      // System.out.print("res: ");
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

  //// ---------------- end (Approach1)-------------------------------------
  //// ----------------start(Approach2)-------------------------------------
  // separate it to two lists
  //refer to leetcode :Approach 1: Two Pointer Approach

  public ListNode partition(ListNode head, int x) {
    if (null == head || null == head.next) {
      return head;
    }
    ListNode smallHead = new ListNode(0);
    ListNode small = smallHead;
    ListNode bigHead = new ListNode(0);
    ListNode big = bigHead;

    ListNode cur = head;
    while (cur != null) {
      if (cur.val >= x) {
        big.next = cur;
        big = cur;
      } else {
        small.next = cur;
        small = cur;
      }
      cur = cur.next;
    }
    small.next = bigHead.next;
    big.next = cur;
    return smallHead.next;
  }
  //// ---------------- end (Approach2)-------------------------------------
  ////////////////// second round(20200917)///////////////////////////////////
  ////////////////// second round(20200917)///////////////////////////////////
  //// ----------------start(Approach3)-------------------------------------
  //20200917. above Approach2 is awesome,  i can't come up this method.
  //// ---------------- end (Approach3)-------------------------------------
}
// @lc code=end
