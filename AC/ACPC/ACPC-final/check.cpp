#include "testlib.h"

int main(int argc, char* argv[]) {
    setName("Checks a single integer: the tree diameter");
    registerTestlibCmd(argc, argv);

    // Read the expected answer from the jury (ans)
    int jury_ans = ans.readInt();
    
    // Read the participant's answer (ouf)
    int participant_ans = ouf.readInt();

    if (jury_ans != participant_ans) {
        quitf(_wa, "Mark failed! Expected %d, but found %d. Think, Mark!", jury_ans, participant_ans);
    }

    quitf(_ok, "Correct! The empire is secure with diameter %d.", jury_ans);
}