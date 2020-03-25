/*
 * @lc app=leetcode id=307 lang=java
 *
 * [307] Range Sum Query - Mutable
 */

// @lc code=start
class NumArray {
  //// ------------------start(Approach1)---------------------------
  // 20200322, segment tree + Array + recursion
  int[] tree;
  int n;

  // public NumArray(int[] nums) {
  // n = nums.length;
  // if (n > 0) {
  // tree = new int[4 * n];
  // buildTree1(0, nums, 0, n - 1);
  // }
  // // System.out.format("tree:%s\n", Arrays.toString(tree));
  // }

  private int buildTree1(int idx, int[] nums, int start, int end) {
    if (start == end) {
      tree[idx] = nums[start];
      return tree[idx];
    }
    int mid = start + (end - start) / 2;
    int leftSum = buildTree1(2 * idx + 1, nums, start, mid);
    int rightSum = buildTree1(2 * idx + 2, nums, mid + 1, end);
    tree[idx] = leftSum + rightSum;
    return tree[idx];
  }

  public void update1(int i, int val) {
    update1(0, 0, n - 1, i, val);
    // System.out.format("tree:%s\n", Arrays.toString(tree));
  }

  private void update1(int idx, int start, int end, int pos, int val) {
    if (start == end) {
      tree[idx] = val;
      return;
    }
    int mid = start + (end - start) / 2;
    if (pos <= mid) {
      update1(2 * idx + 1, start, mid, pos, val);
    } else {
      update1(2 * idx + 2, mid + 1, end, pos, val);
    }
    tree[idx] = tree[2 * idx + 1] + tree[2 * idx + 2];
  }

  public int sumRange1(int i, int j) {
    return sumRange1(0, 0, n - 1, i, j);
  }

  private int sumRange1(int idx, int start, int end, int lo, int hi) {
    if (lo <= start && end <= hi) {
      return tree[idx];
    }
    int mid = start + (end - start) / 2;
    if (hi <= mid) {
      return sumRange1(2 * idx + 1, start, mid, lo, hi);
    } else if (mid < lo) {
      return sumRange1(2 * idx + 2, mid + 1, end, lo, hi);
    } else {
      return sumRange1(2 * idx + 1, start, mid, lo, hi) + sumRange1(2 * idx + 2, mid + 1, end, lo, hi);
    }
  }

  //// ------------------ end (Approach1)---------------------------
  //// ------------------start(Approach2)---------------------------
  // 20200322, segemet tree + array + iteration
  // we dont't use tree[0]. only use tree[1] to tree[2 * n - 1]
  // Your runtime beats 66.22 % of java submissions
  // public NumArray(int[] nums) {
  // n = nums.length;
  // if (n > 0) {
  // tree = new int[2 * n];
  // for (int i = n, j = 0; i < 2 * n; i++, j++) {
  // tree[i] = nums[j];
  // }
  // for (int i = n - 1; i > 0; i--) {
  // tree[i] = tree[2 * i] + tree[2 * i + 1];
  // }
  // }
  // // System.out.format("tree:%s\n", Arrays.toString(tree));
  // }

  public void update2(int i, int val) {
    int pos = i + n;
    tree[pos] = val;

    while (pos > 1) {
      int left = pos;
      int right = pos;
      if (pos % 2 == 0) {
        right = pos + 1;
      } else {
        left = pos - 1;
      }
      int parent = pos / 2;
      tree[parent] = tree[left] + tree[right];
      pos = parent;
    }
    // System.out.format("tree:%s\n", Arrays.toString(tree));
  }

  public int sumRange2(int i, int j) {
    int l = i + n;
    int r = j + n;
    int sum = 0;

    while (l <= r) {
      if (l % 2 == 1) {
        sum += tree[l];
        l++;
      }
      if (r % 2 == 0) {
        sum += tree[r];
        r--;
      }
      l /= 2;
      r /= 2;
    }
    return sum;

  }

  //// ------------------ end (Approach2)---------------------------
  //// ------------------start(Approach2)---------------------------
  // 20200322, optimal.
  // binary indexed tree.
  // Your runtime beats 99.77 % of java submissions
  int[] nums;

  public NumArray(int[] nums) {
    n = nums.length;
    this.nums = new int[n];
    tree = new int[n + 1];
    for (int i = 0; i < n; i++) {
      update(i, nums[i]);
    }
  }

  public void update(int i, int val) {
    int idx = i + 1;
    int diff = val - nums[i];
    nums[i] = val;

    while (idx < nums.length + 1) {
      tree[idx] += diff;
      idx += (idx & -idx);
    }
  }

  public int sumRange(int i, int j) {
    return getSum(j) - getSum(i - 1);
  }

  private int getSum(int pos) {
    int idx = pos + 1;
    int sum = 0;

    while (idx > 0) {
      sum += tree[idx];
      idx -= (idx & -idx);
    }
    return sum;
  }
  //// ------------------ end (Approach2)---------------------------
}

/**
 * Your NumArray object will be instantiated and called as such: NumArray obj =
 * new NumArray(nums); obj.update(i,val); int param_2 = obj.sumRange(i,j);
 */
// @lc code=end
