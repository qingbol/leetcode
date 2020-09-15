/*
 * @lc app=leetcode id=118 lang=java
 *
 * [118] Pascal's Triangle
 */

// @lc code=start
class Solution {
  ////////////////// first round(20200116)///////////////////////////////////
  ////////////////// first round(20200116)///////////////////////////////////
  //// ----------------start(Approach1)-------------------------------------
  // 20200116

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

  //// ---------------- end (Approach1)-------------------------------------
  //// ----------------start(Approach2)-------------------------------------
  //
  // public List<List<Integer>> generate(int numRows) {
  public List<List<Integer>> generate2(int numRows) {
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

  //// ---------------- end (Approach2)-------------------------------------
  ////////////////// second round(20200911)///////////////////////////////////
  ////////////////// second round(20200911)///////////////////////////////////
  //// ----------------start(Approach3)-------------------------------------
  // 20200911
  //refer to approach2. better than approach1

//   15/15 cases passed (1 ms)
// Your runtime beats 30.74 % of java submissions
// Your memory usage beats 24.63 % of java submissions (38.6 MB)

  public List<List<Integer>> generate(int numRows) {
    // public List<List<Integer>> generate2(int numRows) {
    List<List<Integer>> res = new ArrayList<>();
    if (numRows == 0) return res;
    List<Integer> lst = new ArrayList<>();

    for (int i = 0; i < numRows; i++) {
      // lst.add(1);
      lst.add(0, 1);
      for (int j = 1; j < lst.size() - 1; j++) {
        // lst.set(j, lst.get(j - 1) + lst.get(j));
        lst.set(j, lst.get(j) + lst.get(j + 1));
      }
      res.add(new ArrayList<>(lst));
    }

    return res;
  }
  //// ---------------- end (Approach3)-------------------------------------
}
// @lc code=end
