/*
 * @lc app=leetcode id=116 lang=java
 *
 * [116] Populating Next Right Pointers in Each Node
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
  //// -----------------start(Approach1)------------------
  // wrong, why?
  public Node connect1(Node root) {
    if (root != null) {
      return root;
    }
    helper3(root.left, root.right);
    return root;
  }

  private void helper3(Node left, Node right) {
    if (left == null && right == null) {
      return;
    }
    if (left != null) {
      left.next = right;
    }
    helper3(left.left, left.right);
    helper3(left.right, right.left);
    helper3(right.left, right.right);
  }

  //// ----------------- end (Approach1)------------------
  //// -----------------start(Approach2)------------------
  // 20200312
  // by myself. LevelOrder + iteration.
  // O(n) space
  public Node connect2(Node root) {
    if (root == null) {
      return root;
    }
    Queue<Node> queue = new ArrayDeque<>();
    queue.offer(root);
    while (!queue.isEmpty()) {
      int size = queue.size();
      for (int i = 0; i < size; i++) {
        Node cur = queue.poll();
        if (i < size - 1) {
          cur.next = queue.peek();
          // } else {
          // cur.next = null;
        }
        if (cur.left != null) {
          queue.offer(cur.left);
        }
        if (cur.right != null) {
          queue.offer(cur.right);
        }
      }
    }
    return root;
  }

  //// ----------------- end (Approach2)------------------
  //// -----------------start(Approach3)------------------
  // preorder + recursion
  // O(N) space
  public Node connect3(Node root) {
    if (root == null) {
      return root;
    }
    if (root.left != null) {
      root.left.next = root.right;
    }
    if (root.right != null && root.next != null) {
      root.right.next = root.next.left;
    }
    connect(root.left);
    connect(root.right);
    return root;
  }

  //// ----------------- end (Approach3)------------------
  //// -----------------start(Approach4)------------------
  public Node connect(Node root) {
    // use leftmost to denote the leftmost node in one level
    Node leftmost = root;
    while (leftmost != null) {
      Node head = leftmost;
      while (head != null) {
        // set connection 1
        if (head.left != null) {
          head.left.next = head.right;
        }

        // set connection2
        if (head.right != null && head.next != null) {
          head.right.next = head.next.left;
        }

        head = head.next;
      }

      leftmost = leftmost.left;
    }
    return root;
  }
  //// ----------------- end (Approach4)------------------
}
// @lc code=end
