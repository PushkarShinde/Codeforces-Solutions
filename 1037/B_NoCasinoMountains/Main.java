package B_NoCasinoMountains;

import java.util.*;
import java.io.*;

public class Main {

    static FastReader in = new FastReader();
    static PrintWriter out = new PrintWriter(System.out);

    public static void main(String[] args) throws Exception {
        int t = in.nextInt();
        int[] output = new int[t];

        for (int i = 0; i < t; i++) {
            int n = in.nextInt();
            int k = in.nextInt();
            int[] input = new int[n];
            for (int j = 0; j < n; j++) {
                input[j] = in.nextInt(); // ✅ fixed index
            }
            output[i] = solve(n, k, input);
        }

        for (int i = 0; i < t; i++) {
            out.println(output[i]);
        }

        out.flush();
    }



    static int solve(int n, int k, int[] arr) {
        int hikes = 0;
        int i = 0;
        while (i <= n - k) {
            boolean canHike = true;
            for (int j = 0; j < k; j++) {
                if (arr[i + j] == 1) {
                    canHike = false;
                    break;
                }
            }
            if (canHike) {
                hikes++;
                i += k + 1; // Skip k days + 1 rest day
            } else {
                i++; // Try next start day
            }
        }
        return hikes;
    }

    // Fast I/O template
    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            return st.nextToken();
        }

        int nextInt() { return Integer.parseInt(next()); }
        long nextLong() { return Long.parseLong(next()); }
        double nextDouble() { return Double.parseDouble(next()); }
        String nextLine() {
            try {
                return br.readLine();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    // GCD
    static int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    // Sieve of Eratosthenes
    static boolean[] sieve(int n) {
        boolean[] isPrime = new boolean[n+1];
        Arrays.fill(isPrime, true);
        isPrime[0] = isPrime[1] = false;
        for (int i = 2; i*i <= n; i++) {
            if (isPrime[i]) {
                for (int j = i*i; j <= n; j += i) isPrime[j] = false;
            }
        }
        return isPrime;
    }

    // Binary Search Template
    static int binarySearch(int[] arr, int target) {
        int l = 0, r = arr.length - 1;
        while (l <= r) {
            int m = (l + r) / 2;
            if (arr[m] == target) return m;
            else if (arr[m] < target) l = m + 1;
            else r = m - 1;
        }
        return -1;
    }

}
