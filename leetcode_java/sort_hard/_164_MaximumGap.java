/*
 * @lc app=leetcode id=164 lang=java
 *
 * [164] Maximum Gap
 */

// @lc code=start
class Solution {
  ////////////////// first round(20200111)///////////////////////////////////
  ////////////////// first round(20200111)///////////////////////////////////
  //// ----------------start(Approach1)-------------------------------------
  // 20200111

  public int maximumGap1(int[] nums) {
    if (null == nums || 0 == nums.length) {
      return 0;
    }
    List<List<Integer>> bucket = new ArrayList<>();
    int max = Integer.MIN_VALUE;
    int min = Integer.MAX_VALUE;
    for (int num : nums) {
      max = Math.max(max, num);
      min = Math.min(min, num);
    }
    int bucketSize = nums.length;
    int bucketCount = (max - min) / bucketSize + 1;
    for (int i = 0; i < bucketCount; i++) {
      bucket.add(new ArrayList<>());
    }

    // scatter
    int index = 0;
    for (int num : nums) {
      index = (num - min) / nums.length;
      bucket.get(index).add(num);
    }

    // sort
    for (int i = 0; i < bucketSize; i++) {
      Collections.sort(bucket.get(i));
    }

    //
    // System.out.println("bucket: " + bucket.toString());
    // System.out.println("bucket: " + Arrays.toString(bucket.toArray()));

    int maxGap = 0;
    int tmp = -1;
    for (int i = 0; i < bucketCount; i++) {
      for (int j = 0; j < bucket.get(i).size(); j++) {
        // System.out.println("bucket: " + bucket.get(i).get(j));
        if (-1 != tmp) {
          maxGap = Math.max(maxGap, bucket.get(i).get(j) - tmp);
        }
        tmp = bucket.get(i).get(j);
      }
    }
    return maxGap;
  }
  //// ---------------- end (Approach1)-------------------------------------
  //// ----------------start(Approach2)-------------------------------------
  // optimal

  // public int maximumGap(int[] nums) {
  public int maximumGap2(int[] nums) {
    if (null == nums || nums.length < 2) {
      return 0;
    }
    int max = Integer.MIN_VALUE;
    int min = Integer.MAX_VALUE;
    for (int num : nums) {
      max = Math.max(max, num);
      min = Math.min(min, num);
    }
    int gap = (int) Math.ceil((double) (max - min) / (nums.length - 1));
    int[] bucketMin = new int[nums.length - 1];
    int[] bucketMax = new int[nums.length - 1];
    Arrays.fill(bucketMin, Integer.MAX_VALUE);
    Arrays.fill(bucketMax, Integer.MIN_VALUE);

    // scatter
    for (int num : nums) {
      if (min == num || max == num)
        continue;
      int index = (num - min) / gap;
      bucketMin[index] = Math.min(bucketMin[index], num);
      bucketMax[index] = Math.max(bucketMax[index], num);
    }
    // System.out.println("bucketMin: " + Arrays.toString(bucketMin));
    // System.out.println("bucketMax: " + Arrays.toString(bucketMax));

    // gather
    int res = 0;
    int preMax = min;
    for (int i = 0; i < nums.length - 1; i++) {
      if (Integer.MAX_VALUE == bucketMin[i] || Integer.MIN_VALUE == bucketMax[i])
        continue;
      res = Math.max(res, bucketMin[i] - preMax);
      preMax = bucketMax[i];
    }
    res = Math.max(res, max - preMax);

    return res;
  }
  //// ---------------- end (Approach2)-------------------------------------
  ////////////////// second round(20200907)///////////////////////////////////
  ////////////////// second round(20200907)///////////////////////////////////
  //// ----------------start(Approach3)-------- -----------------------------
  // 20200907
  // cant come up with a solution by myself.
  // refer to leetcode standard solution.
  // Approach 3: Buckets and The Pigeonhole Principle
  // very tricky solution

  // 18/18 cases passed (2 ms)
  // Your runtime beats 96.75 % of java submissions
  // Your memory usage beats 61.39 % of java submissions (39.8 MB)

  public int maximumGap(int[] nums) {
    // public int maximumGap3(int[] nums) {
    int n = nums.length;
    if (n < 2)
      return 0;
    // 1. get max and min val in nums
    int max = Integer.MIN_VALUE;
    int min = Integer.MAX_VALUE;
    for (int num : nums) {
      if (num > max)
        max = num;
      if (num < min)
        min = num;
    }
    // 2. design bucketSize
    int bucketSize = Math.max(1, (max - min) / (n - 1));
    // int bucketSize = (max - min) / (n - 1);
    int bucketCount = (max - min) / bucketSize + 1;
    int[] bucketMin = new int[bucketCount];
    Arrays.fill(bucketMin, Integer.MAX_VALUE);
    int[] bucketMax = new int[bucketCount];
    Arrays.fill(bucketMax, Integer.MIN_VALUE);
    // 3. distribute elements to bucket
    for (int num : nums) {
      int idx = (num - min) / bucketSize;
      bucketMin[idx] = Math.min(bucketMin[idx], num);
      bucketMax[idx] = Math.max(bucketMax[idx], num);
    }

    // 4. cal the gap
    int gap = 0;
    int preMax = min;
    for (int i = 0; i < bucketCount; i++) {
      if (bucketMin[i] == Integer.MAX_VALUE || bucketMax[i] == Integer.MIN_VALUE)
        continue;
      gap = Math.max(gap, bucketMin[i] - preMax);
      preMax = bucketMax[i];
    }
    gap = Math.max(gap, max - preMax);
    return gap;
  }

  //// ---------------- end (Approach3)-------------------------------------
}
// @lc code=end
