import java.util.*;
import java.io.*;

public class Main {

  static FastReader in = new FastReader();
  static PrintWriter out = new PrintWriter(System.out);

  static class Node{
    long val;
    int dist;
    Node(long val, int dist){
      this.val=val;
      this.dist=dist;
    }
  }

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
    long[] a=new long[n];
    for(int i=0; i<n; i++) a[i]=in.nextLong();
    boolean same=true;
    for(int i=1;i<n;i++){
      if(a[i]!=a[0]){
        same=false;
        break;
      }
    }
    if(same){
      res.append("0\n");
      return;
    }

    List<Node> path=getPath(a[0]);
    int m=path.size();
    long[] dist=new long[m];
    boolean[] valid=new boolean[m];
    for(int i=0; i<m; i++){
      dist[i]=path.get(i).dist;
      valid[i]=true;
    }

    for(int i=1; i<n; i++){
      List<Node> curPath=getPath(a[i]);
      
      Map<Long, Integer> map=new HashMap<>();
      for(Node node: curPath){
        if(map.containsKey(node.val)) continue;
        map.put(node.val, node.dist);
      }

      for(int j=0; j<m; j++){
        if(!valid[j]) continue;
        long val=path.get(j).val;
        if(map.containsKey(val)){
          dist[j]+=map.get(val);
        }else{
          valid[j]=false;
        }
      }
    }

    long ans=-1;
    for(int i=0; i<m; i++){
      if(valid[i]){
        if(ans==-1 || dist[i]<ans){
          ans=dist[i];
        }
      }
    }
    res.append(ans+"\n");
  }

  //jabh tak 1 nahi aajata, tab tak karenge
  private static List<Node> getPath(long x){
    List<Node> res=new ArrayList<>();
    long cur=x;
    int d=0;
    while(cur!=1){
      res.add(new Node(cur,d));
      if(cur%2==1){
        cur++;
      }else{
        cur/=2;
      }
      d++;
    }
    res.add(new Node(1,d));

    if(x==1){
      res.add(new Node(2,1));
    }
    return res;
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

    // GCD
    static long gcd(long a, long b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    // LCM
    static long lcm(long a, long b) {
        return a/gcd(a,b)*b;
    }

    // Sieve of Eratosthenes
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

    // Binary Search Template
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