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
    long[] a=new long[n+1];
    for(int i=1; i<=n; i++) a[i]=in.nextLong();
    
    int m=n-4;
    if(m<1){
      res.append(0).append('\n');
      return;
    }

    Map<Long, List<Integer>> map=new HashMap<>();

    for(int x=1;x<=m;x++){
      long val=a[x]+a[x+2]-a[x+4];
      map.computeIfAbsent(val,k-> new ArrayList<>()).add(x);
    }

    long total=0;

    for(List<Integer> list:map.values()){
      List<Integer> odds = new ArrayList<>();
      List<Integer> evens = new ArrayList<>();
      for (int x : list) {
          if (x % 2 == 1) odds.add(x);
          else evens.add(x);
      }
      total+=countDisjoint(odds, 6);
      total+=countDisjoint(evens, 6);
      total+=(long) odds.size() * evens.size();
    }

    res.append(total).append('\n');
  }

  static long countDisjoint(List<Integer> list, int minDist) {
    int k=list.size();
    if(k<2) return 0;
    long pairs=0;
    int left=0;
    for(int r=0; r<k; r++) {
      while(list.get(r)-list.get(left)>=minDist){
        left++;
      }
      pairs+=left;
    }
    return pairs;
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