/*
 * @lc app=leetcode id=42 lang=java
 *
 * [42] Trapping Rain Water
 */

// @lc code=start
class Solution {
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

  public int trap(int[] height) {
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
}
// @lc code=end
