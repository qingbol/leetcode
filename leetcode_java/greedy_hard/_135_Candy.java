/*
 * @lc app=leetcode id=135 lang=java
 *
 * [135] Candy
 */

// @lc code=start
class Solution {
  //// ---------------start(Approach1)-------------
  // 20200323,by myself
  // similar to slop analysis, but with wrong logic
  // wrong. 19/48 cases passed (N/A). [1,3,2,2,1] Answer 10, Expected Answer 7
  public int candy1(int[] ratings) {
    if (ratings.length == 0) {
      return 0;
    }
    int n = ratings.length;
    int[] nums = new int[n];
    nums[0] = 1;
    int min = nums[0];
    int sum = nums[0];

    // the logic here is hard to cal the sum later.
    for (int i = 1; i < n; i++) {
      if (ratings[i] > ratings[i - 1]) {
        nums[i] = nums[i - 1] + 1;
      } else if (ratings[i] < ratings[i - 1]) {
        nums[i] = nums[i - 1] - 1;
      } else {
        nums[i] = 1;
      }
      min = Math.min(min, nums[i]);
      sum += nums[i];
    }

    // the logic here is wrong.
    if (min < 1) {
      int diff = 1 - min;
      sum += diff * n;
    }
    return sum;

  }

  //// --------------- end (Approach1)-------------
  //// ---------------start(Approach2)-------------
  // 20200323. forward traversal + backward traversal
  // Your runtime beats 96.12 % of java submissions
  public int candy2(int[] ratings) {
    int n = ratings.length;
    if (n <= 1) {
      return ratings.length;
    }
    int[] candy = new int[n];
    Arrays.fill(candy, 1);

    // forward traversal to check the left neighbor
    for (int i = 1; i < n; i++) {
      if (ratings[i - 1] < ratings[i]) {
        candy[i] = candy[i - 1] + 1;
        // candy[i]++;
      }
    }
    // backward traversal to check the right neighbor
    int sum = candy[n - 1];
    for (int i = n - 2; i >= 0; i--) {
      if (ratings[i] > ratings[i + 1] && candy[i] <= candy[i + 1]) {
        candy[i] = candy[i + 1] + 1;
      }
      sum += candy[i];
    }

    return sum;
  }

  //// --------------- end (Approach2)-------------
  //// ---------------start(Approach3)-------------
  // 20200323. by slop anaylysis
  // brilliant idea.
  //// https://leetcode.com/problems/candy/discuss/135698/Simple-solution-with-one-pass-using-O(1)-space
  // Your runtime beats 96.12 % of java submissions
  public int candy(int[] ratings) {
    int n = ratings.length;
    if (ratings.length == 0) {
      return 0;
    }
    int res = 1;
    int up = 1;
    int peak = up;
    int down = 0;

    for (int i = 1; i < n; i++) {
      if (ratings[i] > ratings[i - 1]) {
        down = 0;
        up++;
        // this is very important, peak++ is wrong, because peak is not updated
        // when go down.
        peak = up;
        // peak++;
        res += up;
      } else if (ratings[i] < ratings[i - 1]) {
        up = 1;
        down++;
        res += down;

        if (peak <= down) {
          res++;
        }
      } else {
        up = 1;
        peak = up;
        down = 0;
        res++;
      }
    }

    return res;
  }
  //// --------------- end (Approach3)-------------
}
// @lc code=end
