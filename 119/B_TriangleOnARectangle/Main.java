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
    int w=in.nextInt();
    int h=in.nextInt();
    int d=in.nextInt();
    long[] down=new long[d];
    for(int i = 0; i <d; i++) down[i]=in.nextLong();
    int u=in.nextInt();
    long[] up=new long[u];
    for(int i = 0; i <u; i++) up[i]=in.nextLong();
    int l=in.nextInt();
    long[] left=new long[l];
    for(int i = 0; i <l; i++) left[i]=in.nextLong();
    int r=in.nextInt();
    long[] right=new long[r];
    for(int i = 0; i <r; i++) right[i]=in.nextLong();
    long area=Long.MIN_VALUE/2;
    
    long base1=down[d-1]-down[0];
    area=Math.max(base1*h, area);
    long base2=up[u-1]-up[0];
    area=Math.max(base2*h, area);
    long base3=left[l-1]-left[0];
    area=Math.max(base3*w, area);
    long base4=right[r-1]-right[0];
    area=Math.max(base4*w, area);

    res.append(area).append('\n');
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