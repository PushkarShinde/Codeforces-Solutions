#include <bits/stdc++.h>
using namespace std;

void solve(vector<pair<int, string>> cases){
   vector<int> results;
   for (auto ch : cases) {
      string str=ch.second;
      int maxl = 0, current = 0;
      for (char c : str) {
         if (c == '7') {
               current++;
               maxl = max(maxl, current);
         } else {
               current = 0;
         }
      }
      results.push_back(maxl);
   }

   for (int r : results) {
      cout << r << endl;
   }
}

int main() {
   int t;
   cin >> t; 
   vector<pair<int, string>> cases;
   int n; string s;
   for (int i = 0; i < t; i++) {
      cin >> n >> s;
      cases.emplace_back(n, s);
   }
   solve(cases);
   return 0;
}
