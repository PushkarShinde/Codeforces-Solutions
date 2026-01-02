import java.util.*;
import java.io.*;

public class Main {

    static FastReader in = new FastReader();
    static PrintWriter out = new PrintWriter(System.out);

    public static void main(String[] args) throws Exception {
        int n=in.nextInt();
        int k=in.nextInt();
        int[] num = new int[2*n + 1];

        for (int i=0; i<n; i++) {
            num[i]=in.nextInt();
        }
        int targetValue=num[k-1]; // k-th element (0-indexed: k-1)
        boolean allSame=true;
        for(int i=k; i<n; i++) {
            if(num[i]!=targetValue) {
                allSame=false;
                break;
            }
        }
        if(!allSame){
            // Impossible - elements from k onwards are not all the same
            out.println(-1);
            out.flush();
            return;
        }
        // Count how many operations needed
        // We need to remove elements before position k-1 that are not equal to targetValue
        int operations=0;
        for(int i=k-2;i>=0;i--) {
            if(num[i]!=targetValue) {
                operations=i+1;
                break;
            }
        }
        out.println(operations);
        out.flush();
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
    static long gcd(long a, long b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    // LCM
    static long lcm(long a, long b) {
        return a/gcd(a,b)*b;
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
            int m = l+(r-l)/ 2;
            if (arr[m] == target) return m;
            else if (arr[m] < target) l = m + 1;
            else r = m - 1;
        }
        return -1;
    }

}