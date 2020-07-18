/*
 * @lc app=leetcode id=341 lang=java
 *
 * [341] Flatten Nested List Iterator
 */

// @lc code=start
/**
 * // This is the interface that allows for creating nested lists. // You should
 * not implement it, or speculate about its implementation public interface
 * NestedInteger {
 *
 * // @return true if this NestedInteger holds a single integer, rather than a
 * nested list. public boolean isInteger();
 *
 * // @return the single integer that this NestedInteger holds, if it holds a
 * single integer // Return null if this NestedInteger holds a nested list
 * public Integer getInteger();
 *
 * // @return the nested list that this NestedInteger holds, if it holds a
 * nested list // Return null if this NestedInteger holds a single integer
 * public List<NestedInteger> getList(); }
 */
//// -------------------start(Approach1)----------------
// 20200207.
// Your runtime beats 5.98 % of java submissions

// class NestedIterator1 implements Iterator<Integer> {
public class NestedIterator implements Iterator<Integer> {
  // List<NestedInteger> lst;
  // NestedInteger it;
  Deque<NestedInteger> stack = new ArrayDeque<>();

  // public NestedIterator1(List<NestedInteger> nestedList) {
  public NestedIterator(List<NestedInteger> nestedList) {
    for (int i = nestedList.size() - 1; i >= 0; i--) {
      stack.push(nestedList.get(i));
    }
    // it = lst.isEmpty() ? null : lst.get(0);
  }

  @Override
  public Integer next() {
    return stack.pop().getInteger();
  }

  @Override
  public boolean hasNext() {
    while (!stack.isEmpty()) {
      NestedInteger curr = stack.peek();
      if (curr.isInteger()) {
        return true;
      } else {
        stack.pop();
        for (int i = curr.getList().size() - 1; i >= 0; i--) {
          stack.push(curr.getList().get(i));
        }
      }
    }
    return false;
  }
}

//// ------------------- end (Approach1)----------------
//// -------------------start(Approach2)----------------
// 20200411
// 34/44 cases passed (N/A).
// Testcase // [[]] Answer [null] Expected Answer []
// public class NestedIterator implements Iterator<Integer> {
class NestedIterator2 implements Iterator<Integer> {
  Deque<NestedInteger> stack = new ArrayDeque<>();
  // List<NestedInteger> nestList;

  // public NestedIterator(List<NestedInteger> nestedList) {
  public NestedIterator2(List<NestedInteger> nestedList) {
    // nestList = nestedList;
    // System.out.format("nestList:%s\n", nestedList);
    for (int i = nestedList.size() - 1; i >= 0; i--) {
      stack.push(nestedList.get(i));
    }
  }

  @Override
  public Integer next() {
    while (!stack.isEmpty()) {
      NestedInteger curr = stack.pop();
      if (curr.isInteger()) {
        return curr.getInteger();
      } else {
        List<NestedInteger> tmp = curr.getList();
        for (int i = tmp.size() - 1; i >= 0; i--) {
          stack.push(tmp.get(i));
        }
      }
    }
    return null;
  }

  @Override
  public boolean hasNext() {
    return !stack.isEmpty();
  }
}
//// ------------------- end (Approach2)----------------
/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList); while (i.hasNext()) v[f()]
 * = i.next();
 */
// @lc code=end
