/*
 * @lc app=leetcode id=298 lang=java
 *
 * [298] Binary Tree Longest Consecutive Sequence
 */

// @lc code=start
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
class Solution {
  /////////////////////////// first round(2020316)///////////////////////
  /////////////////////////// first round(2020316)///////////////////////
  //// ----------------start(Appraoch1)----------------------------------
  // 20200316
  // by myself.
  // 51/54 cases passed (N/A)
  // [1,6,2,7,5,null,null,8,null,6,4,7,9,null,null,3,5,null,null,10,8,4,2,null,null,9,11,null,null,1]
  public int longestConsecutive1(TreeNode root) {
    if (root == null) {
      return 0;
    }
    if (root.left == null && root.right == null) {
      return 1;
    }

    if (root.left != null && root.left.val == root.val + 1) {
      return 1 + longestConsecutive(root.left);
    } else if (root.right != null && root.right.val == root.val + 1) {
      return 1 + longestConsecutive(root.right);
    } else {
      return Math.max(longestConsecutive(root.left), longestConsecutive(root.right));
    }
    // return 0;
  }

  //// -------------- end (Approach1)----------------------------
  //// --------------start(Approach2)----------------------------
  // improvement of Approach1
  // 52/54 cases passed (N/A)
  public int longestConsecutive2(TreeNode root) {
    if (root == null) {
      return 0;
    }
    if (root.left == null && root.right == null) {
      return 1;
    }

    // what ret means? the max length rooted at cur node.
    // here, I get coufused. so the answer is wrong
    int ret = 0;
    if (root.left != null) {
      if (root.left.val == root.val + 1) {
        ret = Math.max(ret, 1 + longestConsecutive(root.left));
      } else {
        // ret = 1;
        ret = Math.max(ret, longestConsecutive(root.left));
      }
    }
    if (root.right != null) {
      if (root.right.val == root.val + 1) {
        ret = Math.max(ret, 1 + longestConsecutive(root.right));
      } else {
        // ret = 1;
        ret = Math.max(ret, longestConsecutive(root.right));
      }
    }

    // ret = Math.max(ret, Math.max(longestConsecutive(root.left),
    // longestConsecutive(root.right)));

    return ret;
  }

  //// -------------- end (Approach2)----------------------------
  //// --------------start(Approach3)----------------------------
  // bottom up, postorder
  int res = 0;

  public int longestConsecutive3(TreeNode root) {
    helper3(root);
    return res;
  }

  private int helper3(TreeNode cur) {
    if (cur == null) {
      return 0;
    }
    int l = helper3(cur.left) + 1;
    int r = helper3(cur.right) + 1;
    if (cur.left != null && cur.left.val != cur.val + 1) {
      l = 1;
    }
    if (cur.right != null && cur.right.val != cur.val + 1) {
      r = 1;
    }
    // max consecutive length from cur to its child
    int len = Math.max(l, r);
    res = Math.max(res, len);
    return len;
  }

  //// -------------- end (Approach3)----------------------------
  //// --------------start(Approach4)----------------------------
  // top down method. preorder
  // Your runtime beats 83.52 % of java submissions
  public int longestConsecutive4(TreeNode root) {
    helper4(root, null, 0);
    return res;
  }

  private void helper4(TreeNode cur, TreeNode p, int length) {
    if (cur == null) {
      return;
    }
    // update length from cur to it's parent
    if (p != null && cur.val == p.val + 1) {
      length++;
    } else {
      length = 1;
    }
    res = Math.max(res, length);

    helper4(cur.left, cur, length);
    helper4(cur.right, cur, length);

  }

  //// -------------- end (Approach4)----------------------------
  //// --------------start(Approach5)----------------------------
  // by cson
  // topdown, preorder
  // Your runtime beats 83.52 % of java submissions
  public int longestConsecutive(TreeNode root) {
    if (root == null) {
      return 0;
    }
    helper5(root, 0, root.val);
    return res;
  }

  // length: the length from cur node to ancestor.
  private void helper5(TreeNode cur, int length, int nextSequence) {
    if (cur == null) {
      return;
    }
    if (cur.val == nextSequence) {
      length++;
    } else {
      length = 1;
    }
    res = Math.max(res, length);

    helper5(cur.left, length, cur.val + 1);
    helper5(cur.right, length, cur.val + 1);
  }

  //// ----------------start(Appraoch5)----------------------------------
  /////////////////////////// second round(20201115)///////////////////////
  /////////////////////////// second round(20201115)///////////////////////
  //// ----------------start(Appraoch6)----------------------------------
  // 20201115.
  //// ---------------- end (Appraoch6)----------------------------------
}
// @lc code=end
