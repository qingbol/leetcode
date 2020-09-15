/*
 * @lc app=leetcode id=229 lang=java
 *
 * [229] Majority Element II
 */

// @lc code=start
class Solution {
  ////////////////// first round(20200116)///////////////////////////////////
  ////////////////// first round(20200116)///////////////////////////////////
  //// ----------------start(Approach1)-------------------------------------
  // 20200116
  // public List<Integer> majorityElement(int[] nums) {
  public List<Integer> majorityElement1(int[] nums) {
    List<Integer> res = new ArrayList<>();
    if (null == nums) {
      return res;
    }
    int num1 = 0;
    int num2 = 0;
    int cnt1 = 0;
    int cnt2 = 0;
    for (int i = 0; i < nums.length; i++) {
      if (num1 == nums[i]) {
        cnt1++;
      } else if (num2 == nums[i]) {
        cnt2++;
      } else if (cnt1 == 0) {
        num1 = nums[i];
        cnt1 = 1;
      } else if (cnt2 == 0) {
        num2 = nums[i];
        cnt2 = 1;
      } else {
        cnt1--;
        cnt2--;
      }
    }

    cnt1 = 0;
    cnt2 = 0;
    for (int num : nums) {
      if (num1 == num) {
        cnt1++;
      } else if (num2 == num) {
        cnt2++;
      }
    }
    if (cnt1 > nums.length / 3) {
      res.add(num1);
    }
    if (cnt2 > nums.length / 3) {
      res.add(num2);
    }
    return res;
  }
  //// ---------------- end (Approach1)-------------------------------------
  ////////////////// second round(20200911)///////////////////////////////////
  ////////////////// second round(20200911)///////////////////////////////////
  //// ----------------start(Approach2)-------------------------------------
  // 20200911, can't solve it by myself.
  // refer to Approach 1: Boyer-Moore Voting Algorithm
  // 1. we only need four variables: two for holding two potential candidates and two for holding
  //// two corresponding counters.
  // 2. need this second pass since your array can have no majority elements at all!

  // 66/66 cases passed (3 ms)
  // Your runtime beats 58.1 % of java submissions
  // Your memory usage beats 25.39 % of java submissions (46.5 MB)

  public List<Integer> majorityElement(int[] nums) {
    // public List<Integer> majorityElement2(int[] nums) {
    int n = nums.length;
    List<Integer> res = new ArrayList<>();
    Integer candidateA = null;
    Integer candidateB = null;
    int countA = 0;
    int countB = 0;
    // 1. first pass to find out the potential candidates.
    for (int num : nums) {
      if (candidateA != null && candidateA == num) {
        // if (candidateA == num) {
        countA++;
      } else if (candidateB != null && candidateB == num) {
        countB++;
      } else if (countA == 0) {
        candidateA = num;
        countA++;
      } else if (countB == 0) {
        candidateB = num;
        countB++;
      } else {
        countA--;
        countB--;
      }
    }
    // System.out.format("A: %d, B: %d || countA: %d, countB: %d\n", candidateA, candidateB, countA,
    // countB);
    // 2. second pass to check the occurrence frequency of candidates
    countA = 0;
    countB = 0;
    for (int num : nums) {
      if (num == candidateA) {
        countA++;
      } else if (num == candidateB) {
        countB++;
      }
    }

    // System.out.format("A: %d, B: %d || countA: %d, countB: %d\n", candidateA, candidateB, countA,
    // countB);
    if (countA > n / 3) {
      res.add(candidateA);
    }
    if (countB > n / 3) {
      res.add(candidateB);
    }
    // System.out.format("res: %s\n", res);
    return res;
  }
  //// ---------------- end (Approach2)-------------------------------------
}
// @lc code=end
