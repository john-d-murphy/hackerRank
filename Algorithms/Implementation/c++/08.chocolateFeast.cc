#include <cmath>
#include <cstdio>
#include <vector>
#include <iostream>
#include <algorithm>
using namespace std;

/*
Little Bob loves chocolate, and he goes to a store with $N in his pocket.
The price of each chocolate is $C.
The store offers a discount: for every M wrappers he gives to the store, he gets one chocolate for free.
How many chocolates does Bob get to eat?

Input Format:
The first line contains the number of test cases, T.
T lines follow, each of which contains three integers, N, C, and M.

Output Format:
Print the total number of chocolates Bob eats.

Constraints:
1 <= T <= 1000
2 <= N <= 10^5
1 <= C <= N
2 <= M <= N

Sample input
3
10 2 5
12 4 4
6 2 2
Sample Output
6
3
5
*/
int main() {
    int testCases;
    cin >> testCases;
    for(int i = 0; i < testCases; i++) {
        int money;
        int costPerChocolate;
        int payBeforeFree;
        int chocolates;
        int freeChocolates;
        int wrappers;
        int remainingWrappers;
        cin >> money >> costPerChocolate >> payBeforeFree;
        chocolates = money/costPerChocolate;
        // Now we need to make sure that we're not going to get
        // any additional chocolates with the wrappers of the
        // chocolate we get for free. We can potentially iterate
        // on this for a while, so we need to continue to add free
        // chocolates while we have enough wrappers.
        wrappers = chocolates;
        while (wrappers/payBeforeFree > 0) {
            freeChocolates = wrappers/payBeforeFree;
            remainingWrappers = wrappers % payBeforeFree + freeChocolates;
            chocolates += freeChocolates;
            wrappers = remainingWrappers;
        }
        cout << chocolates << endl;
    }
}
