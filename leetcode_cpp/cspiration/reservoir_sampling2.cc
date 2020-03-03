#include <cstdlib>
#include <ctime>
#include <iostream>

bool ReservoirSampling(const int *input, int n, int *result, int m);
int RandInt(int start, int end);

int main() {
  int n = 100;
  int m = 10;
  int input[n];
  int result[m];

  for (int i = 0; i < n; ++i) {
    input[i] = i;
  }
  if (ReservoirSampling(input, n, result, m)) {
    for (auto res : result) {
      std::cout << res << " ";
    }
    std::cout << std::endl;
  }
  return 0;
}

bool ReservoirSampling(const int *input, int n, int *result, int m) {
  if (n < m || input == nullptr || result == nullptr) {
    return false;
  }
  std::srand(time(nullptr));
  for (int i = 0; i < m; ++i) {
    result[i] = input[i];
  }
  for (int i = m; i < n; ++i) {
    int j = RandInt(0, i);
    if (j < m) {
      result[j] = input[i];
    }
  }
  return true;
}

int RandInt(int start, int end) {
  if (start > end) {
    int tmp = start;
    start = end;
    end = tmp;
  }
  int ret = start + std::rand() % (end - start + 1);
  return ret;
}
