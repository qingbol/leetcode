#include <cstdlib>
#include <ctime>
#include <iostream>
#include <vector>

typedef std::vector<int> IntVec;
typedef typename IntVec::iterator Iter;
typedef typename IntVec::const_iterator ConstIter;

bool ReservoirSampling(const IntVec &input, IntVec &result, int m);
int RandInt(int l, int r);

int main() {
  int n = 100;
  int m = 10;
  IntVec input(n);
  IntVec result(m);

  for (int i = 0; i < input.size(); ++i) {
    input[i] = i;
  }

  if (ReservoirSampling(input, result, m)) {
    for (auto res : result) {
      std::cout << res << " ";
    }
    std::cout << std::endl;
  }
  return 0;
}

bool ReservoirSampling(const IntVec &input, IntVec &result, int m) {
  if (input.size() < m)
    return false;
  std::srand(time(nullptr));
  ConstIter citer = input.cbegin();
  for (int i = 0; i < m; ++i) {
    result[i] = *citer++;
  }
  for (int i = m; i < input.size(); ++i) {
    int j = RandInt(0, i);
    if (j < m) {
      result[j] = input[i];
    }
  }
  return true;
}

int RandInt(int l, int r) {
  if (l > r) {
    int t = l;
    l = r;
    r = t;
  }
  int ret = l + std::rand() % (r - l + 1);
  return ret;
}
