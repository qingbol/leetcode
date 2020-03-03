/*
 * @lc app=leetcode id=350 lang=java
 *
 * [350] Intersection of Two Arrays II
 */

// @lc code=start
class Solution {
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
}
// @lc code=end
