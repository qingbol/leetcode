/*
 * @lc app=leetcode id=163 lang=java
 *
 * [163] Missing Ranges
 */

// @lc code=start
class Solution {
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

  // optimao solution
  public List<String> findMissingRanges(int[] nums, int lower, int upper) {
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
}
// @lc code=end
