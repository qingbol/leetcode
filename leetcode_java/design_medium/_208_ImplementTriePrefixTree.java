/*
 * @lc app=leetcode id=208 lang=java
 *
 * [208] Implement Trie (Prefix Tree)
 */

// @lc code=start
class Trie {
  private TrieNode root;

  /** Initialize your data structure here. */
  public Trie() {
    root = new TrieNode();
  }

  /** Inserts a word into the trie. */
  public void insert(String word) {
    TrieNode curr = root;
    for (char ch : word.toCharArray()) {
      if (curr.children[ch - 'a'] == null) {
        curr.children[ch - 'a'] = new TrieNode();
      }
      curr = curr.children[ch - 'a'];
    }
    curr.isWord = true;
  }

  /** Returns if the word is in the trie. */
  public boolean search(String word) {
    TrieNode curr = root;
    for (char ch : word.toCharArray()) {
      if (curr.children[ch - 'a'] == null) {
        return false;
      }
      curr = curr.children[ch - 'a'];
    }
    return curr.isWord;
  }

  /**
   * Returns if there is any word in the trie that starts with the given prefix.
   */
  public boolean startsWith(String prefix) {
    TrieNode curr = root;
    for (char ch : prefix.toCharArray()) {
      if (curr.children[ch - 'a'] == null) {
        return false;
      }
      curr = curr.children[ch - 'a'];
    }
    return true;
  }

  private class TrieNode {
    TrieNode[] children;
    boolean isWord;

    public TrieNode() {
      children = new TrieNode[26];
      isWord = false;
    }
  }
}

/**
 * Your Trie object will be instantiated and called as such: Trie obj = new
 * Trie(); obj.insert(word); boolean param_2 = obj.search(word); boolean param_3
 * = obj.startsWith(prefix);
 */
// @lc code=end
