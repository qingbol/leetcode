import java.util.Map;

/*
 * @lc app=leetcode id=299 lang=java
 *
 * [299] Bulls and Cows
 */

// @lc code=start
class Solution {
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
  public String getHint(String secret, String guess) {
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
}
// @lc code=end
