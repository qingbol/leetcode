/*
 * @lc app=leetcode id=381 lang=cpp
 *
 * [381] Insert Delete GetRandom O(1) - Duplicates allowed
 */

// @lc code=start
class RandomizedCollection {
  public:
  /** Initialize your data structure here. */
  RandomizedCollection() {
    srand(time(nullptr));
  }

  /** Inserts a value to the collection. Returns true if the collection did not already contain the specified element. */
  bool insert(int val) {
    umap[val].insert(vec.size());
    vec.emplace_back(val);
    return umap[val].size() == 1;
  }

  /** Removes a value from the collection. Returns true if the collection contained the specified element. */
  bool remove(int val) {
    if (0 == umap.count(val)) {
      return false;
    }
    int last = vec.back();
    int pos = *(umap[val].rbegin());
    umap[last].erase(*(umap[last].rbegin()));
    umap[last].insert(pos);
    vec[pos] = last;
    vec.pop_back();
    if (umap[val].size() > 1) {
      umap[val].erase(pos);
    } else {
      umap.erase(val);
    }
    return true;
  }

  /** Get a random element from the collection. */
  int getRandom() {
    return vec[rand() % vec.size()];
  }

  private:
  vector<int> vec;
  unordered_map<int, set<int>> umap;
};

/**
 * Your RandomizedCollection object will be instantiated and called as such:
 * RandomizedCollection* obj = new RandomizedCollection();
 * bool param_1 = obj->insert(val);
 * bool param_2 = obj->remove(val);
 * int param_3 = obj->getRandom();
 */
// @lc code=end
