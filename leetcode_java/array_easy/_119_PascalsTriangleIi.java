/*
 * @lc app=leetcode id=119 lang=java
 *
 * [119] Pascal's Triangle II
 */

// @lc code=start
class Solution {
  ////////////////// first round(20200116)///////////////////////////////////
  ////////////////// first round(20200116)///////////////////////////////////
  //// ----------------start(Approach1)-------------------------------------
  // 20200116
  // public List<Integer> getRow(int rowIndex) {
  public List<Integer> getRow1(int rowIndex) {
    List<Integer> res = new ArrayList<>();
    for (int i = 0; i <= rowIndex; i++) {
      res.add(0, 1);
      for (int j = 1; j < res.size() - 1; j++) {
        res.set(j, res.get(j) + res.get(j + 1));
      }
    }
    return res;
  }
  //// ---------------- end (Approach1)-------------------------------------
  ////////////////// second round(20200911)///////////////////////////////////
  ////////////////// second round(20200911)///////////////////////////////////
  //// ----------------start(Approach2)-------------------------------------
  // 20200911

  // 34/34 cases passed (1 ms)
  // Your runtime beats 73.76 % of java submissions
  // Your memory usage beats 46.66 % of java submissions (37.1 MB)

  public List<Integer> getRow(int rowIndex) {
    // public List<Integer> getRow2(int rowIndex) {
    List<Integer> lst = new ArrayList<>();
    for (int i = 0; i <= rowIndex; i++) {
      lst.add(1);
      for (int j = lst.size() - 2; j > 0; j--) {
        lst.set(j, lst.get(j) + lst.get(j - 1));
      }
    }
    return lst;
  }
  //// ---------------- end (Approach2)-------------------------------------
}
// @lc code=end
