#include <bits/stdc++.h>
using namespace std;

void solve(vector<pair<int, string>> cases) {
    vector<int> results;
    for (auto ch : cases) {
        string str = ch.second;
        int n = str.length();
        int i = 0, j = n - 1;
        while (i < j && (str[i] != str[j])) {
            i++;
            j--;
        }
        results.push_back(j - i + 1);
    }
    for (int r : results) {
        cout << r << endl;
    }
}

int main() {
    int t;
    cin >> t;
    vector<pair<int, string>> cases;
    int n;
    string s;
    for (int i = 0; i < t; i++) {
        cin >> n >> s;
        cases.emplace_back(n, s);
    }
    solve(cases);

    return 0;
}