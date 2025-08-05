// package B_Tournament;

import java.util.*;
import java.io.*;

public class Main {

    static FastReader in = new FastReader();
    static PrintWriter out = new PrintWriter(System.out);

    public static void main(String[] args) throws Exception {
        // int t = 1;
        int t = in.nextInt(); // comment this line if there's only one test case
        String[] output=new String[t];
        int ind=0;
        while (t-- > 0) {
            int n = in.nextInt();
            int j = in.nextInt() - 1; // Convert to 0-indexed
            int k = in.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = in.nextInt();
            }
            
            int aj = arr[j]; // Strength of player j
            // Use frequency array to count players
            int[] freq = new int[n + 1];
            int maxStrength = 0;
            for (int strength : arr) {
                freq[strength]++;
                maxStrength = Math.max(maxStrength, strength);
            }
            
            if (k == 1) {
                // Player j must have the maximum strength
                if (aj == maxStrength) {
                    output[ind] = "YES";
                } else {
                    output[ind] = "NO";
                }
            } else {
                // Count players with strength >= aj
                int count = 0;
                for (int i = aj; i <= n; i++) {
                    count += freq[i];
                }
                // If there are at least k players with strength >= aj, player j can survive
                if (count >= k) {
                    output[ind] = "YES";
                } else {
                    output[ind] = "NO";
                }
            }
            ind++;
        }
        for(String s: output){
            System.out.println(s);
        }
        out.flush(); // Don't forget to flush output!
    }

    // static String solve(int[] arr, int n, int j, int k) {
    //     Arrays.sort(arr);
    //     int i=0;
    //     for(i=0;i<n;i++){
    //         if(arr[i]==j) break;
    //     }
    //     int rank=n-i;
    //     if(rank<=k) return "YES";
    //     return "NO";
    //     // Example logic:
    //     // out.println(Arrays.toString(arr));
    // }

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