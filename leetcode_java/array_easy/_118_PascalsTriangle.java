/*
 * @lc app=leetcode id=118 lang=java
 *
 * [118] Pascal's Triangle
 */

// @lc code=start
class Solution {
  public List<List<Integer>> generate1(int numRows) {
    List<List<Integer>> lst = new ArrayList<>();
    for (int i = 0; i < numRows; i++) {
      lst.add(new ArrayList<>());
    }
    for (int i = 0; i < numRows; i++) {
      for (int j = 0; j < i + 1; j++) {
        if (0 == j || i == j) {
          lst.get(i).add(1);
        } else {
          lst.get(i).add(lst.get(i - 1).get(j - 1) + lst.get(i - 1).get(j));
        }
      }
    }
    return lst;
  }

  //
  public List<List<Integer>> generate(int numRows) {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> lst = new ArrayList<>();

    for (int i = 0; i < numRows; i++) {
      lst.add(0, 1);
      for (int j = 1; j < lst.size() - 1; j++) {
        lst.set(j, lst.get(j) + lst.get(j + 1));
      }
      res.add(new ArrayList<>(lst));
    }
    return res;
  }
}
// @lc code=end
