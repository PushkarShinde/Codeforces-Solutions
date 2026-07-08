import java.util.*;
import java.io.*;

public class Main {

  static FastReader in = new FastReader();
  static PrintWriter out = new PrintWriter(System.out);

  static int maxVal=-1;
  static int[] best=new int[4];
  public static void main(String[] args) throws Exception {
    int[] a= new int[4];
    for(int i = 0; i <4; i++) a[i]=in.nextInt();
    solve(a,0,new ArrayList<>());
    if(maxVal==-1){
        System.out.println(-1);
    }else{
        System.out.println(""+best[0]+best[1]+":"+best[2]+best[3]+"\n");
    }
    out.flush();
  }

  static void solve(int[] a, int mask, List<Integer> temp){
    if(temp.size()==4){
        int hour=temp.get(0)*10+temp.get(1);   
        int minute=temp.get(2)*10+temp.get(3);   
        if(hour<24 && minute<60){
            int total=hour*60+minute;
            if(total>maxVal){
                maxVal=total;
                for(int i=0;i<4;i++){
                    best[i]=temp.get(i);
                }
            }
        }
        return;
    }
    for(int i=0;i<4;i++){
        if((mask&(1<<i))!=0) continue;
        temp.add(a[i]);
        solve(a, (1<<i)|mask, temp);
        temp.remove(temp.size()-1);
    }
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