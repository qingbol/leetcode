/*
 * @lc app=leetcode id=117 lang=java
 *
 * [117] Populating Next Right Pointers in Each Node II
 */

// @lc code=start
/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/
class Solution {
  //// --------------------start(Approach1)--------------
  // 20200319
  // leetcode standard approach.
  // Approach 2: Using previously established next pointers
  public Node connect(Node root) {
    if (root == null) {
      return null;
    }

    Node leftmost = root;
    while (leftmost != null) {
      Node prev = null;
      Node curr = leftmost;

      // this statement is very important.
      System.out.format("leftmost:%d\n", leftmost.val);
      // leftmost = null;

      while (curr != null) {
        // handle curr node's left child
        if (curr.left != null) {
          if (prev != null) {
            prev.next = curr.left;
          } else {
            // set the next levele's leftmost node;
            leftmost = curr.left;
          }
          prev = curr.left;
        }

        // handle curr node's right child
        if (curr.right != null) {
          if (prev != null) {
            prev.next = curr.right;
          } else {
            // set the next levele's leftmost node;
            leftmost = curr.right;
          }
          prev = curr.right;
        }

        // move on to the next node on the same level
        curr = curr.next;
      }
    }
    return root;
  }
}
// @lc code=end
