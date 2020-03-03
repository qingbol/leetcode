/*
 * @lc app=leetcode id=164 lang=java
 *
 * [164] Maximum Gap
 */

// @lc code=start
class Solution {
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
    int bucketSize = (max - min) / nums.length + 1;
    for (int i = 0; i < bucketSize; i++) {
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
    for (int i = 0; i < bucketSize; i++) {
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

  // optimal
  public int maximumGap(int[] nums) {
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
}
// @lc code=end
