import java.util.*;
import java.io.*;

public class Main {

  static FastReader in = new FastReader();
  static PrintWriter out = new PrintWriter(System.out);

  private static List<Integer>[] adj;
  private static int[] tin, tout, depth, sz;
  private static int[][] up;
  private static int timer=0, log=18;

  @SuppressWarnings("unchecked")
  public static void main(String[] args) throws Exception {
    StringBuilder res=new StringBuilder();
    int n=in.nextInt();
    adj=new List[n+1];
    for(int i=0;i<=n;i++) adj[i]=new ArrayList<>();
    for(int i=1; i<n; i++){
      int u=in.nextInt();
      int v=in.nextInt();
      adj[u].add(v);
      adj[v].add(u);
    }

    tin=new int[n+1];
    tout=new int[n+1];
    sz=new int[n+1];
    depth=new int[n+1];
    up=new int[n+1][log];

    dfs(1,1);
    
    int m=in.nextInt(); 
    while(m-->0){
      int u=in.nextInt();
      int v=in.nextInt();

      if(u==v){
        res.append(n).append('\n');
        continue;
      }

      int l=lca(u,v);
      int dist=depth[u]+depth[v]-2*depth[l];

      if(dist%2!=0){
        res.append(0).append('\n');
        continue;
      }

      if(depth[u]<depth[v]){
        int temp=u;
        u=v;
        v=temp;
      }

      int half=dist/2;
      if(depth[u]==depth[v]){//mid point lca hai
        int cu=getancestor(u,half-1);
        int cv=getancestor(v,half-1);
        res.append(n-sz[cu]-sz[cv]).append('\n');
      }else{
        //mid point is below lca in u's branch
        int mid=getancestor(u,half);
        int cu=getancestor(u,half-1);
        res.append(sz[mid]-sz[cu]).append('\n');
      }
    }
    System.out.println(res);
  }

  private static int lca(int x, int y){
    if(depth[x]<depth[y]){
      int temp=x;
      x=y;
      y=temp;
    }
    int d=depth[x]-depth[y];
    for(int j=log-1;j>=0;j--){
      if(((d>>j)&1)==1){
        x=up[x][j];
      }
    }
    if(x==y) return x;

    for(int j=log-1;j>=0;j--){
      if(up[x][j]!=up[y][j]){
        x=up[x][j];
        y=up[y][j];
      }
    }

    return up[x][0];
  }

  private static int getancestor(int u, int k){
    for(int j=log-1;j>=0;j--){
      if(((k>>j)&1)==1){
        u=up[u][j];
      }
    }
    return u;
  }

  private static void dfs(int u, int p){
    up[u][0]=p;
    for(int j=1;j<log;j++){
      up[u][j]=up[up[u][j-1]][j-1];
    }

    tin[u]=++timer;
    sz[u]=1;

    for(int v:adj[u]){
      if(v==p) continue;
      depth[v]=depth[u]+1;
      dfs(v,u);
      sz[u]+=sz[v];
    }
    tout[u]=++timer;
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