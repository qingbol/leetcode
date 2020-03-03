/*
 * @lc app=leetcode id=384 lang=cpp
 *
 * [384] Shuffle an Array
 */

// @lc code=start
class Solution {
  public:
  vector<int> input;
  vector<int> result;
  Solution(vector<int> &nums) {
    input = nums;
    for (auto num : nums) {
      result.emplace_back(num);
    }
    std::srand(time(nullptr));
    // std::srand(time(nullptr));
    // for (auto res : result) {
    //   std::cout << res << " ";
    // }
    // std::cout << std::endl;
  }

  /** Resets the array to its original configuration and return it. */
  vector<int> reset() {
    return input;
  }

  /** Returns a random shuffling of the array. */
  vector<int> shuffle1() {
    for (int i = 0; i < result.size(); ++i) {
      int pos = rand() % (result.size() - i);
      std::swap(result[i], result[i + pos]);
    }
    return result;
  }
  vector<int> shuffle() {
    if (result.size() > 0) {
      int i = rand() % result.size();
      int j = rand() % result.size();
      int tmp = result[i];
      result[i] = result[j];
      result[j] = tmp;
    }
    return result;
  }
};

/**
 * Your Solution object will be instantiated and called as such:
 * Solution* obj = new Solution(nums);
 * vector<int> param_1 = obj->reset();
 * vector<int> param_2 = obj->shuffle();
 */
// @lc code=end
