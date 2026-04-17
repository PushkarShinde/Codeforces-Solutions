#include "testlib.h"
#include <vector>
#include <algorithm>

using namespace std;

// Function to print a tree given its edges and random shuffling
void printTree(int n, vector<pair<int, int>>& edges) {
    printf("%d\n", n);
    
    // Randomly shuffle the nodes so node 1 isn't always the root
    vector<int> p(n);
    for (int i = 0; i < n; i++) p[i] = i + 1;
    shuffle(p.begin(), p.end());

    // Randomly shuffle edge order
    shuffle(edges.begin(), edges.end());

    for (auto& edge : edges) {
        int u = p[edge.first - 1];
        int v = p[edge.second - 1];
        // Randomly swap u and v to avoid directional bias
        if (rnd.next(2)) swap(u, v);
        printf("%d %d\n", u, v);
    }
}

int main(int argc, char* argv[]) {
    registerGen(argc, argv, 1);

    int n = opt<int>(1);           // Get n from command line arguments
    string type = opt<string>(2);  // Get tree type: "random", "star", "path"

    vector<pair<int, int>> edges;

    if (type == "random") {
        // Prufer-like or simple random growth
        for (int i = 2; i <= n; i++) {
            edges.push_back({rnd.next(1, i - 1), i});
        }
    } 
    else if (type == "star") {
        // Central node 1 connected to everything else
        for (int i = 2; i <= n; i++) {
            edges.push_back({1, i});
        }
    } 
    else if (type == "path") {
        // A single long line: 1-2-3-...-n
        for (int i = 1; i < n; i++) {
            edges.push_back({i, i + 1});
        }
    }

    printTree(n, edges);

    return 0;
}