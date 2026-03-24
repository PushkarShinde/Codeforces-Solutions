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

  // private static int[][] dp;
  static void solve(StringBuilder res){
    int n=in.nextInt();
    int k=in.nextInt();
    int[] a=new int[n];
    int[] b=new int[n];
    for(int i=0; i<n; i++) a[i]=in.nextInt();
    for(int i=0; i<n; i++) b[i]=in.nextInt();

    int[] sum=new int[n];
    sum[0]=a[0];
    int[] large=new int[n];
    large[0]=b[0];
    for(int i=1;i<n;i++){
      sum[i]=sum[i-1]+a[i];
      large[i]=Math.max(large[i-1], b[i]);
    }
    int ans=0;
    for(int i=0;i<Math.min(n,k);i++){
      ans=Math.max(sum[i]+large[i]*(k-(i+1)), ans);
    }

    res.append(ans).append('\n');

    // dp=new int[n+1][k+1];
    // for(int[] d:dp){
    //   Arrays.fill(d, -1);
    // }
    // res.append(a[0]+recur(a, b,0,k-1)).append('\n');
  }

  /* 
  private static int recur(int[] a, int[] b, int ind, int k){
    int n=a.length;
    if(ind==n || k==0) return 0;
    if(dp[ind][k]!=-1) return dp[ind][k];
    int stay=b[ind]+recur(a,b,ind, k-1);
    int move=0;
    if(ind+1<n) move=a[ind+1]+recur(a,b,ind+1, k-1);
    return dp[ind][k]=Math.max(stay, move);
  }
  */

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