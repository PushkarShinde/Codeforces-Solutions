#include <bits/stdc++.h>
using namespace std;

string solve(vector<int>& a, int n, int b) {
    int count=0;
    for(int i=0;i<n-1;i++){
        if((b-a[i])<=(b-a[i+1])){
            count++;
        }
    }
    if(count=n-1) {
        return "YES";
    }
    for (int i = 1; i < n; i++) {
        if (a[i-1] > (b - a[i]) && a[i] < a[i-1]) {
            return "NO";
        }
    }
    return "YES";
}

int main() {
    int t;
    cin >> t;
    vector<string> sol(t);
    for(int in=0;in<t;in++) {
        int n, m;
        cin >> n >> m;
        vector<int> a(n);
        for (int i = 0; i < n; i++) {
            cin >> a[i];
        }
        int b;
        cin >> b;
        sol.push_back(solve(a, n, b));
    }
    for (const auto& s : sol) {
        cout << s << endl;
    }
    return 0;
}
