/*
 * @lc app=leetcode id=384 lang=java
 *
 * [384] Shuffle an Array
 */

// @lc code=start
////-----------------start(Approach1)----------------------------------
//by myself
//10/10 cases passed (169 ms)
// Your runtime beats 15.83 % of java submissions
// public class Solution {
class Solution1 {
  private int[] nums;
  Random rand = new Random(47);

  // public Solution(int[] nums) {
  public Solution1(int[] nums) {
    this.nums = Arrays.copyOfRange(nums, 0, nums.length);
  }

  /** Resets the array to its original configuration and return it. */
  public int[] reset() {
    System.out.println(Arrays.toString(nums));
    return nums;
  }

  /** Returns a random shuffling of the array. */
  public int[] shuffle() {
    int[] shuffledNums = Arrays.copyOfRange(nums, 0, nums.length);
    int n = shuffledNums.length;

    for (int i = 0; i < n; i++) {
      int idx = i + rand.nextInt(n - i);
      int tmp = shuffledNums[i];
      shuffledNums[i] = shuffledNums[idx];
      shuffledNums[idx] = tmp;
    }
    return shuffledNums;
  }
}

//// ----------------- end (Approach1)----------------------------------
//// -----------------start(Approach1)----------------------------------
//leetcode standard solution
//10/10 cases passed (159 ms)
// Your runtime beats 19.64 % of java submissions
public class Solution {
  // class Solution2 {
  int[] arr;
  int[] original;
  Random rand

  public Solution(int[] nums) {
    // public Solution2(int[] nums) {
    arr = nums;
    original = nums.clone();
    rand = new Random(47)
  }

  /** Resets the array to its original configuration and return it. */
  public int[] reset() {
    arr = original;
    original = original.clone();
    return arr;
  }

  /** Returns a random shuffling of the array. */
  public int[] shuffle() {
    int n = arr.length;
    for (int i = 0; i < n; i++) {
      int idx = rand.nextInt(n - i) + i;
      int tmp = arr[i];
      arr[i] = arr[idx];
      arr[idx] = tmp; 
    }
    return arr;
  }
}
//// ----------------- end (Approach1)----------------------------------

// * Your Solution object will be instantiated and called as such:
// * Solution obj = new Solution(nums);
// * int[] param_1 = obj.reset();
// * int[] param_2 = obj.shuffle();
// @lc code=end
