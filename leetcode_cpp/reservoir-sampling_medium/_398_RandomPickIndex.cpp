/*
 * @lc app=leetcode id=398 lang=cpp
 *
 * [398] Random Pick Index
 */

// @lc code=start
class Solution {
  public:
  Solution(vector<int> &nums) {
    this->nums = nums;
    // srand(time(nullptr));
  }

  int pick(int target) {
    int count = 0;
    int res = -1;
    for (int i = 0; i < nums.size(); ++i) {
      if (target != nums[i]) {
        continue;
      }
      if (-1 == res) {
        res = i;
        count++;
      } else {
        count++;
        if (rand() % count == 0) {
          res = i;
        }
      }
    }
    return res;
  }

  private:
  vector<int> nums;
};

/**
 * Your Solution object will be instantiated and called as such:
 * Solution* obj = new Solution(nums);
 * int param_1 = obj->pick(target);
 */
// @lc code=end
