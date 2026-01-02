import java.util.*;
import java.io.*;

public class Main {

    static FastReader in = new FastReader();
    static PrintWriter out = new PrintWriter(System.out);

    public static void main(String[] args) throws Exception {
      int n=in.nextInt();
      int[] a= new int[n];
      for(int i = 0; i < n; i++) a[i]=in.nextInt();
      long clock=cost(a,0);
      long anticlock=cost(a,1);
      if(clock==-1 && anticlock==-1){
        out.println(-1);
      }else if(clock==-1){
        out.println(anticlock);
      }else if(anticlock==-1){
        out.println(clock);
      }else{
        out.println(Math.min(anticlock, clock));
      }
      out.flush();
    }
    private static int cost(int[] a,int pattern){
      int count=0;
      for(int i=0;i<a.length;i++){
        int parity;
        if(pattern==0){
          parity=(i%2==0)?0:1;
        }else{
          parity=(i%2==0)?1:0;
        }
        int cur=a[i];
        int curparity=cur%2;
        if(curparity==parity) continue;
        int cost=0;
        boolean possible=false;
        while(cur>0){
          cur=cur/2;
          cost++;
          if(cur%2==parity){
            possible=true;
            break;
          }
        }
        if(!possible){
          if(parity==1) return -1;
        }
        count+=cost;
      }
      return count;
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