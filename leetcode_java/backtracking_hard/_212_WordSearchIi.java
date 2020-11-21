/*
 * @lc app=leetcode id=212 lang=java
 *
 * [212] Word Search II
 */

// @lc code=start
class Solution {
  ////////////////// first round(20200320)///////////////////////////////////
  ////////////////// first round(20200320)///////////////////////////////////
  //// ----------------start(Approach1)------------------------------------
  // 20200320 
  //// ---------------------start(Approach1)-------------------
  // 20200320. by myself. trie + backtrack
  // Time Limit Exceeded
  // 31/36 cases passed (N/A)
  public List<String> findWords1(char[][] board, String[] words) {
    List<String> res = new ArrayList<>();
    if (board == null || board.length == 0 || words.length == 0) {
      return res;
    }
    int nr = board.length;
    int nc = board[0].length;
    Set<String> dict = new HashSet<>();
    int[][] direction = new int[][] { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
    for (int i = 0; i < nr; i++) {
      for (int j = 0; j < nc; j++) {
        boolean isStart = false;
        for (String word : words) {
          if (board[i][j] == word.charAt(0)) {
            isStart = true;
            break;
          }
        }
        if (isStart == false) {
          continue;
        }
        // System.out.format("i: %d, j: %d, board:%c\n", i, j, board[i][j]);
        boolean[][] visited = new boolean[nr][nc];
        backtrack1(dict, "", direction, visited, board, i, j);
      }
    }
    // System.out.format("dict: %s\n", dict);
    // System.out.format("dict.size: %d\n", dict.size());

    // Add word to Trie
    Trie1 trie = new Trie1();
    for (String str : dict) {
      trie.add(str);
    }
    // search the word in trie
    for (String word : words) {
      if (trie.search(word)) {
        res.add(word);
      }
    }
    return res;
  }

  private void backtrack1(Set<String> dict, String s, int[][] direction, boolean[][] visited, char[][] board, int i,
      int j) {
    int nr = board.length;
    int nc = board[0].length;
    s += board[i][j];
    visited[i][j] = true;

    if (s.length() != 0 && !dict.contains(s)) {
      // System.out.format("s:%s\n", s);
      // System.out.format("dict.size:%d\n", dict.size());
      dict.add(s);
    }

    for (int[] dir : direction) {
      int r = i + dir[0];
      int c = j + dir[1];
      if (r < 0 || r >= nr || c < 0 || c >= nc || visited[r][c]) {
        continue;
      }
      backtrack1(dict, s, direction, visited, board, r, c);
    }
    visited[i][j] = false;
  }

  private class Trie1 {
    TrieNode1 root;

    public Trie1() {
      root = new TrieNode1();
    }

    public void add(String word) {
      TrieNode1 curr = root;
      for (char ch : word.toCharArray()) {
        if (curr.children[ch - 'a'] == null) {
          curr.children[ch - 'a'] = new TrieNode1();
        }
        curr = curr.children[ch - 'a'];
      }
      curr.isWord = true;
    }

    public boolean search(String word) {
      TrieNode1 curr = root;
      for (char ch : word.toCharArray()) {
        if (curr.children[ch - 'a'] == null) {
          return false;
        }
        curr = curr.children[ch - 'a'];
      }
      return curr.isWord;
    }
  }

  private class TrieNode1 {
    TrieNode1[] children;
    boolean isWord;

    public TrieNode1() {
      children = new TrieNode1[26];
      isWord = false;
    }
  }

  //// --------------------- end (Approach1)-------------------
  //// ---------------------start(Approach2)-------------------
  // 20200320,
  public List<String> findWords(char[][] board, String[] words) {
    List<String> res = new ArrayList<>();
    if (board.length == 0 || words.length == 0) {
      return res;
    }

    // build the trie from words.
    // TrieNode2 root = new TrieNode2();
    // buildTree(root, words);
    TrieNode2 root = buildTree(words);
    // printNode(root);
    // System.out.format("root.children:%s\n", root.children.keySet());

    // backtrack the board, to cross out the word in trie.
    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board[0].length; j++) {
        if (root.children.containsKey(board[i][j])) {
          // System.out.format("board[i][j]: %c\n", board[i][j]);
          backtrack2(res, board, root, i, j);
        }
      }
    }

    return res;
  }

  private void backtrack2(List<String> res, char[][] board, TrieNode2 node, int i, int j) {
    int nr = board.length;
    int nc = board[0].length;
    if (i < 0 || i >= nr || j < 0 || j >= nc || board[i][j] == '#') {
      return;
    }
    char c = board[i][j];

    // if current node's map doesn't contian this Character. return.
    if (!node.children.containsKey(c)) {
      return;
    }
    // otherwise, move to the next node.
    TrieNode2 curNode = node.children.get(c);
    // System.out.format("board[i][j]: %c\n", board[i][j]);
    // System.out.format("word: %s\n", node.word);
    if (curNode.word != null) {
      res.add(curNode.word);
      curNode.word = null;
    }

    // mark current character on board as visited
    board[i][j] = '#';
    // check it's neighbors
    backtrack2(res, board, curNode, i - 1, j);
    backtrack2(res, board, curNode, i + 1, j);
    backtrack2(res, board, curNode, i, j - 1);
    backtrack2(res, board, curNode, i, j + 1);
    // backtrack
    board[i][j] = c;

    // optimization: remove the leaf nodes
    // runtime change from
    // Your runtime beats 53.82 % of java submissions
    // to
    // Your runtime beats 60.02 % of java submissions
    if (curNode.children.isEmpty()) {
      node.children.remove(c);
    }

  }

  private TrieNode2 buildTree(String[] words) {
    TrieNode2 root = new TrieNode2();
    for (String word : words) {
      TrieNode2 node = root;
      for (char ch : word.toCharArray()) {
        node.children.putIfAbsent(ch, new TrieNode2());
        node = node.children.get(ch);
      }
      node.word = word;
      // System.out.format("word: %s\n", node.word);
    }
    return root;
  }

  private void printNode(TrieNode2 node) {
    if (node != null) {
      System.out.format("node.word: %s\n", node.word);
    }
    for (TrieNode2 next : node.children.values()) {
      printNode(next);
    }
  }

  private class TrieNode2 {
    Map<Character, TrieNode2> children;
    String word;

    public TrieNode2() {
      children = new HashMap<>();
      word = null;
    }
  }

  //// ---------------- end (Approach2)----------------------------------
  /////////////////////////// second round(20201119)///////////////////////
  /////////////////////////// second round(20201119)///////////////////////
  //// ----------------start(Approach3)----------------------------------
  // 20201119.
  //// ---------------- end (Approach3)----------------------------------
}
// @lc code=end
