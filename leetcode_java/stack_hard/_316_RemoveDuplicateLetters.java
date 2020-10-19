/*
 * @lc app=leetcode id=316 lang=java
 *
 * [316] Remove Duplicate Letters
 */

// @lc code=start
class Solution {
  /////////////////////////// first round(20200212)///////////////////////
  /////////////////////////// first round(20200212)///////////////////////
  //// ----------------start(Approach1)----------------------------------
  // 20200212
  // wrong
  public String removeDuplicateLetters1(String s) {
    Deque<Character> stack = new ArrayDeque<>();
    Deque<Integer> posStack = new ArrayDeque<>();
    int idx = 0;
    for (int i = 0; i < 26; i++) {
      char ch = (char) (i + 'a');
      // System.out.format("ch: %c\n", ch);
      int pos = s.indexOf(ch, idx);
      if (pos != -1) {
        idx = pos + 1;
        stack.push(ch);
        posStack.push(pos);
      } else {
        pos = s.substring(0, idx).indexOf(ch);
        if (pos != -1) {
          idx = pos + 1;
          stack.push(ch);
          posStack.push(pos);
        }
      }
    }

    String tmp = new String(new char[s.length()]);
    StringBuilder str = new StringBuilder(tmp);
    while (!stack.isEmpty()) {
      // str.insert(0, stack.pop());size
      // System.out.format("pos: %d, char: %c", posStack.peek(), stack.peek());
      str.setCharAt(posStack.pop(), stack.pop());
    }
    for (int i = 0; i < str.length(); i++) {
      if (str.charAt(i) == '\0') {
        str.deleteCharAt(i);
        i--;
      }
    }
    return str.toString();
  }

  //// ---------------- end (Approach1)-------------------------------------
  //// ----------------start(Approach2)-------------------------------------
  // by hashmap
  public String removeDuplicateLetters2(String s) {
    Map<Character, Integer> map = new HashMap<>();
    for (int i = 0; i < s.length(); i++) {
      map.put(s.charAt(i), i);
    }
    int start = 0;
    int end = findEnd(map);
    char[] str = new char[map.size()];
    for (int i = 0; i < str.length; i++) {
      char minChar = 'z' + 1;
      for (int j = start; j <= end; j++) {
        if (map.containsKey(s.charAt(j)) && s.charAt(j) < minChar) {
          minChar = s.charAt(j);
          start = j + 1;
        }
      }
      str[i] = minChar;
      map.remove(minChar);
      // if (s.charAt(end) == minChar) {
      System.out.format("start-1: %d, end: %d\n", start - 1, end);
      if (start - 1 == end) {
        end = findEnd(map);
      }
    }
    return new String(str);
  }

  private int findEnd(Map<Character, Integer> hmap) {
    int min = Integer.MAX_VALUE;
    for (int val : hmap.values()) {
      min = Math.min(min, val);
    }
    return min;
  }

  //// ---------------- end (Approach2)-------------------------------------
  //// ----------------start(Approach3)-------------------------------------
  //refer to leetocde solution: Approach 1: Greedy - Solving Letter by Letter
  // optimal solution: greedy - solving letter by letter

  public String removeDuplicateLetters3(String s) {
    if (s.length() == 0) {
      return "";
    }
    char[] freq = new char[26];
    for (char ch : s.toCharArray()) {
      freq[ch - 'a']++;
    }
    int pos = 0;
    for (int i = 0; i < s.length(); i++) {
      if (s.charAt(pos) > s.charAt(i)) {
        pos = i;
      }
      if (--freq[s.charAt(i) - 'a'] == 0) {
        break;
      }
    }
    return s.charAt(pos) + removeDuplicateLetters(s.substring(pos + 1).replaceAll(s.charAt(pos) + "", ""));
  }

  //// ---------------- end (Approach3)-------------------------------------
  //// ----------------start(Approach4)-------------------------------------
  // greedy solving with stack and set
  public String removeDuplicateLetters(String s) {
    Map<Character, Integer> map = new HashMap<>();
    Deque<Character> stack = new ArrayDeque<>();
    Set<Character> set = new HashSet<>();
    for (int i = 0; i < s.length(); i++) {
      map.put(s.charAt(i), i);
    }
    // System.out.format("map: %s\n", map);
    for (int i = 0; i < s.length(); i++) {
      if (!set.contains(s.charAt(i))) {
        while (!stack.isEmpty() && s.charAt(i) < stack.peek() && map.get(stack.peek()) > i) {
          set.remove(stack.pop());
        }
        set.add(s.charAt(i));
        stack.push(s.charAt(i));
      }
    }
    // System.out.format("stack: %s\n", stack);
    StringBuilder sb = new StringBuilder(stack.size());
    for (Character ch : stack) {
      // sb.append(ch);
      sb.insert(0, ch);
    }
    // while (!stack.isEmpty()) {
    // sb.insert(0, stack.pop());
    // }
    return sb.toString();
  }
  //// ---------------- end (Appraoch4)----------------------------------
  /////////////////////////// second round(20201019)///////////////////////
  /////////////////////////// second round(20201019)///////////////////////
  //// ----------------start(Appraoch5)----------------------------------
  // 20201019. refer to leetcode standard solution: Approach 2: Greedy - Solving with Stack
  //just like approach4.
  //// ---------------- end (Appraoch5)----------------------------------
}
// @lc code=end
