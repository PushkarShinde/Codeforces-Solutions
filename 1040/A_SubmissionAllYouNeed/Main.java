import java.util.*;
import java.io.*;

public class Main {

    static FastReader in = new FastReader();
    static PrintWriter out = new PrintWriter(System.out);

    public static void main(String[] args) throws Exception {
        int t =in.nextInt(); // comment this line if there's only one test case
        int[] output=new int[t];
        for(int j=0;j<t;j++) {
            int n=in.nextInt();
            int[] arr=new int[n];
            int[] fre=new int[102];
            for(int i=0;i<n;i++){
                arr[i]=in.nextInt();
                fre[arr[i]]++;
            }
            int a = -1, b = -1;
            // find 'a' : first number with freq < 2 (so 0 or 1 allowed)
            // find 'b' : first number with freq == 0
            for (int i = 0; i < 102; i++) {
                if (fre[i] < 2 && a == -1) a = i;
                if (fre[i] == 0 && b == -1) b = i;
                if (a != -1 && b != -1) break;
            }
            // System.out.println(a + b);
            output[j]=(a+b);
        }
        for(int i=0;i<t;i++){
            out.println(output[i]);
        }
        out.flush(); // Don't forget to flush output!
    }

    // static int solve(int[] arr, int n, int sum, int mex) {
    //     int st=0, end=0;
    //     while(st<=end){
    //         if(arr[end+1]!=arr[end]){
    //             st=end;
    //         }
    //         end++;
    //     }
    //     return 0;
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
            int m = (l + r) / 2;
            if (arr[m] == target) return m;
            else if (arr[m] < target) l = m + 1;
            else r = m - 1;
        }
        return -1;
    }

}