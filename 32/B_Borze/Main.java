import java.util.*;
import java.io.*;

public class Main {

    static FastReader in = new FastReader();
    static PrintWriter out = new PrintWriter(System.out);

    public static void main(String[] args) throws Exception {
        String str=in.nextLine();
        int n=str.length();
        // if(n==1) {
        //     out.println(0);
        //     return;
        // }
        // if(n==2){
        //     if(str.equals("--")){
        //         out.println(2);
        //     }else{
        //         out.println(1);
        //     }
        //     return;
        // }
        int i=0;
        String num="";
        while(i<n){
            char cur=str.charAt(i);
            char next=' ';
            if(i<n-1) next=str.charAt(i+1);
            if(cur=='-' && next=='.'){
                num+="1";
                i+=2;
            }else if(cur=='-' && next=='-'){
                num+="2";
                i+=2;
            }else if(cur=='.'){
                num+="0";
                i++;
            }
        }
        out.println(num);
        out.flush(); // Don't forget to flush output!
    }

    // static void solve() {
    //     // Your logic for each test case goes here
    //     int n = in.nextInt();
    //     int[] arr = new int[n];
    //     for(int i = 0; i < n; i++) arr[i] = in.nextInt();

    //     // Example logic:
    //     out.println(Arrays.toString(arr));
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