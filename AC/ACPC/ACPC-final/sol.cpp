#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

const int MAXN = 200005;
vector<int> adj[MAXN];
int max_dist, farthest_node;

void dfs(int u, int p, int d) {
    if (d > max_dist) {
        max_dist = d;
        farthest_node = u;
    }
    for (int v : adj[u]) {
        if (v != p) dfs(v, u, d + 1);
    }
}

int main() {
    int n;
    if (!(cin >> n)) return 0;
    if (n == 1) { cout << 0 << endl; return 0; }
    for (int i = 0; i < n - 1; i++) {
        int u, v; cin >> u >> v;
        adj[u].push_back(v);
        adj[v].push_back(u);
    }
    max_dist = -1;
    dfs(1, 0, 0);
    max_dist = -1;
    dfs(farthest_node, 0, 0);
    cout << max_dist << endl;
    return 0;
}