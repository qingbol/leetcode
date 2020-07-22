/*
 * @lc app=leetcode id=83 lang=java
 *
 * [83] Remove Duplicates from Sorted List
 */

// @lc code=start
//  * Definition for singly-linked list. 
// public class ListNode { 
//   int val; 
//   ListNode* next; 
//   ListNode(int x) { 
//     val = x; 
//   } 
// }

class Solution {
  //////////////////////// first round(20200111)///////////////////////
  //////////////////////// first round(20200111)///////////////////////
  //// -----------------------start(Approach1)--------------------------
  // 20200111
  public ListNode deleteDuplicates1(ListNode head) {
    if (null == head || null == head.next) {
      return head;
    }
    ListNode p = head;
    ListNode q = head.next;
    while (p != null && p.next != null) {
      if (p.val == q.val) {
        p.next = q.next;
      } else {
        p = p.next;
      }
      q = q.next;
    }
    return head;
  }

  //// ----------------------- end (Approach1)--------------------------
  //// -----------------------start(Approach2)--------------------------
  // 20200111
  //
  public ListNode deleteDuplicates2(ListNode head) {
    if (null == head || null == head.next) {
      return head;
    }
    ListNode cur = head;
    while (cur != null && cur.next != null) {
      if (cur.val == cur.next.val) {
        cur.next = cur.next.next;
      } else {
        cur = cur.next;
      }
    }
    return head;
  }

  //// ----------------------- end (Approach2)--------------------------
  //////////////////////// second round(20200718)///////////////////////
  //// -----------------------start(Approach3)--------------------------
  // 20200718. one pointer
  // 165/165 cases passed (0 ms)
  // Your runtime beats 100 % of java submissions
  // Your memory usage beats 43.95 % of java submissions (39.2 MB)
  //
  public ListNode deleteDuplicates3(ListNode head) {
    // public ListNode deleteDuplicates3(ListNode head) {
    ListNode cur = head;
    while (cur != null && cur.next != null) {
      if (cur.val == cur.next.val) {
        cur.next = cur.next.next;
      } else {
        cur = cur.next;
      }
    }
    return head;
  }

  //// ----------------------- end (Approach3)--------------------------
  //// -----------------------start(Approach4)--------------------------
  // 20200718, two pointer
  // optimal
  // 165/165 cases passed (1 ms)
  // Your runtime beats 40.01 % of java submissions
  // Your memory usage beats 7.62 % of java submissions (41.4 MB)
  public ListNode deleteDuplicates(ListNode head) {
    if (head == null)
      return head;

    ListNode slow = head;
    ListNode fast = head.next;

    while (fast != null) {
      if (slow.val != fast.val) {
        slow.next = fast;
        slow = slow.next;
      }
      fast = fast.next;
    }

    slow.next = null;
    return head;
  }
  //// ----------------------- end (Approach4)--------------------------
}
// @lc code=end
