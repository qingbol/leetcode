/*
 * @lc app=leetcode id=4 lang=java
 *
 * [4] Median of Two Sorted Arrays
 */

// @lc code=start
class Solution {
  public double findMedianSortedArrays1(int[] nums1, int[] nums2) {
    int m = nums1.length;
    int n = nums2.length;
    int len = m + n;
    int halfLen = (m + n + 1) / 2;
    // int halfLen = (m + n) / 2;
    if (m > n) {
      return findMedianSortedArrays(nums2, nums1);
    }
    // System.out.format("m: %d, n: %d\n", m, n);
    int left = 0;
    int right = m;
    while (left <= right) {
      int mid1 = left + (right - left) / 2;
      int mid2 = halfLen - mid1;
      // System.out.format("mid1: %d, mid2: %d\n", mid1, mid2);

      if (mid1 > left && nums1[mid1 - 1] > nums2[mid2]) {
        right = mid1 - 1;
      } else if (mid1 < right && nums2[mid2 - 1] > nums1[mid1]) {
        left = mid1 + 1;
      } else {
        int maxLeft = 0;
        if (mid1 == 0) {
          maxLeft = nums2[mid2 - 1];
        } else if (mid2 == 0) {
          maxLeft = nums1[mid1 - 1];
        } else {
          maxLeft = Math.max(nums1[mid1 - 1], nums2[mid2 - 1]);
        }
        if ((m + n) % 2 == 1) {
          return maxLeft;
          // return minRight;
        }

        int minRight = 0;
        if (mid1 == m) {
          minRight = nums2[mid2];
        } else if (mid2 == n) {
          minRight = nums1[mid1];
        } else {
          minRight = Math.min(nums1[mid1], nums2[mid2]);
        }
        return (maxLeft + minRight) / 2.0;
      }
    }
    return 0.0;
  }

  // method2
  public double findMedianSortedArrays(int[] nums1, int[] nums2) {
    int m = nums1.length;
    int n = nums2.length;

    if (m > n) {
      return findMedianSortedArrays(nums2, nums1);
    }

    int leftPartInNum1 = 0;
    int leftPartInNum2 = 0;
    int leftCutPoint = 0;
    int rightCutPoint = m;
    while (leftPartInNum1 <= m) {
      leftPartInNum1 = leftCutPoint + (rightCutPoint - leftCutPoint) / 2;
      leftPartInNum2 = (m + n) / 2 - leftPartInNum1;
      // System.out.format("left1: %d, left2: %d\n", leftPartInNum1, leftPartInNum2);
      int leftMaxInNum1 = (leftPartInNum1 == 0) ? Integer.MIN_VALUE : nums1[leftPartInNum1 - 1];
      int leftMaxInNum2 = (leftPartInNum2 == 0) ? Integer.MIN_VALUE : nums2[leftPartInNum2 - 1];
      int rightMinInNum1 = (leftPartInNum1 == m) ? Integer.MAX_VALUE : nums1[leftPartInNum1];
      int rightMinInNum2 = (leftPartInNum2 == n) ? Integer.MAX_VALUE : nums2[leftPartInNum2];

      int leftMax = Math.max(leftMaxInNum1, leftMaxInNum2);
      int rightMin = Math.min(rightMinInNum1, rightMinInNum2);
      // System.out.format("leftMax: %d, rightMin: %d\n", leftMax, rightMin);

      if (leftMaxInNum1 > rightMinInNum2) {
        rightCutPoint = leftPartInNum1 - 1;
      } else if (leftMaxInNum2 > rightMinInNum1) {
        leftCutPoint = leftPartInNum1 + 1;
      } else {
        if ((m + n) % 2 == 0) {
          return (leftMax + rightMin) / 2.0;
        } else {
          return rightMin;
        }
      }
    }
    return -1;
  }
}
// @lc code=end
