/*
 * @lc app=leetcode id=88 lang=java
 *
 * [88] Merge Sorted Array
 */

// @lc code=start
class Solution {
  ////////////////// first round(20200109)///////////////////////////////////
  ////////////////// first round(20200109)///////////////////////////////////
  //// ----------------start(Approach1)-------------------------------------
  // 20200109

  public void merge1(int[] nums1, int m, int[] nums2, int n) {
    // public void merge(int[] nums1, int m, int[] nums2, int n) {
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

  //// ---------------- end (Approach1)-------------------------------------
  //// ----------------start(Approach2)-------------------------------------
  // tricky

  // public void merge(int[] nums1, int m, int[] nums2, int n) {
  public void merge2(int[] nums1, int m, int[] nums2, int n) {
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
  //// ---------------- end (Approach2)-------------------------------------
  ////////////////// second round(20200907)///////////////////////////////////
  ////////////////// second round(20200907)///////////////////////////////////
  //// ----------------start(Approach3)-------------------------------------
  // 20200907
  // can't come up with myself

  // 59/59 cases passed (0 ms)
  // Your runtime beats 100 % of java submissions
  // Your memory usage beats 87.46 % of java submissions (39.4 MB)

  // public void merge3(int[] nums1, int m, int[] nums2, int n) {
  public void merge(int[] nums1, int m, int[] nums2, int n) {
    int idx1 = m - 1;
    int idx2 = n - 1;
    int idx = m + n - 1;
    while (idx1 >= 0 && idx2 >= 0) {
      nums1[idx--] = nums1[idx1] >= nums2[idx2] ? nums1[idx1--] : nums2[idx2--];
    }

    while (idx2 >= 0) {
      nums1[idx--] = nums2[idx2--];
    }
  }
  //// ---------------- end (Approach3)-------------------------------------

}
// @lc code=end
