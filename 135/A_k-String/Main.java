import java.util.*;
import java.io.*;

public class Main {

    static FastReader in = new FastReader();
    static PrintWriter out = new PrintWriter(System.out);

    public static void main(String[] args) throws Exception {
        int k = in.nextInt(); // comment this line if there's only one test case
        String str=in.next();
        int[] alpha=new int[26];
        for(char c: str.toCharArray()){
            alpha[c-'a']++;
        }
        int n=str.length();
        if(n % k != 0) {
            System.out.println(-1);
            return;
        }
        for(int i:alpha){
            if(i%k!=0) {
                System.out.println(-1);
                return;
            }
        }
        StringBuilder res=new StringBuilder();
        for(int i=0;i<26;i++){
            if(alpha[i]==0) continue;
            int rep=alpha[i]/k;
            for(int j=0;j<rep;j++){
                res.append((char)('a'+i));
            }
        }
        String temp=res.toString();
        for(int i=0;i<k-1;i++){
            res.append(temp);
        }
        System.out.println(res.toString());
        out.flush(); // Don't forget to flush output!
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