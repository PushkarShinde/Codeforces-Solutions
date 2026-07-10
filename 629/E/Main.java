import java.util.*;
import java.io.*;

public class Main {

  static FastReader in = new FastReader();
  static PrintWriter out = new PrintWriter(System.out);
  private static long mod=(long)1e9+7;
  private static long neg=Long.MIN_VALUE/2;

  private static List<Integer>[] adj;
  private static int[] depth, tin, tout, parent;
  private static int timer=0;

  @SuppressWarnings("unchecked")
  public static void main(String[] args) throws Exception {
    StringBuilder res=new StringBuilder();
    int n=in.nextInt();
    int m=in.nextInt();

    adj=new ArrayList[n+1];
    for(int i=0;i<=n;i++) adj[i]=new ArrayList<>();
    for(int i=1;i<n;i++){
      int u=in.nextInt();
      int v=in.nextInt();
      adj[u].add(v);
      adj[v].add(u);
    } 

    parent=new int[n+1];
    parent[1]=1;
    depth=new int[n+1];
    tin=new int[n+1];
    tout=new int[n+1];

    dfs(1,1);

    while(m-->0){
      int k=in.nextInt();
      int[] a=new int[k];
      for(int i=0; i<k; i++) a[i]=in.nextInt();

      int maxDepth=-1;
      int x=-1;
      for(int i:a){
        if(maxDepth<depth[i]){
          maxDepth=depth[i];
          x=i;
        }
      }

      boolean valid=true;
      for(int i:a){
        int p=parent[i];
        if(tin[p]<=tin[x] && tout[p]>=tout[x]) continue;
        valid=false;
        break;
      }
      res.append(valid?"YES\n":"NO\n");
    }
    
    System.out.println(res);
  }

  private static void dfs(int u, int p){
    tin[u]=timer;
    timer++;
    for(int v:adj[u]){
      if(v==p) continue;
      depth[v]=depth[u]+1;
      parent[v]=u;
      dfs(v,u);
    }
    tout[u]=timer;
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