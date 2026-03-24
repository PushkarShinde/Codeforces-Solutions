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

  static void solve(StringBuilder res){
    int n=in.nextInt();
    int q=in.nextInt();
    long[][] a=new long[n][2];
    for(int i=0; i<n; i++){
      a[i][0]=in.nextLong();
      a[i][1]=i;
    }
    int[] x=new int[q];
    for(int i=0; i<q; i++) x[i]=in.nextInt();

    Arrays.sort(a, (u,v)->{
      if(u[0]!=v[0]) return Long.compare(u[0],v[0]);
      return Long.compare(u[1],v[1]);
    });
    
    long pre=Integer.MAX_VALUE;
    for(int i=0;i<q;i++){
      long num=1<<x[i];
      if(num>=pre) continue;

      long add=1<<(x[i]-1);
      int l=0, r=n-1;
      int start=0;
      while(l<=r){
        int mid=l+(r-l)/2;
        if(a[mid][0]<num){
          l=mid+1;
        }else{
          start=mid;
          r=mid-1;
        }
      }

      for(int j=start;j<n;j++){
        if(a[j][0]%num==0){
          a[j][0]+=add;
        }
      }

      pre=num;
    }

    long[] ans=new long[n];
    for(long[] i:a){
      int ind=(int)i[1];
      ans[ind]=i[0];
    }

    for(long i: ans){
      res.append(i).append(" ");
    }
    res.append('\n');
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