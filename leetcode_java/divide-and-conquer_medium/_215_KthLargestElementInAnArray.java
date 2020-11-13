import java.util.Arrays;

/*
 * @lc app=leetcode id=215 lang=java
 *
 * [215] Kth Largest Element in an Array
 */
public class _215_KthLargestElementInAnArray {
  public static void main(String[] args) {
    int[] nums = new int[] {3, 2, 1, 5, 6, 4};
    // System.out.println("Befor sort: " + Arrays.toString(nums));
    Solution solution = new Solution();
    int res = solution.findKthLargest(nums, 2);
    // System.out.println("res: " + res);
  }
}


// @lc code=start
class Solution {
  ////////////////// first round(20200109)///////////////////////////////////
  ////////////////// first round(20200109)///////////////////////////////////
  //// ----------------start(Approach1)-------------------------------------
  // 20200109

  // public int findKthLargest(int[] nums, int k) {
  public int findKthLargest1(int[] nums, int k) {
    if (null == nums || 0 == nums.length) {
      return 0;
    }
    int pos = 0;
    int start = 0;
    int end = nums.length - 1;
    while (true) {
      pos = partition(nums, start, end);
      if (k == pos + 1) {
        return nums[pos];
      } else if (k > pos + 1) {
        start = pos + 1;
      } else {
        end = pos - 1;
      }
    }
  }

  private int partition(int[] arr, int left, int right) {
    int pivot = arr[right];
    int i = left;
    int j = left;
    while (i < right) {
      if (arr[i] > pivot) {
        swap(arr, i, j);
        j++;
      }
      i++;
    }
    swap(arr, j, right);
    return j;
  }

  //// ---------------- end (Approach1)-----------------------------
  //// ----------------start(Approach2)-----------------------------
  public int findKthLargest2(int[] nums, int k) {
    // public int findKthLargest(int[] nums, int k) {
    int[] kth = new int[1];
    findKth(nums, 0, nums.length - 1, k, kth);
    return kth[0];
  }

  public void findKth(int[] arr, int start, int end, int k, int[] kth) {
    // if (start > end) {
    // return;
    // }
    // int res = -1;
    int pivot = arr[end];
    // System.out.println("pivot: " + pivot);
    int i = start;
    int j = start;
    while (i < end) {
      if (arr[i] > pivot) {
        swap(arr, i, j);
        j++;
      }
      i++;
    }
    swap(arr, j, end);
    // System.out.println("jth: " + j);
    // System.out.println("arr: " + Arrays.toString(arr));
    // System.out.println("-----------------");

    if (j == k - 1) {
      // System.out.format("nums:%s\n", Arrays.toString(arr));
      kth[0] = arr[j];
      // System.out.println("Done: " + kth[0]);
    } else if (j > k - 1) {
      findKth(arr, start, j - 1, k, kth);
    } else if (j < k - 1) {
      findKth(arr, j + 1, end, k, kth);
    }
    // return -1;
    // return res;
  }

  private void swap(int[] arrs, int p, int q) {
    int tmp = arrs[p];
    arrs[p] = arrs[q];
    arrs[q] = tmp;
  }
  //// ---------------- end (Approach2)-----------------------------
  ////////////////// second round(20200907)///////////////////////////////////
  ////////////////// second round(20200907)///////////////////////////////////
  //// ----------------start(Approach3)-------------------------------------
  // 20200907, part by myself.

//   32/32 cases passed (16 ms)
// Your runtime beats 18.5 % of java submissions
// Your memory usage beats 42.09 % of java submissions (40.3 MB)

  public int findKthLargest(int[] nums, int k) {
    // public int findKthLargest3(int[] nums, int k) {
    int n = nums.length;
    int idx = helper3(nums, 0, n - 1, k);
    return nums[idx];
  }

  private int helper3(int[] nums, int lo, int hi, int target) {
    int idx = partition3(nums, lo, hi);

    if (idx == target - 1) {
      // System.out.format("return:%d\n", nums[idx]);
      // return nums[idx];
      return idx;
    } else if (idx > target - 1) {
      int ret = helper3(nums, lo, idx - 1, target);
      if (ret != -1)
        return ret;
    } else if (idx < target - 1) {
      int ret = helper3(nums, idx + 1, hi, target);
      if (ret != -1)
        return ret;
      // helper3(nums, idx + 1, hi, target - idx - 1);
    }
    // System.out.format("nums: %s\n", Arrays.toString(nums));
    return -1;
  }

  private int partition3(int[] nums, int lo, int hi) {
    int pivot = nums[hi];
    int left = lo;
    int right = lo;
    while (right < hi) {
      // if (nums[right] < pivot) {
      if (nums[right] > pivot) {
        swap(nums, left, right);
        left++;
      }
      right++;
    }

    swap(nums, left, hi);
    return left;
  }
  //// ---------------- end (Approach3)-----------------------------
}
// @lc code=end
