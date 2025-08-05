import java.util.*;
import java.io.*;

public class Main {

    static FastReader in = new FastReader();
    static PrintWriter out = new PrintWriter(System.out);

    public static void main(String[] args) throws Exception {
        int t = in.nextInt(); // comment this line if there's only one test case
        int j=0;
        String[] output=new String[t];
        while (t-- > 0) {
            int n=in.nextInt();
            int[] p=new int[n];
            int[] s=new int[n];
            for(int i=0;i<n;i++){
                p[i]=in.nextInt();
            }
            // in.nextLine();
            for(int i=0;i<n;i++){
                s[i]=in.nextInt();
            }
            output[j]=solve(p,s,n);
            j++;
        }
        for(String s: output){
            out.println(s);
        }

        out.flush(); // Don't forget to flush output!
    }

    static String solve(int[] p, int[] s, int n) {
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = gcd(p[i], s[i]);
        }

        // Recompute prefix GCD
        int[] prefixGCD = new int[n];
        prefixGCD[0] = a[0];
        for (int i = 1; i < n; i++) {
            prefixGCD[i] = gcd(prefixGCD[i - 1], a[i]);
        }

        // Recompute suffix GCD
        int[] suffixGCD = new int[n];
        suffixGCD[n - 1] = a[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            suffixGCD[i] = gcd(suffixGCD[i + 1], a[i]);
        }

        // Compare with original p and s
        for (int i = 0; i < n; i++) {
            if (prefixGCD[i] != p[i] || suffixGCD[i] != s[i]) {
                return "NO";
            }
        }

        return "YES";
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