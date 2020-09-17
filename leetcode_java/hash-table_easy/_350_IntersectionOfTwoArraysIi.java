/*
 * @lc app=leetcode id=350 lang=java
 *
 * [350] Intersection of Two Arrays II
 */

// @lc code=start
class Solution {
  ////////////////// first round(20200120)///////////////////////////////////
  ////////////////// first round(20200120)///////////////////////////////////
  //// ----------------start(Approach1)-------------------------------------
  // 20200120
  public int[] intersect(int[] nums1, int[] nums2) {
    HashMap<Integer, Integer> map = new HashMap<>();
    List<Integer> lst = new ArrayList<>();

    for (int num : nums1) {
      map.put(num, map.getOrDefault(num, 0) + 1);
    }
    for (int num : nums2) {
      if (map.containsKey(num) && map.get(num) > 0) {
        map.put(num, map.get(num) - 1);
        lst.add(num);
      }
    }
    int[] res = new int[lst.size()];
    int k = 0;
    for (int num : lst) {
      res[k++] = num;
    }
    return res;
  }
  //// ---------------- end (Approach1)-------------------------------------
  ////////////////// second round(20200915)///////////////////////////////////
  ////////////////// second round(20200915)///////////////////////////////////
  //// ----------------start(Approach2)-------------------------------------
  // 20200915.
  //just like approach1.
  //// ---------------- end (Approach2)-------------------------------------
}
// @lc code=end
