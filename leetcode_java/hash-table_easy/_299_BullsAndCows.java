import java.util.Map;

/*
 * @lc app=leetcode id=299 lang=java
 *
 * [299] Bulls and Cows
 */

// @lc code=start
class Solution {
  ////////////////// first round(20200115)///////////////////////////////////
  ////////////////// first round(20200115)///////////////////////////////////
  //// ---------------------------start(Approach1)-----------------------
  // 20200115
  public String getHint1(String secret, String guess) {
    Map<Character, Integer> map = new HashMap<>();
    int numA = 0;
    int numB = 0;
    for (int i = 0; i < secret.length(); i++) {
      map.put(secret.charAt(i), map.getOrDefault(secret.charAt(i), 0) + 1);
    }
    // System.out.println("map: " + map);
    for (int i = 0; i < secret.length(); i++) {
      // System.out.println("i" + i);
      if (map.containsKey(guess.charAt(i)) && map.get(guess.charAt(i)) > 0) {
        if (secret.charAt(i) == guess.charAt(i)) {
          numA++;
          map.put(guess.charAt(i), map.get(guess.charAt(i)) - 1);
        }
        // System.out.println("map: " + map);
      }
    }
    for (int i = 0; i < secret.length(); i++) {
      // System.out.println("i" + i);
      if (map.containsKey(guess.charAt(i)) && map.get(guess.charAt(i)) > 0) {
        if (secret.charAt(i) != guess.charAt(i)) {
          numB++;
          map.put(guess.charAt(i), map.get(guess.charAt(i)) - 1);
        }
        // System.out.println("map: " + map);
      }
    }
    return numA + "A" + numB + "B";
  }

  //
  //// --------------------------- end (Approach1)-----------------------
  //// ---------------------------start(Approach2)-----------------------
  // public String getHint(String secret, String guess) {
  public String getHint2(String secret, String guess) {
    int[] count = new int[10];
    int bull = 0;
    int cow = 0;
    for (int i = 0; i < secret.length(); i++) {
      if (secret.charAt(i) == guess.charAt(i)) {
        bull++;
      } else {
        if (count[secret.charAt(i) - '0']++ < 0)
          cow++;
        if (count[guess.charAt(i) - '0']-- > 0)
          cow++;
      }
    }
    return bull + "A" + cow + "B";
  }
  //// --------------------------- end (Approach2)-----------------------
  ////////////////// second round(20200908)///////////////////////////////////
  ////////////////// second round(20200908)///////////////////////////////////
  //// ---------------------------start(Approach3)-----------------------
  // 20200908
  // refer to approach2

  // 152/152 cases passed (4 ms)
  // Your runtime beats 91.93 % of java submissions
  // Your memory usage beats 76.08 % of java submissions (39.5 MB)

  // public String getHint3(String secret, String guess) {
  public String getHint(String secret, String guess) {
    int n = secret.length();
    int[] count = new int[10];
    int bull = 0, cow = 0;

    for (int i = 0; i < n; i++) {
      if (secret.charAt(i) == guess.charAt(i)) {
        bull++;
      } else {
        if (count[secret.charAt(i) - '0']++ < 0)
          // if (count[secret.charAt(i)]++ < 0)
          cow++;
        if (count[guess.charAt(i) - '0']-- > 0)
          cow++;
      }
    }
    return bull + "A" + cow + "B";
  }
  //// --------------------------- end (Approach3)-----------------------
}
// @lc code=end
