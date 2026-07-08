import java.io.*;
import java.util.*;

public class ExtremeTestGenerator {

    static int testId = 1;

    public static void main(String[] args) throws Exception {
        File dir = new File("tests");
        if (!dir.exists()) dir.mkdir();

        // Extreme cases
        allNegatives();
        alternatingLarge();
        prefixTrap();
        massiveK();
        worstCaseDeque(123);
        worstCaseDeque(999999);
        worstCaseDeque(20250101);

        System.out.println("Generated " + (testId - 1) + " tests.");
    }

    // Helper to write one test file
    static void writeTest(String content) throws IOException {
        String name = String.format("%02d", testId++);
        try (PrintWriter out = new PrintWriter(new FileWriter("tests/" + name))) {
            out.print(content);
        }
    }

    // 1️⃣ All negatives
    static void allNegatives() throws IOException {
        int n = 100000;
        StringBuilder sb = new StringBuilder();
        sb.append(n).append('\n');
        for (int i = 0; i < n; i++) {
            sb.append("-1");
            if (i + 1 < n) sb.append(' ');
        }
        sb.append('\n').append(1).append('\n');
        writeTest(sb.toString());
    }

    // 2️⃣ Alternating positives & negatives
    static void alternatingLarge() throws IOException {
        int n = 200000;
        StringBuilder sb = new StringBuilder();
        sb.append(n).append('\n');
        for (int i = 0; i < n; i++) {
            sb.append(i % 2 == 0 ? 100000 : -99999);
            if (i + 1 < n) sb.append(' ');
        }
        sb.append('\n').append(100000).append('\n');
        writeTest(sb.toString());
    }

    // 3️⃣ Prefix sum trap
    static void prefixTrap() throws IOException {
        writeTest(
            "5\n" +
            "5 -10 20 -5 5\n" +
            "15\n"
        );
    }

    // 4️⃣ Massive unreachable K
    static void massiveK() throws IOException {
        writeTest(
            "4\n" +
            "100000 100000 100000 100000\n" +
            "1000000000000\n"
        );
    }

    // 5️⃣ Worst-case deque behavior (random)
    static void worstCaseDeque(long seed) throws IOException {
        Random rng = new Random(seed);
        int n = 200000;
        StringBuilder sb = new StringBuilder();
        sb.append(n).append('\n');
        for (int i = 0; i < n; i++) {
            int x = rng.nextInt(200001) - 100000;
            sb.append(x);
            if (i + 1 < n) sb.append(' ');
        }
        long K = Math.abs(rng.nextLong()) % 1_000_000_000_000_000_000L + 1;
        sb.append('\n').append(K).append('\n');
        writeTest(sb.toString());
    }
}
