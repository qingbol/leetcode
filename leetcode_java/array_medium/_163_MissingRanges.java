/*
 * @lc app=leetcode id=163 lang=java
 *
 * [163] Missing Ranges
 */

// @lc code=start
class Solution {
  ////////////////// first round(20200217)///////////////////////////////////
  ////////////////// first round(20200217)///////////////////////////////////
  // ------------start(Approach 1)------------------------------------------
  // 20200217
  // by myself, very ugly
  public List<String> findMissingRanges1(int[] nums, int lower, int upper) {
    List<String> lst = new ArrayList<>();

    // check null inpute
    if (null == nums || nums.length == 0) {
      if (upper != lower && upper > lower + 1) {
        lst.add((lower) + "->" + (upper));
      } else if (upper == lower) {
        lst.add(upper + "");
      }
      return lst;
    }

    int l = 0;
    int r = 0;

    // check lower
    if (lower != nums[l] && lower + 1 < nums[l]) {
      lst.add((lower) + "->" + (nums[l] - 1));
    } else if (lower + 1 == nums[l]) {
      lst.add(lower + "");
    }

    // check other part
    while (r < nums.length - 1) {
      // while (r < nums.length && nums[r] < lower) {
      // r++;
      // }
      l = r;
      while (r < nums.length - 1 && nums[r] <= upper && nums[r] >= nums[r + 1] - 1) {
        r++;
        l++;
      }
      if (r < nums.length - 1) {
        r++;
      }
      // System.out.format("l: %d, r: %d\n", l, r);
      if (nums[r] != nums[l] && nums[r] - 2 > nums[l]) {
        lst.add((nums[l] + 1) + "->" + (nums[r] - 1));
      } else if (nums[r] - 2 == nums[l]) {
        lst.add((nums[l] + 1) + "");
      }
    }

    // check upper
    if (upper != nums[r] && upper - 1 > nums[r]) {
      lst.add((nums[r] + 1) + "->" + (upper));
    } else if (upper == nums[r] + 1) {
      lst.add(upper + "");
    }

    return lst;
  }

  // ------------ end (Approach 1)------------------------------------------
  // ------------start(Approach 2)------------------------------------------
  // optimal solution
  //https://leetcode.com/problems/missing-ranges/discuss/50476/Accepted-Java-solution-with-explanation/266314

  // public List<String> findMissingRanges(int[] nums, int lower, int upper) {
  public List<String> findMissingRanges2(int[] nums, int lower, int upper) {
    List<String> lst = new ArrayList<>();

    // when nums is null
    if (null == nums || 0 == nums.length) {
      lst.add(createRange(lower, upper));
      return lst;
    }

    // check [lower, nums[0]]
    if (nums[0] > lower) {
      lst.add(createRange(lower, nums[0] - 1));
    }

    for (int i = 0; i < nums.length - 1; i++) {
      if (nums[i + 1] != nums[i] && nums[i + 1] > nums[i] + 1) {
        lst.add(createRange(nums[i] + 1, nums[i + 1] - 1));
      }
    }

    // check [nums[nums.length - 1], upper]
    if (upper > nums[nums.length - 1]) {
      lst.add(createRange(nums[nums.length - 1] + 1, upper));
    }
    return lst;
  }

  private String createRange(int left, int right) {
    return left == right ? String.valueOf(left) : left + "->" + right;
  }
  // ------------ end (Approach 2)------------------------------------------
  ////////////////// second round(20200909)///////////////////////////////////
  ////////////////// second round(20200909)///////////////////////////////////
  // ------------start(Approach 3)------------------------------------------
  // 20200909,
  // refer to
  // https://leetcode.com/problems/missing-ranges/discuss/50476/Accepted-Java-solution-with-explanation/239505

//   40/40 cases passed (4 ms)
// Your runtime beats 87.67 % of java submissions
// Your memory usage beats 60.88 % of java submissions (38 MB)

  public List<String> findMissingRanges(int[] nums, int lower, int upper) {
    // public List<String> findMissingRanges3(int[] nums, int lower, int upper) {
    List<String> res = new ArrayList<>();
    // int next = lower;
    long next = lower;
    for (int num : nums) {
      if (num < next)
        continue;
      if (num == next) {
        next++;
        continue;
      }

      res.add(createRange(next, (long)num - 1));
        next = (long)num + 1;
    }

    if (next <= upper)
      res.add(createRange(next, (long)upper));

    return res;
  }

  private String createRange(long left, long right) {
    return left == right ? String.valueOf(left) : String.format("%d->%d", left, right);
  }
  // ------------ end (Approach 3)------------------------------------------
}
// @lc code=end
