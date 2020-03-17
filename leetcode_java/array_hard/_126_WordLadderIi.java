/*
 * @lc app=leetcode id=126 lang=java
 *
 * [126] Word Ladder II
 */

// @lc code=start
class Solution {
  // ------------------strat(Approach1)----------------------------
  // buildGraph + bfs(calculate distance) + backtrack(dfs)
  // 39/39 cases passed (272 ms)
  // Your runtime beats 28.8 % of java submissions

  public List<List<String>> findLadders1(String beginWord, String endWord, List<String> wordList) {
    // declare a nested list to hold the result
    List<List<String>> res = new ArrayList<>();
    if (wordList == null || wordList.size() == 0) {
      return res;
    }

    Map<String, Set<String>> graph = new HashMap<>();
    Map<String, Integer> distanceMap = new HashMap<>();

    // build graph
    buildGraph1(beginWord, wordList, graph);
    // System.out.format("graph: %s\n", graph);

    // build distance map by bfs
    buidDistanceMap1(graph, distanceMap, beginWord, endWord);
    // System.out.format("distanceMap: %s\n", distanceMap);

    // traverse the graph, and output every path. with backtracking(dfs)
    backtrack1(res, new ArrayList<>(Arrays.asList(beginWord)), graph, distanceMap, beginWord, endWord);
    // System.out.format("res: %s\n", res);
    return res;
  }

  private void backtrack1(List<List<String>> res, List<String> lst, Map<String, Set<String>> graph,
      Map<String, Integer> distanceMap, String curWord, String endWord) {
    if (curWord.equals(endWord)) {
      res.add(new ArrayList<>(lst));
      return;
    }

    for (String neighbor : graph.get(curWord)) {
      if (distanceMap.get(neighbor) == distanceMap.get(curWord) + 1) {
        lst.add(neighbor);
        backtrack1(res, lst, graph, distanceMap, neighbor, endWord);
        lst.remove(lst.size() - 1);
      }
    }
  }

  private void buidDistanceMap1(Map<String, Set<String>> graph, Map<String, Integer> distanceMap, String beginWord,
      String endWord) {
    Deque<String> queue = new ArrayDeque<>();
    // initialize the queue
    queue.offer(beginWord);
    distanceMap.put(beginWord, 0);

    while (!queue.isEmpty()) {
      boolean reachEnd = false;
      int size = queue.size();
      // traver current level
      for (int i = 0; i < size; i++) {
        String curWord = queue.poll();
        Integer curLevel = distanceMap.get(curWord);
        for (String neighbor : graph.get(curWord)) {
          if (!distanceMap.containsKey(neighbor)) {
            distanceMap.put(neighbor, curLevel + 1);
            if (neighbor.equals(endWord)) {
              reachEnd = true;
            } else {
              queue.offer(neighbor);
            }
          }
        }

        if (reachEnd) {
          break;
        }
      }
    }
  }

  private void buildGraph1(String beginWord, List<String> wordList, Map<String, Set<String>> graph) {
    if (!wordList.contains(beginWord)) {
      wordList.add(beginWord);
    }
    // use HashSet to improve the search efficient
    // from O(n) to O(1)
    // very important.
    Set<String> set = new HashSet<>(wordList);

    for (String word : wordList) {
      if (graph.containsKey(word)) {
        continue;
      }
      graph.put(word, new HashSet<>());

      // build the adacency list of word
      for (int i = 0; i < word.length(); i++) {
        for (char j = 'a'; j <= 'z'; j++) {
          if (j == word.charAt(i)) {
            continue;
          }
          String newWord = word.substring(0, i) + j + word.substring(i + 1);
          if (set.contains(newWord) && !graph.get(word).contains(newWord) && !newWord.equals(word)) {
            // if (wordList.contains(newWord) && !graph.get(word).contains(newWord) &&
            // !newWord.equals(word)) {
            graph.get(word).add(newWord);
          }
        }
      }
    }
  }

  // ------------------ end (Approach1)----------------------------
  // ------------------strat(Approach2)----------------------------
  // buildGraph + bfs(calculate distance) + backtrack(dfs)
  // improvement of approch 1. build graph on the fly
  // 39/39 cases passed (234 ms)
  // Your runtime beats 33.3 % of java submissions
  public List<List<String>> findLadders2(String beginWord, String endWord, List<String> wordList) {
    // declare a nested list to hold the result
    List<List<String>> res = new ArrayList<>();
    if (wordList == null || wordList.size() == 0) {
      return res;
    }

    Map<String, Set<String>> graph = new HashMap<>();
    Map<String, Integer> distanceMap = new HashMap<>();

    // build graph
    // buildGraph2(beginWord, wordList, graph);
    // System.out.format("graph: %s\n", graph);

    // build distance map by bfs
    Set<String> set = new HashSet<>(wordList);
    buidDistanceMap2(set, graph, distanceMap, beginWord, endWord);
    // System.out.format("distanceMap: %s\n", distanceMap);

    // traverse the graph, and output every path. with backtracking(dfs)
    backtrack2(res, new ArrayList<>(Arrays.asList(beginWord)), graph, distanceMap, beginWord, endWord);
    // System.out.format("res: %s\n", res);
    return res;
  }

  private void backtrack2(List<List<String>> res, List<String> lst, Map<String, Set<String>> graph,
      Map<String, Integer> distanceMap, String curWord, String endWord) {
    if (curWord.equals(endWord)) {
      res.add(new ArrayList<>(lst));
      return;
    }

    if (!graph.containsKey(curWord)) {
      return;
    }
    for (String neighbor : graph.get(curWord)) {
      if (distanceMap.get(neighbor) == distanceMap.get(curWord) + 1) {
        lst.add(neighbor);
        backtrack1(res, lst, graph, distanceMap, neighbor, endWord);
        lst.remove(lst.size() - 1);
      }
    }
  }

  private void buidDistanceMap2(Set<String> set, Map<String, Set<String>> graph, Map<String, Integer> distanceMap,
      String beginWord, String endWord) {
    // System.out.format("CheckPoint 1\n");
    Deque<String> queue = new ArrayDeque<>();
    // initialize the queue
    queue.offer(beginWord);
    distanceMap.put(beginWord, 0);

    while (!queue.isEmpty()) {
      boolean reachEnd = false;
      int size = queue.size();
      // traver current level
      for (int i = 0; i < size; i++) {
        String curWord = queue.poll();
        Integer curLevel = distanceMap.get(curWord);

        // System.out.format("CheckPoint 2\n");
        // ------------start(buld graph on the fly)-----------
        for (int j = 0; j < curWord.length(); j++) {
          // System.out.format("CheckPoint 3\n");
          // System.out.format("j: %d, curWord[j]:%c\n", j, curWord.charAt(j));
          for (char k = 'a'; k <= 'z'; k++) {
            if (k == curWord.charAt(j)) {
              continue;
            }
            String newWord = curWord.substring(0, j) + k + curWord.substring(j + 1);
            if (set.contains(newWord)) {
              // System.out.format("CheckPoint 4\n");
              graph.putIfAbsent(curWord, new HashSet<>());
              graph.get(curWord).add(newWord);
              // System.out.format("CheckPoint 5\n");
            }
          }
        }
        // System.out.format("graph: %s\n", graph);
        // ------------ end (buld graph on the fly)-----------

        // System.out.format("CheckPoint 6\n");
        if (!graph.containsKey(curWord)) {
          continue;
        }
        for (String neighbor : graph.get(curWord)) {
          // System.out.format("CheckPoint 7\n");
          if (!distanceMap.containsKey(neighbor)) {
            distanceMap.put(neighbor, curLevel + 1);
            if (neighbor.equals(endWord)) {
              reachEnd = true;
            } else {
              queue.offer(neighbor);
            }
          }
        }
        // System.out.format("CheckPoint 8\n");

        if (reachEnd) {
          break;
        }
      }
    }
  }

  // ------------------ end (Approach2)----------------------------
  // ------------------strat(Approach3)----------------------------
  // without distance map
  // 39/39 cases passed (75 ms)
  // Your runtime beats 77.81 % of java submissions
  public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
    List<List<String>> res = new ArrayList<>();
    if (wordList == null || wordList.size() == 0) {
      return res;
    }

    // build hashset of wordList, which can improve the search efficiency
    Set<String> wordDict = new HashSet<>(wordList);
    if (!wordDict.contains(endWord)) {
      return res;
    }

    Map<String, Set<String>> tree = new HashMap<>();
    // build tree from grpah (only the child neighbors are acceptable)
    buildTree3(tree, wordDict, beginWord, endWord);
    // System.out.format("tree: %s\n", tree);

    // output every path in the tree
    backtrack3(tree, res, new ArrayList<>(Arrays.asList(beginWord)), beginWord, endWord);

    return res;
  }

  private void backtrack3(Map<String, Set<String>> tree, List<List<String>> res, List<String> lst, String curWord,
      String endWord) {
    if (curWord.equals(endWord)) {
      res.add(new ArrayList<>(lst));
      return;
    }

    if (!tree.containsKey(curWord)) {
      return;
    }

    // lst.add(curWord);
    for (String neighbor : tree.get(curWord)) {
      lst.add(neighbor);
      backtrack3(tree, res, lst, neighbor, endWord);
      lst.remove(lst.size() - 1);
    }
    // lst.remove(lst.size() - 1);
  }

  private void buildTree3(Map<String, Set<String>> tree, Set<String> wordDict, String beginWord, String endWord) {
    Set<String> curLevel = new HashSet<>();
    curLevel.add(beginWord);

    boolean foundEnd = false;
    while (!curLevel.isEmpty()) {
      // key point to avoid the distanceMap structure.
      wordDict.removeAll(curLevel);

      int size = curLevel.size();
      Set<String> nextLevel = new HashSet<>();
      for (String curWord : curLevel) {
        tree.putIfAbsent(curWord, new HashSet<>());

        char[] curArray = curWord.toCharArray();
        for (int i = 0; i < curArray.length; i++) {
          char c = curArray[i];
          for (char ch = 'a'; ch <= 'z'; ch++) {
            if (ch == curArray[i]) {
              continue;
            }
            curArray[i] = ch;
            String newWord = new String(curArray);

            if (wordDict.contains(newWord)) {
              tree.get(curWord).add(newWord);
              nextLevel.add(newWord);
              if (newWord.equals(endWord)) {
                foundEnd = true;
              }
            }
          }
          curArray[i] = c;
        }
      }
      curLevel = nextLevel;
    }

    // if (!foundEnd) {
    // return new ArrayList<>();
    // }
  }
  // ------------------ end (Approach3)----------------------------
  // ------------------strat(Approach4)----------------------------
  // ------------------ end (Approach4)----------------------------

}
// @lc code=end
