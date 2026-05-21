import java.util.*;
import java.io.*;

public class Main {

  static FastReader in = new FastReader();
  static PrintWriter out = new PrintWriter(System.out);

  public static void main(String[] args) throws Exception {
    int t=in.nextInt(); 
    StringBuilder res=new StringBuilder();
    while (t-- > 0) {
      int n=in.nextInt();
      long[] a=new long[n];
      for(int i=0; i<n; i++) a[i]=in.nextLong();
      res.append(solve(a,n)?"YES\n":"NO\n");
    }
    System.out.println(res);
    out.flush();
  }

  static boolean solve(long[] a, int n){
    List<Integer> drops=new ArrayList<>();
    for(int i=0;i<n-1;i++){
      if(a[i]>a[i+1]) drops.add(i);
    } 

    if(drops.isEmpty()) return true;

    for(int i=1;i<drops.size();i++){ // Impossible if there are 2 drops next to each other
      if(drops.get(i)-drops.get(i-1)==1) return false;
    }

    long lowest=0;
    for(int d:drops) lowest=Math.max(lowest, a[d]-a[d+1]);

    long highest=Long.MAX_VALUE;
    for(int i=1;i<drops.size();i++){
      int left=drops.get(i-1);
      int right=drops.get(i);
      long best=Long.MIN_VALUE;
      for(int j=left+1;j<right;j++){
        best=Math.max(best, a[j+1]-a[j]);
      }
      if(best==Long.MIN_VALUE) return false;

      highest=Math.min(highest, best);
    }
    return lowest <= highest;
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