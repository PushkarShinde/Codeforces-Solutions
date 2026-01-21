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

  // static void solve(StringBuilder res){
  //   long n=in.nextLong();
  //   long k=in.nextLong();
  //   if(k>n){
  //     res.append(-1).append('\n');
  //     return;
  //   }
  //   if(k==n){
  //     res.append(0).append('\n');
  //     return;
  //   }
  //   Queue<long[]> q=new LinkedList<>();
  //   Set<Long> vis=new HashSet<>();
  //   q.offer(new long[]{k,0});
  //   vis.add(k);
  //   long ans=-1;
  //   while(!q.isEmpty()){
  //     long[] cur=q.poll();
  //     long val=cur[0];
  //     long step=cur[1];
  //     if(val==n){
  //       ans=step;
  //       break;
  //     }
  //     if(val>n){
  //       continue;//dusra parent dekh lo
  //     }
  //     long[] parent={2*val-1,2*val,2*val+1};
  //     for(long p: parent){
  //       if(p>0 && p<=n && !vis.contains(p)){
  //         vis.add(p);
  //         q.offer(new long[]{p,step+1});
  //       }
  //     }
  //   }
  //   res.append(ans).append('\n');
  // }

  static void solve(StringBuilder res){
    long n=in.nextLong();
    long k=in.nextLong();
    long ans=minOp(n,k);
    res.append(ans).append('\n');
  }

  private static long minOp(long n, long k){
    if(k>n) return -1;
    if(k==n) return 0;
    long left=n/2;
    long right=(n+1)/2;
    if(k==left || k==right){
      return 1;
    }
    long ans=Long.MAX_VALUE;
    if(k<=left){
      long leftRes=minOp(left, k);
      if(leftRes!=-1){
        ans=Math.min(ans,leftRes+1);//answer mill gaya
      }
    }
    if(k<=right){
      long rightRes=minOp(right, k);
      if(rightRes!=-1){
        ans=Math.min(ans,rightRes+1);//answer mill gaya
      }
    }
    return (ans==Long.MAX_VALUE)?-1:ans;
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