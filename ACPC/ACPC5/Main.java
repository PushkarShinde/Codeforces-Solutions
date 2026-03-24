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

  // static int[][] dp;
  static int maxVal=(int)1e9;

  static void solve(StringBuilder res){
    int n=in.nextInt();
    int d=in.nextInt();
    int[] a=new int[n];
    // dp=new int[n+1][d+1];
    // for(int[] i:dp){
    //   Arrays.fill(i, -1);
    // }
    for(int i=0; i<n; i++) a[i]=in.nextInt();
    int ans=machine(a, 0, d);
    res.append(ans>=maxVal?-1:ans).append('\n');
  }

  static private int machine(int[] a, int ind, int d){
    if(d==0) return 0;
    int n=a.length;
    if(ind>=n) return maxVal;
    if(d<0) return maxVal;
    // if(dp[ind][d]!=-1) return dp[ind][d];
    int take=machine(a, ind, d-a[ind]);
    if(take<maxVal) take++;

    int nottake=machine(a, ind+1, d);
    // return dp[ind][d]=Math.min(take, nottake);
    return Math.min(take, nottake);
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