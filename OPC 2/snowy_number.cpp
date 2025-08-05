#include <bits/stdc++.h>
using namespace std;

void solve(vector<int> cases){
    vector<string> result;
    for(int i = 0; i < cases.size(); i++){
        int num = cases[i];
        string s = "no";  // Default answer is "no"
        
        // Check if num can be written as sum of two squares
        for (int j = 0; j * j <= num; j++) {
            int k_square = num - j * j;
            int k = sqrt(k_square);
            
            // If k*k equals the remaining part of num, then we have found a pair
            if (k * k == k_square) {
                s = "yes";
                break;
            }
        }
        result.push_back(s);
    }

    for (string r : result) {
        cout << r << endl;
    }
}

int main() {
   int t;
   cin >> t; 
   vector<int> cases;
   int n;
   for (int i = 0; i < t; i++) {
      cin >> n;
      cases.emplace_back(n);
   }
   solve(cases);
   return 0;
}
