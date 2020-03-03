/*
 * @lc app=leetcode id=315 lang=java
 *
 * [315] Count of Smaller Numbers After Self
 */

// @lc code=start
class Solution {
  public List<Integer> countSmaller1(int[] nums) {
    int[] counts = new int[nums.length];
    for (int i = 0; i < nums.length - 1; i++) {
      for (int j = i + 1; j < nums.length; j++) {
        if (nums[i] > nums[j]) {
          counts[i]++;
        }
      }
    }
    Integer[] cnts = new Integer[counts.length];
    int k = 0;
    for (int cnt : counts) {
      cnts[k++] = Integer.valueOf(cnt);
    }
    return Arrays.asList(cnts);
  }

  // binary sort
  public List<Integer> countSmaller(int[] nums) {
    Integer[] cnts = new Integer[nums.length];
    List<Integer> lst = new ArrayList<>();
    // int[] tmp = new int[nums.length];
    for (int i = nums.length - 1; i >= 0; i--) {
      int idx = findIdx(lst, nums[i]);
      cnts[i] = idx;
      lst.add(idx, nums[i]);
      // System.out.format("idx:%d, lst:%s\n", idx, lst);
    }
    // System.out.println("lst:" + lst);
    return Arrays.asList(cnts);
  }

  private int findIdx(List<Integer> list, int target) {
    int lo = 0;
    int hi = list.size() - 1;
    while (lo <= hi) {
      int mid = lo + (hi - lo) / 2;
      int midVal = list.get(mid);
      // System.out.format("lo:%d, mid:%d, hi:%d, [%d, %d, %d]\n", lo, mid, hi,
      // list.get(lo), list.get(mid), list.get(hi));
      // if (midVal == target) {
      // return mid;
      if (midVal >= target) {
        hi = mid - 1;
      } else {
        lo = mid + 1;
      }
    }
    return lo;
  }
}
// @lc code=end
