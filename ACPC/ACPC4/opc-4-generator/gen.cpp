#include "testlib.h"
#include <bits/stdc++.h>
using namespace std;

int main(int argc, char* argv[]) {
    registerGen(argc, argv, 1);

    int type = opt<int>("type", 0);

    int n, x;
    vector<int> c;

    if (type == 1) {
        n = 1;
        x = 1;
        c = {1};
    }
    else if (type == 2) {
        n = 1;
        x = rnd.next(1, 30);
        c = {x};
    }
    else if (type == 3) {
        n = 1;
        x = rnd.next(1, 30);
        int val = rnd.next(2, 30);
        while (x % val == 0)
            val = rnd.next(2, 30);
        c = {val};
    }
    else if (type == 4) {
        n = rnd.next(2, 5);
        int g = rnd.next(2, 5);
        x = rnd.next(1, 30);
        if (x % g == 0) x++;

        set<int> s;
        while ((int)s.size() < n) {
            s.insert(rnd.next(1, 10) * g);
        }
        c.assign(s.begin(), s.end());
    }
    else if (type == 5) {
        n = rnd.next(2, 10);
        x = rnd.next(1, 30);

        set<int> s;
        s.insert(1);
        while ((int)s.size() < n) {
            s.insert(rnd.next(2, 30));
        }
        c.assign(s.begin(), s.end());
    }
    else if (type == 6) {
        n = 3;
        x = 6;
        c = {1, 3, 4};
    }
    else {
        n = rnd.next(1, 10);
        x = rnd.next(1, 30);

        set<int> s;
        while ((int)s.size() < n) {
            s.insert(rnd.next(1, 30));
        }
        c.assign(s.begin(), s.end());
    }

    shuffle(c.begin(), c.end());

    cout << n << " " << x << "\n";
    for (int i = 0; i < n; i++) {
        cout << c[i];
        if (i + 1 < n) cout << " ";
    }
    cout << "\n";

    return 0;
}
