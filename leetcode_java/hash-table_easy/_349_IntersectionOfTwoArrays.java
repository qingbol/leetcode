/*
 * @lc app=leetcode id=349 lang=java
 *
 * [349] Intersection of Two Arrays
 */

// @lc code=start
class Solution {
  public int[] intersection1(int[] nums1, int[] nums2) {
    HashSet<Integer> set = new HashSet<>();
    HashSet<Integer> hashSet = new HashSet<>();
    List<Integer> lst = new ArrayList<>();
    for (int i = 0; i < nums1.length; i++) {
      set.add(nums1[i]);
    }
    for (int i = 0; i < nums2.length; i++) {
      if (set.contains(nums2[i]) && hashSet.add(nums2[i])) {
        lst.add(nums2[i]);
      }
    }
    Integer[] arr = lst.toArray(new Integer[lst.size()]);
    int[] res = new int[arr.length];
    for (int i = 0; i < arr.length; i++) {
      res[i] = arr[i].intValue();
    }
    return res;
  }

  public int[] intersection(int[] nums1, int[] nums2) {
    HashSet<Integer> set = new HashSet<>();
    List<Integer> lst = new ArrayList<>();
    for (int i = 0; i < nums1.length; i++) {
      set.add(nums1[i]);
    }
    for (int j = 0; j < nums2.length; j++) {
      if (set.contains(nums2[j])) {
        lst.add(nums2[j]);
        set.remove(nums2[j]);
      }
    }
    int[] res = new int[lst.size()];
    for (int i = 0; i < lst.size(); i++) {
      res[i] = lst.get(i);
    }
    return res;
  }
}
// @lc code=end
