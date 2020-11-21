import java.util.Deque;

/*
 * @lc app=leetcode id=32 lang=java
 *
 * [32] Longest Valid Parentheses
 */

// @lc code=start
class Solution {
  ////////////////// first round(20200214)///////////////////////////////////
  ////////////////// first round(20200214)///////////////////////////////////
  //// ---------------start(Approach1)----------------------------------
  // 20200214, 

  // by myself, logic error.
  public int longestValidParentheses1(String s) {
    Deque<Character> stack = new ArrayDeque<>();
    int res = 0;
    for (char ch : s.toCharArray()) {
      if (ch == ')' && !stack.isEmpty()) {
        stack.pop();
        res += 2;
      } else if (ch == '(') {
        stack.push('(');
      }
    }
    // while (!stack.isEmpty()) {
    // res -= 2;
    // stack.pop();
    // }
    return res;
  }

  //// --------------- end (Approach1)------------------------------
  //// ---------------start(Approach2)------------------------------
  // after saw the answer
  public int longestValidParentheses(String s) {
    Deque<Integer> stack = new ArrayDeque<>();
    stack.push(-1);
    int res = 0;
    for (int i = 0; i < s.length(); i++) {
      if (s.charAt(i) == '(') {
        stack.push(i);
      } else if (s.charAt(i) == ')') {
        stack.pop();
        if (stack.isEmpty()) {
          stack.push(i);
        } else {
          res = Math.max(res, i - stack.peek());
        }
      }
    }
    return res;
  }
  //// ----------------- end (Appraoch2)----------------------
  ////////////////// second round(20201025)/////////////////////////////////////
  ////////////////// second round(20201025)/////////////////////////////////////
  //// -----------------start(Appraoch3)----------------------
  //20201025
  //refer to leetcode: Approach 2: Using Dynamic Programming
//dp method is easier to figure out than stack. 
  //// ----------------- end (Appraoch3)----------------------
}
// @lc code=end
