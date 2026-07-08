#include <bits/stdc++.h>
using namespace std;

const int INF = 1e9;

int solve(int x, const vector<int>& c) {
    if (x == 0) return 0;
    if (x < 0) return INF;

    int ans = INF;

    for (int coin : c) {
        int sub = solve(x - coin, c);
        if (sub != INF) {
            ans = min(ans, sub + 1);
        }
    }

    return ans;
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int n, x;
    cin >> n >> x;

    vector<int> c(n);
    for (int i = 0; i < n; i++)
        cin >> c[i];

    int result = solve(x, c);

    if (result == INF)
        cout << -1 << "\n";
    else
        cout << result << "\n";

    return 0;
}
