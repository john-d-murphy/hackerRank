

/*
Objective
Today we're learning about running time! Check out the Tutorial tab for learning materials and an instructional video!

Task
A prime is a natural number greater than 1 that has no positive divisors other than i and itself.
Given a number,n, determine and print whether it's prime or not prime.

Input Format

The first line contains an integer,T, the number of test cases.
Each of the T subsequent lines contains an integer,N, to be tested for primality.

Constraints
1 <= T <= 20
1 <= n <= 2 x 10^9

Output Format
For each test case, print whether n is Prime or Not Prime on a new line.

Sample Input
3
12
5
7

Sample Output
Not prime
Prime
Prime
*/

vector<long> sieveOfEratosthenes() {
  vector<bool> primes;
  vector<long> foundPrimes;

  // Sieve the boolean array
  for (long i = 0 ; i <= maxInt ; i++) {
    primes.push_back(true);
  }

  for (long i = 2; i <= maxInt; i++) {
    if (primes[i] == true) {
       for (long j = i+i; j <= maxInt; j+=i) {
       primes[j] = false;
      }
    }
  }

  // Now take what we found and put it
  // in an array. Probably can be more efficient
  // but for the sake of this exercise, is fast
  // enough.
  for(long i = 2; i <= maxInt; i++ ) {
    if (primes[i] == true) {
      foundPrimes.push_back(i);
    }
  }
  return foundPrimes;
}
bool isPrime(long testCase, vector<long> allPrimes) {
    if (testCase > maxInt) {
        // If we find that we have a number divisible by
        // one of our primes, we know it's not prime.
        for (int i = 0; i < allPrimes.size(); i++) {
            if (testCase % allPrimes[i] == 0) {
                return false;
            }
        }
        // If it's not divisible by any of the primes,
        // then it's prime, since we went up to the sqrt of the
        // number provided in the problem definition.
        return true;
    } else {
        // If it exists in our list of calculated primes, it's prime.
        return (find(allPrimes.begin(), allPrimes.end(), testCase) != allPrimes.end());
    }
}

int main() {
  int testCases;
  vector<long> allPrimes = sieveOfEratosthenes();
  cin >> testCases;
  for (int i = 0 ; i < testCases ; i++) {
    long testCase;
    cin >> testCase;

    if (isPrime(testCase, allPrimes)) {
        cout << "Prime" << endl;
    } else {
        cout << "Not prime" << endl;
    }
  }
}
