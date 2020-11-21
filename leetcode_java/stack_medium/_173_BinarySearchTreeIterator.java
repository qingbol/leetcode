/*
 * @lc app=leetcode id=173 lang=java
 *
 * [173] Binary Search Tree Iterator
 */

// @lc code=start
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
  ////////////////// first round(20200317)///////////////////////////////////
  ////////////////// first round(20200317)///////////////////////////////////
  //// ----------------start(Approach1)----------------------------------
  // 20200317
class BSTIterator {

  TreeNode cur;
  Deque<TreeNode> stack;

  public BSTIterator(TreeNode root) {
    cur = root;
    stack = new ArrayDeque<>();
    while (cur != null) {
      stack.push(cur);
      cur = cur.left;
    }
    // System.out.format("stack:%s\n", stack);
  }

  /** @return the next smallest number */
  public int next() {
    TreeNode ret = stack.pop();
    if (ret.right != null) {
      TreeNode node = ret.right;
      while (node != null) {
        stack.push(node);
        node = node.left;
      }
    }
    // System.out.format("ret:%d\n", ret.val);
    return ret.val;
  }

  /** @return whether we have a next smallest number */
  public boolean hasNext() {
    return !stack.isEmpty();
  }
}

  //// ---------------- end (Approach1)----------------------------------
  /////////////////////////// second round(20201117)///////////////////////
  /////////////////////////// second round(20201117)///////////////////////
  //// ----------------start(Approach2)----------------------------------
  // 20201117.
  //// ---------------- end (Approach2)----------------------------------
/**
 * Your BSTIterator object will be instantiated and called as such: BSTIterator
 * obj = new BSTIterator(root); int param_1 = obj.next(); boolean param_2 =
 * obj.hasNext();
 */
// @lc code=end
