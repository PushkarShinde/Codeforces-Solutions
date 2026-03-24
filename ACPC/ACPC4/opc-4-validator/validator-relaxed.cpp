#include "testlib.h"
#include <set>
using namespace std;

int main(int argc, char* argv[]) {
    registerValidation(argc, argv);

    int n = inf.readInt(1, 10, "n");
    inf.readSpace();
    int x = inf.readInt(1, 30, "x");
    inf.readEoln();

    set<int> seen;

    for (int i = 0; i < n; i++) {
        int c = inf.readInt(1, 30, "ci");
        if (seen.count(c)) {
            quitf(_fail, "Packet weights must be distinct");
        }
        seen.insert(c);

        if (i < n - 1)
            inf.readSpace();
    }

    inf.readEoln();
    inf.readEof();

    return 0;
}
