/*
 * @lc app=leetcode id=88 lang=java
 *
 * [88] Merge Sorted Array
 */

// @lc code=start
class Solution {
  public void merge1(int[] nums1, int m, int[] nums2, int n) {
    // System.out.println(nums1.length + " " + m);
    int[] tmp = new int[m + n];
    int i = 0;
    int j = 0;
    int k = 0;
    while (i < m && j < n) {
      if (nums1[i] > nums2[j]) {
        tmp[k++] = nums2[j++];
      } else {
        tmp[k++] = nums1[i++];
      }
    }

    while (i < m) {
      tmp[k++] = nums1[i++];
    }

    while (j < n) {
      tmp[k++] = nums2[j++];
    }
    System.arraycopy(tmp, 0, nums1, 0, m + n);
  }

  public void merge(int[] nums1, int m, int[] nums2, int n) {
    int i = m - 1;
    int j = n - 1;
    int k = m + n - 1;
    while (i >= 0 && j >= 0) {
      nums1[k--] = nums1[i] < nums2[j] ? nums2[j--] : nums1[i--];
    }

    while (j >= 0) {
      nums1[k--] = nums2[j--];
    }

  }
}
// @lc code=end
