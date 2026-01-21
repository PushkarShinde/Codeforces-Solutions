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
    long[] a= new long[n];
    for(int i = 0; i < n; i++) a[i]=in.nextLong();
    int low=-1;
    int high=-1;
    int mid=-1;
    int[] premin=new int[n];
    premin[0]=0;
    for(int i=1;i<n;i++){
      premin[i] = (a[i] < a[premin[i-1]]) ? i : premin[i-1];
    }

    int[] postmin=new int[n];
    postmin[n-1]=n-1;
    for(int i=n-2;i>=0;i--){
      postmin[i] = (a[i] < a[postmin[i+1]]) ? i : postmin[i+1];
    }
    for(int j=1;j<n-1;j++){
      int i = premin[j-1]; 
      int k = postmin[j+1];
      if(a[i] < a[j] && a[k] < a[j]){
        res.append("YES\n")
        .append(i+1).append(" ")
        .append(j+1).append(" ")
        .append(k+1).append('\n');
        return;
      }
    }
    res.append("NO").append('\n');
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
