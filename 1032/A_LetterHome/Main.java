import java.util.*;
import java.io.*;

public class Main {

    static FastReader in = new FastReader();
    static PrintWriter out = new PrintWriter(System.out);

    public static void main(String[] args) throws Exception {
        int t =in.nextInt(); // comment this line if there's only one test case
        int[] sol=new int[t];
        for(int i=0;i<t;i++){
            int n=in.nextInt();
            int s=in.nextInt();
            int[] tc=new int[n];
            for(int j=0;j<n;j++){
                tc[j]=in.nextInt();
            }
            sol[i]=solve(tc, s);
        }
        for(int i=0;i<t;i++){
            out.println(sol[i]);
        }
        out.flush(); // Don't forget to flush output!
    }

    static int solve(int[] tc, int s) {
        int maxtc=Integer.MIN_VALUE;
        int mintc=Integer.MAX_VALUE;
        for(int i:tc){
            maxtc=Math.max(maxtc, i);
            mintc=Math.min(mintc, i);
        }
        if(s<=mintc){
            return Math.abs(maxtc-s);
        }else if(s>mintc && s<maxtc){
            if((maxtc-s)<(s-mintc)){
                return Math.abs(2*(maxtc-s)+s-mintc);
            }else{
                return Math.abs(maxtc-s+2*(s-mintc));
            }
        }else{
            return Math.abs(s-mintc);
        }
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