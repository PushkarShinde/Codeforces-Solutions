import java.util.*;
import java.io.*;

public class Main {

  static FastReader in = new FastReader();
  static PrintWriter out = new PrintWriter(System.out);
  private static long mod=(long)1e9+7;
  private static long neg=Long.MIN_VALUE/2;

  private static int log=18, timer=0;
  private static int[] depth, tin, tout;
  private static List<Integer>[] adj;
  private static int[][] up;

  @SuppressWarnings("unchecked")
  public static void main(String[] args) throws Exception {
    StringBuilder res=new StringBuilder();
    int n=in.nextInt();
    adj=new ArrayList[n+1];
    for(int i=0;i<=n;i++) adj[i]=new ArrayList<>();
    for(int i=1;i<n;i++){
      int u=in.nextInt();
      int v=in.nextInt();
      adj[u].add(v);
      adj[v].add(u);
    }

    tin=new int[n+1];
    tout=new int[n+1];
    depth=new int[n+1];
    up=new int[n+1][log];

    dfs(1, 1);

    int q=in.nextInt();
    while(q-->0){
      int k=in.nextInt();
      int[] a=new int[k];
      for(int i=0;i<k;i++){
        a[i]=in.nextInt();
      }
      
      int x=a[0];
      int maxDepth=depth[x];
      for(int i:a){
        if(maxDepth<depth[i]){
          maxDepth=depth[i];
          x=i;
        }
      }

      maxDepth=-1;
      int y=-1;
      for(int i:a){
        if(i!=x && !ancestor(i, x)){
          if(depth[i]>maxDepth){
            maxDepth=depth[i];
            y=i;
          }
        }
      }

      if(y==-1) {
        res.append("Yes\n");
        continue;
      }

      int l=lca(x,y);
      boolean valid=true;
      for(int i:a){
        if(i!=x && i!=y){
          if((ancestor(i,x) || ancestor(i,y)) && ancestor(l, i)) continue;
          valid=false;
          break;
        }
      }

      res.append(valid?"Yes\n":"No\n");
    }
    
    System.out.println(res);
  }

  private static boolean ancestor(int x, int y){
    return (tin[x]<=tin[y] && tout[x]>=tout[y]);
  }

  private static void dfs(int u, int p){
    up[u][0]=p;
    for(int i=1;i<log;i++){
      up[u][i]=up[up[u][i-1]][i-1];
    }

    tin[u]=timer;
    timer++;
    for(int v:adj[u]){
      if(v==p) continue;
      depth[v]=depth[u]+1;
      dfs(v,u);
    }
    tout[u]=timer;
  }

  private static int lca(int u, int v) {
    if(ancestor(u, v)) return u;
    if(ancestor(v, u)) return v;
    for(int i = log - 1; i >= 0; i--) {
      if(!ancestor(up[u][i], v)) {
        u = up[u][i];
      }
    }
    return up[u][0];
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
}