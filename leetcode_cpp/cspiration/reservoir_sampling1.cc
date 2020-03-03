#include <cstdlib>
#include <ctime>
#include <iostream>
#include <vector>

// using namespace std;
typedef std::vector<int> IntVec;
typedef typename IntVec::iterator Iter;
typedef typename IntVec::const_iterator ConstIter;

bool ReservoirSampling(const IntVec &input, int &res);
int RandInt(int i, int k);

int main() {
  const int n = 10;
  // IntVec input;
  // input.reserve(n);
  IntVec input(n);
  int res = 0;

  for (int i = 0; i < n; ++i) {
    input[i] = i;
    // input.emplace_back(i);
    // std::cout << "i:" << i << " input:" << input.size() << " capacity:" << input.capacity() << std::endl;
    for (auto vec : input) {
      std::cout << vec << " ";
    }
    std::cout << std::endl;
  }
  if (ReservoirSampling(input, res))
    std::cout << res << std::endl;
}

bool ReservoirSampling(const IntVec &input, int &res) {
  std::srand(time(nullptr));
  if (input.size() < 0)
    return false;
  ConstIter citer = input.begin();
  res = *citer++;
  std::cout << res << std::endl;
  for (int i = 1; citer != input.end(); ++citer, ++i) {
    int j = RandInt(0, i);
    if (j < 1)
      res = *citer;
  }
  return res;
}

int RandInt(int i, int k) {
  if (i > k) {
    int t = i;
    i = k;
    k = t;
  }
  int ret = i + rand() % (k - i + 1);
  return ret;
}
