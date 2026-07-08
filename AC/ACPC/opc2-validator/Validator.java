import java.io.*;
import java.util.*;

public class Validator {
    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner(System.in);

        // Read n
        if (!fs.hasNext()) {
            throw new AssertionError("Missing n");
        }
        int n = fs.nextInt();
        assert 1 <= n && n <= 200_000;

        // Read array
        for (int i = 0; i < n; i++) {
            if (!fs.hasNext()) {
                throw new AssertionError("Missing array element");
            }
            long x = fs.nextLong();
            assert -100_000 <= x && x <= 100_000;
        }

        // Read K
        if (!fs.hasNext()) {
            throw new AssertionError("Missing K");
        }
        long K = fs.nextLong();
        assert 1 <= K && K <= 1_000_000_000_000_000_000L;

        // Ensure no extra input
        if (fs.hasNext()) {
            throw new AssertionError("Extra input detected");
        }
    }

    // Fast input reader
    static class FastScanner {
        private final byte[] buffer = new byte[1 << 16];
        private int ptr = 0, len = 0;
        private final InputStream in;

        FastScanner(InputStream in) {
            this.in = in;
        }

        private int read() throws IOException {
            if (ptr >= len) {
                len = in.read(buffer);
                ptr = 0;
                if (len <= 0) return -1;
            }
            return buffer[ptr++];
        }

        boolean hasNext() throws IOException {
            int c;
            while ((c = read()) != -1) {
                if (!Character.isWhitespace(c)) {
                    ptr--;
                    return true;
                }
            }
            return false;
        }

        int nextInt() throws IOException {
            int c, sign = 1, val = 0;
            c = read();
            while (c <= ' ') c = read();
            if (c == '-') {
                sign = -1;
                c = read();
            }
            while (c > ' ') {
                val = val * 10 + (c - '0');
                c = read();
            }
            return val * sign;
        }

        long nextLong() throws IOException {
            int c, sign = 1;
            long val = 0;
            c = read();
            while (c <= ' ') c = read();
            if (c == '-') {
                sign = -1;
                c = read();
            }
            while (c > ' ') {
                val = val * 10 + (c - '0');
                c = read();
            }
            return val * sign;
        }
    }
}
