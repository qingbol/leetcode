/*
 * @lc app=leetcode id=307 lang=java
 *
 * [307] Range Sum Query - Mutable
 */

// @lc code=start
////////////////// first round(20200322)///////////////////////////////////
////////////////// first round(20200322)///////////////////////////////////
//// ------------------start(Approach1)---------------------------
// 20200322, segment tree + Array + recursion
// refer to : Recursive Approach to Segment Trees
// https://leetcode.com/articles/a-recursive-approach-to-segment-trees-range-sum-queries-lazy-propagation/

// 10/10 cases passed (10 ms)
// Your runtime beats 79.67 % of java submissions
// Your memory usage beats 8.4 % of java submissions (45.6 MB)

class NumArray1 {
  // public class NumArray {
  int[] tree;
  int n;

  // public NumArray(int[] nums) {
  public NumArray1(int[] nums) {
    n = nums.length;
    if (n > 0) {
      // tree = new int[2 * n];
      tree = new int[4 * n];
      buildTree1(0, nums, 0, n - 1);
      // System.out.format("tree:%s\n", Arrays.toString(tree));
    }
    // System.out.format("tree:%s\n", Arrays.toString(tree));
  }

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

  public void update(int i, int val) {
    update(0, 0, n - 1, i, val);
    // System.out.format("tree:%s\n", Arrays.toString(tree));
  }

  private void update(int idx, int start, int end, int pos, int val) {
    if (start == end) {
      tree[idx] = val;
      return;
    }
    int mid = start + (end - start) / 2;
    if (pos <= mid) {
      update(2 * idx + 1, start, mid, pos, val);
    } else {
      update(2 * idx + 2, mid + 1, end, pos, val);
    }
    tree[idx] = tree[2 * idx + 1] + tree[2 * idx + 2];
  }

  public int sumRange(int i, int j) {
    return sumRange(0, 0, n - 1, i, j);
  }

  private int sumRange(int idx, int start, int end, int lo, int hi) {
    if (lo <= start && end <= hi) {
      return tree[idx];
    }
    int mid = start + (end - start) / 2;
    if (hi <= mid) {
      return sumRange(2 * idx + 1, start, mid, lo, hi);
    } else if (mid < lo) {
      return sumRange(2 * idx + 2, mid + 1, end, lo, hi);
    } else {
      // return sumRange(2 * idx + 1, start, mid, lo, hi)
      // + sumRange(2 * idx + 2, mid + 1, end, lo, hi);
      return sumRange(2 * idx + 1, start, mid, lo, mid)
          + sumRange(2 * idx + 2, mid + 1, end, mid + 1, hi);
    }
  }
}

//// ------------------ end (Approach1)---------------------------
//// ------------------start(Approach2)---------------------------
// 20200322, segemet tree + array + iteration
// refer to : Approach 3: Segment Tree

// we dont't use tree[0]. only use tree[1] to tree[2 * n - 1]
// Your runtime beats 66.22 % of java submissions

// 10/10 cases passed (10 ms)
// Your runtime beats 79.67 % of java submissions
// Your memory usage beats 53.83 % of java submissions (45 MB)


// class NumArray2 {
public class NumArray {
  int[] tree;
  int n;

  public NumArray(int[] nums) {
    // public NumArray2(int[] nums) {
    n = nums.length;
    if (n > 0) {
      tree = new int[2 * n];
      for (int i = n, j = 0; i < 2 * n; i++, j++) {
        tree[i] = nums[j];
      }
      for (int i = n - 1; i > 0; i--) {
        tree[i] = tree[2 * i] + tree[2 * i + 1];
      }
    }
    // System.out.format("tree:%s\n", Arrays.toString(tree));
  }

  public void update(int i, int val) {
    int pos = i + n;
    int oldVal = tree[pos];
    tree[pos] = val;

    // leetcode standard solution
    // while (pos > 1) {
    // int left = pos;
    // int right = pos;
    // if (pos % 2 == 0) {
    // right = pos + 1;
    // } else {
    // left = pos - 1;
    // }
    // int parent = pos / 2;
    // tree[parent] = tree[left] + tree[right];
    // pos = parent;
    // }

    // by myself
    while (pos > 1) {
      int parent = pos / 2;
      tree[parent] = tree[parent] + val - oldVal;
      pos = parent;
    }
    // System.out.format("tree:%s\n", Arrays.toString(tree));
  }

  public int sumRange(int i, int j) {
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
}

//// ------------------ end (Approach2)---------------------------
//// ------------------start(Approach3)---------------------------
// 20200322, optimal.
// binary indexed tree.
// i dont unnderstand it now. need to be learned

// refer to: Java using Binary Indexed Tree with clear explanation
// https://leetcode.com/problems/range-sum-query-mutable/discuss/75753/Java-using-Binary-Indexed-Tree-with-clear-explanation
// explanation:
// https://www.topcoder.com/community/competitive-programming/tutorials/binary-indexed-trees/

// Your runtime beats 99.77 % of java submissions


class NumArray3 {
  // public class NumArray {
  int[] tree;
  int n;
  int[] nums;

  // public NumArray(int[] nums) {
  public NumArray3(int[] nums) {
    n = nums.length;
    this.nums = new int[n];
    tree = new int[n + 1];
    for (int i = 0; i < n; i++) {
      update(i, nums[i]);
    }
  }

  public void update(int i, int val) {
    //this means tree[0] is not used.
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
    //means tree[0] is not used.
    int idx = pos + 1;
    int sum = 0;

    while (idx > 0) {
      sum += tree[idx];
      idx -= (idx & -idx);
    }
    return sum;
  }
}
//// ---------------- end (Approach3)----------------------------------
/////////////////////////// second round(20201119)///////////////////////
/////////////////////////// second round(20201119)///////////////////////
//// ----------------start(Approach4)----------------------------------
// 20201119.
// refer to: Approach 3: Segment Tree
//// ---------------- end (Approach4)----------------------------------

/**
 * Your NumArray object will be instantiated and called as such: NumArray obj = new NumArray(nums);
 * obj.update(i,val); int param_2 = obj.sumRange(i,j);
 */
// @lc code=end
