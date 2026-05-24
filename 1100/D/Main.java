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
    long[] a=new long[n+1];
    for(int i=1; i<=n; i++) a[i]=in.nextLong();
    boolean[][][] choice=new boolean[n+1][2][2];
    long[][] dp=new long[2][2];

    for(int j=1;j<=n;j++){
      long[][] ndp=new long[2][2];
      for(int p=0;p<2;p++){
        for(int d=0;d<2;d++){
          long v=a[j]*(p==0?1L:-1L);

          long noop=v+dp[p][d];
          long doop=(a[j]>0 || d==1)? (-v+dp[1-p][1]):(Long.MIN_VALUE/2);
          if(doop>noop){
            ndp[p][d]=doop;
            choice[j][p][d]=true;
          }else{
            ndp[p][d]=noop;
          }
        }
      }
      dp=ndp;
    }

    boolean[] ins=new boolean[n+1];
    int p=0, d=0;
    for(int j=n;j>=1;j--){
      if(choice[j][p][d]){
        ins[j]=true;
        p=1-p;
        d=1;
      }
    }

    List<Integer> result=new ArrayList<>();
    Deque<Integer> dq=new ArrayDeque<>();
    for(int j=1;j<=n;j++){
      if(ins[j]){
        if(a[j]>0){
          result.add(j);
          result.addAll(dq);
          dq.clear();
        }else{
          dq.add(j);
        }
      }
    }

    res.append(result.size()).append('\n');
    for(int i=0;i<result.size();i++){
      res.append(result.get(i));
      if(i<result.size()-1) res.append(' ');
    }
    res.append('\n');
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