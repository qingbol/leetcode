/*
 * @lc app=leetcode id=297 lang=java
 *
 * [297] Serialize and Deserialize Binary Tree
 */

// @lc code=start
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
public class Codec {

  // -------------------start(Approach1)---------------------------
  // 20200319, by myself
  // 15/48 cases passed (N/A). Testcase [1,2]
  // Encodes a tree to a single string.
  public String serialize1(TreeNode root) {
    if (root == null) {
      return "";
    }

    Queue<TreeNode> queue = new ArrayDeque<>();
    StringBuilder res = new StringBuilder();

    queue.offer(root);
    res.append(root.val);
    res.append("_");
    int size = 0;
    while (!queue.isEmpty()) {
      size = queue.size();
      for (int i = 0; i < size; i++) {
        TreeNode cur = queue.poll();
        if (cur.left != null) {
          queue.offer(cur.left);
          res.append(cur.left.val);
          res.append("_");
        } else {
          res.append("null_");
        }

        if (cur.right != null) {
          queue.offer(cur.right);
          res.append(cur.right.val);
          res.append("_");
        } else {
          res.append("null_");
        }
      }

    }

    // System.out.format("res:%s\n", res.toString());
    // System.out.format("size:%d\n", size);
    // res.setLength(res.length() - 2 * size * 5);

    // find the index of last digit
    int index = res.toString().replaceAll("[^0-9]*$", "").length() - 1;
    res.setLength(index + 2);

    // System.out.format("res:%s\n", res.toString());
    return res.toString();

  }

  // Decodes your encoded data to tree.
  public TreeNode deserialize1(String data) {
    if (data.length() == 0) {
      return null;
    }
    List<TreeNode> lst = new ArrayList<>();
    // System.out.format("data:%s\n", data);
    for (int i = 0; i < data.length();) {
      int idx = data.indexOf("_", i);
      String curStr = data.substring(i, idx);
      i = idx + 1;
      if (!curStr.equals("null")) {
        Integer curNum = Integer.valueOf(curStr);
        // System.out.format("i:%d\n", Integer.valueOf(curStr));
        TreeNode curNode = new TreeNode(curNum);
        lst.add(curNode);
      } else {
        // lst.add(new TreeNode());
        lst.add(null);
      }
    }
    // System.out.format("lst:%s\n", lst);
    // for (TreeNode tmp : lst) {
    // System.out.format("tmp:%d\n", tmp.val);
    // }
    int nullNum = 0;
    for (int i = 0; i < lst.size(); i++) {
      int leftIndex = 2 * i + 1 - 2 * nullNum;
      int rightIndex = 2 * i + 2 - 2 * nullNum;
      // System.out.format("l:%d, r:%d\n", leftIndex, rightIndex);
      if (lst.get(i) != null) {
        if (leftIndex < lst.size()) {
          // System.out.format("node: %d, left:%d\n", lst.get(i).val,
          // lst.get(leftIndex).val);
          lst.get(i).left = lst.get(leftIndex);
        } else {
          lst.get(i).left = null;
        }

        if (rightIndex < lst.size()) {
          lst.get(i).right = lst.get(rightIndex);
        } else {
          lst.get(i).right = null;
        }
      } else {
        nullNum++;
      }
    }

    //// print the tree
    // TreeNode temp = lst.get(0);
    // Deque<TreeNode> stack = new ArrayDeque<>();
    // stack.push(temp);
    // while (!stack.isEmpty()) {
    // temp = stack.pop();
    // System.out.format("temp:%d->", temp.val);
    // if (temp.left != null) {
    // stack.push(temp.left);
    // }
    // if (temp.right != null) {
    // stack.push(temp.right);
    // }
    // }
    return lst.get(0);
  }

  // -------------------start(Approach1)---------------------------
  // -------------------start(Approach2)---------------------------

  // -------------------end (Approach2)---------------------------
  // improvement of Approach1. BFS (level order)
  public String serialize(TreeNode root) {
    if (root == null) {
      return "";
    }
    Queue<TreeNode> queue = new LinkedList<>();
    // Queue<TreeNode> queue = new ArrayDeque<>();
    StringBuilder sb = new StringBuilder();

    queue.offer(root);
    while (!queue.isEmpty()) {
      TreeNode cur = queue.poll();

      if (cur == null) {
        sb.append("null").append("_");
      } else {
        sb.append(cur.val).append("_");
        queue.offer(cur.left);
        queue.offer(cur.right);
      }
      // System.out.format("sb: %s\n", sb.toString());
    }
    // System.out.format("sb: %s\n", sb.toString());
    return sb.toString();
  }

  public TreeNode deserialize(String data) {
    if (data == "")
      return null;
    String[] strs = data.split("_");
    Queue<TreeNode> queue = new LinkedList<>();

    TreeNode root = new TreeNode(Integer.valueOf(strs[0]));
    queue.offer(root);
    for (int i = 1; i < strs.length; i++) {
      TreeNode cur = queue.poll();
      if (!strs[i].equals("null")) {
        cur.left = new TreeNode(Integer.valueOf(strs[i]));
        queue.offer(cur.left);
      }
      i++;
      if (!strs[i].equals("null")) {
        cur.right = new TreeNode(Integer.valueOf(strs[i]));
        queue.offer(cur.right);
      }

    }
    return root;
  }

  // -------------------start(Approach3)---------------------------
  // 20200319 leetcode standard approach. preorder + recursion
  public String serialize3(TreeNode root) {
    StringBuilder sb = new StringBuilder();
    buildString(sb, root);
    return sb.toString();
  }

  private void buildString(StringBuilder sb, TreeNode node) {
    if (node == null) {
      sb.append("null").append("_");
    } else {
      sb.append(node.val).append("_");
      buildString(sb, node.left);
      buildString(sb, node.right);
    }
  }

  public TreeNode deserialize3(String data) {
    // System.out.format("data:%s\n", data);
    Queue<String> queue = new ArrayDeque<>(Arrays.asList(data.split("_")));
    // queue.addAll(Arrays.asList(data.split("_")));
    return buildTree(queue);
  }

  private TreeNode buildTree(Queue<String> queue) {
    String cur = queue.poll();
    if (cur.equals("null")) {
      return null;
    }
    TreeNode node = new TreeNode(Integer.valueOf(cur));
    node.left = buildTree(queue);
    node.right = buildTree(queue);
    return node;
  }
  // ------------------- end (Approach3)---------------------------
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
// @lc code=end
