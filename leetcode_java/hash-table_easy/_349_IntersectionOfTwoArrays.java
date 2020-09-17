/*
 * @lc app=leetcode id=349 lang=java
 *
 * [349] Intersection of Two Arrays
 */

// @lc code=start
class Solution {
  ////////////////// first round(20200120)///////////////////////////////////
  ////////////////// first round(20200120)///////////////////////////////////
  //// ----------------start(Approach1)-------------------------------------
  // 20200120
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

  //// ---------------- end (Approach1)-------------------------------------
  //// ----------------start(Approach2)-------------------------------------
  // public int[] intersection(int[] nums1, int[] nums2) {
  public int[] intersection2(int[] nums1, int[] nums2) {
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
  //// ---------------- end (Approach2)-------------------------------------
  ////////////////// second round(20200915)///////////////////////////////////
  ////////////////// second round(20200915)///////////////////////////////////
  //// ----------------start(Approach2)-------------------------------------
  // 20200915.

  // 60/60 cases passed (6 ms)
  // Your runtime beats 17.94 % of java submissions
  // Your memory usage beats 74.9 % of java submissions (39.6 MB)

  public int[] intersection(int[] nums1, int[] nums2) {
    // public int[] intersection3(int[] nums1, int[] nums2) {
    List<Integer> lst = new ArrayList<>();
    Set<Integer> set = new HashSet<>();
    for (int num : nums1) {
      set.add(num);
    }
    for (int num : nums2) {
      if (set.contains(num)) {
        lst.add(num);
        set.remove(num);
      }
    }
    // return lst.toArray(new int[]{});
    return lst.stream().mapToInt(i -> i).toArray();
  }
  //// ---------------- end (Approach3)-------------------------------------
}
// @lc code=end
