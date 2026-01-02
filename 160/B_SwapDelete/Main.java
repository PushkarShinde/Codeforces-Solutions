import java.util.*;
import java.io.*;

public class Main {

    static FastReader in = new FastReader();
    static PrintWriter out = new PrintWriter(System.out);

    public static void main(String[] args) throws Exception {
        int t = in.nextInt(); // comment this line if there's only one test case
        StringBuilder res=new StringBuilder();
        for(int i=0;i<t;i++){
          String s=in.next();
          int n=s.length();
          int one=0, zero=0;
          for(char c:s.toCharArray()){
            if(c=='0') zero++;
            else one++;
          }
          int usedZero=0, usedOne=0;
          int L=n; //lets assume the entire string can stay
           
          for(int j=0;j<n;j++){
            if(s.charAt(j)=='1') {
                usedOne++;
                if(usedOne>zero){// prefix has too many ones: cannot find enough zeros to mismatch
                    L=j;
                    break;
                }
            }else {
                usedZero++;
                if(usedZero>one){// prefix has too many zeros: cannot find enough ones to mismatch
                    L=j;
                    break;
                }
            }
          }
          int deletion=n-L;
          res.append(deletion).append('\n');
        }
        System.out.println(res);
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