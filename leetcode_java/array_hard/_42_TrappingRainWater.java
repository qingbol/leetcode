/*
 * @lc app=leetcode id=42 lang=java
 *
 * [42] Trapping Rain Water
 */

// @lc code=start
class Solution {
  //// -------------------start(Approach1)---------------------
  // 20200206.
  public int trap1(int[] height) {
    if (null == height || height.length < 3) {
      return 0;
    }
    int left = 0;
    while (0 == height[left]) {
      left++;
    }
    // int right = 1;
    int stoneSize = 0;
    int trapSize = 0;
    // while (left < height.length) {
    int flagHeight = height[left];
    for (int right = left + 1; right < height.length; right++) {
      flagHeight = Math.min(flagHeight, height[right]);
      stoneSize += height[right];
      if (height[right] > flagHeight) {
        System.out.format("left: %d, right: %d, stoneSize: %d\n", left, right, stoneSize);
        trapSize += Math.min(height[left], height[right]) * (right - left - 1);
        System.out.format("left: %d, right: %d, trapSize: %d\n", left, right, trapSize);
        trapSize -= stoneSize - height[right];
        System.out.format("left: %d, right: %d, trapSize: %d\n", left, right, trapSize);
        left = right;
        stoneSize = 0;
        flagHeight = height[left];
      }
    }
    // left++;
    // stoneSize = 0;
    // }
    return trapSize;
  }

  //// ------------------- end (Approach1)---------------------
  //// -------------------start(Approach1)---------------------
  // 20200206.
  public int trap2(int[] height) {
    int left = 0;
    int right = height.length - 1;
    int leftMax = 0;
    int rightMax = 0;
    int trapSize = 0;
    while (left < right) {
      if (height[left] < height[right]) {
        if (height[left] < leftMax) {
          trapSize += (leftMax - height[left]);
        } else {
          leftMax = Math.max(leftMax, height[left]);
        }
        left++;
      } else {
        if (height[right] < rightMax) {
          trapSize += (rightMax - height[right]);
        } else {
          rightMax = Math.max(rightMax, height[right]);
        }
        right--;
      }
    }
    return trapSize;
  }

  //// ------------------- end (Approach2)---------------------
  //// -------------------start(Approach3)---------------------
  // 20200206.
  // two pointer
  public int trap3(int[] height) {
    int left = 0;
    int right = height.length - 1;
    int leftMax = 0;
    int rightMax = 0;
    int trapSize = 0;
    while (left < right) {
      if (height[left] < height[right]) {
        leftMax = Math.max(leftMax, height[left]);
        trapSize += (leftMax - height[left]);
        left++;
      } else {
        rightMax = Math.max(rightMax, height[right]);
        trapSize += (rightMax - height[right]);
        right--;
      }
    }
    return trapSize;
  }

  //// ------------------- end (Approach3)---------------------
  //// -------------------start(Approach4)---------------------
  // 20200206.
  // stack_myself_wrong
  public int trap4(int[] height) {
    Deque<Integer> stack = new ArrayDeque<>();
    int res = 0;
    int leftMax = Integer.MIN_VALUE;
    for (int i = 0; i < height.length; i++) {
      if (height[i] > leftMax) {
        while (!stack.isEmpty()) {
          res += leftMax - height[stack.pop()];
        }
        leftMax = height[i];
        System.out.format("res : %s\n", res);
      } else if (height[i] < leftMax) {
        stack.push(i);
        System.out.format("stack : %s\n", stack);
      }
    }
    return res;
  }

  //// ------------------- end (Approach4)---------------------
  //// -------------------start(Approach5)---------------------
  // 20200206.
  public int trap5(int[] height) {
    Deque<Integer> stack = new ArrayDeque<>();
    int res = 0;
    for (int i = 0; i < height.length; i++) {
      while (!stack.isEmpty() && height[i] > height[stack.peek()]) {
        int idx = stack.pop();
        if (!stack.isEmpty()) {
          int j = stack.peek();
          int width = i - j - 1;
          int length = Math.min(height[i], height[j]) - height[idx];
          res += width * length;
        }
      }
      stack.push(i);
    }
    return res;
  }

  //// ------------------- end (Approach5)---------------------
  /////////////////////////// 20200718secound round////////////////////
  /////////////////////////// 20200718secound round////////////////////
  //// -------------------start(Approach6)--------------------------
  // 20200718, brute force.
  // refer to labladong & leetcode standard solution
  // 315/315 cases passed (70 ms)
  // Your runtime beats 5.12 % of java submissions

  // public int trap(int[] height) {
  public int trap6(int[] height) {
    int res = 0;
    for (int i = 0; i < height.length; i++) {
      int lMax = 0;
      for (int j = 0; j <= i; j++) {
        lMax = Math.max(lMax, height[j]);
      }
      int rMax = 0;
      for (int j = i; j < height.length; j++) {
        rMax = Math.max(rMax, height[j]);
      }

      res += Math.min(lMax, rMax) - height[i];
    }
    return res;
  }

  //// ------------------- end (Approach6)--------------------------
  //// -------------------start(Approach7)--------------------------
  // 20200718, memoization
  // refer to labladong & leetcode standard solution
  // 315/315 cases passed (1 ms)
  // Your runtime beats 94.68 % of java submissions

  // public int trap(int[] height) {
  public int trap7(int[] height) {
    if (height == null || height.length == 0)
      return 0;

    int n = height.length;
    int[] lMax = new int[n];
    int[] rMax = new int[n];
    lMax[0] = height[0];
    rMax[n - 1] = height[n - 1];
    for (int i = 1; i < height.length; i++) {
      lMax[i] = Math.max(lMax[i - 1], height[i]);
    }
    for (int i = n - 2; i >= 0; i--) {
      rMax[i] = Math.max(rMax[i + 1], height[i]);
    }

    int res = 0;
    for (int i = 1; i < n - 1; i++) {
      // for (int i = 0; i < n; i++) {
      res += Math.min(lMax[i], rMax[i]) - height[i];
    }
    return res;

  }

  //// ------------------- end (Approach7)--------------------------
  //// -------------------start(Approach8)--------------------------
  // 20200718, two pointer
  // refer to labladong & leetcode standard solution
  // 315/315 cases passed (1 ms)
  // Your runtime beats 94.68 % of java submissions
  // Your memory usage beats 55.17 % of java submissions (39.2 MB)

  // public int trap(int[] height) {
  public int trap8(int[] height) {
    if (height == null || height.length < 3)
      return 0;

    int n = height.length;
    int left = 0, right = n - 1;
    int lMax = height[0], rMax = height[n - 1];
    int res = 0;

    while (left <= right) {
      lMax = Math.max(lMax, height[left]);
      rMax = Math.max(rMax, height[right]);

      if (lMax < rMax) {
        res += lMax - height[left];
        left++;
      } else {
        res += rMax - height[right];
        right--;
      }
    }
    return res;
  }
  //// ------------------- end (Approach8)--------------------------
  //// -------------------start(Approach9)--------------------------
  // 20200718, using stack
  // refer to labladong & leetcode standard solution
  //315/315 cases passed (2 ms)
// Your runtime beats 31.29 % of java submissions
// Your memory usage beats 78.49 % of java submissions (39 MB)

  public int trap(int[] height) {
    // public int trap9(int[] height) {
    int n = height.length;
    Deque<Integer> stack = new ArrayDeque<>();
    int res = 0;

    for (int i = 0; i < n; i++) {
      //note: should use while rather than if.
      while (!stack.isEmpty() && height[i] > height[stack.peek()]) {
        int cur = stack.pop();
        if (stack.isEmpty())
          break;

        int pre = stack.peek();
        int h = Math.min(height[i], height[pre]) - height[cur];
        int length = i - pre - 1;
        res += h * length;
      }
      stack.push(i);
    }

    return res;
  }
  //// ------------------- end (Approach9)--------------------------
}
// @lc code=end
