/*
 * @lc app=leetcode id=211 lang=java
 *
 * [211] Add and Search Word - Data structure design
 */

// @lc code=start
class WordDictionary {
  //// -----------------------start(Approach1)----------------------
  // by meself. can only handle the scenario when there's no . in addWord.
  Set<String> set;

  /** Initialize your data structure here. */
  public WordDictionary() {
    set = new HashSet<>();
  }

  /** Adds a word into the data structure. */
  public void addWord(String word) {
    set.add(word);
    for (int i = 0; i < word.length(); i++) {
      for (int j = i + 1; j < word.length() + 1; j++) {
        String newWord = word.substring(0, i) + word.substring(i, j).replaceAll("[a-z]", ".")
            + word.substring(j, word.length());
        set.add(newWord);
      }
    }
  }

  /**
   * Returns if the word is in the data structure. A word could contain the dot
   * character '.' to represent any one letter.
   */
  public boolean search(String word) {
    if (set.contains(word)) {
      return true;
    }
    return false;
  }

  //// ----------------------- end (Approach1)----------------------
  //// -----------------------start(Approach2)----------------------
  // backtrack
  // Time Limit Exceeded
  // 10/13 cases passed (N/A)
  //
  // public WordDictionary() {
  // set = new HashSet<>();
  // }

  public void addWord2(String word) {
    backtrack2(word, 0);
  }

  private void backtrack2(String word, int pos) {
    if (pos == word.length()) {
      set.add(word);
      return;
    }
    backtrack2(word, pos + 1);
    if (word.charAt(pos) != '.') {
      String s = word.substring(0, pos) + '.' + word.substring(pos + 1);
      backtrack2(s, pos + 1);
    } else {
      for (char ch = 'a'; ch <= 'z'; ch++) {
        String s = word.substring(0, pos) + ch + word.substring(pos + 1);
        backtrack2(s, pos + 1);
      }
    }
  }

  public boolean search2(String word) {
    if (set.contains(word)) {
      return true;
    }
    return false;
  }
  //// ----------------------- end (Approach2)----------------------
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary(); obj.addWord(word); boolean param_2
 * = obj.search(word);
 */
// @lc code=end
