/*
 * @lc app=leetcode id=364 lang=java
 *
 * [364] Nested List Weight Sum II
 */

// @lc code=start
/**
 * // This is the interface that allows for creating nested lists. // You should
 * not implement it, or speculate about its implementation public interface
 * NestedInteger { // Constructor initializes an empty nested list. public
 * NestedInteger();
 *
 * // Constructor initializes a single integer. public NestedInteger(int value);
 *
 * // @return true if this NestedInteger holds a single integer, rather than a
 * nested list. public boolean isInteger();
 *
 * // @return the single integer that this NestedInteger holds, if it holds a
 * single integer // Return null if this NestedInteger holds a nested list
 * public Integer getInteger();
 *
 * // Set this NestedInteger to hold a single integer. public void
 * setInteger(int value);
 *
 * // Set this NestedInteger to hold a nested list and adds a nested integer to
 * it. public void add(NestedInteger ni);
 *
 * // @return the nested list that this NestedInteger holds, if it holds a
 * nested list // Return null if this NestedInteger holds a single integer
 * public List<NestedInteger> getList(); }
 */
class Solution {
  //// ---------------------start(Approach1)-------------------
  // two pass method
  // findDepth1() is wrong
  int depth;

  public int depthSumInverse1(List<NestedInteger> nestedList) {

    // find the depth first
    findDepth1(nestedList, 1);
    return dfs1(nestedList, depth);
  }

  private int dfs1(List<NestedInteger> lst, int level) {
    int sum = 0;
    for (NestedInteger cur : lst) {
      if (cur.isInteger()) {
        System.out.format("level: %d, cur:%d\n", level, cur.getInteger());
        sum += cur.getInteger() * level;
      } else {
        sum += dfs1(cur.getList(), level - 1);
      }
    }
    return sum;
  }

  private void findDepth1(List<NestedInteger> lst, int level) {
    depth = level;
    System.out.format("level:%d\n", level);
    System.out.format("depth:%d\n", depth);
    for (NestedInteger cur : lst) {
      if (!cur.isInteger()) {
        depth = level + 1;
        findDepth1(cur.getList(), level + 1);
        // level = level + 1;
      }
    }
    // return max;
  }

  //// --------------------- end (Approach1)-------------------
  //// ---------------------start(Approach2)-------------------
  public int depthSumInverse2(List<NestedInteger> nestedList) {

    // find the depth first
    int depth = findDepth2(nestedList);
    return dfs2(nestedList, depth);
  }

  private int dfs2(List<NestedInteger> lst, int level) {
    int sum = 0;
    for (NestedInteger cur : lst) {
      if (cur.isInteger()) {
        // System.out.format("level: %d, cur:%d\n", level, cur.getInteger());
        sum += cur.getInteger() * level;
      } else {
        sum += dfs2(cur.getList(), level - 1);
      }
    }
    return sum;
  }

  private int findDepth2(List<NestedInteger> lst) {
    int depth = 1;
    for (NestedInteger cur : lst) {
      if (!cur.isInteger()) {
        int level = findDepth2(cur.getList());
        // depth = Math.max(depth, level + 1);
        depth = level + 1;
        // System.out.format("level:%d ", level);
        // System.out.format("depth:%d\n", depth);
      }
    }
    return depth;
  }

  //// --------------------- end (Approach2)-------------------
  //// ---------------------start(Approach3)-------------------
  // One pass method + recursion
  public int depthSumInverse3(List<NestedInteger> nestedList) {
    return dfs3(nestedList, 0);
  }

  private int dfs3(List<NestedInteger> lst, int res) {
    List<NestedInteger> nextLst = new ArrayList<>();
    for (NestedInteger cur : lst) {
      if (cur.isInteger()) {
        res += cur.getInteger();
      } else {
        nextLst.addAll(cur.getList());
      }
    }
    res += nextLst.size() == 0 ? 0 : dfs3(nextLst, res);
    return res;
  }

  //// --------------------- end (Approach3)-------------------
  //// ---------------------start(Approach4)-------------------
  // One pass method + iteration
  public int depthSumInverse(List<NestedInteger> nestedList) {
    return dfs4(nestedList);
  }

  private int dfs4(List<NestedInteger> lst) {
    int sum = 0;
    int res = 0;
    while (!lst.isEmpty()) {
      List<NestedInteger> nextLst = new ArrayList<>();
      for (NestedInteger cur : lst) {
        if (cur.isInteger()) {
          sum += cur.getInteger();
        } else {
          nextLst.addAll(cur.getList());
        }
      }
      res += sum;
      lst = nextLst;
    }
    return res;
  }
  //// --------------------- end (Approach4)-------------------
  //// ---------------------start(Approach5)-------------------
  //// --------------------- end (Approach5)-------------------
}
// @lc code=end
