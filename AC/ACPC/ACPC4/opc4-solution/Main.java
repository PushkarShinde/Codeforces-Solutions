import java.util.*;
import java.io.*;

public class Main {

  static FastReader in = new FastReader();
  static PrintWriter out = new PrintWriter(System.out);

  static final int inf=1_000_000_000;
  public static void main(String[] args) throws Exception {
    int n=in.nextInt(); 
    int x=in.nextInt(); 
    int[] a=new int[n];
    for(int i=0;i<n;i++){
      a[i]=in.nextInt();
    }
    int ans=solve(a,x);
    if(ans==inf){
      System.out.println(-1);
    }else{
      System.out.println(ans);
    }
    out.flush();
  }

  static int solve(int[] a,int x){
    if(x==0) return 0;
    if(x<0) return inf;
    int ans=inf;
    for(int i:a){
      if(i<=x) ans=Math.min(ans,1+solve(a,x-i));
    }
    return ans;
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
}