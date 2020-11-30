/*
 * @lc app=leetcode id=339 lang=java
 *
 * [339] Nested List Weight Sum
 */

// @lc code=start
// /**
//  * // This is the interface that allows for creating nested lists. // You should
//  * not implement it, or speculate about its implementation 
//  * public interface NestedInteger {
//  *     // Constructor initializes an empty nested list.
//  *     public NestedInteger();
//  *
//  *     // Constructor initializes a single integer.
//  *     public NestedInteger(int value);
//  *
//  *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
//  *     public boolean isInteger();
//  *
//  *     // @return the single integer that this NestedInteger holds, if it holds a single integer
//  *     // Return null if this NestedInteger holds a nested list
//  *     public Integer getInteger();
//  *
//  *     // Set this NestedInteger to hold a single integer.
//  *     public void setInteger(int value);
//  *
//  *     // Set this NestedInteger to hold a nested list and adds a nested integer to it.
//  *     public void add(NestedInteger ni);
//  *
//  *     // @return the nested list that this NestedInteger holds, if it holds a nested list
//  *     // Return null if this NestedInteger holds a single integer
//  *     public List<NestedInteger> getList();
//  * }
//  */
class Solution {
  ////////////////// first round(20200308)///////////////////////////////////
  ////////////////// first round(20200308)///////////////////////////////////
  //// ----------------start(Approach1)------------------------------------
  // 20200308 
  // Wrote by myself.
  public int depthSum1(List<NestedInteger> nestedList) {
    // System.out.format("nestedList: %s\n", nestedList);
    int res = 0;
    for (int i = 0; i < nestedList.size(); i++) {
      res += dfs1(nestedList.get(i), 1);
      // System.out.format("res: %d\n", res);
    }
    return res;
  }

  private int dfs1(NestedInteger nestInt, int level) {
    int sum = 0;
    if (nestInt.isInteger()) {
      // System.out.format("level: %d || int: %d\n", level, nestInt.getInteger());
      return level * nestInt.getInteger();
      // return sum;
    }

    List<NestedInteger> cur = nestInt.getList();
    // System.out.format("cur:%s size: %d\n", cur, cur.size());
    for (int i = 0; i < cur.size(); i++) {
      sum += dfs1(cur.get(i), level + 1);
      // System.out.format("sum: %d\n", sum);
    }
    return sum;
  }

  //// --------------- end (Approach1)-------------------
  //// ---------------start(Approach2)-------------------
  // better, more concise
  public int depthSum(List<NestedInteger> nestedList) {
    return dfs2(nestedList, 1);
  }

  private int dfs2(List<NestedInteger> curList, int level) {
    int sum = 0;
    for (NestedInteger element : curList) {
      if (element.isInteger()) {
        sum += element.getInteger() * level;
      } else {
        sum += dfs2(element.getList(), level + 1);
      }
    }
    return sum;
  }

  //// ---------------- end (Approach2)----------------------------------
  /////////////////////////// second round(20201124)///////////////////////
  /////////////////////////// second round(20201124)///////////////////////
  //// ----------------start(Approach3)----------------------------------
  // 20201124.
  //// ---------------- end (Approach3)----------------------------------
}
// @lc code=end
