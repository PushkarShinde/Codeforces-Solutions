import java.util.*;
import java.io.*;

public class Main {

    static FastReader in = new FastReader();
    static PrintWriter out = new PrintWriter(System.out);

    public static void main(String[] args) throws Exception {
        int t = in.nextInt(); // comment this line if there's only one test case
        long[] cost=new long[t];
        for(int i=0;i<t;i++) {
            long a = in.nextLong();
            long b = in.nextLong();
            long k = in.nextLong();
            cost[i]=solve(a,b,k);
        }
        for(int i=0;i<t;i++){
            out.println(cost[i]);
        }
        out.flush(); // Don't forget to flush output!
    }

    static long solve(long a, long b, long k) {
        // int cost=0;
        // if(k>=a && k>=b){
        //     return 1;
        // }else if((k<=a && k>=b) || (k>=a && k<=b)){
        //     return 
        // }
        // int factor=gcd(a, b);
        // if(factor!=1 && factor<=k){
        //     return 1;
        // }else if(factor==1){
        //     int big=(a<b)?b:a;
        //     int small=(a<b)?a:b;

        //     cost+=((small+1)/k)-1;
        //     cost+=(((big-small)+1)/k)-1;
        // }
        // return cost;
        long g = gcd(a, b);
        long dx = a / g;
        long dy = b / g;
        if (dx <= k && dy <= k) return 1;
        return 2;
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