/*
 * @lc app=leetcode id=99 lang=java
 *
 * [99] Recover Binary Search Tree
 */

// @lc code=start
// /**
// * Definition for a binary tree node.
// * public class TreeNode {
// * int val;
// * TreeNode left; TreeNode right;
// * TreeNode(int x) { val = x; } }
// */
class Solution {
  /////////////////////// first round(20200318)//////////////////
  /////////////////////// first round(20200318)//////////////////
  //// --------------start(Approach1)---------------------
  // 20200318, leetcode's standard solution. inorder iteration
  public void recoverTree1(TreeNode root) {
    TreeNode pred = null;
    TreeNode firstMistake = null;
    TreeNode secondMistake = null;

    Deque<TreeNode> stack = new ArrayDeque<>();
    TreeNode node = root;
    while (node != null || !stack.isEmpty()) {
      while (node != null) {
        stack.push(node);
        node = node.left;
      }

      node = stack.pop();
      // logic part
      if (pred != null && pred.val >= node.val) {
        secondMistake = node;
        if (firstMistake == null) {
          firstMistake = pred;
        } else {
          break;
        }
      }
      pred = node;

      // traverse the right subtree
      node = node.right;
    }

    // swap the two incorrect elements
    int temp = firstMistake.val;
    firstMistake.val = secondMistake.val;
    secondMistake.val = temp;
  }

  //// -------------- end (Approach1)---------------------
  //// --------------start(Approach2)---------------------
  // 20200318 Morris inorder
  public void recoverTree2(TreeNode root) {
    // public void recoverTree(TreeNode root) {
    TreeNode pred = null;
    TreeNode firstMistake = null;
    TreeNode secondMistake = null;
    TreeNode morrisPred = null;

    while (root != null) {
      // if root.left != null, find root's predecessor.
      if (root.left != null) {
        morrisPred = root.left;
        while (morrisPred.right != null && morrisPred.right != root) {
          morrisPred = morrisPred.right;
        }
        // check the predecessor link, if null, set it. if not null, break it.
        if (morrisPred.right == null) {
          morrisPred.right = root;
          root = root.left;
        } else {
          // logical part
          if (pred != null && pred.val >= root.val) {
            secondMistake = root;
            if (firstMistake == null) {
              firstMistake = pred;
              // } else {
              // break;
            }
          }
          pred = root;
          // break predecessor link
          morrisPred.right = null;
          root = root.right;
        }
        // if the root.left == null, just go right
      } else {
        if (pred != null && pred.val >= root.val) {
          secondMistake = root;
          if (firstMistake == null) {
            firstMistake = pred;
            // } else {
            // break;
          }
        }
        pred = root;
        root = root.right;
      }
    }

    // swap the two incorrect elements
    int tmp = firstMistake.val;
    firstMistake.val = secondMistake.val;
    secondMistake.val = tmp;
  }

  //// -------------- end (Approach2)---------------------
  /////////////////////////// second round(20200723)///////////////////////
  /////////////////////////// second round(20200723)///////////////////////
  //// --------------start(Approach3)---------------------
  // 202000723. by myself. recursive version.

  // 1917/1917 cases passed (2 ms)
  // Your runtime beats 83.28 % of java submissions
  // Your memory usage beats 27.5 % of java submissions (39.9 MB)

  // public void recoverTree(TreeNode root) {
  public void recoverTree3(TreeNode root) {
    TreeNode[] mistakeNode = new TreeNode[2];
    TreeNode[] prev = new TreeNode[1];

    helper3(root, prev, mistakeNode);
    // helper3(root, null, mistakeNode);
    // System.out.format("first: %d, second: %d\n", mistakeNode[0].val,
    // mistakeNode[1].val);
    int tmp = mistakeNode[0].val;
    mistakeNode[0].val = mistakeNode[1].val;
    mistakeNode[1].val = tmp;
  }

  // private void helper3(TreeNode node, TreeNode pre, TreeNode[] mistake) {
  private void helper3(TreeNode node, TreeNode[] pre, TreeNode[] mistake) {
    if (node == null) {
      return;
    }
    helper3(node.left, pre, mistake);
    // if (pre != null && node != null && pre.val > node.val) {
    // if (pre[0] != null && node != null && pre[0].val > node.val) {
    if (pre[0] != null && pre[0].val > node.val) {
      if (mistake[0] == null) {
        // mistake[0] = pre;
        mistake[0] = pre[0];
        mistake[1] = node;
      } else if (mistake[0] != null) {
        mistake[1] = node;
        return;
      }
    }
    pre[0] = node;
    // pre = node;
    helper3(node.right, pre, mistake);

  }
  //// -------------- end (Approach3)---------------------
  //// --------------start(Approach4)---------------------
  // 202000723. by myself. iterative version.

  // 1918/1918 cases passed (2 ms)
  // Your runtime beats 87.01 % of java submissions
  // Your memory usage beats 33.75 % of java submissions (39.5 MB)

  public void recoverTree(TreeNode root) {
    // public void recoverTree4(TreeNode root) {
    Deque<TreeNode> stack = new ArrayDeque<>();

    TreeNode node = root;
    TreeNode pre = null;
    TreeNode first = null;
    TreeNode second = null;

    while (!stack.isEmpty() || node != null) {
      // while (!stack.isEmpty() || node == root) {
      // traverse the left tree
      while (node != null) {
        stack.push(node);
        node = node.left;
      }

      // in-order doing sth
      TreeNode cur = stack.pop();
      // System.out.format("cur: %d\n", cur.val);
      if (pre != null && pre.val > cur.val) {
        // System.out.format("pre: %d\n", pre.val);
        if (first == null) {
          first = pre;
          second = cur;
        } else {
          second = cur;
          break;
        }
      }
      pre = cur;

      // traverse the right tree
      node = cur.right;
    }

    // swap the two mistaked nodes
    // System.out.format("first: %d, second: %d\n", first.val, second.val);
    int tmp = first.val;
    first.val = second.val;
    second.val = tmp;
  }
  //// -------------- end (Approach4)---------------------
}
// @lc code=end
