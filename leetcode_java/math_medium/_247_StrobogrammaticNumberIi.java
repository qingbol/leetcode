/*
 * @lc app=leetcode id=247 lang=java
 *
 * [247] Strobogrammatic Number II
 */

// @lc code=start
class Solution {
  //////////////////////// first round(20200216)//////////////////////////
  //////////////////////// first round(20200216)//////////////////////////
  //// ----------start(Approach1)------------------------------------
  // 20200216
  public List<String> findStrobogrammatic(int n) {
    return helper(n, n);
  }

  private List<String> helper(int n, int m) {
    if (n == 0) {
      return new ArrayList<>(Arrays.asList(""));
    }
    if (n == 1) {
      return new ArrayList<>(Arrays.asList("0", "1", "8"));
    }
    List<String> lst = helper(n - 2, m);
    System.out.format("lst.size: %d\n", lst.size());
    List<String> res = new ArrayList<>();
    for (int i = 0; i < lst.size(); i++) {
      String s = lst.get(i);
      if (n != m) {
        res.add("0" + s + "0");
      }
      res.add("1" + s + "1");
      res.add("8" + s + "8");
      res.add("6" + s + "9");
      res.add("9" + s + "6");
    }
    return res;
  }
  //// ---------- end (Approach1)------------------------------------
  //////////////////////// second round(20201022)//////////////////////////
  //////////////////////// second round(20201022)//////////////////////////
  //// ----------start(Approach2)------------------------------------
  // 20201022. 
  //// ---------- end (Approach2)------------------------------------
}
// @lc code=end
