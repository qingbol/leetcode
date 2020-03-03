/*
 * @lc app=leetcode id=234 lang=java
 *
 * [234] Palindrome Linked List
 */

// @lc code=start
/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode(int x) { val = x; } }
 */
class Solution {
  // reverse the second half (by myself)
  public boolean isPalindrome1(ListNode head) {
    if (null == head || null == head.next) {
      return true;
    }
    ListNode dummy = new ListNode(0);
    dummy.next = head;
    // ListNode prev = dummy;
    ListNode fast = head;
    ListNode slow = head;
    while (fast.next != null && fast.next.next != null) {
      // prev = prev.next;
      slow = slow.next;
      fast = fast.next.next;
    }
    // printList(prev);
    // printList(slow);
    // if (slow.val != slow.next.val) {
    // return false;
    // }
    ListNode tail = reverse(slow.next);
    // System.out.format("tai:");
    // printList(tail);
    // printList(head);
    while (tail != null) {
      if (head.val != tail.val) {
        return false;
        // System.out.format("head:%d, tail:%d\n", head.val, tail.val);
      }
      head = head.next;
      tail = tail.next;
    }
    return true;
  }

  private ListNode reverse(ListNode h) {
    // printList(h);
    // ListNode preHead = new ListNode(0);
    ListNode prev = null;
    // prev.next = h;
    ListNode next = null;
    while (h != null) {
      next = h.next;
      h.next = prev;
      prev = h;
      h = next;
      // printList(prev);
    }
    // printList(prev);
    return prev;
  }

  private void printList(ListNode ptr) {
    while (ptr != null) {
      System.out.format("->%d", ptr.val);
      ptr = ptr.next;
    }
    System.out.println();
  }

  // reverse the first half in place
  public boolean isPalindrome2(ListNode head) {
    if (null == head || null == head.next) {
      return true;
    }
    ListNode fast = head;
    ListNode slow = head.next;
    ListNode prev = null;
    ListNode cur = head;
    ListNode next = head.next;

    // printList(head);
    while (fast.next != null && fast.next.next != null) {
      // used for find the mid and end;
      fast = fast.next.next;
      slow = slow.next;
      // used for reverse the first half of the list.
      // printList(head);
      prev = cur;
      cur = next;
      next = cur.next;
      cur.next = prev;

      // printList(head);
    }

    // odd number, move cur to the left for 1 step.
    if (fast.next == null) {
      cur = cur.next;
    }

    // compare forom mid to head/tail.
    while (slow != null) {
      if (cur.val != slow.val) {
        return false;
      }
      cur = cur.next;
      slow = slow.next;
    }
    return true;
  }

  // recursion
  ListNode frontPtr;

  public boolean isPalindrome3(ListNode head) {
    frontPtr = head;
    return isPalindromeHelper(head);
  }

  public boolean isPalindromeHelper(ListNode curHead) {
    if (curHead != null) {
      if (!isPalindromeHelper(curHead.next)) {
        return false;
      }
      if (frontPtr.val != curHead.val) {
        return false;
      }
      frontPtr = frontPtr.next;
    }
    return true;
  }

  // copy into arraylist
  public boolean isPalindrome4(ListNode head) {
    List<Integer> lst = new ArrayList<>();
    while (head != null) {
      lst.add(head.val);
      head = head.next;
    }

    for (int i = 0, j = lst.size() - 1; i < j; i++, j--) {
      // System.out.format("i:%d, j:%d\n", lst.get(i), lst.get(j));
      // System.out.format("type: %b\n", lst.get(i) instanceof Integer);
      if (!lst.get(i).equals(lst.get(j))) {
        // System.out.format("warning");
        return false;
      }
    }
    return true;
  }

  // Reverse second half in place
  public boolean isPalindrome(ListNode head) {
    if (null == head || null == head.next) {
      return true;
    }
    ListNode firstHalfEnd = findFirstHalfEnd(head);
    // ListNode secondHalfStart = findSecondHalfStart(head);
    // printList(firstHalfEnd);
    // printList(secondHalfStart);
    // newHead : first postion in second half
    ListNode secondHalfHead = reverseList(firstHalfEnd);
    // printList(secondHalfHead);

    // check wether or not there is a palindrome
    ListNode p = head;
    ListNode q = secondHalfHead;
    while (q != null) {
      if (p.val != q.val) {
        return false;
      }
      p = p.next;
      q = q.next;
    }
    return true;
  }

  private ListNode findFirstHalfEnd(ListNode curHead) {
    ListNode slow = curHead;
    ListNode fast = curHead;
    while (fast.next != null && fast.next.next != null) {
      slow = slow.next;
      fast = fast.next.next;
    }
    return slow;
  }

  private ListNode findSecondHalfStart(ListNode curHead) {
    ListNode slow = curHead.next;
    ListNode fast = curHead;
    while (fast.next != null && fast.next.next != null) {
      slow = slow.next;
      fast = fast.next.next;
    }
    return slow;
  }

  private ListNode reverseList(ListNode curHead) {
    ListNode prev = null;
    ListNode cur = curHead.next;
    ListNode next = null;
    while (cur != null) {
      next = cur.next;
      cur.next = prev;
      prev = cur;
      cur = next;
    }
    return prev;
  }
}
// @lc code=end
