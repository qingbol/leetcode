// : bit-manipulation_medium/_318_.java
package medium;

import java.util.Arrays;
import java.util.Comparator;
/*
 * @lc app=leetcode id=318 lang=java
 *
 * [318] Maximum Product of Word Lengths
 */
import java.util.Map;

public class _318_MaximumProductOfWordLengths {
  public static void main(String[] args) {
    Solution solution = new Solution();
    String[] words = new String[] {"abcw", "baz", "foo", "bar", "xtfn", "abcdef"};
    int max = solution.maxProduct(words);
    System.out.println(max);
  }
}


// @lc code=start
class Solution {
  ////////////////// first round(20200103)///////////////////////////////////
  ////////////////// first round(20200103)///////////////////////////////////
  //// ----------------start(Approach1)-------------------------------------
  // 20200103
  public int maxProduct1(String[] words) {
    // public int maxProduct(String[] words) {
    int max = 0;
    int flagOuter = 0;
    int flagInsider = 0;
    int isDuplicate = 0;
    for (int i = 0; i < words.length - 1; i++) {
      flagOuter = 0;
      for (int letter : words[i].toCharArray()) {
        letter = letter - 'a';
        if ((flagOuter & 1 << letter) > 0) {
          continue;
        } else {
          flagOuter |= 1 << letter;
          System.out.println(Integer.toBinaryString(flagOuter));
        }
      }

      for (int j = i + 1; j < words.length; j++) {
        flagInsider = flagOuter;
        for (int letter : words[j].toCharArray()) {
          letter = letter - 'a';
          isDuplicate = flagInsider & (1 << letter);
          if ((flagInsider & (1 << letter)) > 0) {
            break;
          } else {
            flagInsider |= (1 << letter);
          }
        }
        if (0 == isDuplicate) {
          max = Math.max(max, words[i].length() * words[j].length());
        }
      }
    }
    return max;
  }

  //// ---------------- end (Approach1)-------------------------------------
  //// ----------------start(Approach2)-------------------------------------
  // 20200103
  // public int maxProduct(String[] words) {
  public int maxProduct2(String[] words) {
    int res = 0;

    // In order to prune the choices, sort the array first,
    Arrays.sort(words, new Comparator<String>() {
      public int compare(String a, String b) {
        return b.length() - a.length();
      }
    });

    // convert sting to int
    int[] string2int = new int[words.length];
    for (int i = 0; i < words.length; i++) {
      int val = 0;
      for (int j = 0; j < words[i].length(); j++) {
        val |= 1 << words[i].charAt(j) - 'a';
        // System.out.println(Integer.toBinaryString(val));
      }
      string2int[i] = val;
    }

    // compare the two ints
    for (int i = 0; i < words.length - 1; i++) {
      if (words[i].length() * words[i].length() <= res) {
        break;
      }
      for (int j = i + 1; j < words.length; j++) {
        if ((string2int[i] & string2int[j]) == 0) {
          res = Math.max(words[i].length() * words[j].length(), res);
          break;
        }
      }
    }
    return res;
  }
  //// ---------------- end (Approach2)-------------------------------------
  ////////////////// second round(20200904)///////////////////////////////////
  ////////////////// second round(20200904)///////////////////////////////////
  //// ----------------start(Approach3)-------------------------------------
  // 20200904, bitmap, refer to leetcode standard solution
  // can't come up with myself.

  // 174/174 cases passed (24 ms)
  // Your runtime beats 42.99 % of java submissions
  // Your memory usage beats 81.41 % of java submissions (39.5 MB)

  public int maxProduct(String[] words) {
    // public int maxProduct3(String[] words) {
    Map<Integer, Integer> bitmap = new HashMap<>();

    for (String word : words) {
      int bitmask = 0;
      for (char ch : word.toCharArray()) {
        bitmask |= 1 << (ch - 'a');
      }
      bitmap.putIfAbsent(bitmask, 0);
      bitmap.put(bitmask, Math.max(word.length(), bitmap.get(bitmask)));
    }

    int res = 0;
    for (int x : bitmap.keySet()) {
      for (int y : bitmap.keySet()) {
        if ((x & y) == 0) {
          res = Math.max(res, bitmap.get(x) * bitmap.get(y));
        }
      }
    }
    return res;
  }
  //// ---------------- end (Approach3)-------------------------------------

}
// @lc code=end
