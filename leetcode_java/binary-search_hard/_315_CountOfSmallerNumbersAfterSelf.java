/*
 * @lc app=leetcode id=315 lang=java
 *
 * [315] Count of Smaller Numbers After Self
 */

// @lc code=start
class Solution {
  ////////////////// first round(20200121)///////////////////////////////////
  ////////////////// first round(20200121)///////////////////////////////////
  //// ----------------start(Approach1)------------------------------------
  // 20200121.naive approach.
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

  //// ---------------- end (Approach1)------------------------------------
  //// ----------------start(Approach2)------------------------------------
  // binary sort
  // refer to
  //// https://leetcode.com/problems/count-of-smaller-numbers-after-self/discuss/76576/My-simple-AC-Java-Binary-Search-code

  // public List<Integer> countSmaller(int[] nums) {
  public List<Integer> countSmaller2(int[] nums) {
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
  //// ---------------- end (Approach2)-------------------------------------
  ////////////////// second round(20200916)///////////////////////////////////
  ////////////////// second round(20200916)///////////////////////////////////
  //// ----------------start(Approach3)-------------------------------------
  // 20200916
  // refer to leecode: 11ms JAVA solution using merge sort with explanation
  // https://leetcode.com/problems/count-of-smaller-numbers-after-self/discuss/76583/11ms-JAVA-solution-using-merge-sort-with-explanation

  // merge sort refer to <algorithm 4> :merge sort

  // 16/16 cases passed (7 ms)
  // Your runtime beats 68.13 % of java submissions
  // Your memory usage beats 19.87 % of java submissions (44.9 MB)

  public List<Integer> countSmaller(int[] nums) {
    // public List<Integer> countSmaller3(int[] nums) {
    int n = nums.length;
    int[] aux = new int[n];
    int[] index = new int[n];
    for (int i = 0; i < n; i++) {
      index[i] = i;
    }
    int[] count3 = new int[n];
    mergeSort3(nums, index, aux, 0, n - 1, count3);
    return Arrays.stream(count3).boxed().collect(Collectors.toList());
    // return Arrays.asList(count);
  }

  private void mergeSort3(int[] nums, int[] index, int[] aux, int lo, int hi, int[] count3) {
    if (lo >= hi)
      return;
    int mid = lo + (hi - lo) / 2;
    mergeSort3(nums, index, aux, lo, mid, count3);
    mergeSort3(nums, index, aux, mid + 1, hi, count3);
    merge3(nums, index, aux, lo, mid, hi, count3);
    // System.out.format("count: %s\n", Arrays.toString(count3));
    // System.out.format("index: %s\n", Arrays.toString(index));
  }

  private void merge3(int[] nums, int[] index, int[] aux, int lo, int mid, int hi, int[] count3) {
    int i = lo, j = mid + 1;
    int rightCount = 0;
    for (int k = lo; k <= hi; k++) {
      aux[k] = index[k];
    }
    for (int k = lo; k <= hi; k++) {
      if (i > mid) {
        index[k] = aux[j++];
        rightCount++;
      } else if (j > hi) {
        count3[aux[i]] += rightCount;
        index[k] = aux[i++];
        // count3[index[i]] += rightCount;
      } else {
        if (nums[aux[i]] > nums[aux[j]]) {
          // if (nums[index[i]] > nums[index[j]]) {
          index[k] = aux[j++];
          rightCount++;
        } else {
          // System.out.format("k: %d\n", k);
          count3[aux[i]] += rightCount;
          // count3[index[i]] += rightCount;
          index[k] = aux[i++];
        }
      }
      // System.out.format("index: %s\n", Arrays.toString(index));
    }
  }

  //// ---------------- end (Approach3)-------------------------------------
}
// @lc code=end
