//{ Driver Code Starts
#include <bits/stdc++.h>
using namespace std;

// } Driver Code Ends
class Solution {
  public:
  int setBits(int N) {
    // Initialize a variable to count the set bits
    int setBits = 0;

    // Iterate until all bits are processed
    while (N > 0) {
      // Clear the rightmost set bit using bitwise AND operation
      N = N & (N - 1);

      // Increment the set bit count
      setBits++;
    }

    // Return the total number of set bits
    return setBits;
  }
};


//{ Driver Code Starts.
int main() {
    int t;
    cin >> t;
    while (t--) {
        int N;
        cin >> N;

        Solution ob;
        int cnt = ob.setBits(N);
        cout << cnt << endl;
    }
    return 0;
}

// } Driver Code Ends
