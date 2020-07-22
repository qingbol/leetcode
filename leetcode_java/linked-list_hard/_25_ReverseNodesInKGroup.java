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
  ///////////////////////////// first round(20200125)////////////////////////
  ///////////////////////////// first round(20200125)////////////////////////
  //// -----------------------start(Approach1)------------------------------
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

  //// ----------------------- end (Approach1)------------------------------
  //// -----------------------start(Approach2)------------------------------
  // recursion
  // public ListNode reverseKGroup(ListNode head, int k) {
  public ListNode reverseKGroup2(ListNode head, int k) {
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

  //// ----------------------- end (Approach2)------------------------------
  ///////////////////////////// second round(20200719)////////////////////////
  ///////////////////////////// second round(20200719)////////////////////////
  //// -----------------------start(Approach3)------------------------------
  // 20200719. recursive version.
  // cant come up it with myself.
  // refer to labuladong <如何k个一组反转链表>
  // 62/62 cases passed (1 ms)
  // Your runtime beats 38.14 % of java submissions
  // Your memory usage beats 5.14 % of java submissions (43.3 MB)

  public ListNode reverseKGroup3(ListNode head, int k) {
    // public ListNode reverseKGroup(ListNode head, int k) {
    if (head == null)
      return head;
    ListNode a = head, b = head;

    for (int i = 0; i < k; i++) {
      if (b == null)
        return head;
      b = b.next;
    }

    // reverse the current k nodes
    ListNode newReversedKHead = reverseAll3(a, b);
    // link the current reversed nodes with the following nodes
    a.next = reverseKGroup(b, k);

    return newReversedKHead;
  }

  // reverse the node betweetn [a, b)
  private ListNode reverseAll3(ListNode a, ListNode b) {
    ListNode prev = null, cur = a, nxt = a;
    while (cur != b) {
      nxt = cur.next;
      cur.next = prev;
      prev = cur;
      cur = nxt;
    }

    return prev;
  }
  //// ----------------------- end (Approach3)------------------------------
  //// -----------------------start(Approach4)------------------------------
  // 20200720, iterative version
  // 62/62 cases passed (1 ms)
  // Your runtime beats 37.97 % of java submissions
  // Your memory usage beats 54.51 % of java submissions (39.6 MB)

  // public ListNode reverseKGroup4(ListNode head, int k) {
  public ListNode reverseKGroup(ListNode head, int k) {
    if (head == null)
      return head;

    // Use newHead to mark the real head of new linked list
    ListNode newHead = null;
    // Use Ktail to mark the tail of reversed K nodes.
    ListNode kTail = null;
    // use ptr traverse the linkedList
    ListNode ptr = head;

    while (ptr != null) {
      // ptr = head;
      // first find the k nodes. if less than k, return
      int count = 0;
      while (count < k && ptr != null) {
        ptr = ptr.next;
        count++;
      }
      if (count != k)
        break;

      // reverse the new k nodes
      ListNode newReversedKHead = reverseAll4(head, ptr);

      if (newHead == null) {
        newHead = newReversedKHead;
      }
      if (kTail != null) {
        kTail.next = newReversedKHead;
      }
      kTail = head;
      head = ptr;
    }

    if (kTail != null) {
      kTail.next = head;
    }

    return newHead == null ? head : newHead;
  }

  private ListNode reverseAll4(ListNode a, ListNode b) {
    ListNode pre = null, cur = a, nxt = a;
    while (cur != b) {
      nxt = cur.next;
      cur.next = pre;
      pre = cur;
      cur = nxt;
    }

    return pre;
  }
  //// ----------------------- end (Approach3)------------------------------
}
// @lc code=end
