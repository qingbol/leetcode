
import java.util.Arrays;

public class _0300_LongestIncreasingSubsequence {
  /** Brute force - recursion */
  public static int lengthOfLisBruteForce(int[] nums) {
    return lengthOfLisBruteForce(nums, Integer.MIN_VALUE, 0);
  }

  public static int lengthOfLisBruteForce(int[] nums, int prev, int curpos) {
    if (curpos == nums.length) {
      return 0;
    }
    int taken = 0;
    if (nums[curpos] > prev) {
      taken = 1 + lengthOfLisBruteForce(nums, nums[curpos], curpos + 1);
    }
    int nottaken = lengthOfLisBruteForce(nums, prev, curpos + 1);
    System.out.println(Math.max(taken, nottaken));
    return Math.max(taken, nottaken);
  }

  public static int lengthOfLisDp(int[] nums) {
    if (nums.length == 0) {
      return 0;
    }
    int[] dp = new int[nums.length];
    dp[0] = 1;
    int maxans = 1;
    for (int i = 1; i < dp.length; i++) {
      int maxval = 0;
      for (int j = 0; j < i; j++) {
        if (nums[i] > nums[j]) {
          maxval = Math.max(maxval, dp[j]);
        }
      }
      dp[i] = maxval + 1;
      System.out.println(Arrays.toString(dp));
      maxans = Math.max(maxans, dp[i]);
    }
    return maxans;
  }

  /** binary insert method */
  public static int lengthOfLIS1(int[] arr) {
    int[] tails = new int[arr.length];
    int res = 0;
    for (int elem : arr) {
      int i = 0, j = res;
      while (i != j) {
        int mid = (i + j) / 2;
        if (tails[mid] < elem) {
          i = mid + 1;
        } else {
          j = mid;
        }
      }
      tails[i] = elem;
      System.out.println(Arrays.toString(tails));
      if (res == i)
        ++res;
    }
    return res;
  }

  public static int lengthOfLIS2(int[] nums) {
    int[] dp = new int[nums.length];
    int len = 0;
    for (int num : nums) {
      int i = Arrays.binarySearch(dp, 0, len, num);
      if (i < 0) {
        i = -(i + 1);
      }
      dp[i] = num;
      if (i == len) {
        len++;
      }
      System.out.println(Arrays.toString(dp));
    }
    return len;
  }

  public static void main(String[] args) {
    int[] arr = new int[] { 8, 9, 5, 10, 11 };
    // int[] arr = new int[] { 8, 2, 9, 3, 5, 10, 6, 11, 7, };
    // lengthOfLisBruteForce(arr);
    // lengthOfLIS2(arr);
    lengthOfLisDp(arr);
  }
}