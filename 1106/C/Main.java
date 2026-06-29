import java.util.*;
import java.io.*;

public class Main {

  static FastReader in = new FastReader();
  static PrintWriter out = new PrintWriter(System.out);
  private static long mod=(long)1e9+7;
  private static long neg=Long.MIN_VALUE/2;

  public static void main(String[] args) throws Exception {
    int t=in.nextInt(); 
    StringBuilder res=new StringBuilder();
    while (t-- > 0) {
      solve(res);
    }
    System.out.println(res);
    out.flush();
  }

  @SuppressWarnings("unchecked")
  static void solve(StringBuilder res){
    int n=in.nextInt();
    int[] p=new int[n+1];
    List<Integer>[] adj=new ArrayList[n+1];
    for(int i=0;i<=n;i++) adj[i]=new ArrayList<>();
    for(int i=2;i<=n;i++){
      int v=in.nextInt();
      p[i]=v;
      adj[i].add(v);
      adj[v].add(i);
    }

    int[] m1=new int[n+1];
    int[] m2=new int[n+1];
    int[] depth=new int[n+1];

    //koi child nhi h filhal
    Arrays.fill(m1, -1);
    Arrays.fill(m2, -1);

    for(int i=n;i>=2;i--){
      int parent=p[i];
      int childDepth=depth[i];

      if(childDepth>m1[parent]){
        m2[parent]=m1[parent];
        m1[parent]=childDepth;
      }else if(childDepth>m2[parent]){
        m2[parent]=childDepth;
      }

      depth[parent]=m1[parent]+1;
    }

    long total=n;

    for(int i=1;i<=n;i++){
      if(m2[i]!=-1){
        total+=(m2[i]+1);
      }
    }

    res.append(total).append('\n');
  }

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

    static long gcd(long a, long b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    static long lcm(long a, long b) {
        return a/gcd(a,b)*b;
    }

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