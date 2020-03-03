/*
 * @lc app=leetcode id=60 lang=java
 *
 * [60] Permutation Sequence
 */

// @lc code=start
class Solution {
  public String getPermutation(int n, int k) {
    int[] factorialBase = new int[n];
    List<Integer> nums = new ArrayList<>();
    // generate base nums
    for (int i = 1; i <= n; i++) {
      nums.add(i);
    }
    // generate factorial base
    factorialBase[0] = 1;
    for (int i = 1; i < n; i++) {
      factorialBase[i] = factorialBase[i - 1] * i;
    }

    // permutation number - 1
    k--;

    // Generate factorial number system representation
    StringBuilder sb = new StringBuilder();
    for (int i = n - 1; i >= 0; i--) {
      int idx = k / factorialBase[i];
      k -= idx * factorialBase[i];
      sb.append(nums.get(idx));
      nums.remove(idx);
    }
    return sb.toString();
  }
}
// @lc code=end
