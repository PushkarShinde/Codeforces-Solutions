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

  static void solve(StringBuilder res){
    int n=in.nextInt();
    String s=in.next();
    Stack<Integer> stack=new Stack<>();
    boolean[] printed = new boolean[n+1];

    for(int i=0;i<n;i++){
      char c=s.charAt(i);
      int doc=i+1;

      if(c=='1'){
        stack.push(doc);
      }else if(c=='2'){
        if(!stack.isEmpty()){
          printed[stack.pop()]=true;
        }else{
          printed[doc]=true;
        }
      }else{
        printed[doc]=true;
      }
    }

    int k=0;
    StringBuilder notprinted=new StringBuilder();
    for(int i=1;i<=n;i++){
      if(!printed[i]){
        k++;
        notprinted.append(i).append(' ');
      }
    }
    res.append(k).append('\n');
    res.append(notprinted).append('\n');
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