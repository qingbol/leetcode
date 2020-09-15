/*
 * @lc app=leetcode id=128 lang=java
 *
 * [128] Longest Consecutive Sequence
 */

// @lc code=start
class Solution {
  ////////////////// first round(20200116)///////////////////////////////////
  ////////////////// first round(20200116)///////////////////////////////////
  //// ----------------start(Approach1)-------------------------------------
  // 20200116

  public int longestConsecutive1(int[] nums) {
    if (null == nums || 0 == nums.length) {
      return 0;
    }
    List<List<Integer>> lst = new ArrayList<>();
    int max = 0;
    int min = 0;
    for (int i = 0; i < nums.length; i++) {
      max = Math.max(max, nums[i]);
      min = Math.min(min, nums[i]);
    }
    int bucketSize = 1 + (max - min) / nums.length;
    for (int i = 0; i < bucketSize; i++) {
      lst.add(new ArrayList<>());
    }

    // scatter
    int bucket = -1;
    for (int i = 0; i < nums.length; i++) {
      // System.out.format("i: %d\n", i);
      bucket = (nums[i] - min) / nums.length;
      // System.out.format("bucket: %d\n", bucket);
      lst.get(bucket).add(nums[i]);
    }

    // sort
    List<Integer> tmp = new ArrayList<>();
    for (int i = 0; i < lst.size(); i++) {
      // System.out.format("i: %d\n", i);
      Collections.sort(lst.get(i));
      tmp.addAll(lst.get(i));
    }
    // System.out.format("tmp: %s", tmp);

    // gathering
    int cnt = 1;
    int res = 1;
    int start = tmp.get(0);
    for (int i = 1; i < tmp.size(); i++) {
      if (tmp.get(i) == tmp.get(i - 1))
        continue;
      if (tmp.get(i) == start + cnt) {
        cnt++;
        res = Math.max(res, cnt);
      } else {
        start = tmp.get(i);
        cnt = 1;
      }
    }
    return res;
  }

  //// ---------------- end (Approach1)-------------------------------------
  //// ----------------start(Approach2)-------------------------------------
  // hashset

  // public int longestConsecutive(int[] nums) {
  public int longestConsecutive2(int[] nums) {
    if (null == nums || 0 == nums.length) {
      return 0;
    }
    Set<Integer> set = new HashSet<>();
    for (int num : nums) {
      set.add(num);
    }
    int max = 1;
    int cnt = 1;
    for (int num : nums) {
      if (set.remove(num)) {
        int val = num;
        cnt = 1;
        while (set.remove(val - 1)) {
          val--;
          cnt++;
        }
        val = num;
        while (set.remove(val + 1)) {
          val++;
          cnt++;
        }
      }
      max = Math.max(max, cnt);
    }
    return max;
  }
  //// ---------------- end (Approach2)-------------------------------------
  ////////////////// second round(20200913)///////////////////////////////////
  ////////////////// second round(20200913)///////////////////////////////////
  //// ----------------start(Approach3)-------------------------------------
  // 20200913, cant come up a soluiton by myself.
  // refer to leetcode:Approach 2: Sorting

  // 68/68 cases passed (4 ms)
  // Your runtime beats 71.32 % of java submissions
  // Your memory usage beats 91.41 % of java submissions (39.5 MB)

  public int longestConsecutive(int[] nums) {
    // public int longestConsecutive3(int[] nums) {
    int n = nums.length;
    if (n == 0)
      return 0;
    // 1. buid hashset
    Set<Integer> set = new HashSet<>();
    for (int num : nums) {
      set.add(num);
    }
    // 2.
    int res = 0;
    for (int num : nums) {
      if (!set.contains(num - 1)) {
        int cur = num;
        int cnt = 1;
        while (set.contains(cur + 1)) {
          cur += 1;
          cnt += 1;
        }
        res = Math.max(res, cnt);
      }
    }
    return res;
  }
  //// ---------------- end (Approach3)-------------------------------------
}
// @lc code=end
