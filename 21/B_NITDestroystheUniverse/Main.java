import java.util.*;
import java.io.*;

public class Main {

    static FastReader in = new FastReader();
    static PrintWriter out = new PrintWriter(System.out);

    public static void main(String[] args) throws Exception {
        int t=in.nextInt(); 
        StringBuilder res=new StringBuilder();
        while (t-- > 0) {
            solve(res);
        }
        System.out.println(res);
        out.flush();
    }

    static void solve(StringBuilder res){
      int n=in.nextInt();
      int[] a= new int[n];
      for(int i = 0; i < n; i++) a[i]=in.nextInt();
      int zeroes=0;
      int left=0;
      int right=n;
      for(int i=0;i<n;i++){
        if(a[i]!=0){
          left=i;
          break;
        }
      }
      for(int i=n-1;i>=0;i--){
        if(a[i]!=0){
          right=i;
          break;
        }
      }
      for(int i=0;i<n;i++){
        if(a[i]==0) zeroes++;
      }
      int ans=0;
      if(zeroes==n) {
        ans=0;
        res.append(ans).append('\n');
        return;
      }
      zeroes=0;
      for(int i=left;i<=right;i++){
        if(a[i]==0) zeroes++;
      }
      if(zeroes>0) ans=2;
      else ans=1;
      res.append(ans).append('\n');
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